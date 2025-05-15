package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.User;

import static io.restassured.RestAssured.given;

public class UserApi extends RestApi {
    public static final String API_AUTH_REGISTER = "/api/auth/register";
    public static final String API_AUTH_USER = "/api/auth/user";

    @Step("Create user")
    public ValidatableResponse createUser(User user) {
        return given().spec(requestSpecification())
                .body(user)
                .when()
                .post(API_AUTH_REGISTER)
                .then();
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(String accessToken) {
        return given().spec(requestSpecification())
                .header("Authorization", accessToken)
                .when()
                .delete(API_AUTH_USER)
                .then();
    }
}