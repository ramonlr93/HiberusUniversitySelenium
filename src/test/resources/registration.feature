@register
Feature: validate register test suite

  Background:
    Given the user is on the register page

  Scenario Outline: Navigate to the register page
    When user enter "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>"
    And choose if he wants to accept newsletter
    And agree with privacy policy
    And clicks on continue button
    Then user should see the success message
    Examples:
      | firstName | lastName | email                  | telephone | password  |
      | Jodie     | Foster   | jodieE604@game4hr.com | 999999999 | Caviko609 |



