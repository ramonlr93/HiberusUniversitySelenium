@cart
Feature: Cart test suite

  Background:
    Given the user is on the home page

  @testcase025
    @smoke
  Scenario Outline: Verify that an unlogged user can add a product to cart
    And the user adds a "<item>" from homepage to cart
    And the user should be shown a product added confirmation message
    When the user clicks the Your Store link
    Then there should be "<num_items>" items on the shopping cart
    Examples:
      | item    | num_items |
      | MacBook | 1         |


  @testcase026
  Scenario Outline: Verify that a logged user can add products to cart
    And the user clicks the my account button
    And the user clicks the login link
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user adds a "<item>" from homepage to cart
    And the user adds a "<item>" from homepage to cart
    Then there should be "<num_items>" items on the shopping cart

    Examples:
      | email                 | password | item    | num_items |
      | gonex68008@falkyz.com | password | MacBook | 2         |