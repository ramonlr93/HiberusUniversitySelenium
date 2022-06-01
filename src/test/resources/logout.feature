@Logout
Feature: Logout test suite

  Background:
    Given the user is on the home page
    And the user provides the username "standard_user"
    And the user provides the password "secret_sauce"
    When the user clicks the login button

  @TestCase14
  Scenario: Verify valid user can login
    When the user clicks the burger menu and select logout
    Then the user is logout
