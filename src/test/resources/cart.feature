@cart
Feature: cart test suite

  Background:
    Given the user is on the home page

  @useraddtwoproductstothecart
    @smoke
  Scenario Outline: the user adds two products to the cart
    And the user adds two product to the cart "<product1>" and "<product2>"
    When the user click the cart section
    Then the user is redirected to the cart page and sees the 2 products he added "<product1>" and "<product2>" in alphabetical order

    Examples:
      | product1 | product2 |
      | iPhone   | MacBook  |

  @useraddtwoproductsanddeletesone
    @smoke
  Scenario Outline: the user adds two products to the cart and removes one
    And the user adds two product to the cart "<product1>" and "<product2>"
    When the user click the cart section
    And the user is redirected to the cart page and removes one of the products
    Then the cart list will only have 1 product

    Examples:
      | product1 | product2 |
      | iPhone   | MacBook  |


  @userupdateproductquantityincart
  Scenario Outline: the user adds one product to the cart and updates his quantity
    And the user adds one product to the cart "<product>"
    When the user click the cart section
    And the user is redirected to the cart page and updates the quantity of one of the products "<quantity>"
    Then the cart list will only have one product with 2 units

    Examples:
      | product | quantity |
      | iPhone  | 2        |

  @productprice
  Scenario Outline: the price of the product in the cart is correct
    And the user adds two product to the cart "<product1>" and "<product2>"
    When the user click the cart section
    Then the price of the product is equal to the total price

    Examples:
      | product1 | product2 |
      | iPhone   | MacBook  |

