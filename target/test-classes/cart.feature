@cart
Feature: cart test suite

  Background:
    Given the user is on the home page

  @testcase10
  Scenario Outline: delete product in cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is in the inventory page
    And the user select <number> random itmes
    And the user clicks the cart button
    When the user deletes 1 item in the cart by <position>
    Then the user cant see the item in the <position>
    Examples:
      | username      | password     | number | position |
      | standard_user | secret_sauce | 2      | 0        |

