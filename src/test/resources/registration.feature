@registration
Feature: Validate Registration test suite

  @testcase01
  Scenario Outline: validate inventory list size
    Given the user is on the home page
    And the user provides the username "<username>" and password "<password>"
    When the user clicks the login button
    Then the user see the inventory list with "<items>" size list
    Examples:
      | username      | password     | items |
      | standard_user | secret_sauce | 6     |