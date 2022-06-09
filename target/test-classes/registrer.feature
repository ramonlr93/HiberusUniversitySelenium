@register
Feature: validate register test suite

  Background:
    Given the user is on the home page
    And the user clicks on my account button and the register option


  @testcase01
    @smoke
  Scenario: Verify user can register
    And the user provides the data for the form
      | Javier    |
      | Cuadrado |
      | jajaja@yopmail.com |
      | 666555444 |
      | Hola1234# |
      | Hola1234# |
    When the user clicks the register button
    Then the user is registered successfully


  @testcase02
  Scenario: Verify invalid registration
    And the user provides the incorrect data for the form
      | Javier    |
      | Cuadrado |
      | jajaja@yopmail.com |
      | 666555444 |
      | Hola1234# |
      | Hola1234# |
    When the user clicks the register button
    Then the user cannot registered