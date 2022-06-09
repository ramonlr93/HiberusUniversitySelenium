@logout
Feature: Logout test suite

  Background:
    Given the user is in the landing page
    And the user clicks the login button

  @smoke
    @testcase-6
  Scenario Outline: Verify valid logout
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    And the user clicks on login button
    When the user clicks on logout button
    Then the user is in logout page

    Examples:

      | mail                 | password  |
      | manape79@hotmail.com | Manape195 |

