package services;

import helper.DataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Booking;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetBooking {
    String url = "https://restful-booker.herokuapp.com/booking";
    public Response getBookingByID() {

        Response response = RestAssured.get(url);

        return response;
    }

    public Response getBookingByFirstNameLastName(){
        Response response = given().queryParams("firstname", Booking.bookingInfo.getFirstname())
                        .queryParams("lastname", Booking.bookingInfo.getLastname()).log().all()
                        .when().get(url);
                response.then().log().all();
                response.then().statusCode(200);
        return response;
    }

    public Response getBookingByCheckinCheckout(){
        Response response = given().queryParams("checkin", Booking.bookingInfo.getBookingdates().get("checkin"))
                .queryParams("checkout", Booking.bookingInfo.getBookingdates().get("checkout")).log().all()
                .when().get(url);
        response.then().log().all();
        response.then().statusCode(200);
        return response;
    }

    public void verifyResponseStatus(int expectedResponseStatus){
        int responseStatus = getBookingByID().getStatusCode();
        Assert.assertEquals(expectedResponseStatus, responseStatus);
    }

    public void verifyResponseBodyContains(Response response, String expectedString) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedString));
    }

}
