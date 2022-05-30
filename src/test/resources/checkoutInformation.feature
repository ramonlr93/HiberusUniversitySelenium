Feature: Checkout test suite

  Background:
    Given the user is on the home page

  @checkout
  Scenario Outline: Remove an item from cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user clicks in the button add-to-cart of three random items
    And the user goes to cart
    When the user goes to checkout
    And the user fills the field name "<name>"
    And the user fills the field lastname "<lastname>"
    And the user fills the field zipcode "<zipcode>"
    Then the user clicks the continue button
    And the user is in the checkout overview page

    Examples:
      | username      | password     | name   | lastname | zipcode |
      | standard_user | secret_sauce | Aketza | Garcia   | 26580   |
