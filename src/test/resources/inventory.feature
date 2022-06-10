@inventory
Feature: Validate Inventory test suite

  Background:
    Given the user navigates to the inventory page
    And the user is in the inventory page

  @inventory01
    @smoke
  Scenario Outline: validate inventory list size
    When the user add the item "<itemName>"
    Then the user can see added item message with the text "<itemName>"
    Examples:
      | itemName     |
      | Canon EOS 5D |


