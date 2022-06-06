@register
Feature: validate login in OpenCart

  Background: Navigate to the register
    Given the user is on the register page

  @OC-3
  Scenario Outline: Verify valid user can login
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    When the user clicks the continue button
    Then the user is logged successfully
    Examples:
      | first_name | last_name | email          | phone     | password |
      | marco      | ruiz      | marco@mail.com | 384521548 | 1311     |

  @OC-4
  Scenario Outline: Verify invalid user canot login
    And the user enters the "<email>" and "<password>"
    When the user clicks the login button
    Then the error message is shown
    Examples:
      | email          | password |
      | mario@mail.com | 1311     |
