@logOut
Feature: logOut test suite

  Background:
    Given the user is on the home page

  @testcase14
    @smoke
  Scenario Outline: Check the logout button
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks on the menu
    When the user clicks on logOut button
    Then the user is on the home page
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
