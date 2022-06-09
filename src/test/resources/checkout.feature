@checkout
Feature: validate checkout test suite

  Background:
    Given the user is on the home page
    And the user clicks on myAccountButton
    And the user clicks on loginSelectOption
    And the user go to LoginPage
    And the user introduces his email "carrabmin@gmail.com" and password "hlarsson7"
    And the user clicks on the login button
    And the user clicks on loginSelectOption
    And the user see Your Store Page
    And the user clicks on the tablets button
    And the user see Product Page
    And the user clicks on the add to cart button
    And the user clicks on the cart button
    And the user clicks on the checkout button
    And the user see the Checkout Page

    @smoke-checkout-correct
  Scenario Outline: Verify user can checkout and confirm his order
    And the user clicks the new address radio button
    And the user introduces his address: "<firstName>", "<lastName>", "<address>", "<city>", "<postCode>"
    And the user select his country "<country>" and region "<region>"
    And the user clicks continueButton step 2
    And the user clicks continueButton step 3
    And the user clicks continueButton step 4
    And the user clicks cod radioButton
    And the user clicks conditions checkbox
    And the user clicks continueButton step 5
    And the user clicks confirm order button
    Then the user see the Order Placed Page

    Examples:
      | firstName | lastName | address          | city      | postCode | country | region |
      | Ernesto   | Lopez    | C/ Santa Lucia 8 | Santander | 39011    | 195     | 2983   |