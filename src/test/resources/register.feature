@register
Feature: Register test suite

  Background:
    Given the user is on the register page

  @testcase01
    @smoke
  Scenario Outline: Verify that the user is register successfully
    And the user provides the register information "<firstName>","<lastName>","<telephone>","<password>" and "<passwordConfirm>"
    And the user subscribe to the newsletter
    And the user clicks agree to the privacy policy
    When the user clicks the continue button
    Then the user is in the register account successfully page
    Examples:
      | firstName | lastName | telephone | password   | passwordConfirm |
      | Katherin  | Sanabria | 633101010 | katherinQA | katherinQA      |

  @testcase02
  Scenario Outline: Verify the error message if any field of the form is empty
    And the user provides the register information "<firstName>","<lastName>","<email>","<telephone>","<password>" and "<passwordConfirm>"
    And the user clicks agree to the privacy policy
    When the user clicks the continue button
    Then the user should be shown an invalid message
    Examples:
      | firstName | lastName | email | telephone | password | passwordConfirm |
      |           |          |       |           |          |                 |


  @testcase03
  Scenario Outline: Verify alert when E-mail is already registered
    And the user provides the email "<email>"
    And the user clicks agree to the privacy policy
    When the user clicks the continue button
    Then the user should be shown an invalid email message
    Examples:
      | email           |
      | kat@yopmail.com |

  @testcase04
  Scenario Outline: Verify the alert if password doesnt match with the password confirmation
    And the user provides the password "<password>"
    And the user provides the passwordConfirmation "<passwordConfirm>"
    And the user clicks agree to the privacy policy
    When the user clicks the continue button
    Then the user should be shown and alert "Password confirmation does not match password!"
    Examples:
      | password  | passwordConfirm |
      | HolaTodos | HolaTodo        |

  @testcase03
  Scenario: Verify the warning when the user must agree to the privacy policy
    And the user clicks the continue button
    Then the user should be shown an warning message
