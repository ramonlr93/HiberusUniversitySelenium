@checkout
@smoke
Feature: Validate Checkout test suite

  Background:
    Given the user is on the home page
    And The user clicks phones and pdas button
    And the user is on phones and pdas page
    And the user add the first product to the cart
    And The user clicks cart button
    And The user clicks checkout option
    And The user is on checkout page

  @testcase22
  Scenario Outline: validate checkout ok
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    And the user clicks check of that delivery and billing addresses are the same
    And the user clicks continue in step 2
    And the user clicks flat shipping
    And the user clicks continue in step 3
    And the user clicks cash on delivery option
    And the user accepts check of terms and conditions
    And the user clicks continue in step 4
    When the user clicks confirm order button
    Then the user is on checkout success page

    Examples:
      | firstName | lastName   | email             | telephone | address1    | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | calle falsa | Valladolid | 47010    |

#    Falla el último paso

