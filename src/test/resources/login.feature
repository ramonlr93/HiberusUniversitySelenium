@login
Feature: Login test suite

  Background:
    Given the user is in the landing page
    And the user click on login button
  @smoke
    @testcase-1
  Scenario Outline: Verify valid user can login
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the user is logged

    Examples:
      | mail                 | password  |
      | manape79@hotmail.com | Manape195 |

  @testcase-2
  Scenario Outline: Verify invalid login
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail                  | password  |
      | manape798@hotmail.com | Manape195 |


