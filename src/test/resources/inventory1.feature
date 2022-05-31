Feature: Inventory Test Suite

Background: Navigate to the home page
  Given the user is on the home page

Scenario Outline: Verify the number of items in the inventory
  And the user provides the username "<username>"
  And the user provides the password "<password>"
  And the clicks the login button
  When the user is in the inventory page
  Then it shows there are "<items>" in the inventory

  Examples:
  | username      | password     | items |
  | standard_user | secret_sauce | 6     |

Scenario Outline: Verify that the product is in the inventory
  And the user provides the username "<username>"
  And the user provides the password "<password>"
  And the clicks the login button
  When the user is in the inventory page
  Then it shows that the product "<product>" exists

  Examples:
  | username      | password     | product                 |
  | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

Scenario Outline: Add an item to the cart
  And the user provides the username "<username>"
  And the user provides the password "<password>"
  And the clicks the login button
  And the user is in the inventory page
  When the user adds the product "<product>" to the cart
  Then it shows in the cart icon that the product was added

  Examples:
  | username      | password     | product                 |
  | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Remove an item from the cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the clicks the login button
    And the user added the product "<product>" to the cart
    When the user removes the product "<product>" from the cart
    Then it shows in the cart icon that the product was removed

    Examples:
    | username      | password     | product                 |
    | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Add multiple items to the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the clicks the login button
    And the user is in the inventory page
    When the user adds to the cart
      | product                 |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Backpack     |
      | Sauce Labs Onesie       |

    Then it shows in the cart icon that the three products were added

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |

  Scenario Outline: Sort the inventory by alphabetical order (Z to A)
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the clicks the login button
    And the user is in the inventory page
    When the user clicks the filter button "<optionSort>"
    Then it shows that the items are sorted by alphabetic desc order

    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | za       |

  Scenario Outline: Sort the inventory by price order (Low to High)
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the clicks the login button
    And the user is in the inventory page
    When the user clicks the filter button "<optionSort>"
    Then it shows that the items are sorted by price - Low to High

    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | lohi       |

  Scenario Outline: Sort the inventory by price order (High to Low)
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the clicks the login button
    And the user is in the inventory page
    When the user clicks the filter button "<optionSort>"
    Then it shows that the items are sorted by price - High to Low

  Examples:
  | username      | password     | optionSort |
  | standard_user | secret_sauce | hilo       |