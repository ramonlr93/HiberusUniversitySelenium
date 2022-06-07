@register
Feature: Register test suite

  Background:
    Given the user navigates to the register page
    And the user is in the register page

    @register01
    Scenario: The user can see all elements.
      Then the user can see the input FirstName
      And the user can see the input LastName
      And the user can see the input E-Mail
      And the user can see the input Telephone
      And the user can see the input Password
      And the user can see the input Password Confirm
      And the user can see the div Subscribe
      And the user can see the div PrivacyPolicy
      And the user can see the button Continue

  @register02
  Scenario: The user can sign in.
    And the user write in the input FirstName "firstName"
    And the user write in the input LastName "lastName"
    And the user write in the input E-Mail
    And the user write in the input Telephone "Telephone"
    And the user write in the input Password "Password"
    And the user write in the input Password Confirm "Password"
    And the user click in the div PrivacyPolicy
    When the user click the button Continue
    Then the user is in the register success

  @register03
  Scenario: Validate that all error messages appear
    And the user write in the input FirstName ""
    And the user write in the input LastName ""
    And the user write in the input E-Mail ""
    And the user write in the input Telephone ""
    And the user write in the input Password ""
    And the user write in the input Password Confirm "h"
    When the user click the button Continue
    Then the user can see 6 the error messages

  @register03
  Scenario: Validate that all error messages appear
    And the user write in the input FirstName ""
    And the user write in the input LastName ""
    And the user write in the input E-Mail ""
    And the user write in the input Telephone ""
    And the user write in the input Password ""
    And the user write in the input Password Confirm "h"
    When the user click the button Continue
    Then the user can see 6 the error messages

  @register04
  Scenario: Validate that the warning messages of Privacy Policy appear
    When the user click the button Continue
    Then the user can see the warning messages of "Privacy Policy" appear

  @register05
  Scenario: Validate that the warning messages of E-Mail Address appear
    And the user click in the div PrivacyPolicy
    And the user write in the input E-Mail "ejemplo@ejemplo.es"
    When the user click the button Continue
    Then the user can see the warning messages of "E-Mail Address" appear

  @register06
  Scenario: Validate that the user can navigate to the login screen from the link
    When the user click the login page link
    Then the user is in the login page