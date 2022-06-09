@store
  Feature: validate store test suite

    Background:
      Given the user is on the home page
      And the user clicks on myAccountButton
      And the user clicks on loginSelectOption
      And the user go to LoginPage
      And the user introduces his email "carrabmin@gmail.com" and password "hlarsson7"
      And the user clicks on the login button
      And the user clicks on loginSelectOption
      And the user see Your Store Page

      @smoke-store
    Scenario: Verify user clicks on tablet button and goes to Product Page
      And the user clicks on the tablets button
      Then the user see Product Page