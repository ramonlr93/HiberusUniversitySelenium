@inventory
Feature: Inventory Test Suite

  Background:
  Given the user is in the home page


  @testcase08
  Scenario Outline:  Verify one item is added to cart
    And the user goes to the Mobile Phones & PDAs page
    When the user add "<quantity>" item to the cart
    Then it shows that the item was added

    Examples:
      |  quantity |
      |    1      |

  @testcase09
  Scenario Outline:  Verify an item is deleted from cart
    And the user goes to the Mobile Phones & PDAs page
    And the user add "<quantity>" item to the cart
    And it shows that the item was added
    When the user removes the item from cart
    Then it shows the item was removed

    Examples:
      |  quantity |
      |    1      |

