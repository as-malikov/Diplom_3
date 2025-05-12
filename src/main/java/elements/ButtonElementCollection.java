package elements;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ButtonElementCollection {
    ElementsCollection buttonElementsCollection;

    public ButtonElementCollection(String locator) {
        this.buttonElementsCollection = $$(new By.ByXPath(locator));
    }

    public void findVisibleButtonAndClick() {
        ButtonElement buttonElement = new ButtonElement(buttonElementsCollection.findBy(visible));
        buttonElement.clickButton();
    }
}
