@login
Feature: validate login test suite

  Background:
    Given the user is on the home page
    And the user clicks on my account button and the login option

  @testcase03
  @smoke
  Scenario Outline: Verify valid user can login
    And the user provides the username "<username>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully and is into the account page
    Examples:
      | username      | password     |
      | jajaja@yopmail.com | Hola1234# |

  @testcase04
  Scenario Outline: Verify invalid user cannot login
    And the user provides the username "<username>" and  wrong password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      | username | password     |
      | jajaja@yopmail.com | Holi123# |

  @testcase05
  Scenario Outline: Verify user forgot his password
    And the user clicks on forgot password
    And the user provides the username "<email>" and continue
    Then The user should be shown an info message
    Examples:
      | email |
      | jajaja@yopmail.com |