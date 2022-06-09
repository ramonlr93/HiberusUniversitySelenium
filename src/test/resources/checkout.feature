@checkout
Feature: Validate checkout test suite

  Background:
    Given the user is on the home page

  @testcase09
    @smoke
  Scenario Outline: a register user add product to cart
    And the user go to My Account to login
    And the user enter the email "<email>" and password "<password>"
    And the user clicks the login button
    And the user go cameras section
    And the user add to cart a camera
    And the user go checkout
    And the user inside checkout
    And the user enter "<firstname>", "<lastname>", "<company>", "<address_1>", "<city>", "<postalcode>"
    And the user select "<country>" and "<state>"
    And the user clicks the payment button, the shipping button and the shipping method button
    And the user accepts the conditions
    And the user clicks the payment method button
    #And the user clicks the confirm button

    Examples:
      | email                  | password       | firstname | lastname | company | address_1   | city     | postalcode | country | state |
      | tapihaw117@game4hr.com | tapihawGame4hr | Tappi     | Haw      | Game4hr | Peregrina 9 | A Coruña | 15010      | 195     | 2970  |