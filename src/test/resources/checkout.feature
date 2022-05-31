@checkout
Feature: checkout test suite

  Background:
    Given the user is on the home page

  Scenario Outline: Check the final price in the checkout
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user selects
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    And the user clicks on the shopping cart
    And the user clicks on the checkout button
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the zip "<zip>"
    When the user clicks on the continue button
    Then the user can see the item total price
    Examples:
      | username      | password     | firstname | lastname | zip   |
      | standard_user | secret_sauce | Santos    | Pena     | 31230 |

  Scenario Outline: Check in the complete checkout the message is "<message>"
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user adds a "<item>" by clicking Add To Cart
    And the user clicks on the shopping cart
    And the user clicks on the checkout button
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the zip "<zip>"
    And the user clicks on the continue button
    When the user clicks on the finish button
    Then the user can see the message "<message>"
    Examples:
      | username      | password     | firstname | lastname | zip   | item                | message                                                                                 |
      | standard_user | secret_sauce | Santos    | Pena     | 31230 | Sauce Labs Backpack | Your order has been dispatched, and will arrive just as fast as the pony can get there! |