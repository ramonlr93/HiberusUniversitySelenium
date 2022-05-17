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

  Scenario Outline: Verify invalid user cannot login
    Then the user should be shwon and invalid message

    Examples:
      | username   | password      |
      | bad_user   | secret_sauce  |
