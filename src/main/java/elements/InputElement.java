package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class InputElement {
    SelenideElement inputElement;

    public InputElement(String locator) {
        this.inputElement = $(new By.ByXPath(locator));
    }

    public InputElement(SelenideElement inputElement) {
        this.inputElement = inputElement;
    }

    public void clearAndSetValue(String inputValue) {
        inputElement.shouldBe(enabled).clear();
        inputElement.setValue(inputValue);
    }

    public void setValue(String inputValue) {
        inputElement.shouldBe(enabled)
                .setValue(inputValue);
    }

    public void setValueIfIsEmpty(String value) {
        if (inputElement.getValue().isEmpty()) {
            setValue(value);
        }
    }

    public String getValue() {
        return inputElement.getValue();
    }
}
