import model.OrderModel;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.MainPageExample;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static pageobject.MainPage.MAIN_PAGE_URL;

public class UrlTest extends BaseUiTest {

    @Test
    public void urlTest() {
        open(MAIN_PAGE_URL, MainPageExample.class);
        System.out.println("url = " + url());
    }

    @Test
    public void builderTest() {
        OrderModel orderModel = OrderModel.builder()
                .name("Ваня")
                .surname("Петров")
                .phoneNumber("89231234569")
                .build();
    }
}
