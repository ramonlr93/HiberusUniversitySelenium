@checkoutOverview
Feature: CheckoutOverview test suite

  Background:
    Given the user is on the home page

  @smoke
  @testcase-11
  Scenario Outline: Check the final price if multiple products
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks in the button add-to-cart of three random items
    And the user goes to cart
    And the user goes to checkout
    And the user fills the field name "<name>"
    And the user fills the field lastname "<lastname>"
    And the user fills the field zipcode "<zipcode>"
    When the user clicks the continue button
    Then the total price of the order is the sum of the amount of the items selected in the inventory

    Examples:
      | username      | password     | name   | lastname | zipcode |
      | standard_user | secret_sauce | Aketza | Garcia   | 26580   |

  @smoke
  @testcase-12
  Scenario Outline: Do an order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks in the button add-to-cart of three random items
    And the user goes to cart
    And the user goes to checkout
    And the user fills the field name "<name>"
    And the user fills the field lastname "<lastname>"
    And the user fills the field zipcode "<zipcode>"
    And the user clicks the continue button
    When the user clicks the finalice button
    Then validate the checkout is correct showing the "<message>"

    Examples:
      | username      | password     | name   | lastname | zipcode | message                                                                                 |
      | standard_user | secret_sauce | Aketza | Garcia   | 26580   | Your order has been dispatched, and will arrive just as fast as the pony can get there! |

