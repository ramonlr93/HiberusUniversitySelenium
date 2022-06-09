@register
Feature: validate register correct test suite

  Background:
    Given the user is on the home page
    And the user clicks on myAccountButton
    And the user clicks on registerSelectOption
    And the user go to RegisterPage

  @smoke-register-correct
  Scenario Outline: the user register is successfully
    And the user introduces his register information: "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>", "<confirmPassword>"
    And the user clicks Privacy Policy
    And the user clicks continueButton
    Then the user see Success Account Page

    Examples:
      | firstName | lastName  | email                 | telephone | password     | confirmPassword |
      | Miguel    | Fernandez | miguelfdz@terra.com | 685475986 | picaporte321 | picaporte321    |

  @smoke-register-email-used
  Scenario Outline: the user register is successfully
    And the user introduces his register information: "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>", "<confirmPassword>"
    And the user clicks Privacy Policy
    And the user clicks continueButton
    Then the user introduces an email registered in the data base and it showed a warning message

    Examples:
      | firstName | lastName  | email               | telephone | password     | confirmPassword |
      | Miguel    | Fernandez | carrabmin@gmail.com | 685475986 | picaporte321 | picaporte321    |