Feature: Testing the create user functionality

  Scenario: Validating the successful user creation

    Given User get request with correct authorization
    Then User pass request body
    Then User validates the response body


  Scenario Outline: Validating the negative test for a new user creation
    Given User get request with negative authorization '<token>'
    When User pass wrong request body '<name>', '<gender>', '<email>', '<status>'
    Then user validates the response body error

    Examples:
      | token             | name | gender | email | status |
      | 38u74fdgbg nfgh n | test | gender | email | active |
