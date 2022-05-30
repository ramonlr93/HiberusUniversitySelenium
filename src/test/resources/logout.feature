@logout
Feature: LogOut test suite

  Background:
    Given the user is on the home page

  @logout-1
  Scenario Outline: Check the logout
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks the menuButton
    When the user clicks the logout link
    Then the user is in the login page
    Examples:
      | username | password     |
      | standard_user | secret_sauce |

