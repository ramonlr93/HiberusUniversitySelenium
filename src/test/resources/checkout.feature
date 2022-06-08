@login
Feature: validate checkout test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase14
  Scenario Outline: Verify checkout of product
    When the user adds "<product>" to the cart
    And the user clicks the cart button
    And the user clicks checkout link
    And the user selects guest user
    And the user clicks step one continue button
    And the user provides the first name "<firstName>" and the last name "<lastName>" and the address "<address>" and the city "<city>" and the country "<country>" and the region "<region>"
    Examples:
      |product| firstName | lastName | address        |  city      |  country  | region |
      |MacBook| Laura     |  Del Rio | Av avenida A B | Frigiliana |  Spain    | Malaga |

