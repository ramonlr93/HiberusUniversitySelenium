@login
Feature: Login test suite

  Background:
    Given the user is on the home page
@loginok
  @smoke
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | email        | password      |
      | sanzporro@gmail.com   | porro  |

  @loginko
  Scenario Outline: Verify valid user cannot login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown and invalid message

    Examples:
      | email   | password      |
      | FAKEsanzporro@gmail.com   | porro  |