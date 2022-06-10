@login
Feature: Login test suite

  Background:
    Given the user navigates to the login page
    And the user is in the login page

  @login01
  Scenario: The user can see all elements.
    Then the user can see the E-Mail login input
    And the user can see the Password login input
    And the user can see the ForgottenPassword link
    And the user can see the Login button
    And the user can see the ContinueRegister button

  @login02
  @smoke
  Scenario: The user can login.
    And the user write in the E-Mail "ejemplo@ejemplo.es" login input
    And the user write in the Password "hola" login input
    When the user click in the link Login button
    Then the user is in the MyAccount page

  @login03
  Scenario: Validate that the user can navigate to the Forgotten Password page from the link
    When the user click in the Forgotten Password link
    Then the user is in the Forgotten Password page

  @login04
  Scenario: The user can login.
    When the user click in the link Login button
    Then the user can see the warning messages appear
