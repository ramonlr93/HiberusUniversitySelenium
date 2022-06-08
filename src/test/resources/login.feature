@login
Feature: validate login test suite

  Background: Navigate to the Home page
    Given the user is on the Home page

  @testcase05
  @smoke
  Scenario Outline: Verify the user can login successfully
    And the user access to MyAccountNavBarButton and access to LoginMenu
    And the user is on the Login page
    And the user provides the email "<email>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully
    Examples:
      |            email               |   password   |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |

  @testcase06
  Scenario Outline: Verify that invalid user cannot login
    And the user access to MyAccountNavBarButton and access to LoginMenu
    And the user is on the Login page
    And the user not provides correct email "<email>" and password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      |                email            |   password   |
      | nubrokakattoi-8879@yopmail.com  |    hiberus   |
      |      kaka-8879@yopmail.com      | hiberusfinal |