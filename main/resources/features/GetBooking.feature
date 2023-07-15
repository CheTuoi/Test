Feature: Get booking

  @GetBooking_TC_01
  Scenario: Get booking by id
    When I send GET request to get booking by id
    Then I should receive a successfully response
    Then The response should contain booking id


  @GetBooking_TC_02
  Scenario: Get booking by firstname and lastname
    When I send POST request to create booking
    And I send GET request by firstname and lastname
    Then The response should contain booking id

  @GetBooking_TC_03
  Scenario: Get booking by checkin and checkout
    When I send POST request to create booking
    And I send GET request by checkin and checkout
    Then The response filtered by checkin and checkout should contain booking id
