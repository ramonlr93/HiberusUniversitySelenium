@cart
Feature: Validate shopping cart test suite

  Background: Navigate to the home page
    Given the user is on the home page actual

  @testcase10
  @smoke
  Scenario Outline: Add a single item in the shopping cart
    And the user clicks MyAccount
    And the user selects the login
    And the user provides the username "<e-mail>" and password "<password>"
    And the user clicks the login button
    And the user goes to your store
    When the user adds an item by clicking 'Add To Cart'
    And the user see the success alert
    Then there should be an item in the cart
    Examples:
      | e-mail                      | password     |
      | isabel.ezquerra83@gmail.com | 123456       |


    @testcase11
    Scenario Outline: Delete an item in the shopping cart
      And the user clicks MyAccount
      And the user selects the login
      And the user provides the username "<e-mail>" and password "<password>"
      And the user clicks the login button
      And the user goes to your store
      And the user adds an item by clicking 'Add To Cart'
      And the user see the success alert
      And there should be an item in the cart
      And the user clicks to the cart
      When the user deletes an item from shopping cart
      Then there should be 0 items in the shopping cart
      Examples:
        | e-mail                      | password     |
        | isabel.ezquerra83@gmail.com | 123456       |


