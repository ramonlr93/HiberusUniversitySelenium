@inventory
Feature: Validate home test suite

  Background: Navigate to the Home page
    Given the user is on the Home page

  @testcase07
    @smoke
  Scenario: Add item into the shopping cart
    When the user adds a single product by clicking AddToCart
    And the user should be shown a success_added_product message
    Then the user verify that the product info appear in the shopping cart

#  @testcase11
#  Scenario Outline: Delete a single item in the sopping cart
#    And the user provides the username "<username>" and password "<password>"
#    And the user clicks the login button
#    And the user adds a "<item>" by clicking 'Add To Cart'
#    And the user clicks on the shopping cart
#    And there should be "1" items in the shopping cart
#    When the user deletes a "<item>" item from shopping cart
#    Then there should be "0" items in the shopping cart
#    Examples:
#      | username      | password     | item                |
#      | standard_user | secret_sauce | Sauce Labs Backpack |



# #@testcase06
# #@TODO
# # Scenario Outline: Delete an item in the shopping cart
# #   And the user provides the username "<username>" and password "<password>"
# #   When the user clicks the login button
# #   And the user adds a "<item>" by clicking 'Add To Cart'
# #   And the user clicks on the shopping cart
# #   Then there should be "1" items in the shopping cart
# #   Examples:
# #     | username      | password     | item                |
# #     | standard_user | secret_sauce | Sauce Labs Backpack |
#

#  @testcase07
#  Scenario Outline: Place multiple items in the shopping cart
#    And the user provides the email "<email>" and password "<password>"
#    And the user clicks the login button
#    Examples:
#      |              email            |   password   |
#      |nubrokakattoi-8879@yopmail.com | hiberusfinal |
#    When the user adds a "<item>" by clicking 'Add To Cart'
#    When the user selects
#      | Sauce Labs Backpack     |
#      | Sauce Labs Bolt T-Shirt |
#      | Sauce Labs Onesie       |
#    And the user clicks on the shopping cart
#    Then there should be "3" items in the shopping cart
#
#
#
#
#
#
#
#  @testcase03
#  Scenario Outline: validate inventory list size
#    And the user provides the email "<email>" and password "<password>"
#    When the user clicks the login button
#    Then the user see the inventory list with "<items>" size list
#    Examples:
#      | username      | password     | items |
#      | standard_user | secret_sauce | 6     |
#      Then there should be "1" items in the shopping cart