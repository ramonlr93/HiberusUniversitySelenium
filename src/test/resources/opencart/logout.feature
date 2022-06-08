@logout
Feature: Logout test suite

  Background:
    Given the user is in the main page
    And the user goes to login

  @testcase-18
  Scenario Outline: Verify valid user can logout
    And the user provides the mail "<mail>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user clicks logout
    Then the user is in logout page
    Examples:
      | mail                 | password  |
      | herceclase@gmail.com | David2001 |

