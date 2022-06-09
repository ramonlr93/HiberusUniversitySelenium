@checkout
Feature: Validate checkout test suite

  Background:
    Given the user is on the home page

  @testcase09
    @smoke
  Scenario Outline: a register user add product to cart
    And the user go to My Account to login
    And the user enter the email "<email>" and password "<password>"
    And the user clicks the login button
    And the user go cameras section
    And the user add to cart a camera
    And the user click checkout button
    Examples:
      | email                  | password       |
      | tapihaw117@game4hr.com | tapihawGame4hr |