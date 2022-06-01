@logout
Feature: logout test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase13
  Scenario Outline: User logout
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    When the user clicks the logout option
    Then the user is again on the home page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
