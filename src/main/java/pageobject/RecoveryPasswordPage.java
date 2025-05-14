package pageobject;

import elements.ButtonElement;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    public static final String RECOVERY_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private String inputButton = ".//*[text() = 'Войти']";
    
    protected WebDriver driver;

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public RecoveryPasswordPage() {
    }

    public RecoveryPasswordPage openRecoveryPasswordPage() {
        driver.get(RECOVERY_PASSWORD_URL);
        return this;
    }

    public void inputButtonClick() {
        ButtonElement mainInputButton = new ButtonElement(inputButton);
        mainInputButton.clickButton();
    }
}
