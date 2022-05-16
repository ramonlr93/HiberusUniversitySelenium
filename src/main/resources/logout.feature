@Logout
Feature: Logout test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button

  Scenario Outline: Verify valid user can login
    When the user clicks the burger menu and select logout
    Then the user is logout

    Examples:
          | username        | password      |