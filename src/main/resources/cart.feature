Feature: Cart test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks on login button
    And add two random products to cart

  @testcase10
  Scenario Outline: Remove a product from the cart

    When the user remove one of the product from the cart
    Then the product remove does not shown in the cart

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |


