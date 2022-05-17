Feature: LogOut test suite

  Background: Navigate to the home page https://www.saucedemo.com
    Given the user is on the home page https://www.saucedemo.com
    And the user provides the username "username" and the password "password"
    And the user clicks the login button and access to inventory page

  Scenario Outline: Check Logout
    And the user click and open out the left "list Menu"
    And the user click the "Logout" button
    Then the Login page appear

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |