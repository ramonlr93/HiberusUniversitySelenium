@registration
Feature: Validate Registration test suite

  Background:
    Given the user is on the home page
    And the user selects -My Account-
    And the user selects -Register-
    And the user is on registration page


  @testcase01
    @smoke
  Scenario Outline: validate registration ok
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user has successfully registered and can see the congratulations message
    Examples:
      | firstName | lastName | email                          | telephone | password | passwordConfirm | suscribe | privacyPolicy |
      | prueba    | prueba   | prueba3214467580247@prueba.com | 600600600 | 1.Prueba | 1.Prueba        | No       | Yes           |


  @testcase02
  Scenario Outline: validate that an error message appears when leaving fields unfilled
    When the user clicks the continue button
    Then The user can see an error message about the privacy policy "<privacyPolicy>"first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" and password "<password>"

    Examples:
      | privacyPolicy | firstName | lastName   | email | telephone | password |
      | privacypolicy | firstname | secondname | email | telephone | password |


  @testcase03
  Scenario Outline: Validate that the user cannot register with a first name greater than 32 characters
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName                            | lastName | email                     | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | aaasssdddaaasssdddaaasssdddaaasssddd | prueba   | prueb6a8024788@prueba.com | 600600600 | 1.Prueba | 1.Prueba        | No       | Yes           | firstname |


  @testcase04
  Scenario Outline: Validate that the user cannot register with a last name greater than 32 characters
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName                             | email                     | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType  |
      | prueba    | aaasssdddaaasssdddaaasssdddaaasssddd | preueba8024788@prueba.com | 600600600 | 1.Prueba | 1.Prueba        | No       | Yes           | secondname |

  @testcase05
  Scenario Outline: Validate that the user cannot register with an invalid email
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email      | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | asdaqt@asd | 600600600 | 1.Prueba | 1.Prueba        | No       | Yes           | email     |

  @testcase06
  Scenario Outline: Validate that the user cannot register with a phone less than 3 digits
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                      | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | prueba877638763@prueba.com | 01        | 1.Prueba | 1.Prueba        | No       | Yes           | telephone |


  @testcase07
  Scenario Outline: Validate that the user cannot register with a phone number greater than 32 digits
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone                           | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | prueba87638763@prueba.com | 12345678901234567890123456789012345 | 1.Prueba | 1.Prueba        | No       | Yes           | telephone |


  @testcase08
  Scenario Outline: Validate that the user cannot register with a phone with invalid characters (no symbols)
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | prueba67668765@prueba.com | 123asd456 | 1.Prueba | 1.Prueba        | No       | Yes           | telephone |


  @testcase09
  Scenario Outline: Validate that the user cannot register with a phone with invalid characters (symbols)
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone  | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | prueba77632465@prueba.com | 123*+^^456 | 1.Prueba | 1.Prueba        | No       | Yes           | telephone |

  @testcase10
  Scenario Outline: Validate that the user cannot register with a password less than 4 characters
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | prueba87632165@prueba.com | 600600600 | as       | as              | No       | Yes           | password  |


  @testcase11
  Scenario Outline: Validate that the user cannot register with a password greater than 20 characters
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone | password                 | passwordConfirm          | suscribe | privacyPolicy | errorType |
      | prueba    | prueba   | prueba57636765@prueba.com | 600600600 | aaaaaaaaaaaaaaaaaaaaaaaa | aaaaaaaaaaaaaaaaaaaaaaaa | No       | Yes           | password  |


  @testcase12
  Scenario Outline: Validate that the user cannot register with a confirmation password different that password
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType       |
      | prueba    | prueba   | prueba84632165@prueba.com | 600600600 | 1.Prueba | prueba          | No       | Yes           | confirmpassword |


  @testcase13
  Scenario Outline: Validate that the user cannot register if he does not accept the privacy policy
    And the user complete the form with first name "<firstName>" last name "<lastName>" e-mail "<email>" telephone "<telephone>" password "<password>" and password confirm "<passwordConfirm>"
    And the user selects suscribe option "<suscribe>" and accepts check privacy policy "<privacyPolicy>"
    When the user clicks the continue button
    Then The user can see the error "<errorType>"
    Examples:
      | firstName | lastName | email                     | telephone | password | passwordConfirm | suscribe | privacyPolicy | errorType     |
      | prueba    | prueba   | prueba84632165@prueba.com | 600600600 | 1.Prueba | 1.Prueba        | No       | No            | privacypolicy |
