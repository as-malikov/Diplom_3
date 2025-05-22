package elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Element {
    SelenideElement element;

    public Element(String locator) {
        this.element = $(new By.ByXPath(locator));
    }

    @Step("Element should be visible")
    public void elementIsVisible() {
        element.shouldBe(visible);
    }

    @Step("Element should be not visible")
    public void elementIsNotVisible() {
        element.shouldBe(disappear);
    }
}
