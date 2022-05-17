Feature: Login test suite

  Background:
    Given the user is on the home page


  Scenario Outline: Verify valid user can login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully and is into the inventory page
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Verify invalid user can't login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the page shows a error message
    Examples:
      | username      | password     |
      | bad_user      | secret_sauce |
      | standard_user | bad_password |