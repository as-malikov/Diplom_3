package browser;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static browser.BrowserType.*;

public class Browser {

    protected WebDriver driver;

    public static void initDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        BrowserType browserType =   BrowserType.valueOf(browserProperty);
        System.out.println("browserType = " + browserType);
        switch (browserType) {
            case CHROME :
                Configuration.browser = "CHROME";
                break;
            case FIREFOX :
                Configuration.browser = "FIREFOX";
                break;
            case YANDEX :
//                System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/yandexdriver-25.2.0" +
//                        ".2123-win64/yandexdriver.exe");
                Configuration.browser = "YANDEX";
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }

    }
}
