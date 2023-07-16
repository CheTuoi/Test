Feature: Post booking

  @PostBooking_TC_01
  Scenario: Create booking successfully
    When I send POST request to create booking
    Then I should receive a successfully response when post
    And Verify response body


  @PostBooking_TC_02
  Scenario Outline: Create booking with different data
    When I send POST request to create booking
    Then I should receive a successfully response when post
    And Verify response body

    Examples:
    |firstname |lastname |totalprice |depositpaid |checkin   |checkout  |additionalneeds |status |expectedresult|
    |          |Brown    |111        |true        |2018-01-01|2019-01-01|Breakfast       |200    |              |
    |Fresheeeee|Brown    |111        |true        |2018-01-01|2019-01-01|Breakfast       |200    |Fresheeeee    |
    |àáâ       |Brown    |111        |true        |2018-01-01|2019-01-01|Breakfast       |200    |àáâ           |
    |/\,;:     |Brown    |111        |true        |2018-01-01|2019-01-01|Breakfast       |200    |/\,;:         |
