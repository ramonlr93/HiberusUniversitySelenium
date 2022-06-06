@login
Feature: validate login test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase01
  @smoke
  Scenario Outline: Verify valid user can login
    And the user clicks My account link
    And the user clicks Login link
    Given the user is on the login page
    And the user provides the mail "<mail>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully
    Examples:
      | mail                | password  |
      | pruebas@hotmail.com | 123456    |

  @testcase02
  Scenario Outline: Verify invalid user cannot login
    And the user clicks My account link
    And the user clicks Login link
    Given the user is on the login page
    And the user provides the mail "<mail>" and password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      | mail               | password |
      | pruebashotmail.com | 123456   |

  @testcase03
  Scenario Outline: Verify invalid user cannot login
    And the user clicks My account link
    And the user clicks Login link
    Given the user is on the login page
    And the user clicks on Forgotten Password
    Given the user is on the forgottenPassword page
    And the user provides the mail "<mail>"
    When the user clicks the continue button
    Given the user is on the login page
    Then The user should be shown a confirmation message
    Examples:
      | mail               |
      | pruebashotmail.com |