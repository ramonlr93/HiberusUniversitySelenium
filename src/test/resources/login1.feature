Feature: Login Test Suite

  Background: Navigate to the home page
    Given the user is on the home page

  Scenario Outline: Verify valid user can login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the clicks the login button
    Then the user logged in succesfully

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Verify invalid user cant login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the clicks the login button
    Then a message error should be shown

    Examples:
      | username   | password     |
      | bad_user   | secret_sauce |