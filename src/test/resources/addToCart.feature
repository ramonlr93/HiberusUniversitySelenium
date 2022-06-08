@shopping
Feature: Add product to cart

  Background:
    Given the user is on the home page

  @testcase06
  @smoke
  Scenario: a user unknown add product to cart
    When the user adds a MacBook from the home page to the cart
    Then Item is successfully added to the cart
