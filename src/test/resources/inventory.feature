@inventory
Feature: Inventory test suite

  Background:
    Given the user is on the home page

  @testcase03
  Scenario Outline: Verify valid the number of results is 6
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the items count is equal 6
    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

  @testcase04
  Scenario Outline: Verify valid the product exists in inventory
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the "<product>" product is present on the inventory page

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase05
  Scenario Outline: Verify valid the product is add to cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the "<product>" product add to cart
    Then the cart icon has increased to 1

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase06
  Scenario Outline: Verify valid remove product to cart from inventory
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the "<product>" product add to cart
    When the "<product>" product is remove
    Then the cart icon has not increased

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase07
  Scenario Outline: Verify valid the 3 products is add to cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the 3 products random add to cart
    Then the cart icon has increased to 3

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @testcase08
  Scenario Outline: Verify valid sort inventory alphabetically z to a
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When select the filter "<filter>"
    Then see the list by name is order correctly

    Examples:
      | username      | password     | filter |
      | standard_user | secret_sauce | za     |

  @testcase09
  Scenario Outline: Verify valid sort inventory by price from lowest to highest
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When select the filter "<filter>"
    Then see the list by price is order correctly

    Examples:
    | username      | password     | filter   |
    | standard_user | secret_sauce | hilo     |