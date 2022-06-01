@cart
Feature: Cart test

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button
    When the user is logged successfully

  Scenario Outline: Remove product from cart
    And the user clicks on the "add to cart" button of 2 different products.
    And the user clicks on the cart button.
    When the user clicks on remove of the product to be removed.
    Then the deleted product is no longer in the cart.

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |

