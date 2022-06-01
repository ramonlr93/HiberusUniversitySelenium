@checkout
Feature: checkout

  Background: Navigate to the home page
    Given the user is on the home page
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button

    @checkprice
  Scenario Outline: check the final price of the products on the cart

    And the user selects
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
    And the user clicks on the shopping cart
    And the user does the checkout of the products
    And the user fills the checkout form with the values "<test first name>", "<test last name>", "<test postal code>"
    When the user continues to the second step
    Then the total price of the order is the correct

    Examples:
      | test first name | test last name | test postal code |
      | firstName       | lastName       | 47000            |

      @removeproduct
  Scenario: Remove a product from the cart
    And the user selects 1 random items
    And the user clicks on the shopping cart
    And the user does the checkout of the products
    And the user fills the checkout form with the values "test first name", "test last name", "test postal code"
    And the user continues to the second step
    When the user ends the checkout
    Then the page redirect to the confirmation order page and sees the text "Your order has been dispatched, and will arrive just as fast as the pony can get there!"