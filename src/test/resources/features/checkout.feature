@checkout
Feature: validate checkout test suite

  Background: Navigate to the checkout page
    Given the user is on the home page
    And the user clicks the add to cart of a product
    And the user clicks the checkout button
    And the user checks as guest
    And the user clicks the continue to account button

  @testcase07
    @smoke
  Scenario Outline: Verify checkout works correctly

    And the user provides the firstName "<firstName>", the lastName "<lastName>", the email "<email>" and the telephone "<telephone>" details
    And the user provides the address "<address>", the city "<city>", the post code "<postCode>", the country "<country>" and the region "<region>"
    And the user click the button to continue to delivery details
    And the user click the button to continue to payment methods if delivery method appear
    And the user clicks on the check of the Term conditions
    And the user clicks on the continue in payment method
    When the user clicks on the confirm checkout button
    Then the user sees a message that the order has been placed
    Examples:
      | firstName | lastName | email                   | telephone | address     | city     | postCode | country | region   |
      | Prueba    |  Compra  | prueba.usuario@pu12.com | 600000000 | C/ Mayor 16 | Zaragoza | 50000    | Spain   | Zaragoza |

  @testcase08
  Scenario Outline: Verify user doesn't check the Term Conditions

    And the user provides the firstName "<firstName>", the lastName "<lastName>", the email "<email>" and the telephone "<telephone>" details
    And the user provides the address "<address>", the city "<city>", the post code "<postCode>", the country "<country>" and the region "<region>"
    And the user click the button to continue to delivery details
    And the user click the button to continue to payment methods if delivery method appear
    When the user clicks on the continue in payment method section
    Then a warning message appear on the top of the section
    Examples:
      | firstName | lastName | email                   | telephone | address     | city     | postCode | country | region   |
      | Prueba    |  Compra  | prueba.usuario@pu12.com | 600000000 | C/ Mayor 16 | Zaragoza | 50000    | Spain   | Zaragoza |

  @testcase09
  Scenario Outline: Verify user enter an invalid option in the information

    And the user provides the firstName "<firstName>", the lastName "<lastName>", the email "<email>" and the telephone "<telephone>" details
    And the user provides the address "<address>", the city "<city>", the post code "<postCode>", the country "<country>" and the region "<region>"
    When the user click the button to continue to delivery details section
    Then a message appear on the field of the details that is invalid
    Examples:
      | firstName | lastName | email                   | telephone | address     | city     | postCode | country | region   |
      |           |  Compra  | prueba.usuario@pu12.com | 600000000 | C/ Mayor 16 | Zaragoza | 50000    | Spain   | Zaragoza |