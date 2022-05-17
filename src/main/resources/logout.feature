Feature: Logout test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks the login button
    When the user clicks the logout link

  Scenario: Verify valid user can logout
    Then the user is logged out successfully
