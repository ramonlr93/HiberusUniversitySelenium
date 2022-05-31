@cart
Feature: cart test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    When the user clicks the login button

    @testAddToCart
  Scenario Outline: add to cart "product" product
    #....

    Examples:
      | username        | password      | product |
      | standard_user   | secret_sauce  |   ...   |