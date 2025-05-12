package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LinkElement {
    SelenideElement linkElement;

    public LinkElement(String locator) {
        this.linkElement = $(new By.ByXPath(locator));
    }

    public void click() {
        linkElement.scrollIntoView(false);
        linkElement.shouldBe(enabled);
        linkElement.click();
    }

    public String getLinkText() {
        linkElement.shouldBe(enabled);
        return linkElement.getText();
    }

}
