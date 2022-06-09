@checkout_test_suite
Feature: validate the checkout functionality in OpenCart

  Background:
    Given the user is on the login page

  @OC-12
    @smoke
  Scenario Outline: The logged user orders one item with existing address
    And the user enters the "mario@mail.com" and "1311" credentials
    And the user clicks the login button
    And the user clicks go home button
    And the user adds one item to the cart
    And the user clicks go checkout
    And the user clicks continue to billing details
    And the user clicks continue to delivery details
    And the user clicks continue to delivery method
    And the user selects "<payment_option>"
    And the user accepts terms and conditions
    And the user clicks continue to payment
    And the user clicks continue to confirm
    And the user clicks confirm order
    Then the user sees the "Your order has been placed!" message
    Examples:
      | payment_option   |
      | Cash On Delivery |
      | Bank Transfer    |




