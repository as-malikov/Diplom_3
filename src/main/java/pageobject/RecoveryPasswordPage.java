package pageobject;

import elements.ButtonElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    public static final String RECOVERY_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    protected WebDriver driver;
    private String inputButton = ".//*[text() = 'Войти']";

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public RecoveryPasswordPage() {
    }

    public RecoveryPasswordPage openRecoveryPasswordPage() {
        driver.get(RECOVERY_PASSWORD_URL);
        return this;
    }

    @Step("Click input button on RecoveryPasswordPage")
    public void inputButtonClick() {
        ButtonElement mainInputButton = new ButtonElement(inputButton);
        mainInputButton.clickButton();
    }
}
