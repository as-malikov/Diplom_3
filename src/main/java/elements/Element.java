package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Element {
    SelenideElement element;

    public Element(String locator) {
        this.element = $(new By.ByXPath(locator));
    }

    public void elementIsVisible() {
        element.shouldBe(visible);
    }

    public void elementIsNotVisible() {
        element.shouldBe(disappear);
    }
}
