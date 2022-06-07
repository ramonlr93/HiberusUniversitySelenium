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
  Scenario Outline: Account with invalid first name is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "First Name" error message shows "<message>"
    Examples:
      | first_name                        | last_name | email           | phone     | password | message                                         |
      |                                   | ruiz      | marco2@mail.com | 355154895 | 1311     | First Name must be between 1 and 32 characters! |
      | a_very_long_and_useless_user_name | ruiz      | marco2@mail.com | 355154895 | 1311     | First Name must be between 1 and 32 characters! |


  @OC-5
  Scenario Outline: Account with invalid last name is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Last Name" error message shows "<message>"
    Examples:
      | first_name | last_name                         | email           | phone     | password | message                                        |
      | marco      |                                   | marco2@mail.com | 355154895 | 1311     | Last Name must be between 1 and 32 characters! |
      | marco      | a_very_long_and_useless_last_name | marco2@mail.com | 355154895 | 1311     | Last Name must be between 1 and 32 characters! |

  @OC-6
  Scenario Outline: Account with invalid email is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "E-Mail" error message shows "<message>"
    Examples:
      | first_name | last_name | email          | phone     | password | message                                     |
      | marco      | ruiz      |                | 355154895 | 1311     | E-Mail Address does not appear to be valid! |
      | marco      | ruiz      | marco2mail.com | 355154895 | 1311     | E-Mail Address does not appear to be valid! |

  @OC-7
  Scenario Outline: Account with repeated email is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the alert message shows up
    Examples:
      | first_name | last_name | email           | phone     | password |
      | marco      | ruiz      | marco2@mail.com | 355154895 | 1311     |


  @OC-8
  Scenario Outline: Account with invalid password is not created
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Password " error message shows "<message>"
    Examples:
      | first_name | last_name | email           | phone     | password | message                                       |
      | marco      | ruiz      | marco2@mail.com | 355154895 | 1311     | Password must be between 4 and 20 characters! |

  @OC-9
  Scenario Outline: Create account with invalid email
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the error message is shown
    Examples:
      | first_name | last_name | email           | phone     | password | password |
      | marco      | ruiz      | marco2@mail.com | 355154895 | 1311     | 1311     |

  @OC-10
  Scenario Outline: Create account with invalide telephone
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Password " error message shows "<message>"
    Examples:
      | first_name | last_name | email           | phone                             | password | message                                        |
      | marco      | ruiz      | marco2@mail.com | 22                                | 1311     | Telephone must be between 3 and 32 characters! |
      | marco      | ruiz      | marco2@mail.com | 123251568792856215623687987845321 | 1311     | Telephone must be between 3 and 32 characters! |
