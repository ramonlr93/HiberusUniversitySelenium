@login
Feature: Validate Login test suite

  Background:
    Given the user is on the home page
    And the user selects -My Account-
    And the user selects -Login-
    And the user is on login page

  @testcase14
  Scenario: validate registration button
    When the user clicks the continue button in New Customer div
    Then The user can see registration page


  @testcase15
    @smoke
  Scenario Outline: validate login ok
    And the user complete the login form with email "<email>" and password "<password>"
    When the user clicks the login button
    Then The user can see my account page

    Examples:
      | email                 | password  |
      | cfradejas94@gmail.com | 1.Hiberus |


  @testcase16
  Scenario Outline: Validate that an alert is displayed when an incorrect email is entered
    And the user complete the login form with email "<email>" and password "<password>"
    When the user clicks the login button
    Then The user can see an alert of incorrect email or password

    Examples:
      | email | password  |
      | fail  | 1.Hiberus |


  @testcase17
  Scenario Outline: Validate that an alert is displayed when an incorrect password is entered
    And the user complete the login form with email "<email>" and password "<password>"
    When the user clicks the login button
    Then The user can see an alert of incorrect email or password

    Examples:
      | email                 | password |
      | cfradejas94@gmail.com | fail     |


  @testcase18
  Scenario: validate forgotten password button
    When the user clicks the forgotten password button
    Then The user can see forgotten password page