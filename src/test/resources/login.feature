@login
Feature: Login test suite

  Background:
    Given the user is in the landing page
    And the user click on login button

  @smoke
  @LoginOK
  Scenario Outline: Verify valid user can login
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the user is logged

    Examples:
      | mail                 | password |
      | silvia1383@gmail.com | 1383     |

  @WrongMail
  Scenario Outline: Verify invalid login (wrong mail)
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail                | password  |
      | FAKEsilvia1383@gmail.com | 1383 |


  @WrongPassword
  Scenario Outline: Verify invalid login (wrong password)
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail                 | password |
      | silvia1383@gmail.com | FAKE1383 |