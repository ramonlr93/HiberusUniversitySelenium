@Inventory
Feature: Inventory test

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button
    When the user is logged successfully

  Scenario Outline: Verify 6 items in inventory
    Then on the inventory page there are 6 items

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

  Scenario Outline: exists in inventory Sauce Labs Bolt T-Shirt
    Then show exists in inventory "item"

    Examples:
         | item      |
         | Sauce Labs Bolt T-Shirt  |

  Scenario Outline: add Sauce Labs Bolt T-Shirt to cart
    And the user click add to cart "item" button
    Then the product is in the cart

    Examples:
             | item      |
             | Sauce Labs Bolt T-Shirt  |

  Scenario Outline: Remove product from cart from inventory
    And the user click add to cart "item" button
    And the user click remove to cart "item" button
    Then in the cart icon the product has been removed

    Examples:
                 | item      |
                 | Sauce Labs Bolt T-Shirt  |

  Scenario Outline: Add to cart 3 products
      And the user click add to cart "item" button
      And the user click add to cart "item" button
      And the user click add to cart "item" button
      Then the user has all 3 products in the shopping cart

      Examples:
                   | item      |
                   | Sauce Labs Bolt T-Shirt  |
                   | Sauce Labs Backpack |
                   | Sauce Labs Fleece Jacket |

  Scenario Outline: Sort inventory in alphabetical order (Z to A)
      When the user select "option"
      Then the user has the products in the inventory sorted from Z to A.

      Examples:
        | option |
        | Name (A to Z) |
        | Name (Z to A) |
        | Price (low to high) |
        | Price (high to low) |

  Scenario Outline: Sort the inventory by price from Lowest to Highest
        When the user select "option"
        Then the user has the products in the inventory sorted from Lowest to Highest

        Examples:
          | option |
          | Name (A to Z) |
          | Name (Z to A) |
          | Price (low to high) |
          | Price (high to low) |

  Scenario Outline: Sort the inventory by price from highest to lowest
          When the user select "option"
          Then the user has the products in the inventory sorted from highest to lowest

          Examples:
            | option |
            | Name (A to Z) |
            | Name (Z to A) |
            | Price (low to high) |
            | Price (high to low) |



