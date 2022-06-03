@login
Feature: Login test suite

  Background:
    Given the user is in the main page
    And the user goes to register

  @smoke
    @testcase-01
  Scenario Outline: Verify valid user can register
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail "<mail>"
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user is registered successfully

    Examples:
      | mail                | password  | firstname | lastname | phone     |
      | fiolinoq@gmail.com | Aketza123 | Aketza    | Garcia   | 609946055 |


  @testcase-02
  Scenario Outline: Verify invalid login
    And the user provides the mail "<mail>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user can see the error message

    Examples:
      | mail             | password  |
      | aketza@gmail.com | David2001 |

