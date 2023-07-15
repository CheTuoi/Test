package helper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Authen;

import static io.restassured.RestAssured.given;

public class AuthenticationUtils {

    private static Authen authen;
    public static String getAuthToken() {
        authen = Authen.getInstance();
        Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(authen)
                .post("https://restful-booker.herokuapp.com/auth");
        String responseBody = response.getBody().asString();

        JsonPath jsonPath = new JsonPath(responseBody);
        String token = jsonPath.get("token");
        return token;
    }
}
//    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
//    private static final String USERNAME = "admin";
//    private static final String PASSWORD = "password123";
//
//    public static Response getAuthToken() {
//        Response response = given()
//                .baseUri(BASE_URL)
//                .auth()
//                .preemptive()
//                .basic(USERNAME, PASSWORD)
//                .when()
//                .post("/auth");
//
//        String responseBody = response.getBody().asString();
//        System.out.println(responseBody);
//        JsonPath jsonPath = new JsonPath(responseBody);
//        String token = jsonPath.get("token");
//        System.out.println(token);
//        return response;
//        return response.jsonPath().getString("token");
//    }
//}
