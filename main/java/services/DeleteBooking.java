package services;

import helper.AuthenticationUtils;
import helper.BookingContext;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Booking;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class DeleteBooking {

//    String url = "https://restful-booker.herokuapp.com/booking";
    private Response res;

    public void deleteBooking() {
        BookingContext bookingContext = new BookingContext();
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        this.res = RestAssured.given()
                .log().all()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + AuthenticationUtils.getAuthToken())
                .delete("/booking/" + bookingContext.getBookingId());
    }

    public void verifyResponseStatus(int expectedResponseStatus){
        int actualResponseStatus = this.res.getStatusCode();
        Assert.assertEquals(actualResponseStatus, expectedResponseStatus);
    }


}
