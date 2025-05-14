import api.UserApi;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.User;
import model.UserCredential;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RecoveryPasswordPage;
import pageobject.RegisterPage;

import java.util.Arrays;
import java.util.Collection;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static pageobject.MainPage.MAIN_PAGE_URL;
import static pageobject.RecoveryPasswordPage.RECOVERY_PASSWORD_URL;
import static pageobject.RegisterPage.REGISTER_PAGE_URL;

import static util.UserGenerator.getRandomShortPasswordUser;
import static util.UserGenerator.getRandomUser;

@RunWith(Parameterized.class)
public class LoginUserParamTest {
    private final User user;
    private static boolean createdUser;
    private UserApi userApi;
    private UserCredential userCredential;

    public LoginUserParamTest(User user, boolean createdUser) {
        this.user = user;
        this.createdUser = createdUser;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> canBeCreated() {
        return Arrays.asList(
                new Object[]{getRandomUser(), true},
                new Object[]{getRandomUser(), true},
                new Object[]{getRandomUser(), true},
                new Object[]{getRandomShortPasswordUser(), false},
                new Object[]{getRandomShortPasswordUser(), false});
    }

    @Before
    public void createUser() {
        userApi = new UserApi();
        userCredential = getUserCredentialByResponse(userApi.createUser(user)
                .assertThat()
                .statusCode(SC_OK));
        userCredential.setUser(user);
    }

    @Test
    public void loginByInputButtonTest() {
        open(MAIN_PAGE_URL, MainPage.class);
        MainPage mainPage = new MainPage();
        mainPage.inputButtonClick();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        checkingInputText(loginPage, createdUser);
    }

    @Test
    public void personalAccountInputButtonTest() {
        open(MAIN_PAGE_URL, MainPage.class);
        MainPage mainPage = new MainPage();
        mainPage.personalAccountElementClick();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        checkingInputText(loginPage, createdUser);
    }

    @Test
    public void registrationFormInputButtonTest() {
        open(REGISTER_PAGE_URL, RegisterPage.class);
        RegisterPage registerPage = new RegisterPage();
        registerPage.inputButtonClick();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        checkingInputText(loginPage, createdUser);
    }

    @Test
    public void recoveryPasswordFormInputButtonTest() {
        open(RECOVERY_PASSWORD_URL, RegisterPage.class);
        RecoveryPasswordPage registerPage = new RecoveryPasswordPage();
        registerPage.inputButtonClick();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAndPasswordInput(user.getEmail(), user.getPassword());
        checkingInputText(loginPage, createdUser);
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

    @Step("Checking input text")
    public void checkingInputText(LoginPage loginPage, boolean userInput) {
        if (userInput) {
            loginPage.inputIsVisible();
        } else {
            loginPage.inputIsNotVisible();
        }
    }
}
