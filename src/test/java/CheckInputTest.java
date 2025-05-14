import api.UserApi;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.User;
import model.UserCredential;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static pageobject.MainPage.MAIN_PAGE_URL;
import static util.UserGenerator.getRandomUser;

public class CheckInputTest extends BaseUiTest{
    private ValidatableResponse createUserResponse;
    private UserApi userApi;
    private User user;
    private UserCredential userCredential;
    private Gson gson;

    @Before
    public void createUser() {
//        user = getRandomUser();
//        userApi = new UserApi();
//        gson = new Gson();
//        createUserResponse = userApi.createUser(user);
//        userCredential = getUserCredentialByResponse(createUserResponse);
    }

    @Test
    public void urlTest() {
        open(MAIN_PAGE_URL, MainPage.class);
        System.out.println("url = " + url());
        MainPage mainPage = new MainPage();
        mainPage.inputToProfileMainPage();
        LoginPage loginPage = new LoginPage();
//        loginPage.loginAndPasswordInput("login", "password");
        loginPage.recoveryPasswordIsDisplayed();
    }

    @After
    public void tearDown() {
//        if (createUserResponse.extract().statusCode() == SC_OK) {
//            ValidatableResponse deleteUserResponse = userApi.deleteUser(userCredential.getAccessToken());
//            deleteUserResponse.log().all()
//                    .assertThat()
//                    .statusCode(SC_ACCEPTED);
//        }
    }

    @Step("Get user credential")
    public UserCredential getUserCredentialByResponse(ValidatableResponse response) {
        return gson.fromJson(response.extract().body().asString(), UserCredential.class);
    }
}
