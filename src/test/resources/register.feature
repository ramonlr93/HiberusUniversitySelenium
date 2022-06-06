@register
Feature: validate login in OpenCart

  Background: Navigate to the register
    Given the user is on the register page

  @OC-3
  Scenario Outline: Verify valid user can register
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the user account is created
    Examples:
      | first_name | last_name | email           | phone     | password |
      | marco      | ruiz      | marco2@mail.com | 355154895 | 1311     |

  @OC-4
  Scenario Outline: Account without first_name is not created
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the user account is not created
    Examples:
      | last_name | email           | phone     | password |
      | ruiz      | marco2@mail.com | 384521548 | 1311     |

  @OC-5
  Scenario Outline: Account without last_name is not created
    And the user enters the name "<first_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the user account is not created
    Examples:
      | first_name | email           | phone     | password |
      | marco      | marco2@mail.com | 384521548 | 1311     |

  @OC-6
  Scenario Outline: Account without email is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the user account is not created
    Examples:
      | first_name | last_name | phone     | password |
      | marco      | ruiz      | 384521548 | 1311     |

  @OC-7
  Scenario Outline: Account without password is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the user account is not created
    Examples:
      | first_name | last_name | email           | phone     |
      | marco      | ruiz      | marco2@mail.com | 384521548 |
