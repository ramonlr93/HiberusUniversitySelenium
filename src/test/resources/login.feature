@login
Feature: Login test suite

  Background:
    Given the user is on the home page
    And the user clicks the my account button
    And the user clicks the login link

  @testcase001
    @smoke
  Scenario Outline: Verify valid user can login
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | email                 | password |
      | gonex68008@falkyz.com | passwor |

  @testcase002
  Scenario Outline: Verify that the user cannot login due to invalid email
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown an invalid message

    Examples:
      | email     | password |
      | bad_email | password |

  @testcase003
  Scenario Outline: Verify that the user cannot login due to invalid password
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | email                 | password     |
      | gonex68008@falkyz.com | bad_password |

  @testcase004
  Scenario Outline: Verify that the user cannot login due to missing password
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown an invalid message

    Examples:
      | email                 | password |
      | gonex68008@falkyz.com |          |

  @testcase005
  Scenario Outline: Verify that the user cannot login due to missing email
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown an invalid message

    Examples:
      | email | password |
      |       | password |

  @testcase006
  Scenario Outline: Verify that the user cannot login due to missing email and password
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown an invalid message

    Examples:
      | email | password |
      |       |          |

  @testcase007
  Scenario Outline: Verify that the user has a maximum number (5) of login attempts
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    When the user clicks the login button multiple times
    Then the user should be shown an invalid message due to maximum number of login attempts

    Examples:
      | email                 | password |
      | gonex68008@falkyz.com |          |

  @testcase008
  Scenario Outline: Verify that the user can request a password reset
    And the user clicks the forgotten password link
    And the user enter the email "<email>" to request a password reset
    When the user clicks the continue button to request a password reset
    Then the user should be shown an email confirmation message

    Examples:
      | email                 |
      | gonex68008@falkyz.com |
