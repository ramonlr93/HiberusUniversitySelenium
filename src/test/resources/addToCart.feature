@shopping

  @testcase 06
  @smoke
Feature: Add product to cart
  Scenario: User is able to add product to the cart
    Given User is at the product details
    When User click on Add to Cart button
    Then Item is successfully added to the cart