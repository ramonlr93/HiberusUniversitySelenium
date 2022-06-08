@login
Feature: validate login in OpenCart

  Background: Navigate to the home page
    Given the user is on the login page

  @testcase04
    @smoke
  Scenario Outline: Verify valid user can login
    And the user enter the email "<email>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully
    Examples:
      | email                  | password       |
      | tapihaw117@game4hr.com | tapihawGame4hr |

  @testcase05
  Scenario Outline: Verify invalid user cannot login
    And the user enter the email "<email>" and password "<password>"
    When the user clicks the login button
    Then an error message appears
    Examples:
      | email        | password       |
      | hulu@hulu.es | tapihawGame4hr |