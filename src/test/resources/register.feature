@register
Feature: Login test suite

  Background:
    Given the user go to the home page
    And the user go to the register page

  @testcase01
  Scenario Outline: Verify valid user can register
    And the user provides the first name "<firstName>"
    And the user provides the last name "<lastName>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password "<password>"
    And the user provides the password confirm "<password>"
    And the user checked checkbox
    When the user clicks the continue button
    Then the user should be shown and invalid message

    Examples:
      | firstName | lastName | email                | telephone | password |
      | flor      | qa       | flor.qa1@yopmail.com | 612345678 | 123456   |
      | flor      | qa       | flor.qa@yopmail.com  | 612345678 | 123456   |

  @testcase02
  Scenario Outline: Verify valid user can not register, missing checked checkbox
    And the user provides the first name "<firstName>"
    And the user provides the last name "<lastName>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password "<password>"
    And the user provides the password confirm "<password>"
    When the user clicks the continue button
    Then the user should be shown and invalid message

    Examples:
      | firstName | lastName | email               | telephone | password |
      | flor      | qa       | flor.qa@yopmail.com | 612345678 | 123456   |