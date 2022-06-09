@login
Feature: validate login test suite

  Background: Navigate to the login page
    Given the user is on the home page
    And the user clicks MyAccount
    And the user click Login

  @testcase01
  @smoke
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully and is into the My Account page
    Examples:
      | email                 | password     |
      | ander.valencia@gmail.com | contraseña   |

  @testcase02
  Scenario Outline: Verify invalid user cannot login
    And the user provides the email "<email>" and password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      | email           | password     |
      | ander.valencia@ | contraseña   |

  @testcase11
  Scenario Outline: Verify valid user can logout
    And the user provides the email "<email>" and password "<password>"
    And the user clicks the login button
    When the user clicks the logout button
    Then the user is logout successfully and a message appear
    Examples:
      | email                 | password     |
      | ander.valencia@gmail.com | contraseña   |