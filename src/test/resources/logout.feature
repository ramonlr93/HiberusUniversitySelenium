@logout
Feature: validate logout in My Account

  Background: Navigate to My Account
    Given the user is on the login page

  @testcase06
    @smoke
  Scenario Outline: Verify valid user can login
    And the user enter the email "<email>" and password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    When the user clicks the logout button
    Then the user is logout successfully
    Examples:
      | email                  | password       |
      | tapihaw117@game4hr.com | tapihawGame4hr |