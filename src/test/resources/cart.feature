@cart
Feature: cart test suite

  Scenario Outline: Delete one item in the shopping cart
    Given the user is on the home page
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user selects 2 random items
    And the user clicks on the shopping cart
    Then the user remove 1 item by clicking Remove Button cart
    And there should be 1 items in the shopping cart
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
