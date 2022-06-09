@base
Feature: validate base page test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase06
    @smoke
  Scenario: Verify user can add to cart
    And the user clicks the add to cart of a product
    When the user clicks on the cart button
    Then the cart has a product

  @testcase10
  Scenario: Verify user can change the currency of the page
    When the user clicks the currency button and change to "Euro"
    Then the price of the products will be in "€"

  @testcase12
  Scenario: Verify user can remove a product from cart
    And the user clicks the add to cart of a product
    And the user clicks on the cartButton
    When the user clicks in the remove button
    Then the cart will be empty