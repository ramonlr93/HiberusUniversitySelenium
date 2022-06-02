@cart
Feature: Cart test suite

  Background:
    Given the user is on the home page

  @testcase10
  Scenario Outline: Verify valid remove product from to cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the 2 products random add to cart
    And go to the cart page
    When the product random is remove
    Then the remove product no apparent to the cart

    Examples:
       | username      | password     |
       | standard_user | secret_sauce |