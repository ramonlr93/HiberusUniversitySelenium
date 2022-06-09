@cart
Feature: Validate shopping cart test suite

  Background:
    Given the user is on the home page

  @testcase05
  @smoke
  Scenario: Add a items into the sopping cart
    And the user adds items to the cart
    And the user clicks on the shopping cart button
    Then there should be 2 items in the shopping cart


  @testcase06
  Scenario: Delete a single item in the shopping cart
    And the user adds 2 items into the shopping cart
    And the user clicks on the shopping cart button
    When the user deletes an item from shopping cart
    Then there should be 1 items in the shopping cart

