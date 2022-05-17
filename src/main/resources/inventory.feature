/*
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
*/

@inventory
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page
    And the user provides the username "<username>" and password "<password>"

  @testcase03
  Scenario Outline: validate inventory list size
    When the user clicks the login button
    Then the user see the inventory list with "<items>" size list
    Examples:
      | username      | password     | items |
      | standard_user | secret_sauce | 6     |

  @testcase04
  Scenario Outline: validate exist "<item>" product in inventory list
    When the user clicks the login button
    Then the user see the "<item>" in the inventory list
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase05
  Scenario Outline: Add a single item in the shopping cart
    And the user clicks the login button
    When the user adds a "<item>" by clicking Add To Cart
    And the user clicks on the shopping cart
    Then there should be "1" items in the shopping cart
    Examples:
      | username      | password     | item                |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  @testcase06
  @TODO
 # Scenario Outline: Delete an item in the shopping cart
 #   When the user clicks the login button
 #   And the user adds a "<item>" by clicking 'Add To Cart'
 #   And the user clicks on the shopping cart
 #   Then there should be "1" items in the shopping cart
 #   Examples:
 #     | username      | password     | item                |
 #     | standard_user | secret_sauce | Sauce Labs Backpack |

  @testcase07
  Scenario Outline: Place multiple items in the shopping cart
    And the user clicks the login button
    When the user selects
      | product                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
    And the user clicks on the shopping cart
    Then there should be "3" items in the shopping cart
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @testcase08
  Scenario Outline: sort inventory by alphabetical desc order
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by alphabetical desc order
    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | za         |

  @testcase09
  Scenario Outline: sort inventory by price desc order
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by price desc order
    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | hilo       |