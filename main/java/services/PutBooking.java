package services;

import helper.AuthenticationUtils;
import helper.BookingContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Booking;
import org.testng.Assert;

public class PutBooking {
    private Booking booking;

    private Response res;

    private BookingContext bookingContext = new BookingContext();

    public void updateBooking(){
        booking = Booking.getInstance();
        this.res = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .header("Cookie", "token=" + AuthenticationUtils.getAuthToken())
                .body(booking)
                .put("https://restful-booker.herokuapp.com/booking/" + bookingContext.getBookingId());
        String responseBody = this.res.getBody().asString();
        System.out.println(responseBody);

        Booking.bookingInfo = booking;
    }

    public void verifyResponseStatus(int expectedResponseStatus){
        int actualResponseStatus = this.res.getStatusCode();
        Assert.assertEquals(actualResponseStatus, expectedResponseStatus);
    }

    public void verifyResponseBody(){
        String firstName = this.res.path("firstname");
        Assert.assertEquals(firstName, Booking.bookingInfo.getFirstname());
        String lastName = this.res.path("lastname");
        Assert.assertEquals(lastName, Booking.bookingInfo.getLastname());
        int totalPrice = this.res.path("totalprice");
        Assert.assertEquals(totalPrice, Booking.bookingInfo.getTotalprice());
        boolean depositPaid = this.res.path("depositpaid");
        Assert.assertEquals(depositPaid, Booking.bookingInfo.isDepositpaid());
        String checkIn = this.res.path("bookingdates.checkin");
        Assert.assertEquals(checkIn, Booking.bookingInfo.getBookingdates().get("checkin"));
        String checkOut = this.res.path("bookingdates.checkout");
        Assert.assertEquals(checkOut, Booking.bookingInfo.getBookingdates().get("checkout"));
        String additionalNeeds = this.res.path("additionalneeds");
        Assert.assertEquals(additionalNeeds, Booking.bookingInfo.getAdditionalneeds());
    }

}
