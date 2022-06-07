@register
Feature: Register Test Suite

  Background: Navigate to the register page
  Given the user is in the register page

  @registerok
  @smoke
  Scenario Outline: Verify an user can register in the page
  And the user provides the first name "<firstname>"
  And the user provides the last name "<lastname>"
  And the user provides the email "<email>"
  And the user provides the telephone "<telephone>"
  And the user provides the password for registration "<password>"
  And the user provides the confirmation "<passwordconfirm>"
  And the user clicks the privacy policy button
  When the user clicks the register button
  Then the user registers succesfully

  Examples:
    | firstname | lastname | email              | telephone | password | passwordconfirm |
    | Pepe      | Lopez    | pepe99999@correo.es | 599511    | 55555    | 55555           |


  @testcase01
  Scenario Outline: Verify an user cant register if he does not accept the privacy policy
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    When the user clicks the register button
    Then an error message saying you must accept the Privacy Policy is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      | Pepe      | Lopez    | pepe99999@correo.es | 599511    | 55555    | 55555           |

  @testcase02
  Scenario Outline: Verify an user cant register without a first name
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    And the user clicks the privacy policy button
    When the user clicks the register button
    Then an error message is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      |           | Lopez    | pepe99999@correo.es | 599511    | 55555    | 55555           |


  @testcase03
  Scenario Outline: Verify an user cant register without a last name
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    And the user clicks the privacy policy button
    When the user clicks the register button
    Then an error message is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      | Pepe      |          | pepe99999@correo.es | 599511    | 55555    | 55555           |


  @testcase04
  Scenario Outline: Verify an user cant register without an email
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    And the user clicks the privacy policy button
    When the user clicks the register button
    Then an error message is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      | Pepe      |  Lopez   |                    | 599511    | 55555    | 55555           |

  @testcase05
  Scenario Outline: Verify an user cant register without a telephone
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    And the user clicks the privacy policy button
    When the user clicks the register button
    Then an error message is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      | Pepe      | Lopez    | pepe99999@correo.es |           | 55555    | 55555           |

  @testcase06
  Scenario Outline: Verify an user cant register without a password
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    And the user clicks the privacy policy button
    When the user clicks the register button
    Then an error message is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      | Pepe      | Lopez    | pepe99999@correo.es | 599511    |          | 55555           |


  @testcase07
  Scenario Outline: Verify an user cant register if both password do not match
    And the user provides the first name "<firstname>"
    And the user provides the last name "<lastname>"
    And the user provides the email "<email>"
    And the user provides the telephone "<telephone>"
    And the user provides the password for registration "<password>"
    And the user provides the confirmation "<passwordconfirm>"
    And the user clicks the privacy policy button
    When the user clicks the register button
    Then an error message is shown

    Examples:
      | firstname | lastname | email              | telephone | password | passwordconfirm |
      | Pepe      | Lopez    | pepe99999@correo.es | 599511    | 55555    | 666666          |