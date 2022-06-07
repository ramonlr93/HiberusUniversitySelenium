@login
Feature: Register test suite

  Background:
    Given the user is on the login page

  @testcase07
    @smoke
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | email                  | password   |
      | ksanabriad@yopmail.com | katherinQA |

  @testcase08
  Scenario Outline: Verify valid user cannot login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown an invalid message "login failed"

    Examples:
      | email                  | password |
      | ksanabriad@yopmail.com | katherin |

  @testcase09
  Scenario Outline: Verify that the user can recover password
    And the user provides the email "<email>"
    And the user clicks the "Forgotten Password" link
    And the user provides the email "<email>"
    When the user clicks the continue button to recover the password
    Then the user should be shown the message "An email with a confirmation link has been sent your email address."

    Examples:
      | email                  | password |
      | ksanabriad@yopmail.com | katherin |