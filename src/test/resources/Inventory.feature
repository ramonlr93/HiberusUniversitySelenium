Feature: Inventory

  Background:
    Given the user is on the home page
    And the user provides the username "standard_user"
    And the user provides the password "secret_sauce"
    And the user clicks the login button
    When the user is logged successfully and is into the inventory page

  Scenario: Verify that there are 6 items on the inventory
    Then the page have 6 items

  Scenario: Verify that "Sauce Labs Bolt T-Shirt" exists on the inventory
    Then the page have the "Sauce Labs Bolt T-Shirt" is displayed

  Scenario: Add the product "Sauce Labs Bolt T-Shirt" to the cart
    And the user adds the product "Sauce Labs Bolt T-Shirt" to the cart
    Then the cart value increments to 1

  Scenario: Remove a product from the cart from the inventory
    And the user adds the product "Sauce Labs Bolt T-Shirt" to the cart
    And the user removes the product "Sauce Labs Bolt T-Shirt" from the cart
    Then the cart is empty

  Scenario: Add 3 products to the cart
    And the user adds 3 random products to the cart
    Then the cart value increments to 3

  Scenario: Sort the items from Z to A
    And the user clicks the filter to sort from Z to A
    Then the page get sorted from Z to A

  Scenario: Sort the items by price from lower to higher
    And the user clicks the filter to sort by price from lower to higher
    Then the page get sorted by price from lower to higher

  Scenario: Sort the items by price from higher to lower
    And the user clicks the filter to sort by price from higher to lower
    Then the page get sorted by price from higher to lower
