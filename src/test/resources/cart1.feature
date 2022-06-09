@cart
Feature: Cart Test Suite

  Background:
    Given the user is in the home page

  @testcase11
  Scenario Outline:  Verify we can delete and update items in the cart
    And the user goes to the Mobile Phones & PDAs page
    And the user add "<quantity>" item to the cart
    And the user goes to the cart page
    When the user updates and deletes items in the cart
    Then it shows a message that the cart was updated

    Examples:
      |  quantity |
      |    2      |