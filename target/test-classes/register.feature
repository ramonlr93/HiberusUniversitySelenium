@register
Feature: Register test suite

  Background:
    Given the user is in the register page

  @smoke
  @testcase-4
  Scenario Outline: Verify valid user registers
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the pass "<password>"
    And the user provides the confirm "<confirm>"
    And the user clicks on privacy button
    When the user clicks on continue button
    Then the user is registered

    Examples:
      | firstname | lastname | email                     | telephone | password  | confirm   |
      | User      | Test     | testtrece-hiberus.com     | 66666666  | 181818    | 181818    |

  @testcase-5
  Scenario Outline: Verify invalid user registers
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the pass "<password>"
    And the user provides the confirm "<confirm>"
    And the user clicks on privacy button
    When the user clicks on continue button
    Then the user is registered

    Examples:
      | firstname | lastname | email                     | telephone | password  | confirm   |
      | User      | Test     | testdoce-hiberu           | 6         | 181819    | 181819    |