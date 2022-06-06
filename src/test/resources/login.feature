@login
Feature: Login test suite

  Background:
    Given the user is on the home page
    And the user go to the login page

  @testOpenCat01
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button

    Examples:
      | email               | password |
      | flor.QA@yopmail.com | 123456   |

  @testOpenCat02
  Scenario Outline: Verify valid user can not login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown and invalid message

    Examples:
      | email               | password |
      | flor.QA@yopmail.com | 123456   |