package pageobject;

import elements.ButtonElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    protected WebDriver driver;
    private String inputButton = ".//*[text() = 'Войти']";

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage() {
    }

    public RegisterPage openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
        return this;
    }

    @Step("Click input button on RegisterPage")
    public void inputButtonClick() {
        ButtonElement mainInputButton = new ButtonElement(inputButton);
        mainInputButton.clickButton();
    }
}
