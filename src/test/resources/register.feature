@register
Feature: validate register test suite

  Background: Navigate to the home page
    Given the user is on the register page

  @testcase04
  Scenario Outline: Verify valid data can register
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    And the user accepts Privacy Policy terms
    When the user clicks the continue register button
    Then the user is registered successfully
    Examples:
      | firstName | lastName | email                |  telephone  |  password  | passwordConfirm |
      | Laura     |  Del Rio | pruebas2@hotmail.com | 555555555   |  123456    | 123456          |

  @testcase05
  Scenario Outline: Verify invalid data cannot register
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    And the user accepts Privacy Policy terms
    When the user clicks the continue register button
    Then The user should be shown some error messages
    Examples:
      | firstName | lastName | email |  telephone  |  password  | passwordConfirm |
      |           |          |       |             |            |                 |

