@login
Feature: Login test suite

  Background:
    Given the user is on the home page

  @smoke
  @login-01
  Scenario Outline: Verify valid user can login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

  @login-02
  Scenario Outline: Verify valid user cannot login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown and invalid message

    Examples:
      | username   | password      |
      | bad_user   | secret_sauce  |