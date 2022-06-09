@register
Feature: validate register page test suite

  Background: Navigate to the register page
    Given the user is on the register page

  @testcase03
  Scenario Outline: Verify user is succesfully registered
    And input First Name "<firstName>"
    And input Last Name "<lastName>"
    And input email "<email>"
    And input telephone number "<phoneNumber>"
    And input password "<password>"
    And input confirm "<confirmPassword>"
    And checks checkbox
    When clics on Continue button
    Then "<successRegistration>" webpage is displayed
    Examples:
      | firstName | lastName   | email                 | phoneNumber | password      | confirmPassword | successRegistration                                          |
      | Octavio   | miApellido | ojmeneses@hiberus.com | 666555666   | encryptedPass | encryptedPass   | http://opencart.abstracta.us/index.php?route=account/success |