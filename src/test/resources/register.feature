@register

Feature: Register test suite

  Background:
    Given the user is on the landing page
    And the user clicks on register button

  @testcase-03
  Scenario Outline: Verify valid user can register
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user is registered successfully

    Examples:
      | password  | firstname | lastname | phone     |
      | test987   | Testuno   | User     | 666666666 |