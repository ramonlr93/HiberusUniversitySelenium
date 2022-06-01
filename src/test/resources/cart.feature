Feature: Cart

  Background:
    Given the user is on the home page
    And the user provides the username "standard_user"
    And the user provides the password "secret_sauce"
    And the user clicks the login button

  Scenario: Remove a product from the cart
    When the user adds 2 random products to the cart
    And the user clicks the cart button
    And the user remove 1 product from the cart
    Then the removed product doesn't appears on the cart