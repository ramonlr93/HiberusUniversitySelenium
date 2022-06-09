@maininventory
Feature: validate main inventory suite
  Background: Add an item into the cart
    Given the user is logged on and in the main inventory page

  @testcase06
  @smoke
  Scenario: Validate the user goes Phones & PDAS store
    When user clicks on Phones & PDAS menu
    Then Phones & PDAS store "http://opencart.abstracta.us/index.php?route=product/category&path=24" is displayed
