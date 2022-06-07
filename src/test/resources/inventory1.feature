Feature: Inventory Test Suite

  Background:
  Given the user is in the home page
  And the user clicks to go to the login page
  And the user is in the login page

  Scenario Outline:  Verify one item is added to cart
    And the user provides the username "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user log in succesfully
    And the user goes to the Mobile Phones & PDAs page
    When the user add "<quantity>" item to the cart
    Then it shows that the item was added

    Examples:
      |         email           | password     |  quantity |
      | robertoch1985@gmail.com | 12345        |    1      |

  Scenario Outline:  Verify an item is deleted from cart
    And the user provides the username "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user log in succesfully
    And the user goes to the Mobile Phones & PDAs page
    And the user add "<quantity>" item to the cart
    And it shows that the item was added
    When the user removes the item from cart
    Then it shows the item was removed

    Examples:
      |         email           | password     |  quantity |
      | robertoch1985@gmail.com | 12345        |    2      |

  Scenario Outline:  Verify 2 items are added to cart
    And the user provides the username "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user log in succesfully
    And the user goes to the Mobile Phones & PDAs page
    When the user adds two items to the cart
    Then it shows that the 2 items were added

    Examples:
      |         email           | password     |
      | robertoch1985@gmail.com | 12345        |