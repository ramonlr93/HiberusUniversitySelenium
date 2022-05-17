Feature: Inventory Test Suite

Background:
  Given the user is in the home page
  And the user provides the username "username"
  And the user provides the password "password"
  And the user clicks the login button

Scenario Outline: Verify the number of items in the inventory is 6
  When the user is in the page www.saucedemo.com/inventory.html
  Then it shows there are 6 items in the inventory

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |

Scenario Outline: Verify that the product "Sauce Labs Bolt T-Shirt" is in the inventory
  When the user is in the page www.saucedemo.com/inventory.html
  Then it shows that the product "product" exists

  Examples:
  | username | password     | product                 |
  | bad_user | secret_sauce | Sauce Labs Bolt T-Shirt |

Scenario Outline: Add the product "Sauce Labs Bolt T-Shirt" to the cart
  And the user is in the page www.saucedemo.com/inventory.html
  When the user adds the product "product" to the cart
  Then it shows in the cart icon that the product was added

  Examples:
  | username | password     | product                 |
  | bad_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Remove the product "Sauce Labs Bolt T-Shirt" from the cart
  And the user added the product "product" to the cart
  When the user removes the product "product" from the cart
  Then it shows in the cart icon that the product was removed

  Examples:
  | username | password     | product                 |
  | bad_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Add 3 random products to the cart
  And the user is in the page www.saucedemo.com/inventory.html
  When the user adds 3 random products to the cart
  Then it shows in the cart icon that the 3 products were added

  Examples:
  | username | password     | product                 |
  | bad_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Sort the inventory by price order (Low to High)
  And the user is in the page www.saucedemo.com/inventory.html
  When the user clicks the filter button (Price - Low to High)
  Then it shows that the items are sorted by price - Low to High

  Examples:
  | username | password     | product                 |
  | bad_user | secret_sauce | Sauce Labs Bolt T-Shirt |