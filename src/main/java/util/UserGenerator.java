package util;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import model.User;

import java.util.Locale;

public class UserGenerator {
    public static final String NAME = "name_";
    public static final String PASSWORD = "password_";
    public static final String EMAIL = "email_";
    public static final String UNDERLINE = "_";
    public static final int CHARACTERS_8 = 8;
    public static final int CHARACTERS_12 = 12;
    public static final int CHARACTERS_3 = 3;
    public static final int CHARACTERS_5 = 5;



    private static final Faker faker = new Faker(new Locale("en"));

    @Step("Generate random login user default")
    public static String getRandomName() {
        return NAME + faker.name().username();
    }

    @Step("Generate random password user default")
    public static String getRandomPassword() {
        return PASSWORD + faker.internet().password(CHARACTERS_8, CHARACTERS_12, true, true
                , true);
    }

    @Step("Generate random email user default")
    public static String getRandomEmail() {
        return EMAIL + faker.internet().emailAddress();
    }

    @Step("Generate random user default")
    public static User getRandomUser() {
        String login = NAME + faker.name().username();
        String password = PASSWORD + faker.internet().password(CHARACTERS_8, CHARACTERS_12, true, true
                , true);
        String email = EMAIL + faker.internet().emailAddress();
        return new User(login, password, email);
    }

    @Step("Generate random user default")
    public static User getRandomShortPasswordUser() {
        String login = NAME + faker.name().username();
        String password = PASSWORD + faker.internet().password(CHARACTERS_3, CHARACTERS_5, true, true
                , true);
        String email = EMAIL + faker.internet().emailAddress();
        return new User(login, password, email);
    }
}
