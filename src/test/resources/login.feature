@login
Feature: validate login test suite

  Background:
    Given the user is on the home page
    And the user clicks on myAccountButton
    And the user clicks on loginSelectOption
    And the user go to LoginPage

  @smoke-login-correct
  Scenario Outline: Verify valid user can login
    And the user introduces his email "<email>" and password "<password>"
    And the user clicks on the login button
    Then the user see Your Store Page
    Examples:
      | email               | password  |
      | carrabmin@gmail.com | hlarsson7 |

  @smoke-login-incorrect
  Scenario Outline: Verify invalid user cannot login
    And the user introduces his email "<email>" and password "<password>"
    When the user clicks on the login button
    Then the user should be shown an error message
    Examples:
      | email    | password     |
      | bad_user | bad_password |