@cart
Feature: Cart test suite

  Background:
    Given the user go to the home page
    And the user go to the login page

  @testcase7 @smoke
  Scenario Outline: Verify valid remove product from to cart
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user go to the home page
    And the user add product to cart
      | MacBook |
      | iPhone  |
    And the user go to the cart page
    When the product random is remove
    Then the remove product no apparent to the cart

    Examples:
      | email               | password |
      | flor.qa@yopmail.com | 123456   |