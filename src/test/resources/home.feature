@home
Feature: validate home test suite

    Background:
    Given the user is on the home page


    @smoke-homelogin
    Scenario: Verify the user goes to login page
      And the user clicks on myAccountButton
      When the user clicks on loginSelectOption
      Then the user go to LoginPage

    @smoke-homeregister
    Scenario: Verify the user goes to register page
      And the user clicks on myAccountButton
      When the user clicks on registerSelectOption
      Then the user go to RegisterPage