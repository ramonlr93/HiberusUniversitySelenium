@logout
Feature: Logout test suite

  Background:
    Given the user is in the landing page
    And the user click on login button

  @smoke
    @logoutOK
  Scenario Outline: Check the logout
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    And the user clicks on login button
    When the user clicks the logout button
    Then the user is in the logout page

    Examples:
      | mail               | password |
      | erojas@hiberus.com | edurne   |