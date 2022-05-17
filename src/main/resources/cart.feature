Feature: Cart test suite

  Background: Navigate to the home page https://www.saucedemo.com
    Given the user is on the home page https://www.saucedemo.com
    And the user provides the username "username" and the password "password"
    And the user clicks the login button and access to inventory page

  @deleteProductFromCart
  Scenario Outline: delete product from cart
    And the user clicks 2 different "products" randomly from inventory page
    And validates that the 2 products have been added to the cart
    When the user clicks on the "Remove" button of one of the products in the cart
    Then the product chosen should be removed from the cart.

    Examples:
      | username      | password     | product1 | product2 |
      | standard_user | secret_sauce | 1        |    2     |