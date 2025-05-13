import model.User;
import org.junit.After;
import org.junit.Before;

import static browser.Browser.initDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static util.UserGenerator.getRandomUser;

import com.codeborne.selenide.Configuration;

import java.io.IOException;
import api.UserApi;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.User;
import model.UserCredential;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.is;
import static util.UserGenerator.getRandomUser;


public class BaseUiTest {

    public static final int TIMEOUT_4000 = 10000;


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
