@inventory
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page


  @testcase-inv01
  Scenario Outline: validate inventory list size
    When the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is on the inventory page

    Then the user see the inventory list with items size list <item>

    Examples:
      | username      | password     | item |
      | standard_user | secret_sauce | 6    |

  @testcase-inv02
  Scenario Outline: validate exist "<item>" product in inventory list
    When the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is on the inventory page
    Then the user see the item in the inventory list "<item>"
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase-inv03
  Scenario Outline: Add a single item in the shopping cart
    When the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is on the inventory page
    Then the item is added to the cart and the cart has 1 product "<item>"
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase-int04
  Scenario Outline: Remove a single item in the shopping cart
    When the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is on the inventory page
    And the item is added to the cart and the cart has 1 product "<item>"
    Then the item is removed from the cart "<item>"
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

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