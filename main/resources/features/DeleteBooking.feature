Feature: Delete booking
  Background:
    When I send POST request to create booking

  @DeleteBooking_TC_01
  Scenario: Delete booking
    When I send DELETE request to delete booking
    Then I should receive a successfully response when delete
