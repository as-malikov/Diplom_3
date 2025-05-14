import api.UserApi;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.User;
import model.UserCredential;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.AccountProfilePage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static pageobject.LoginPage.LOGIN_PAGE_URL;
import static util.UserGenerator.getRandomUser;

public class CheckConstructorTest {
    private User user;
    private static boolean createdUser;
    private UserApi userApi;
    private UserCredential userCredential;

    @Before
    public void createUser() {
        userApi = new UserApi();
        user = getRandomUser();
        userCredential = getUserCredentialByResponse(userApi.createUser(user)
                .assertThat()
                .statusCode(SC_OK));
        userCredential.setUser(user);
    }

    @Test
    public void shouldGoBunAndCheckIsVisibleBunTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.bunElementClickedAndIsVisible();
    }

    @Test
    public void shouldGoSauceAndCheckIsVisibleSauceTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.sauceElementClickAndIsVisible();
    }

    @Test
    public void shouldGoFillingAndCheckIsVisibleFillingTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.fillingElementClickAndIsVisible();
    }


    @After
    public void tearDown() {
        ValidatableResponse deleteUserResponse = userApi.deleteUser(userCredential.getAccessToken());
        deleteUserResponse.log()
                .all()
                .assertThat()
                .statusCode(SC_ACCEPTED);
    }

    @Step("Get user credential")
    public UserCredential getUserCredentialByResponse(ValidatableResponse response) {
        Gson gson = new Gson();
        return gson.fromJson(response.extract()
                .body()
                .asString(), UserCredential.class);
    }
}
