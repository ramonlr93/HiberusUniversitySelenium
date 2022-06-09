@checkout
@smoke
Feature: Checkout Test Suite

  Background:
    Given the user is in the home page
    And the user clicks to go to the login page
    And the user is in the login page

  @testcase12
  Scenario Outline:  Verify and order is placed
    And the user provides the username "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user log in succesfully
    And the user goes to the Mobile Phones & PDAs page
    And the user add "<quantity>" item to the cart
    And the user goes to checkout page
    And the user adds the details correctly "<name>" "<surname>" "<address>" "<city>" "<postalcode>" "<country>" "<state>"
    When the user confirms all the information
    Then it shows a message that the order was placed

    Examples:
      |         email           | password     |  quantity |  name  | surname |  address  | city   | postalcode| country | state |
      | robertoch1985@gmail.com | 12345        |    2      | Pepe   | Lopez   | Sin calle | Ciudad |  4444     | 195     | 2975  |