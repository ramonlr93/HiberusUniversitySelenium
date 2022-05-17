Feature: Checkout Test Suite

Background:
  Given the user is in the home page
  And the user provides the username "username"
  And the user provides the password "password"
  And the user clicks the login button
  And the user added 2 products to the cart
  And the user clicked in the cart icon button
  And the user clicked the checkout button
  And the user added the details correctly

Scenario Outline: Checking the final price of some products added to the cart
  When the user clicks in the continue button and goes to the checkout page
  Then it shows the total price to pay

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |

Scenario Outline: Make an order
  When the user clicks the finish checkout button
  Then it shows the message "Your order has been dispatched, and will arrive just as fast..."

  Examples:
  | username | password     | product                 |
  | bad_user | secret_sauce | Sauce Labs Bolt T-Shirt |
