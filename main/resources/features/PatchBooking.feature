Feature: Patch booking

  Background:
    When I send POST request to create booking

  @PatchBooking_TC_01
  Scenario Outline: Patch booking
    When I send PATCH request to update booking with firstname is <firstname>
    Then I should receive a response is <responseStatus>
    And Verify response body when patch with firstname is <responseBody>

    Examples:
      | firstname   | responseStatus | responseBody |
      | "freshee"   | 200            | freshee      |
      |             | 200            |              |
      | "  freshee" | 200            | freshee      |
      | "ahihi    " | 200            | ahihi        |
      | )"(         | 200            | )"(          |
