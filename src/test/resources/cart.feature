@cart
Feature: Cart test suite

  Background:
    Given the user is on the home page

  @smoke
  @testcase-14
  Scenario Outline: Remove an item from cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks in the button "<buttonName>" of two random items
    And the user goes to cart
    When the user remove one of those items
    Then the deleted item doesn't appear in the cart

    Examples:
      | username | password     | buttonName |
      | standard_user | secret_sauce | add to cart|
