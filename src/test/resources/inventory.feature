Feature: Inventory test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks the login button

  Scenario Outline: Verify valid the number of results is 6
    When the user is on the inventory page
    Then the items count is equal 6

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

  Scenario Outline: Verify valid the product exists in inventory
    When the user is on the inventory page
    Then the "product" product is present on the inventory page

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Verify valid the product is add to cart
    When the "product" product add to cart
    Then the cart icon has increased to 1

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Verify valid remove product to cart from inventory
    And the "product" product add to cart
    When the "product" protuct is remove
    Then the cart icon has increased to 1

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Verify valid the 3 products is add to cart
    When the 3 products add to cart
    Then the cart icon has increased to 3

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Verify valid sort inventory alphabetically
    When select the filter "filter"
    Then the filter, name (z to a) is order correctly

    Examples:
      | username      | password     | filter |
      | standard_user | secret_sauce | za     |

  Scenario Outline: Verify valid sort inventory by price from lowest to highest
    When select the filter "filter"
    Then the filter, price (low to high) is order correctly

    Examples:
      | username      | password     | filter |
      | standard_user | secret_sauce | lohi   |