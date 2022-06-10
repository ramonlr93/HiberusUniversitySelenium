@register
Feature: Register test suite

  Background:
    Given the user navigates to the register page
    And the user is in the register page

    @register01
    Scenario: The user can see all elements.
      Then the user can see the FirstName input
      And the user can see the LastName input
      And the user can see the E-Mail input
      And the user can see the Telephone input
      And the user can see the Password input
      And the user can see the Password Confirm input
      And the user can see the Subscribe div
      And the user can see the PrivacyPolicy div
      And the user can see the Continue button

  @register02
  @smoke
  Scenario: The user can sign in.
    And the user write in the FirstName "firstName" input
    And the user write in the LastName "lastName" input
    And the user write in the E-Mail input
    And the user write in the Telephone "Telephone" input
    And the user write in the Password "Password" input
    And the user write in the Password Confirm "Password" input
    And the user click in the PrivacyPolicy div
    When the user click the Continue button
    Then the user is in the register success

  @register03
  @smoke
  Scenario: Validate that all error messages appear
    And the user write in the FirstName "" input
    And the user write in the LastName "" input
    And the user write in the E-Mail "" input
    And the user write in the Telephone "" input
    And the user write in the Password "" input
    And the user write in the Password Confirm "h" input
    When the user click the Continue button
    Then the user can see 6 the error messages

  @register04
  Scenario: Validate that the warning messages of Privacy Policy appear
    When the user click the Continue button
    Then the user can see the warning messages of "Privacy Policy" appear

  @register05
  Scenario: Validate that the warning messages of E-Mail Address appear
    And the user click in the PrivacyPolicy div
    And the user write in the E-Mail "ejemplo@ejemplo.es" input
    When the user click the Continue button
    Then the user can see the warning messages of "E-Mail Address" appear

  @register06
  Scenario: Validate that the user can navigate to the login screen from the link
    When the user click the login page link
    Then the user is in the login page