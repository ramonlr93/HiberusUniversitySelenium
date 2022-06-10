@checkout
Feature: checkout test suite

  @checkout01
  @smoke
  Scenario: Validate the user can do a checkout
    Given the user navigates to the inventory page
    And the user is in the inventory page
    And the user add the item "Canon EOS 5D"
    When the user press the checkout button
    And the user write in the E-Mail "ejemplo@ejemplo.es" login input
    And the user write in the Password "hola" login input
    And the user click in the Login button
    And the user press the continue button
    And the user press the continue button
    And the user press the continue button
    And the user press the check Terms and Conditions
    And the user press the continue button
    And the user press the confirm button
    Then the user is in the checkout success page

