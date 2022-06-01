Feature: Checkout

  Background:
    Given the user is on the home page
    And the user provides the username "standard_user"
    And the user provides the password "secret_sauce"
    And the user clicks the login button
    And the user is logged successfully and is into the inventory page

  Scenario: Remove a product from the cart
    And the user adds 3 random products to the cart
    And the user clicks the cart button
    And the user does the checkout of the products
    And the user fills the checkout form with the values "test first name", "test last name", "test postal code"
    When the user continues to the second step
    Then the total price of the order is the correct

  Scenario: Remove a product from the cart
    And the user adds 1 random products to the cart
    And the user clicks the cart button
    And the user does the checkout of the products
    And the user fills the checkout form with the values "test first name", "test last name", "test postal code"
    And the user continues to the second step
    When the user ends the checkout
    Then the page redirect to the confirmation order page and sees the text "Your order has been dispatched, and will arrive just as fast as the pony can get there!"