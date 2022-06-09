@register_test_suite
Feature: validate register in OpenCart

  Background: Navigate to the register page
    Given the user is on the register page

  @OC-3
  Scenario Outline: Verify valid user can register
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the user account is created
    Examples:
      | first_name | last_name | phone     | password |
      | mario      | ruiz      | 355154895 | 1311     |

  @OC-4
  Scenario Outline: Creating an account with invalid length first name is not allowed
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "First Name" error message shows "<message>"
    Examples:
      | first_name                        | last_name | phone     | password | message                                         |
      |                                   | ruiz      | 355154895 | 1311     | First Name must be between 1 and 32 characters! |
      | a_very_long_and_useless_user_name | ruiz      | 355154895 | 1311     | First Name must be between 1 and 32 characters! |


  @OC-5
  Scenario Outline: Creating an account with invalid lenght last name is not allowed
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Last Name" error message shows "<message>"
    Examples:
      | first_name | last_name                         | phone     | password | message                                        |
      | mario      |                                   | 355154895 | 1311     | Last Name must be between 1 and 32 characters! |
      | mario      | a_very_long_and_useless_last_name | 355154895 | 1311     | Last Name must be between 1 and 32 characters! |


  @OC-6
  Scenario Outline: Creating an account with empty email is not allowed
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "E-Mail" error message shows "<message>"
    Examples:
      | first_name | last_name | email         | phone     | password | message                                     |
      | mario      | ruiz      |               | 355154895 | 1311     | E-Mail Address does not appear to be valid! |
      | mario      | ruiz      | mariomail.com | 355154895 | 1311     | E-Mail Address does not appear to be valid! |

#  @OC-11
#  Scenario Outline: Creating an account with invalid email is not allowed
#    And the user enters the name "<first_name>"
#    And the user enters the last name "<last_name>"
#    And the user enters the email "<email>"
#    And the user enters the phone number "<phone>"
#    And the user enters the password "<password>"
#    And the user enter the confirm password "<password>"
#    And the user accepts privacy policy
#    When the user clicks the continue button
#    Then the "E-Mail" error message shows "<message>"
#    Examples:
#      | first_name | last_name | email         | phone     | password | message                                     |
#


  @OC-7
  Scenario Outline: Creating an account with already used email is not allowed
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the alert message telling that there's already an account with that email shows up
    Examples:
      | first_name | last_name | email          | phone     | password |
      | mario      | ruiz      | mario@mail.com | 355154895 | 1311     |


  @OC-8
  Scenario Outline: Creating an account with invalid length password is not allowed
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Password" error message shows "<message>"
    Examples:
      | first_name | last_name | phone     | password                | message                                       |
      | mario      | ruiz      | 355154895 | 13                      | Password must be between 4 and 20 characters! |
      | mario      | ruiz      | 355154895 | my_password_way_to_long | Password must be between 4 and 20 characters! |

  @OC-9
  Scenario Outline: Creating an account with different passwords is not allowed
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<different_password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Password" error message shows "<message>"
    Examples:
      | first_name | last_name | phone     | password | different_password | message                                        |
      | mario      | ruiz      | 355154895 | 1311     | 1312               | Password confirmation does not match password! |

  @OC-10
  Scenario Outline: Creating an account with invalid length telephone
    And the user enters the name "<first_name>"
    And the user enters the last name "<last_name>"
    And the user enters the email
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    And the user enter the confirm password "<password>"
    And the user accepts privacy policy
    When the user clicks the continue button
    Then the "Telephone" error message shows "<message>"
    Examples:
      | first_name | last_name | phone                             | password | message                                        |
      | mario      | ruiz      | 22                                | 1311     | Telephone must be between 3 and 32 characters! |
      | mario      | ruiz      | 123251568792856215623687987845321 | 1311     | Telephone must be between 3 and 32 characters! |

