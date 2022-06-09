@checkout
Feature: Validate checkout test suite

  Background: Navigate to the home page
    Given the user is on the home page actual

  @testcase11
  @smoke
  Scenario Outline: validate product price in checkout

    And the user clicks MyAccount
    And the user selects the login
    And the user provides the username "<e-mail>" and password "<password>"
    And the user clicks the login button
    And the user goes to your store
    And the user adds an item by clicking 'Add To Cart'
    And the user see the success alert
    And the user clicks checkout
    And the user provides the first name "<firstname>" and last name "<lastname>" and address "<address>" and city "<city>" and postal code "<postalCode>" and country "<country>" and region "<region>"
    When the user clicks continueButtonPayment
    And  the user clicks continueButtonShipping
    And  the user clicks continueButtonShippingMethod
    And  the user agrees the terms and conditions
    And  the user clicks continuePaymentButtonMethod
    Then the user clicks confirm order

    Examples:
       | e-mail                      | password     | firstname | lastname   | address      | city          | postalCode         | country                | region   |
       | isabel.ezquerra83@gmail.com | 123456       | isabel    | ezquerra   | calle baja  | london         | 111111             | United Kingdom         | Aberdeen |