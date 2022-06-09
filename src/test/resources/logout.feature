@logout
Feature: Logout test suite

  Background:
    Given the user go to the home page
    And the user go to the login page

  @testcase9 @smoke
  Scenario Outline: Verify valid user can logout
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user is clicks the logout link
    Then the user is logout successfully

    Examples:
      | email               | password     |
      | flor.qa@yopmail.com | 123456 |