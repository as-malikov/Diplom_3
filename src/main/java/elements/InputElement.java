package elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class InputElement {
    SelenideElement inputElement;

    public InputElement(String locator) {
        this.inputElement = $(new By.ByXPath(locator));
    }

    @Step("Input element should be clear and set value")
    public void clearAndSetValue(String inputValue) {
        inputElement.shouldBe(enabled).clear();
        inputElement.setValue(inputValue);
    }

    @Step("Should be set value to input element")
    public void setValue(String inputValue) {
        inputElement.shouldBe(enabled)
                .setValue(inputValue);
    }

    @Step("Get value from input element")
    public String getValue() {
        return inputElement.getValue();
    }
}
