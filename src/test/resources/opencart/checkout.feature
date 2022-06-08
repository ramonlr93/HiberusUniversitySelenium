@checkout
Feature: Checkout test suite

  Background:
    Given the user is in the main page
    And the user goes to login

  @smoke
    @testcase-17
  Scenario Outline: Verify can checkout with logged account
    And the user provides the mail "<mail>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user goes to home
    And the user adds all items to the cart
    And the user goes to cart
    And the user clicks the checkout button
    And the user is in the checkout
    When the user select new adress opcion
    And the user provides a firstname "<firstname>"
    And the user provides a lastname "<lastname>"
    And the user provides a company "<company>"
    And the user provides an address_1 "<address_1>"
    And the user provides an address_2 "<address_2>"
    And the user provides a city "<city>"
    And the user provices a postalcode "<postalcode>"
    And the user select a country "<country>"
    And the user select a state "<state>"
    And the user clicks the payment button
    And the user clicks the shipping button
    And the user clicks the shipping method button
    And the user selects the conditions
    And the user clicks the payment method button
    And the user clicks the confirm button
    Then the user is in the checkout success site

    Examples:
      | mail                 | password  | firstname | lastname | company | address_1 | address_2 | city   | postalcode | country | state |
      | herceclase@gmail.com | David2001 | Aketza    | Garcia   | Hiberus | Farsia 7  | 2C        | Arnedo | 26580      | 195     | 2996  |

