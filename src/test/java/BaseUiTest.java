import org.junit.After;
import org.junit.Before;

import static browser.Browser.initDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;

import java.io.IOException;


public class BaseUiTest {

    public static final int TIMEOUT_4000 = 4000;

    @Before
    public void init() throws IOException {
        initDriver();
        Configuration.timeout = TIMEOUT_4000;
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
