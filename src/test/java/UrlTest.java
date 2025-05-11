import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static pageobject.MainPage.MAIN_PAGE_URL;

public class UrlTest extends BaseUiTest {

    @Test
    public void urlTest() {
        open(MAIN_PAGE_URL, pageobject.MainPage.class);
        System.out.println("url = " + url());
    }
}
