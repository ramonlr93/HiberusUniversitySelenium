@checkout
Feature: validate checkout suite

  Background: Confirm order
    Given the user is logged, added an item and in the checkout page

  @testcase09
  @smoke
  Scenario Outline: Verify order is succesfully placed

    And the user fills Billing Details by default
    And the user leaves the existing billing details address for delivery
    And the user fills "<comments>" into the text area
    And the user clicks on continue button
    And the user leaves Bank transfer payment method by default and clicks on agreement checkbox
    And clicks on continue button
    And clicks on Confirm Order
    Then order confirmed is displayed on the "<url>"
    Examples:
      | comments                        | url                                                           |
      | I want my HTC and I want it now | http://opencart.abstracta.us/index.php?route=checkout/success |