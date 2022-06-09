@register
Feature: Register test suite

  Background:
    Given the user is in the register page


  @RegisterOK
  @smoke
  Scenario Outline: Verify valid user can register
    And the user fills the firstname "<firstname>"
    And the user fills the lastname "<lastname>"
    And the user fills the email "<email>"
    And the user fills the telephone "<telephone>"
    And the user fills the pass "<password>"
    And the user fills the confirm "<confirm>"
    And the user clicks on privacy button
    When the user clicks on continue button
    Then the user is registered

    Examples:
      | firstname | lastname | email                 | telephone | password | confirm |
      | pepe      | perez    | pepeperez@hiberus.com | 666666666 | 1234     | 1234    |

  @RegisterKO
  Scenario Outline: Verify invalid register (repeated email)
    And the user fills the firstname "<firstname>"
    And the user fills the lastname "<lastname>"
    And the user fills the email "<email>"
    And the user fills the telephone "<telephone>"
    And the user fills the pass "<password>"
    And the user fills the confirm "<confirm>"
    And the user clicks on privacy button
    When the user clicks on continue button
    Then the user is not registered

    Examples:
      | firstname | lastname | email                 | telephone | password | confirm |
      | luis      | lopez    | pepeperez@hiberus.com | 666666666 | 6666     | 6666    |