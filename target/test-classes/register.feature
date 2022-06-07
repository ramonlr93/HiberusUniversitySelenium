@register
Feature: Register test suite

  Background:
    Given the user is in the register page

  @smoke
    @RegisterOK
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
      | firstname | lastname | email                    | telephone | password  | confirm   |
      | User      | Test     | testdos@hiberus.com      | 66666666  | 191919    | 191919    |