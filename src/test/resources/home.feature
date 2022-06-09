@home
Feature: Validate home test suite

  Background: Navigate to the Home page
    Given the user is on the Home page

  @testcase07
  Scenario: Validate that the user changes the currency from Dollar ($) to Euro (€)
    And the user visualizes that the currency displayed in the shopping cart is Dollar
    And the user clicks the Currency button
    When the user clicks the Euro button
    Then the user validate that the currency in the shopping cart button is Euro

  @testcase08 @smoke
  Scenario Outline: Validate that the user adds item to the shopping cart
    And the user access to MyAccountNavBarButton
    And the user access to LoginMenu
    And the user login with "<email>", "<password>"
    And the user clicks the HomeItemHouse
    And the user adds a single product by clicking AddToCart
    And the user should be shown a success_added_product message
    Then the user verify that the product info appear in the shopping cart button
     Examples:
      |            email               |   password   |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |

  @testcase09
  Scenario Outline: Validate that the shopping cart information panel is displayed
    And the user access to MyAccountNavBarButton
    And the user access to LoginMenu
    And the user login with "<email>", "<password>"
    And the user clicks the HomeItemHouse
    And the user adds a single product by clicking AddToCart
    And the user should be shown a success_added_product message
    And the user verify that the product info appear in the shopping cart button
    When the user clicks on the Shopping Cart button
    Then the user should be shown a view panel with the info of the product added to the shopping cart
     Examples:
      |            email               |   password   |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |

  @testcase10 @smoke
  Scenario Outline: Validate that the user delete item from the shopping cart
    And the user access to MyAccountNavBarButton
    And the user access to LoginMenu
    And the user login with "<email>", "<password>"
    And the user clicks the HomeItemHouse
    And the user adds a single product by clicking AddToCart
    And the user should be shown a success_added_product message
    And the user verify that the product info appear in the shopping cart button
    And the user clicks on the Shopping Cart button
    And the user should be shown a view panel with the info of the product added to the shopping cart
    When the user clicks on the Delete button
    Then the user deletes the product from the shopping cart
     Examples:
      |            email               |   password   |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |
