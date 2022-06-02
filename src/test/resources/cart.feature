@cart
Feature: Validate shopping cart test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase10
  @smoke
  Scenario Outline: Add a single item in the sopping cart
    And the user provides the username "<username>" and password "<password>"
    And the user clicks the login button
    And the user adds a "<item>" by clicking 'Add To Cart'
    When the user clicks on the shopping cart
    Then there should be "1" items in the shopping cart
    Examples:
      | username      | password     | item                |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  @testcase11
  Scenario Outline: Delete a single item in the sopping cart
    And the user provides the username "<username>" and password "<password>"
    And the user clicks the login button
    And the user adds a "<item>" by clicking 'Add To Cart'
    And the user clicks on the shopping cart
    And there should be "1" items in the shopping cart
    When the user deletes a "<item>" item from shopping cart
    Then there should be "0" items in the shopping cart
    Examples:
      | username      | password     | item                |
      | standard_user | secret_sauce | Sauce Labs Backpack |
