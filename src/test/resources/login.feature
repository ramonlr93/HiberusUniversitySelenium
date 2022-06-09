@login
Feature: Login test suite

  Background:
    Given the user go to the home page
    And the user go to the login page

  @testcase03
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | email               | password |
      | flor.qa@yopmail.com | 123456   |

  @tescase04
  Scenario Outline: Verify valid user can not login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown and invalid message

    Examples:
      | email               | password |
      | flor.qa@yopmail.com | 12346   |