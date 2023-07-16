package stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import services.*;

public class MyStepdefs {

    GetBooking getBooking = new GetBooking();
    PostBooking postBooking = new PostBooking();
    DeleteBooking deleteBooking = new DeleteBooking();

    PutBooking putBooking = new PutBooking();

    PatchBooking patchBooking = new PatchBooking();

    @When("I send GET request to get booking by id")
    public void getBookingByID() {
        getBooking.getBookingByID();
    }

    @Then("I should receive a successfully response")
    public void verifyResponseStatus() {
        getBooking.verifyResponseStatus(200);
    }


    @Then("The response should contain booking id")
    public void verifyResponseBody() {
        getBooking.verifyResponseBodyContains(getBooking.getBookingByID(), "bookingid");
    }

    @When("I send POST request to create booking")
    public void createBooking(){
        postBooking.createBooking();
    }

    @Then("I should receive a successfully response when post")
    public void verifyResponseStatusOfPost(){
        postBooking.verifyResponseStatus(200);
    }

    @And("Verify response body")
    public void verifyResponseBodyOfPost(){
        postBooking.verifyResponseBody();
    }

//    @When("I send POST request to create booking with different data")
//    public void createBookingWithDifferentData(){
//        postBooking.createBookingWithDifferentData();
//    }
    @And("I send GET request by firstname and lastname")
    public void getBookingByFirstNameLastName(){
        getBooking.getBookingByFirstNameLastName();
    }

    @And("I send GET request by checkin and checkout")
    public void getBookingByCheckinCheckout(){
        getBooking.getBookingByCheckinCheckout();
    }

    @Then("The response filtered by checkin and checkout should contain booking id")
    public void verifyResponseByCheckinCheckout(){
        getBooking.verifyResponseBodyContains(getBooking.getBookingByCheckinCheckout(), "bookingid");
    }

    @When("I send DELETE request to delete booking")
    public void deleteBooking(){
        deleteBooking.deleteBooking();
    }

    @Then("I should receive a successfully response when delete")
    public void verifyResponseStatusOfDelete(){
        deleteBooking.verifyResponseStatus(201);
    }

    @When("I send PUT request to update booking")
    public void putBooking(){
        putBooking.updateBooking();
    }

    @Then("I should receive a successfully response when put")
    public void verifyResponseStatusOfPut(){
        putBooking.verifyResponseStatus(200);
    }

    @And("Verify response body when put")
    public void verifyResponseBodyOfPut(){
        putBooking.verifyResponseBody();
    }

    @When("^I send PATCH request to update booking with firstname is (.*)$")
    public void patchBooking(String firstName){
        patchBooking.updateBooking(firstName);
    }

    @Then("I should receive a response is {int}")
    public void i_should_receive_a_response_is(Integer responseStatus) {
        patchBooking.verifyResponseStatus(responseStatus);

        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @And("^Verify response body when patch with firstname is (.*)$")
    public void verifyResponseBodyOfPatch(String firstName){
        patchBooking.verifyResponseBody(firstName);
    }



//    @Then("I should receive a response is {int}  when patch")
//    public void iShouldReceiveAResponseIsWhenPatch(String arg0) {
//    }
}
