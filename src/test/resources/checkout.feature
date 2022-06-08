@checkout
Feature: Validate checkout test suite

  Background: Navigate to the home page
    Given the user is on the Home page

  @testcase08 @smoke
  Scenario Outline: validate checkout
    And the user access to MyAccountNavBarButton and access to LoginMenu
    And the user is logged in with "<email>", "<password>"
    And the user clicks the HomeItemHouse
    And the user adds a product to the shopping cart
    And the user clicks the CheckoutNavBarButton and navigates to the CheckoutPage
    And the user complete the Billing Details with "<firstname>", "<lastname>", "<address>", "<city>", "<country>", "<region_state>"
    And the user complete the Delivery Details step
    And the user complete the Delivery Methods step
    And the user complete the Payment Method step
    When the user Confirm the Order and checkout successfully
    Then the user Logout successfully
    Examples:
      |            email               |   password   | firstname | lastname |    address     |   city   | country | region_state |
      | nubrokakattoi-8879@yopmail.com | hiberusfinal |    Jack   |  Sparrow | street 11, 280 | Zaragoza |   195   |     3021     |









