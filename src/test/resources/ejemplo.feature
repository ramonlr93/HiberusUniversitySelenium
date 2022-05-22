// Extendido

Feature: Login test suite

  Scenario Outline: Verify valid user can login
    Given the user is on the home page
    And the user providers the username "username"
    And the user providers the password "password"
    When the user click the login button
    Then the user is logged successfully and is into the inventory page

  Examples:
    | username      | password     |
    | standard_user | secret_sauce |

  Scenario Outline: Verify valid user can login
    Given the user is on the home page
    And the user providers the username "username"
    And the user providers the password "password"
    When the user click the login button
    Then the user should be swon and invalid message

  Examples:
    | username | password     |
    | bad_user | secret_sauce |


//Refactorizado

Feature: Login test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button

  Scenario Outline: Verify valid user can login
    Then the user is logged successfully

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

  Scenario Outline: Verify valid user can login
    Then the user should be shwon and invalid message

    Examples:
      | username   | password      |
      | bad_user   | secret_sauce  |
