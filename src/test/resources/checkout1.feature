@checkout
Feature: Checkout Test Suite

Background:
  Given the user is on the home page

@checkprice
Scenario Outline: Checking the final price of some products added to the cart
  And the user provides the username "<username>"
  And the user provides the password "<password>"
  And the clicks the login button
  And the user added 2 items to the cart
  And the user clicked the cart button
  And the user clicked the checkout button
  And the user added the details correctly "<name>" "<surname>" "<postcode>"
  When the user clicks in the continue button and goes to the checkout page
  Then it shows the total price to pay

  Examples:
  | username      | password     | name     | surname   | postcode |
  | standard_user | secret_sauce | Fulanito | Fulanitez | 55555    |

  @makeanorder
  @smoke
Scenario Outline: Make an order
  And the user provides the username "<username>"
  And the user provides the password "<password>"
  And the clicks the login button
  And the user added 2 items to the cart
  And the user clicked the cart button
  And the user clicked the checkout button
  And the user added the details correctly "<name>" "<surname>" "<postcode>"
  When the user clicks in the continue button and goes to the checkout page
  And the user clicks the finish checkout button
  Then it shows the message "<message>"

  Examples:
  | username      | password     | name     | surname   | postcode | message                                                                                 |
  | standard_user | secret_sauce | Fulanito | Fulanitez | 55555    | Your order has been dispatched, and will arrive just as fast as the pony can get there! |
