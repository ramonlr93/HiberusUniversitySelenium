@checkout
Feature: validate checkout test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase16
  Scenario Outline: Verify checkout of product
    When the user adds "<product>" to the cart
    And the user clicks the cart button
    And the user clicks checkout link
    And the user selects guest user
    And the user clicks step one continue button
    And the user provides the first name "<firstName>" and the last name "<lastName>" and the address "<address>" and the mail "<email>" and the "<telephone>" and the city "<city>" and the country "<country>" and the region "<region>"
    And the user clicks step two continue button
    And the user clicks on Terms and Conditions radio button
    And the user clicks step three continue button
    When the user clicks on confirm order button
    Then the user is shown de order has been placed page
    Examples:
      |product| firstName | lastName | address        | email                    | telephone | city      |  country  | region |
      |MacBook| Laura     |  Del Rio | Av avenida A B | maildeprueba@hotmail.com |555555555  |Frigiliana |  Spain    | Malaga |

