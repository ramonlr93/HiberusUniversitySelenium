@inventory
Feature: Inventory test suite

  Background:
    Given the user go to the home page
    And the user go to the login page

  @testcase05
  Scenario Outline: Verify valid the number of results is 4
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user go to the home page
    Then the items count on feature is equal 4
    Examples:
      | email               | password |
      | flor.qa@yopmail.com | 123456   |

  @testcase06
  Scenario Outline: Verify valid the products add to cart
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user go to the home page
    When the user add product to cart
      | MacBook          |
      | iPhone           |
      | Apple Cinema 30" |
      | Cannon EOS 5D    |
    Then show the ok message add to cart product

    Examples:
      | email               | password |
      | flor.qa@yopmail.com | 123456   |
