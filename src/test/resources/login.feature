@login
Feature: validate login test suite

  Background: Navigate to the login page
    Given the user is on the login page

  @testcase01
  @smoke
  Scenario Outline: Verify the user can login successfully
    And the user provides the email "<email>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully
    Examples:
      |            email               |   password   |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |

  @testcase02
  Scenario Outline: Verify that invalid user cannot login
    And the user not provides correct email "<email>" and password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      |                email            |   password   |
      | nubrokakattoi-8879@yopmail.com  |    hiberus   |
      |      kaka-8879@yopmail.com      | hiberusfinal |