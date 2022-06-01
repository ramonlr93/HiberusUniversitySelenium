@inventory
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page


  @testcase03
  Scenario Outline: validate inventory list size
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user is in the inventory page
    Then the user see the inventory list with 6 items
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @testcase04
  Scenario Outline: validate exist "<item>" product in inventory list
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user is in the inventory page
    Then the user see the "<itemName>" in the inventory list
    Examples:
      | username      | password     | itemName                |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase05
  Scenario Outline: Add a single item in the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    When the user adds a "<itemName>" by clicking Add To Cart
    Then there should be 1 items in the shopping cart
    Examples:
      | username      | password     | itemName                |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase06
  Scenario Outline: Delete an item in the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    And the user adds a "<itemName>" by clicking Add To Cart
    When the user removes a "<itemName>" by clicking Remove
    Then there should be 0 items in the shopping cart
    Examples:
      | username      | password     | itemName            |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  @testcase07
  Scenario Outline: Place multiple items in the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    When the user select <number> random itmes
    Then there should be 3 items in the shopping cart
    Examples:
      | username      | password     | number |
      | standard_user | secret_sauce | 3      |

  @testcase08
  Scenario Outline: sort inventory by alphabetical desc order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    When the user clicks select "<option>"
    Then the user see the list by alphabetical desc order
    Examples:
      | username      | password     | option |
      | standard_user | secret_sauce | za     |

  @testcase09
  Scenario Outline: sort inventory by price desc order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    When the user clicks select "<option>"
    Then the user see the list by price desc order
    Examples:
      | username      | password     | option |
      | standard_user | secret_sauce | hilo   |