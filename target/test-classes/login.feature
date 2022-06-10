@login
Feature: Login test suite

  Background:
    Given the user is in the landing page
    And the user click on login button

  @smoke
    @testcase-1

  Scenario Outline: Verify valid user
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the user is logged



    Examples:
      | mail           | password |
      | sutto@mail.com | sutto     |

  @testcase-2
  Scenario Outline: Verify invalid user (incorrect mail)
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail               | password |
      | mimail@hiberus.com | 0000     |


  @testcase-3
  Scenario Outline: Verify invalid user (incorrect password)
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail           | password |
      | sutto@mail.com | 0001     |