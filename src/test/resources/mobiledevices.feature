@mobiledevices
Feature: validate mobile devices store suite

  Background: Navigate to different stores
    Given the user is logged and in the mobile devices page

  @testcase07
  @smoke
  Scenario: Verify adds a HTC device to the cart
    When user clicks on the add to cart button
    Then the cart icon at the top right displays "1 item(s) - $100.00" and price item added

  @testcase08
  Scenario: Verify I can go to checkout and buy the product
    When user clicks on the add to cart button
    And user clicks on ckeckout button
    Then checkout webpage "https://opencart.abstracta.us/index.php?route=checkout/checkout" is displayed