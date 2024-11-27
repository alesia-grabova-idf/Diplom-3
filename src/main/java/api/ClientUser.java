package api;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import config.StellarBurgerConfig;

public class ClientUser {

  @Step("Send POST request to register a new user")
  public Response registerUser(ClientUser user) {
    return given()
        .header("Content-Type", "application/json")
        .body(user)
        .when()
        .post(StellarBurgerConfig.BASE_URL + StellarBurgerConfig.API_REGISTER_USER);
  }

  @Step("Send DELETE request to delete user")
  public Response deleteUser(String accessToken) {
    return given()
        .header("Authorization", accessToken)  // Используем токен для авторизации
        .contentType(ContentType.JSON)
        .when()
        .delete(StellarBurgerConfig.BASE_URL + StellarBurgerConfig.API_DELETE);
  }

  @Step("Extract access token from response")
  public String extractToken(Response response) {
    return response.jsonPath().getString("accessToken");
  }
}
