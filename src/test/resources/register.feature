@register
Feature: validate register test suite

  Background: Navigate to the home page
    Given the user is on the register page

  @testcase01
    @smoke
  Scenario Outline: Verify valid data can register
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    And the user accepts Privacy Policy terms
    When the user clicks the continue register button
    Then the user is registered successfully
    Examples:
      | firstName | lastName | email                 |  telephone  |  password  | passwordConfirm |
      | Laura     |  Del Rio | pruebas19@hotmail.com | 555555555   |  123456    | 123456          |

  @testcase02
  Scenario Outline: Verify invalid data cannot register
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    And the user accepts Privacy Policy terms
    When the user clicks the continue register button
    Then The user should be shown some error messages
    Examples:
      | firstName | lastName | email |  telephone  |  password  | passwordConfirm |
      |           |          |       |             |            |                 |

  @testcase03
  Scenario Outline: Verify password and confirm password must match
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    And the user accepts Privacy Policy terms
    When the user clicks the continue register button
    Then the user should be shown a password not match error message
    Examples:
      | firstName | lastName | email                 |  telephone  |  password  | passwordConfirm |
      | Laura     |  Del Rio | pruebas22@hotmail.com | 555555555   |  123456    | 111111          |

  @testcase04
  Scenario Outline: Verify an email already in use can not be registered
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    And the user accepts Privacy Policy terms
    When the user clicks the continue register button
    Then the user should be shown an email already registered error message
    Examples:
      | firstName | lastName | email               |  telephone  |  password  | passwordConfirm |
      | Laura     |  Del Rio | pruebas@hotmail.com | 555555555   |  123456    | 111111          |

  @testcase05
  Scenario Outline: Verify a user can not register without agreeing privacy policy terms
    And the user provides the mail "<firstName>" and lastName "<lastName>" and email "<email>" and telephone "<telephone>" and password "<password>" and passwordConfirm "<passwordConfirm>"
    When the user clicks the continue register button
    Then the user should be shown a you must agree privacy policy error message
    Examples:
      | firstName | lastName | email               |  telephone  |  password  | passwordConfirm |
      | Laura     |  Del Rio | pruebas@hotmail.com | 555555555   |  123456    | 111111          |

  @testcase06
  Scenario: Verify the user can clic on already account link
    When the user clicks the login page link
    Then the user should go to login page