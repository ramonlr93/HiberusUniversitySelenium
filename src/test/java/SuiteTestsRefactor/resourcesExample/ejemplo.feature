Feature: Login test suite example

#Extendido
  Scenario Outline: Verify valid user can login example
    Given the user is on the home page
    And the user providers the username "<username>"
    And the user providers the password "<password>"
    When the user click the login button
    Then the user is logged successfully and is into the inventory page

  Examples:
    | username      | password     |
    | standard_user | secret_sauce |

  Scenario Outline: Verify valid user can not login example
    Given the user is on the home page
    And the user providers the username "<username>"
    And the user providers the password "<password>"
    When the user click the login button
    Then the user should be swon and invalid message

  Examples:
    | username | password     |
    | bad_user | secret_sauce |