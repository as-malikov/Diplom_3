package pageobject;

import elements.ButtonElement;
import elements.Element;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    public String ACCOUNT_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    protected WebDriver driver;
    private String logoButtonLocator = ".//div/a[@href='/']";
    private String constructorButtonLocator = ".//*[text() = 'Конструктор']";
    private String exitButtonLocator = ".//*[text() = 'Выход']";

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountProfilePage() {
    }

    public AccountProfilePage opeAccountProfilePage() {
        driver.get(ACCOUNT_PROFILE_URL);
        return this;
    }

    public void exitFromPersonalAccounElementtIsVisible() {
        Element element = new Element(exitButtonLocator);
        element.elementIsVisible();
    }

    public void constructorButtonClick() {
        ButtonElement constructorButton = new ButtonElement(constructorButtonLocator);
        constructorButton.clickButton();
    }

    public void logoButtonClick() {
        ButtonElement logoButton = new ButtonElement(logoButtonLocator);
        logoButton.clickButton();
    }

    public void exitButtonClick() {
        ButtonElement exitButton = new ButtonElement(exitButtonLocator);
        exitButton.clickButton();
    }
}
