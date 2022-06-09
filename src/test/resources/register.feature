@register
Feature: validate register test suite

  Background: Navigate to the register page
    Given the user is on the register page

  @testcase01
    @smoke
  Scenario Outline: Validate completed registration
    And user enter "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>"
    And choose if he wants to accept newsletter
    And agree with privacy policy
    When clicks on continue button
    Then user should see the success message
    Examples:
      | firstName | lastName | email                     | telephone | password  |
      | Jodie     | Foster   | jodie10804@game4hr.com | 999999999 | Caviko609 |

  @testcase02
  Scenario Outline: validate already registered account
    And user enter "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>"
    And choose if he wants to accept newsletter
    And agree with privacy policy
    When clicks on continue button
    Then user should see error message, account already registered
    Examples:
      | firstName | lastName | email                  | telephone | password  |
      | Jodie     | Foster   | jooodiE604@game4hr.com | 999999999 | Caviko609 |

  @testcase03
  Scenario Outline: validate E-Mail Address does not appear to be valid!
    And user enter "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>"
    And choose if he wants to accept newsletter
    And agree with privacy policy
    When clicks on continue button
    Then user should see error message, E-Mail Address does not appear to be valid!
    Examples:
      | firstName | lastName | email | telephone | password  |
      | Jodie     | Foster   |       | 999999999 | Caviko609 |

