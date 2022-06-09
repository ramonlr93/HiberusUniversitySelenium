@home
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page actual

  @testcase01
  Scenario Outline: validate inventory list size
    Then the items in the featured are "<items>"
    Examples:
      | items |
      | 4     |

  @testcase02
  Scenario Outline: validate login access
    And the user clicks MyAccount
    And the user clicks the login button

  @testcase03
  Scenario Outline: validate register option
    And the user clicks MyAccount
    And the user selects register

  @testcase07
  Scenario Outline: Add a single item in the sopping cart
    When the user adds an item by clicking 'Add To Cart'
    And the user see the success alert
    Then there should be an item in the cart



