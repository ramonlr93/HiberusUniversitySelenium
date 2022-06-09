@product
Feature: validate product test suite

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

    @smoke-product
  Scenario: Verify user clicks on checkout button and goes to Checkout Page
    And the user clicks on the add to cart button
    And the user clicks on the cart button
    And the user clicks on the checkout button
    Then the user see the Checkout Page