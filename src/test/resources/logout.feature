@logout
Feature: Logout test suite

  Background:
    Given the user is on the home page
    And the user clicks the my account button
    And the user clicks the login link

  @testcase030
    @smoke
  Scenario Outline: Verify valid user can logout
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the my account button
    When the user clicks the logout button
    Then the user is successfully logged out

    Examples:
      | email                 | password |
      | gonex68008@falkyz.com | password |