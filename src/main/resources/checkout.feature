Feature: Checkout test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks on login button


  @testcase11
  Scenario Outline: Verify the final price of several products

    And the user add 3 random products to cart
    And the
    When the user remove one of the product from the cart
    Then the product remove does not shown in the cart

    Examples:
      | username        | password      |  product |
      | standard_user   | secret_sauce  |  random  |


  @testcase12
    Scenario Outline: hacer un pedido