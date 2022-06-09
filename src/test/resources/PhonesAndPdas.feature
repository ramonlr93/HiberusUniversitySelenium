@addproductscart
@smoke
Feature: Validate Phones test suite

  Background:
    Given the user is on the home page
    And The user clicks phones and pdas button
    And the user is on phones and pdas page


  @testcase19
  Scenario: validate add 1 item to cart
    When the user add 1 item to cart
    Then The user can see 1 item in the cart button


  @testcase20
  Scenario: validate add 2 items to cart and information is correct
    When the user add an item 2 times to cart
    And The user clicks cart button
    Then The user can see the product is x2


  @testcase21
  Scenario: validate add 1 item to cart and remove it later
    When the user add an item 1 times to cart
    And The user clicks cart button
    And The user remove the item
    Then The user can see 0 item in the cart button