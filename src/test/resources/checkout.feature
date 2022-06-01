@checkout
Feature: checkout test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase11
  Scenario Outline: validate final price
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    And the user select <number> random itmes
    And the user clicks the cart button
    And the user clicks the checkout button
    And the user fills the checkout information "<firstName>" ,"<lastname>" and "<postalCode>"
    When the user clicks the continue button
    Then the user see the item total price that is equal to the sum of each item
    Examples:
      | username      | password     | number | firstName | lastname | postalCode |
      | standard_user | secret_sauce | 3      | Katherin  | Sanabria | 04009      |

  @testcase12
  Scenario Outline: validate checkout message
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    And the user select <number> random itmes
    And the user clicks the cart button
    And the user clicks the checkout button
    And the user fills the checkout information "<firstName>" ,"<lastname>" and "<postalCode>"
    And the user clicks the continue button
    When the user clicks the finish button
    Then the user see the checkout message
    Examples:
      | username      | password     | number | firstName | lastname | postalCode |
      | standard_user | secret_sauce | 3      | Katherin  | Sanabria | 04009      |