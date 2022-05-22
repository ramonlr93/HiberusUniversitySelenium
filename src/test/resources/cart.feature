Feature: Cart test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button

  SScenario Outline: Verify valid remove product from to cart
       And the 2 products add to cart
       And go to the cart page
       When the "product" protuct is remove
       Then the remove product no apparent to the cart

       Examples:
         | username      | password     | product                 |
         | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |