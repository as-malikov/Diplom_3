package pageobject;

import elements.ButtonElement;
import elements.Element;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String mainInputLocator = ".//*[text() = 'Войти в аккаунт']";
    private static final String personalAccountElement = ".//*[text() = 'Личный Кабинет']";

    private static final String bunButtonlocator = ".//span[text() = 'Булки']";
    private static final String sauceButtonLocator = ".//span[text() = 'Соусы']";
    private static final String fillingButtonLocator = ".//span[text() = 'Начинки']";

    private static final String bunsSelectedLocator = ".//div[contains(@class, 'current')]//span[text() = 'Булки']";
    private static final String sauceSelectedLocator = ".//div[contains(@class, 'current')]//span[text() = 'Соусы']";
    private static final String fillingSelectedLocator = ".//div[contains(@class, 'current')]//span[text() = 'Начинки']";

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

    public void inputButtonClick() {
        ButtonElement mainInputButton = new ButtonElement(mainInputLocator);
        mainInputButton.clickButton();
    }

    public void personalAccountElementClick() {
        ButtonElement personalAccountButton = new ButtonElement(personalAccountElement);
        personalAccountButton.clickButton();
    }

    public void bunElementIsVisible() {
        Element element = new Element(bunButtonlocator);
        element.elementIsVisible();
    }

    public void bunElementClickedAndIsVisible() {
        bunElementIsVisible();
        Element bunElement = new Element(bunsSelectedLocator);
        bunElement.elementIsVisible();
    }

    public void sauceElementClickAndIsVisible() {
        ButtonElement sauceButton = new ButtonElement(sauceButtonLocator);
        sauceButton.clickButton();
        Element sauceElement = new Element(sauceSelectedLocator);
        sauceElement.elementIsVisible();
    }

    public void fillingElementClickAndIsVisible() {
        ButtonElement fillingButton = new ButtonElement(fillingButtonLocator);
        fillingButton.clickButton();
        Element fillingElement = new Element(fillingSelectedLocator);
        fillingElement.elementIsVisible();
    }
}
