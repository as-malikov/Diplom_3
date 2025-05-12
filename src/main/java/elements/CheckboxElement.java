package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxElement {
    SelenideElement checkboxElement;

    public CheckboxElement(String locator) {
        this.checkboxElement = $(new By.ByXPath(locator));
    }

    public void setSelectedTrue() {
        checkboxElement.scrollIntoView(false);
        checkboxElement.setSelected(true);
    }

    public boolean isSelected() {
        checkboxElement.scrollIntoView(false);
        return checkboxElement.isSelected();
    }
}
