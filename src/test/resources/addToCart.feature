@addtocart
Feature: Add product to cart

  Background:
    Given the user is on the home page

  @testcase06
  @smoke
  Scenario: a user unknown add product to cart
    When the user adds a MacBook from the home page to the cart
    Then Item is successfully added to the cart

  @testcase07
  Scenario Outline: a register user add product to cart
    And the user go to My Account to login
    And the user enter the email "<email>" and password "<password>"
    And the user clicks the login button
    And the user go to the home page
    When the user adds a MacBook from the home page to the cart
    Then Item is successfully added to the cart
    Examples:
      | email                  | password       |
      | tapihaw117@game4hr.com | tapihawGame4hr |
