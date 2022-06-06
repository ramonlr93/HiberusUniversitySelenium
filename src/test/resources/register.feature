@register
Feature: Register Test Cases

  Background:
    Given the user is on the home page
    And the user clicks on the my account button
    And the user clicks on the register option

  @pr-03
    @smoke
  Scenario Outline: Validate that the user can register correctly
    When the user introduces "<first name>" as first name
    And the user introduces "<last name>" as last name
    And the user introduces "<email>" as email
    And the user introduces <telephone> as telephone
    And the user introduces "<password>" as password
    And the user introduces "<password>" as confirm password
    And the user agree the privacy policy
    And the user clicks the continue button
    Then the user sees on the menu, on my account, all the logged in options
    Examples:
      | first name | last name  | email                      | telephone | password       |
      | Usuario    | Pruebas AM | usuariopruebasam001@qa.com | 666666666 | usuariopruebas |

  @pr-04
  Scenario Outline: Validate that the user can't register if leaves an mandatory field empty
    When the user introduces "<last name>" as last name
    And the user introduces "<email>" as email
    And the user introduces <telephone> as telephone
    And the user introduces "<password>" as password
    And the user introduces "<password>" as confirm password
    And the user agree the privacy policy
    And the user clicks the continue button
    Then the user sees an error message behind input that says "<error message>"
    Examples:
      | last name  | email                     | telephone | password       | error message                                   |
      | Pruebas AM | usuariopruebasam01@qa.com | 666666666 | usuariopruebas | First Name must be between 1 and 32 characters! |

  @pr-05
  Scenario Outline: Validate that the user can't register if leaves privacy policy unchecked
    When the user introduces "<first name>" as first name
    And the user introduces "<last name>" as last name
    And the user introduces "<email>" as email
    And the user introduces <telephone> as telephone
    And the user introduces "<password>" as password
    And the user introduces "<password>" as confirm password
    And the user clicks the continue button
    Then the user sees an error message that says "<error message>"
    Examples:
      | first name | last name  | email                     | telephone | password       | error message                                  |
      | Usuario    | Pruebas AM | usuariopruebasam01@qa.com | 666666666 | usuariopruebas | Warning: You must agree to the Privacy Policy! |

  @pr-06
  Scenario Outline: Validate that the user can't register if the email introduced already exist
    When the user introduces "<first name>" as first name
    And the user introduces "<last name>" as last name
    And the user introduces "<email>" as email
    And the user introduces <telephone> as telephone
    And the user introduces "<password>" as password
    And the user introduces "<password>" as confirm password
    And the user agree the privacy policy
    And the user clicks the continue button
    Then the user sees an error message that says "<error message>"
    Examples:
      | first name | last name  | email                   | telephone | password       | error message                                  |
      | Usuario    | Pruebas AM | usuariopruebasam@qa.com | 666666666 | usuariopruebas | Warning: E-Mail Address is already registered! |

  @pr-07
  Scenario Outline: Validate that the user can't register if the passwords doesn't coincide
    When the user introduces "<first name>" as first name
    And the user introduces "<last name>" as last name
    And the user introduces "<email>" as email
    And the user introduces <telephone> as telephone
    And the user introduces "<password>" as password
    And the user introduces "<password> error" as confirm password
    And the user agree the privacy policy
    And the user clicks the continue button
    Then the user sees an error message behind input that says "<error message>"
    Examples:
      | first name | last name  | email                   | telephone | password       | error message                                  |
      | Usuario    | Pruebas AM | usuariopruebasam@qa.com | 666666666 | usuariopruebas | Password confirmation does not match password! |