Feature: Checkout test suite

 Background: Navigate to the home page https://www.saucedemo.com
    Given the user is on the home page https://www.saucedemo.com
    And the user provides the username "username" and the password "secret_sauce"
    And the user clicks the "Login" button and access to the inventory page

  @checkout @price
  Scenario Outline: check the final price of the Checkout
    And the user clicks on "3" different products randomly from the inventory page
    And the user clicks for access to the cart page
    And the user clicks the "Checkout" button and fills in the data
    And the user clicks the "Continue" button
    When the user clicks "Finish" button
    Then the total price of the order (Total Item) is the sum of the amount of the added products.

    Examples:
      | username      | password     | product1 | product2 | product3 |
      | standard_user | secret_sauce | 1        | 2        | 3        |

  @order
  Scenario Outline: place an order
    And the user clicks on "1" product randomly from the inventory page
    And the user clicks for access to the cart page
    And the user clicks the "Checkout" button and fills in the data
    And the user clicks the "Continue" button
    When the user clicks "Finish" button
    Then the message “Your order has been dispatched and will arrive just as fast as the pony can get there!” is displayed.

    Examples:
      | username      | password     | product1 |
      | standard_user | secret_sauce | 1        |