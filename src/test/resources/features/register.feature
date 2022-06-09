@register
Feature: validate register test suite

  Background: Navigate to the register page
    Given the user is on the home page
    And the user clicks MyAccount
    And the user click Register

  @testcase03
    @smoke
  Scenario Outline: Verify user can register correctly
    And the user provides the firstName "<firstName>", the lastName "<lastName>", the email "<email>" and the telephone "<telephone>"
    And the user provides the password "<password>" and confirm the password "<confirmPassword>"
    And the user checks the Private Policy check
    When the user clicks the continue button
    Then the user is register successfully and is into the account-success page
    Examples:
      | firstName | lastName     | email                   | telephone      | password     | confirmPassword |
      | Prueba    | Usuario      | prueba.usuario@pu.com   | 600000000      | password     | password        |

  @testcase04
  Scenario Outline: Verify user doesn't check the Private Policy
    And the user provides the firstName "<firstName>", the lastName "<lastName>", the email "<email>" and the telephone "<telephone>"
    And the user provides the password "<password>" and confirm the password "<confirmPassword>"
    When the user clicks the continue button
    Then a warning message appear on the top of the page
    Examples:
      | firstName | lastName     | email                   | telephone      | password     | confirmPassword |
      | Prueba    | Usuario      | prueba.usuario@pu1.com  | 600000000      | password     | password        |

  @testcase05
  Scenario Outline: Verify user enter an invalid option in the information
    And the user provides the firstName "<firstName>", the lastName "<lastName>", the email "<email>" and the telephone "<telephone>"
    And the user provides the password "<password>" and confirm the password "<confirmPassword>"
    And the user checks the Private Policy check
    When the user clicks the continue button
    Then a message appear on the field that is invalid
    Examples:
      | firstName | lastName     | email            | telephone      | password     | confirmPassword |
      |           | Usuario      | prueba@usuario   | 600000000      | password     | password        |