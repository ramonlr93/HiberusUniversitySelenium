@register
Feature: Register test suite

  Background:
    Given the user is on the home page
    And the user clicks the my account button
    And the user clicks the register link

  @testcase009
    @smoke
  Scenario Outline: Verify valid user can register
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user is registered successfully

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68100@falkyz.com | 600000000 | password123 | password123      |

  @testcase010
  Scenario Outline: Verify valid user can register subscribing to the newsletter
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the newsletter subscription box
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user is registered successfully

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68101@falkyz.com | 600000000 | password123 | password123      |

  @testcase011
  Scenario Outline: Verify that the user cannot register because the password confirmation does not match password
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to password confirmation error

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 600000000 | password123 | bad_password     |

  @testcase012
  Scenario Outline: Verify that the user cannot register because the email was already registered
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to email already registered error


    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68008@falkyz.com | 600000000 | password123 | bad_password     |

  @testcase013
  Scenario Outline: Verify that the user cannot register because the first name is missing
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to first name error

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      |            | Casado    | gonex68009@falkyz.com | 600000000 | password123 | password123      |

  @testcase014
  Scenario Outline: Verify that the user cannot register because the first name is over 32 characters
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to first name error

    Examples:
      | first_name                        | last_name | email                 | telephone | password    | password_confirm |
      | 123412341234123412341234123412345 | Casado    | gonex68009@falkyz.com | 600000000 | password123 | password123      |

  @testcase015
  Scenario Outline: Verify that the user cannot register because the last name is missing
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to last name error

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     |           | gonex68009@falkyz.com | 600000000 | password123 | password123      |

  @testcase016
  Scenario Outline: Verify that the user cannot register because the last name is over 32 characters
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to last name error

    Examples:
      | first_name | last_name                         | email                 | telephone | password    | password_confirm |
      | Miguel     | 123412341234123412341234123412345 | gonex68009@falkyz.com | 600000000 | password123 | password123      |

  @testcase017
  Scenario Outline: Verify that the user cannot register because the email is missing
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to email error

    Examples:
      | first_name | last_name | email | telephone | password    | password_confirm |
      | Miguel     | Casado    |       | 600000000 | password123 | password123      |

  @testcase018
  Scenario Outline: Verify that the user cannot register because the telephone is missing
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to telephone error

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com |           | password123 | password123      |

  @testcase019
  Scenario Outline: Verify that the user cannot register because the telephone is over 32 characters
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to telephone error

    Examples:
      | first_name | last_name | email                 | telephone                         | password    | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 123412341234123412341234123412345 | password123 | password123      |

  @testcase020
  Scenario Outline: Verify that the user cannot register because the telephone has less than 3 characters
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to telephone error

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 12        | password123 | password123      |

  @testcase021
  Scenario Outline: Verify that the user cannot register because the password is missing
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to password error

    Examples:
      | first_name | last_name | email                 | telephone | password | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 600000000 |          | password123      |

  @testcase022
  Scenario Outline: Verify that the user cannot register because the password is over 20 characters
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to password error

    Examples:
      | first_name | last_name | email                 | telephone | password              | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 600000000 | 123451234512345123456 | password123      |

  @testcase023
  Scenario Outline: Verify that the user cannot register because the password has less than 4 characters
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    And the user checks the privacy policy button
    When the user clicks the continue button
    Then the user should be shown an invalid message due to password error

    Examples:
      | first_name | last_name | email                 | telephone | password | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 600000000 | 123      | password123      |

  @testcase024
  Scenario Outline: Verify that the user cannot register because the privacy policy is not accepted
    And the user enter the first name "<first_name>"
    And the user enter the last name "<last_name>"
    And the user enter the email "<email>"
    And the user enter the telephone "<telephone>"
    And the user enter the password "<password>"
    And the user enter the password confirmation "<password_confirm>"
    When the user clicks the continue button
    Then the user should be shown an invalid message due to accept privacy policy error

    Examples:
      | first_name | last_name | email                 | telephone | password    | password_confirm |
      | Miguel     | Casado    | gonex68009@falkyz.com | 600000000 | password123 | password123      |