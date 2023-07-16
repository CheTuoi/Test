Feature: Put booking
  Background:
    When I send POST request to create booking

  @PutBooking_TC_01
  Scenario: Put booking
    When I send PUT request to update booking
    Then I should receive a successfully response when put
    And Verify response body when put
