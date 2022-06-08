@login
Feature: Login test suite

  Background:
    Given the user is in the landing page
    And the user click on login button

  @smoke
    @testcase-01
#  Scenario Outline: Log in with existing user
#    And type the mail in the "<mail>" field
#    And type the password in the "<password>" field
#    When click on login button
  Scenario Outline: Verify valid user
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the user is logged
#    And the user fills the mail "<mail>"
#    And the user fills the password "<password>"
#    When the user clicks on login button
#    Then the user is logged
#    And the user fills the mail "<mail>"
#    And the user fills the password "<password>"
#    When the user clicks on login button


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