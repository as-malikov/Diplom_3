package pageobject;

import elements.ButtonElement;
import elements.Element;
import elements.InputElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private String inputButtonLocator = ".//*[text() = 'Войти']";
    private String recoveryPasswordLocator = ".//*[text() = 'Восстановить пароль']";
    private String loginInputLocator = ".//input[contains(@name, 'name')]";
    private String passwordInputLocator = ".//input[contains(@name, 'Пароль')]";
    private String inputLocator = ".//*[text() = 'Вход']";

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage() {
    }

    public LoginPage openMainPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    public void recoveryPasswordClick() {
        ButtonElement buttonElement = new ButtonElement(recoveryPasswordLocator);
        buttonElement.clickButton();
    }

    @Step("Login and password input and input button click on LoginPage")
    public void loginAndPasswordInput(String login, String password) {
        InputElement inputLoginElement = new InputElement(loginInputLocator);
        inputLoginElement.clearAndSetValue(login);
        InputElement inputPasswordElement = new InputElement(passwordInputLocator);
        inputPasswordElement.clearAndSetValue(password);
        ButtonElement buttonInputElement = new ButtonElement(inputButtonLocator);
        buttonInputElement.clickButton();
    }
    @Step("Check visible input buton on LoginPage")
    public void inputIsVisible() {
        Element element = new Element(inputLocator);
        element.elementIsVisible();
    }

    @Step("Check not visible input buton on LoginPage")
    public void inputIsNotVisible() {
        Element element = new Element(inputLocator);
        element.elementIsNotVisible();
    }
}
