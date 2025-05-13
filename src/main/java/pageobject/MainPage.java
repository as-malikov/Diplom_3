package pageobject;

import elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String mainInputLocator = ".//*[text() = 'Войти в аккаунт']";
    private static final  String personalAccountElement = ".//*[text() = 'Личный Кабинет']";

    private static final String bunSpanElement = ".//span[text() = 'Булки']";
    private static final String sauceSpanElement = ".//span[text() = 'Соусы']";
    private static final String fillingSpanElement = ".//span[text() = 'Начинки']";

    private static final String bunsCurrentSelectedElement = ".//div[contains(@class, 'current')]//span[text() = 'Булки']";
    private static final String sauceCurrentSelectedElement = ".//div[contains(@class, 'current')]//span[text() = 'Соусы']";
    private static final String fillingCurrentSelectedElement = ".//div[contains(@class, 'current')]//span[text() = 'Начинки']";
    private By recoveryPasswordLocator = By.xpath(".//*[text() = 'Восстановить пароль']");

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage() {
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public void inputToProfileMainPage() {
        ButtonElement mainInputButton = new ButtonElement(mainInputLocator);
        mainInputButton.clickButton();
    }
}
