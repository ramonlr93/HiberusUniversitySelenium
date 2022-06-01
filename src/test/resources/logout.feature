@logout
Feature: logout
  Scenario Outline: Verify valid user can login
    Given the user is on the home page
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    And the user clicks option menu
    And the user clicks logout button
    Then the user is on the home page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |