@checkout
Feature: Validate logout test suite

  Background: Navigate to the home page
    Given the user is on the Home page

  @testcase12 @smoke
  Scenario Outline: validate logout
    And the user access to MyAccountNavBarButton
    And the user access to LoginMenu
    And the user is on the Login page
    And the user login with "<email>", "<password>"
    And the user is on the Account page
    And the user access to MyAccountNavBarButton
    When the user access to LogoutMenu
    Then the user Logout successfully
     Examples:
      |            email               |   password   |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |









