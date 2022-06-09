@user
Feature: validate user page suite

  Background: Navigate to the home page
    Given the user is logged on the user page

  @testcase05
  Scenario Outline: Verify user goes to main inventory page
    When user clicks on Your Store label
    Then "<mainInventory>" is displayed
    Examples:
      | mainInventory                                            |
      | http://opencart.abstracta.us/index.php?route=common/home |