@login
Feature: validate login test suite

  Background: Navigate to the home page
    Given the user is on the login page

  @testcase05
  @smoke
  Scenario Outline: Verify valid user can login
    And the user clicks MyAccount
    And the user selects the login
    And the user provides the username "<e-mail>" and password "<password>"
    When the user clicks the login button
    Then the user is logged successfully and is into the inventory page
    Examples:
      | e-mail                      | password     |
      | isabel.ezquerra82@gmail.com | 123456       |


  @testcase06
  Scenario Outline: Verify invalid user cannot login

    And the user provides the username "<username>" and password "<password>"
    When the user clicks the login button
    Then The user should be shown an invalid message
    Examples:
      | username | password     |
      | bad_user | secret_sauce |


