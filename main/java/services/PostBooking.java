package services;

import helper.AuthenticationUtils;
import helper.BookingContext;
import helper.ExcelHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Booking;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostBooking {

    private Booking booking;

    private Response res;

    private BookingContext bookingContext = new BookingContext();

    public void createBooking(){
        booking = Booking.getInstance();
        this.res = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(booking)
                .post("https://restful-booker.herokuapp.com/booking");
        String responseBody = this.res.getBody().asString();

        JsonPath jsonPath = new JsonPath(responseBody);
        int bookingId = jsonPath.getInt("bookingid");
        System.out.println(bookingId);
        bookingContext.setBookingId(bookingId);
        Booking.bookingInfo = booking;
    }

    public void createBookingWithDifferentData(String firstName, String lastName, String totalPrice, String checkin, String checkout, String additionalNeeds){
        firstName = firstName.replace("\"","");
        lastName = lastName.replace("\"","");
        totalPrice = totalPrice.replace("\"","");
        checkin = checkin.replace("\"","");
        checkout = checkout.replace("\"","");
        additionalNeeds = additionalNeeds.replace("\"","");
        JSONObject requestParams = new JSONObject();
        requestParams.put("firstname", firstName);
        requestParams.put("lastname", lastName);
        requestParams.put("totalprice", totalPrice);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);
        requestParams.put("bookingdates", bookingDates);
        requestParams.put("additionalneeds", additionalNeeds);
        this.res = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(requestParams.toString())
                .post("https://restful-booker.herokuapp.com/booking");
        String responseBody = this.res.getBody().asString();

        JsonPath jsonPath = new JsonPath(responseBody);
        int bookingId = jsonPath.getInt("bookingid");
        System.out.println(bookingId);
        bookingContext.setBookingId(bookingId);
        Booking.bookingInfo = booking;
    }

    public void verifyResponseStatus(int expectedResponseStatus){
        int actualResponseStatus = this.res.getStatusCode();
        Assert.assertEquals(actualResponseStatus, expectedResponseStatus);
    }

    public void verifyResponseBody(){
        String firstName = this.res.path("booking.firstname");
        Assert.assertEquals(firstName, Booking.bookingInfo.getFirstname());
        String lastName = this.res.path("booking.lastname");
        Assert.assertEquals(lastName, Booking.bookingInfo.getLastname());
        int totalPrice = this.res.path("booking.totalprice");
        Assert.assertEquals(totalPrice, Booking.bookingInfo.getTotalprice());
        boolean depositPaid = this.res.path("booking.depositpaid");
        Assert.assertEquals(depositPaid, Booking.bookingInfo.isDepositpaid());
        String checkIn = this.res.path("booking.bookingdates.checkin");
        Assert.assertEquals(checkIn, Booking.bookingInfo.getBookingdates().get("checkin"));
        String checkOut = this.res.path("booking.bookingdates.checkout");
        Assert.assertEquals(checkOut, Booking.bookingInfo.getBookingdates().get("checkout"));
        String additionalNeeds = this.res.path("booking.additionalneeds");
        Assert.assertEquals(additionalNeeds, Booking.bookingInfo.getAdditionalneeds());
    }

//    @Test(dataProvider = "data")
//    public void createBookingWithDifferentData(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds, int status, String expectedresult) {
//        booking.setFirstname(firstname);
//        booking.setLastname(lastname);
//        booking.setTotalprice(totalprice);
//        booking.setDepositpaid(depositpaid);
//        HashMap<String, String> bookingDateInfo = new HashMap<>();
//        bookingDateInfo.put("checkin", checkin);
//        bookingDateInfo.put("checkout", checkout);
//        booking.setBookingdates(bookingDateInfo);
//        booking.setAdditionalneeds(additionalneeds);
//
//        this.res = RestAssured.given().log().all()
//                .contentType(ContentType.JSON)
//                .accept("application/json")
//                .body(booking)
//                .post("https://restful-booker.herokuapp.com/booking");
//
////        int actualResponseStatus = response.getStatusCode();
//        this.expectedStatusFromExcel = status;
//    }
//    public void verifyBookingWithDifferenceData(){
//        Assert.assertEquals(this.res.getStatusCode(), expectedStatusFromExcel);
//        String responseBody = this.res.getBody().asString();
//        System.out.println(responseBody);
//
//    }
//
//    @DataProvider(name = "data")
//    public Object[][] getData(){
//        return ExcelHelper.getData("CreateBooking");
//    }


    // Use the response object to perform assertions or extract information
//    String responseBody = response.getBody().asString();



}
