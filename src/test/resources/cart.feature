@cart
Feature: cart test suite
  @testcase11
    @smoke
  Scenario Outline: Delete one items in the shopping cart
    Given the user is on the home page
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user selects
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    And the user clicks on the shopping cart
    Then the user remove a "<item>" by clicking Remove in cart
    And there should be 1 items in the shopping cart
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |