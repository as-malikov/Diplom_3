package pageobject;

import elements.ButtonElement;
import elements.InputElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private String inputButtonLocator = ".//*[text() = 'Войти']";
    private String recoveryPasswordLocator = ".//*[text() = 'Восстановить пароль']";
    private String loginInputLocator = ".//input[contains(@name, 'name')]";
    private String passwordInputLocator = ".//input[contains(@name, 'Пароль')]";

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

    public void loginAndPasswordInput(String login, String password) {
        InputElement inputLoginElement = new InputElement(loginInputLocator);
        inputLoginElement.clearAndSetValue(login);
        InputElement inputPasswordElement = new InputElement(password);
        inputPasswordElement.clearAndSetValue(password);
        ButtonElement buttonInputElement = new ButtonElement(inputButtonLocator);
        buttonInputElement.clickButton();
    }

    public void recoveryPasswordIsDisplayed() {
        driver.findElement(By.xpath(recoveryPasswordLocator)).isDisplayed();
    }

}
