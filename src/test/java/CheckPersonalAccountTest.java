import api.UserApi;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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

public class CheckPersonalAccountTest {
    private User user;
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
    @DisplayName("User should login by personal account button.")
    public void shouldLoginByPersonalAccountButtonTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        AccountProfilePage accountProfilePage = new AccountProfilePage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.bunElementIsVisible();
        mainPage.personalAccountElementClick();
        accountProfilePage.exitFromPersonalAccountElementIsVisible();
    }

    @Test
    @DisplayName("User should go from personal account to constructor.")
    public void shouldGoFromPersonalAccountToConstructorTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        AccountProfilePage accountProfilePage = new AccountProfilePage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.personalAccountElementClick();
        accountProfilePage.constructorButtonClick();
        mainPage.bunElementIsVisible();
    }

    @Test
    @DisplayName("User should go from personal account to logo.")
    public void shouldGoFromPersonalAccountToLogoTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        AccountProfilePage accountProfilePage = new AccountProfilePage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.personalAccountElementClick();
        accountProfilePage.logoButtonClick();
        mainPage.bunElementIsVisible();
    }

    @Test
    @DisplayName("User should exit from personal account.")
    public void shouldExitFromPersonalAccountTest() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        AccountProfilePage accountProfilePage = new AccountProfilePage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        mainPage.personalAccountElementClick();
        accountProfilePage.exitButtonClick();
        loginPage.inputIsVisible();
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
