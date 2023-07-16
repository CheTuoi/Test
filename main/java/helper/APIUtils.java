package helper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Booking;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtils {
    private Response res;
    public void createBooking(Object body, String path){
        RestAssured.baseURI = ConfigReader.readBaseUriFromProperties();
        this.res = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(body)
                .post(path);
    }

    public void getBookingByFields(Map param){
        RestAssured.baseURI = ConfigReader.readBaseUriFromProperties();
        Response response = given().queryParams(param)
                .when().get();
    }

    public void deleteBooking(String bookingId) {
        RestAssured.baseURI = ConfigReader.readBaseUriFromProperties();
        RestAssured.given()
                .log().all()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + AuthenticationUtils.getAuthToken())
                .delete("/booking/" + bookingId);
<<<<<<< HEAD
=======
	System.out.println("zzz");
>>>>>>> 8e20f42 (add fresh)
    }

}
