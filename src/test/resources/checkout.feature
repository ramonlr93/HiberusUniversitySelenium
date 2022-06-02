@checkout
Feature: Checkout test suite

  Background:
    Given the user is on the home page

  @testcase11
  Scenario Outline: Verify valid total price is equal to the sum of the quantities
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the 3 products random add to cart
    And go to the cart page
    When click checkout button
    And  And the user provides the firstName "<firsname>"
    And the user provides the lastName "<lastname>"
    And the user provides the postalCode "<postalcode>"
    And click continue button
    Then the item total is equal to the sum of quantities

    Examples:
      | username      | password     | firsname | lastname | postalcode |
      | standard_user | secret_sauce | Flor     | Ch       | 55555      |

  @testcase12
  Scenario Outline: Verify valid make an order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the 1 products random add to cart
    And go to the cart page
    And click checkout button
    And And the user provides the firstName "<firsname>"
    And the user provides the lastName "<lastname>"
    And the user provides the postalCode "<postalcode>"
    And click continue button
    When click finish button
    Then the order has been completed successfully and the message has been displayed

    Examples:
      | username      | password     | firsname | lastname | postalcode |
      | standard_user | secret_sauce | Flor     | Ch       | 55555      |