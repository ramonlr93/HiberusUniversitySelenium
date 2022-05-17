Feature: Inventory test suite

  Background: Navigate to the home page https://www.saucedemo.com
    Given the user is on the home page https://www.saucedemo.com
    And the user provides the username "username" and the password "secret_sauce"
    And the user clicks the "Login" button

   @verifyInventoryProducts
   Scenario Outline: Verify that are 6 products in the inventory page
     When the user access to inventory page
     Then the user visualize "6" products in the inventory page

     Examples:
       | username        | password      |products|
       | standard_user   | secret_sauce  |    6   |

   @validateProduct
   Scenario Outline: Validate product "Sauce Labs Bolt T-Shirt" exits at the inventory page.
     And the user access to inventory page
     When the user visualize product "Sauce Labs Bolt T-Shirt"
     Then user validate that "Sauce Labs Bolt T-Shirt" product appear in the inventory.

    Examples:
      | username        | password      |product                |
      | standard_user   | secret_sauce  |Sauce Labs Bolt T-Shirt|

   @addProduct
   Scenario Outline: Add product
     And the user access to inventory page
     When the user clicks product "Sauce Labs Bolt T-Shirt"
     Then the "Sauce Labs Bolt T-Shirt" product is added to the cart and it can be verify on the cart

    Examples:
      | username      | password     | product                   |
      | standard_user | secret_sauce | "Sauce Labs Bolt T-Shirt" |

   @removeProduct
   Scenario Outline: delete product "Sauce Labs Bolt T-Shirt" from the inventory page
     And the user access to inventory page
     And the user clicks product "Sauce Labs Bolt T-Shirt"
     And the product "Sauce Labs Bolt T-Shirt" has been added to the cart and appears in the cart
     And the product Sauce Labs Bolt T-Shirt has been added to the cart and appears in the cart
     When the user clicks the "Remove" button on the product "Sauce Labs Bolt T-Shirt"
     Then the user removes the "Sauce Labs Bolt T-Shirt" product from the cart and validates that the product has been removed from the cart icon.

    Examples:
      | username      | password     | product                   |
      | standard_user | secret_sauce | "Sauce Labs Bolt T-Shirt" |

   @add"3"products
   Scenario Outline: add 3 random products from the inventory page
     And the user access to inventory page
     When the user clicks 3 different products randomly from inventory
     Then the 3 randomly chosen products are added to the cart and it is validated that, in the cart icon, the 3 products have been added.

    Examples:
       | username      | password     | product1 | product2 | product3 |
       | standard_user | secret_sauce | 1        | 2        | 3        |

   @sort"za"
   Scenario Outline: Sort inventory alphabetically (Z to A)
     And the user access to inventory page
     When the user selects the filter NAME (Z TO A)
     Then the products are arranged in alphabetical order from Z to A

    Examples:
      | username      | password     |optionSort |
      | standard_user | secret_sauce |za         |

   @sortLowToHigh
   Scenario Outline: Sort inventory by price from Low to High
     And the user access to inventory page
     When the user selects the filter PRICE (low to high)
     Then the products are sorted by price from lowest to highest.

    Examples:
      | username      | password     |optionSort  |
      | standard_user | secret_sauce |low to high |

   @sortHighToLow
   Scenario Outline: Sort inventory by price from High To Low
     And the user access to inventory page
     When the user selects the filter PRICE (high to low)
     Then the products are sorted by price from highest to lowest.

    Examples:
      | username      | password     |optionSort  |
      | standard_user | secret_sauce |high to low |