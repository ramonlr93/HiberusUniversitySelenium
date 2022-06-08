@register
Feature: validate register test suite

  Background:
    Given the user is on the register page

  @testcase01
    @smoke
  Scenario Outline: Navigate to the register page
    And user enter "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>"
    And choose if he wants to accept newsletter
    And agree with privacy policy
    When clicks on continue button
    Then user should see the success message
    Examples:
      | firstName | lastName | email                  | telephone | password  |
      | Jodie     | Foster   | jooodiE604@game4hr.com | 999999999 | Caviko609 |



