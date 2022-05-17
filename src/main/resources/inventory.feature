Feature: Inventory test suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"

  @testcase3
  Scenario Outline: validate inventory list is 6
    When the user clicks the login button
    Then validate the number of products are six

    Examples:
     | username        | password      | products
     | standard_user   | secret_sauce  | 6

  @testcase4
   Scenario Outline: Verify the Sauce Labs Bolt T-Shirt product exists in inventory page
    When the user clicks the login button
    Then validate if the Sauce Labs Bolt T-Shirt is shown in the inventory

    Examples:
     | username        | password      |  product                  |
     | standard_user   | secret_sauce  |  Sauce Labs Bolt T-Shirt  |


  @testcase5
  Scenario Outline: Verify the Sauce Labs Bolt T-Shirt product is added to cart
    And the user clicks the login button
    When the user clicks the product is added to cart
    And the user clicks on the shopping cart
    Then product is shown in cart

    Examples:
     | username        | password      |  product                  |
     | standard_user   | secret_sauce  |  Sauce Labs Bolt T-Shirt  |


  @testcase6
  Scenario Outline: Verify the Sauce Labs Bolt T-Shirt product is removed from cart
    And the user clicks the login button
    And the user adds the Sauce Labs Bolt T-Shirt product to cart
    When the user removed the product from the cart
    Then product is not shown in the cart

    Examples:
     | username        | password      |  product                  |
     | standard_user   | secret_sauce  |  Sauce Labs Bolt T-Shirt  |

  @testcase7
  Scenario Outline: Place multiple items in the shopping cart
    And the user clicks the login button
    When the user selects
    | random products         |
    And the user clicks on the shopping cart
    Then there should be "3" items in the shopping cart
    Examples:
     | username      | password     |
     | standard_user | secret_sauce |


  @testcase08
  Scenario Outline: sort inventory by alphabetical desc order
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by alphabetical desc order
    Examples:
     | username      | password     | optionSort |
     | standard_user | secret_sauce | za         |

   @testcase09
   Scenario Outline: sort inventory by price desc order
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by price desc order
    Examples:
     | username      | password     | optionSort |
     | standard_user | secret_sauce | hilo       |         | standard_user | secret_sauce | hilo       |


