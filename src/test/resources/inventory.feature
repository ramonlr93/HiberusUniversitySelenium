@inventory
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page
    And the user provides the username "standard_user"
    And the user provides the password "secret_sauce"
    When the user clicks the login button

  @testcase03
  Scenario Outline: validate inventory list size
    Then the user see the inventory list with "<items>" size list
    Examples:
      | items |
      | 6     |

  @testcase04
  Scenario Outline: validate exist "<item>" product in inventory list
    Then the user see the "<item>" in the inventory list
    Examples:
      | item                    |
      | Sauce Labs Bolt T-Shirt |

  @testcase05
  Scenario Outline: Add a single item in the shopping cart
    When the user adds a "<item>" by clicking Add To Cart
    And the user clicks on the shopping cart
    Then there should be 1 items in the shopping cart
    Examples:
      | item                |
      | Sauce Labs Backpack |

  @testcase06
  Scenario Outline: Delete an item in the shopping cart
    And the user adds a "<item>" by clicking Add To Cart
    And the user clicks on the shopping cart
    When the user deletes the "<item>" from the inventory
    Then there are no numbers in cart icon
    Examples:
      | item                    |
      | Sauce Labs Bolt T-Shirt |


  @testcase07
  Scenario: Place multiple items in the shopping cart
    When the user selects
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
    And the user clicks on the shopping cart
    Then there should be 3 items in the shopping cart


  @testcase08
  Scenario Outline: sort inventory by alphabetical desc order
    When the user clicks select "<optionSort>"
    Then the user see the list by alphabetical desc order
    Examples:
      | optionSort |
      | za         |

  @testcase09
  Scenario Outline: sort inventory by price desc order
    When the user clicks select "<optionSort>"
    Then the user see the list by price desc order
    Examples:
      | optionSort |
      | hilo       |

  @testcase10
  Scenario Outline: sort inventory by price asc order
    When the user clicks select "<optionSort>"
    Then the user see the list by price asc order
    Examples:
      | optionSort |
      | lohi       |

