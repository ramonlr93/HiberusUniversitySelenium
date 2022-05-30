@inventory
Feature: Inventory test suite

  Background:
    Given the user is on the home page

  @testcase-02
  Scenario Outline: Verify number of products
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user is in the inventory page
    Then the number of items is six

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @testcase-03
  Scenario Outline: Verify that Sauce "<itemName>" exist in the inventory
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user is in the inventory page
    Then the the item "<itemName>" exist in the inventory

    Examples:
      | username      | password     | itemName                |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase-04
  Scenario Outline: Add the item Sauce "<itemName>"
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user clicks in the button "<buttonName>" of the item "<itemName>"
    Then the user should see a one on the cart icon

    Examples:
      | username      | password     | itemName                | buttonName  |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt | add to cart |

  @testcase-05
  Scenario Outline: Remove item from cart being in the inventory
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks in the button "<buttonName>" of the item "<itemName>"
    When the user clicks in the button "<removeButtonName>" of the item "<itemName>"
    Then the user should see the cart icon empty

    Examples:
      | username      | password     | itemName                | buttonName  | removeButtonName |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt | add to cart | remove           |

  @smoke
  @testcase-06
  Scenario Outline: Add three items to the cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks in the button add-to-cart of three random items
    Then the user should see a three on the cart icon

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @testcase-07
  Scenario Outline: Sort the inventory from A to Z
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user select the filter "<filtreName>"
    Then the selected filter sort by alphabetic order

    Examples:
      | username      | password     | filtreName |
      | standard_user | secret_sauce | az         |

  @testcase-08
  Scenario Outline: Sort the inventory from Z to A
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user select the filter "<filtreName>"
    Then the selected filter sort by alphabetic reverse order

    Examples:
      | username      | password     | filtreName |
      | standard_user | secret_sauce | za         |

  @testcase-09
  Scenario Outline: Sort the inventory from lower to higher
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user select the filter "<filtreName>"
    Then the selected filter sort from lower to higher

    Examples:
      | username      | password     | filtreName |
      | standard_user | secret_sauce | lohi       |

  @testcase-10
  Scenario Outline: Sort the inventory from higher to low
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user select the filter "<filtreName>"
    Then the selected filter sort from higher to lower

    Examples:
      | username      | password     | filtreName |
      | standard_user | secret_sauce | hilo       |
