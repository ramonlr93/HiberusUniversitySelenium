@login
Feature: Register test suite

  Background:
    Given the user is on the login page

  @testcase01
    @smoke
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | email                  | password   |
      | ksanabriad@yopmail.com | katherinQA |

  @testcase02
    @smoke
  Scenario Outline: Verify valid user cannot login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown and invalid message

    Examples:
      | email                  | password     |
      | ksanabriad@yopmail.com | katherin |