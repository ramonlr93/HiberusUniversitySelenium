@logout
Feature: Logout test suite

  Background:
    Given the user is on the home page

  @testcase13
  Scenario Outline: Verify valid user can logout
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user is clicks the logout link
    Then the user is logout successfully

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |