@checkout_test_suite
Feature: validate the checkout functionality in OpenCart

  Background:
    Given the user is on the login page

  @OC-12
  Scenario: The logged user orders one item with existing address
    And the user enters the "mario@mail.com" and "1311"
    And the user clicks the login button
    And the user clicks go home button
    And the user adds one item to the chart
    And the user clicks go checkout
    And the user uses already existing address for billing
    And the user clicks continue to delivery details
    And the user uses already existing address for delivery details
    And the user clicks continue to delivery method
    And the user clicks continue to payment
    And the user selects
    And the user accepts terms and conditions
    And the user clicks continue to confirm
    When the user clicks confirm order
    Then the user sees the "Your order has been placed!" window



#  @OC-13
#  Scenario: The logged user orders one item with new address
#    And the user enters the "mario@mail.com" and "1311"
#    And the user clicks the login button
#    And the user clicks go home button
#    And the user adds one item to the chart
#    And the user clicks go checkout
#    And the user enters a new address
#    And the user clicks continue
#    And the user enters a new address for delivery





