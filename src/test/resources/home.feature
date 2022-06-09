@home_test_suite
Feature: validate the inventory functionality in OpenCart

  Background: The user is logged in
    Given the user is on the login page
    And the user enters the "mario@mail.com" and "1311" credentials
    And the user clicks the login button
    And the user clicks go home button

  @OC-13
  Scenario: the user empties the shopping cart
    And the user adds one item to the cart
    And the user clicks the cart summary button
    When the user clicks each of the remove items button
    Then the cart is emptied



