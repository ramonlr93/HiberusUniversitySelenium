@login
Feature: validate login test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase07
  @smoke
  Scenario Outline: Verify valid user can login
    And the user clicks My account link
    And the user clicks Login link
    And the user provides the mail "<mail>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully
    Examples:
      | mail                | password  |
      | pruebas@hotmail.com | 123456    |

  @testcase08
  Scenario Outline: Verify invalid user cannot login
    And the user clicks My account link
    And the user clicks Login link
    And the user provides the mail "<mail>" and password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      | mail               | password |
      | pruebashotmail.com | 123456   |

  @testcase09
  Scenario Outline: Verify forgotten password
    And the user clicks My account link
    And the user clicks Login link
    And the user clicks on Forgotten Password
    And the user provides the mail "<mail>"
    When the user clicks the continue button
    Then The user should be shown a confirmation message
    Examples:
      | mail                |
      | pruebas@hotmail.com |