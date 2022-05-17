Feature: Logout

  Background:
    Given the user is on the home page
    And the user provides the username "standard_user"
    And the user provides the password "secret_sauce"
    And the user clicks the login button

  Scenario: Verify the logout
    When the user clicks on the lateral panel
    And the user clicks on the log out button
    Then the page redirects to the login page