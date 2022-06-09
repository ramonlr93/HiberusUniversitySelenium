@home_test_suite
Feature: validate the inventory functionality in OpenCart

  Background: The user is logged in
    Given the user is on the login page
    And the user enters the "mario@mail.com" and "1311"
    And the user clicks the login button
    And the user clicks go home button

  @OC-13
  Scenario: the user empties the shipping cart
    And the user clicks the chart summary button
    When the user clicks the remove button
    Then the cart is emptied



