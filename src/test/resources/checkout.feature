@checkout
Feature: Checkout test

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button
    When the user is logged successfully

  Scenario Outline: Check the final Checkout price of several products
    And the user clicks on the "add to cart" button of 3 different products.
    And the user clicks on the cart button.
    When the user fills in the form and clicks on the checkout button
    Then the user can see the total price of the order.

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

  Scenario Outline: Check the final Checkout price of several products
      And the user clicks on the "add to cart" button of 1 product.
      And the user clicks on the cart button.
      And the user clicks on the checkout button.
      And the user clicks on the continue button.
      And the user fills in the form and clicks on the checkout button
      When the user clicks on the continue button.
      Then the order has been successfully completed by displaying the message "Your order has been shipped, and will arrive as fast as the pony can get there!"

      Examples:
        | username        | password      |
        | standard_user   | secret_sauce  |