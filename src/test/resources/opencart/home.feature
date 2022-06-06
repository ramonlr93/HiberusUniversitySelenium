@home
Feature: Home test suite

  Background:
    Given the user is in the main page


  @testcase-11
  Scenario Outline: Verify the number of items is <number>
    When the user can see the featured section
    Then the number of items is <number>

    Examples:
      | number |
      | 4      |

  @testcase-12
  Scenario Outline: Verify the carousels are visible
    Then the user can see the carousels "<about>"

    Examples:
      | about     |
      | products  |
      | companies |


  @testcase-13
  Scenario: Verify can add products to cart
    When the user adds all items to the cart
    And the user goes to cart
    Then the item should appear in the cart
