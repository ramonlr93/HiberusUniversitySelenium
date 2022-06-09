@start
Feature: validate home page test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase01
  @smoke
  Scenario Outline: Verify user can navigate to register webpage
    When the user selects register option by My Account combobox
    Then Register "<url>" is displayed

    Examples:
      | url                                                            |
      | https://opencart.abstracta.us/index.php?route=account/register |

  @testcase02
  @smoke
  Scenario Outline: Verify user can navigate to login webpage
    When the user selects login option by My Account combobox
    Then Login "<url>" is displayed
    Examples:
      | url                                                         |
      | https://opencart.abstracta.us/index.php?route=account/login |