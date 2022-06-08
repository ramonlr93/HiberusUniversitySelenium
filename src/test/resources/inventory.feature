@inventory
Feature: Validate Inventory test suite

  Background:
    Given the user navigates to the inventory page
    And the user is in the inventory page

  @inventory01
  Scenario Outline: validate inventory list size
    And the user add the item "<itemName>"
    Examples:
      | itemName     |
      | Canon EOS 5D |


