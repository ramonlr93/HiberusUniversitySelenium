@login
Feature: validate inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase10
  Scenario Outline: Verify a product is shown
    Then the "<product>" is shown
    Examples:
      | product |
      | iPhone  |

  @testcase11
  Scenario: Verify random product can be added to cart
    When the user adds 1 product to the cart
    Then the cart button shows 1 products

  @testcase12
  Scenario Outline: Verify product can be added to cart by name
    When the user adds "<product>" to the cart
    Then the cart button shows 1 products
    Examples:
      | product |
      | MacBook |

  @testcase13
  Scenario: Verify product can be removed from cart
    And the user adds 1 product to the cart
    And the user clicks on cart button
    When the user clicks on remove button
    Then the cart button shows 0 products

  @testcase14
  Scenario: Verify 3 products can be added to cart
    When the user adds 3 product to the cart
    Then the cart button shows 3 products

  @testcase15
  Scenario Outline: Verify number of products shown
    Then "<numberOfProducts>" products are shown
    Examples:
        | numberOfProducts |
        | 4                |


