@login_test_suite
Feature: validate login in OpenCart

  Background: Navigate to the home page
    Given the user is on the login page

  @OC-1
    @smoke
  Scenario Outline: Verify valid user can login
    And the user enters the "<email>" and "<password>" credentials
    When the user clicks the login button
    Then the user is logged successfully
    Examples:
      | email          | password |
      | mario@mail.com | 1311     |

  @OC-2
    @smoke
  Scenario Outline: Verify a non created user cannot login
    And the user enters the "<email>" and "<password>" credentials
    When the user clicks the login button
    Then the error message is shown
    Examples:
      | email                | password |
      | non_created@mail.com | 1311     |
