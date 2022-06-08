@checkout_test_suite
Feature: validate the checkout functionality in OpenCart

  Background: The user is logged in
    Given the user is on the login page
    And the user enters the "mario@mail.com" and "1311"
    And the user clicks the login button
    And the user clicks go home button

    Scenario Outline:


