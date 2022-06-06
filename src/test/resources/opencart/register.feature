@register
Feature: Register test suite

  Background:
    Given the user is in the main page
    And the user goes to register

  @testcase-03
  Scenario Outline: Verify valid user can register
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user is registered successfully

    Examples:
      | password  | firstname | lastname | phone     |
      | Aketza123 | Aketza    | Garcia   | 609946055 |

  @testcase-04
    @invalid-register
  Scenario Outline: Verify invalid fistname message
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user can see the error "<message error>"

    Examples:
      | password  | lastname | phone     | message error                                   |
      | Aketza123 | Garcia   | 609946055 | First Name must be between 1 and 32 characters! |


  @testcase-05
    @invalid-register
  Scenario Outline: Verify invalid lastname message
    And the user provides the firstname "<firstname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user can see the error "<message error>"

    Examples:
      | password  | firstname | phone     | message error                                  |
      | Aketza123 | Aketza    | 609946055 | Last Name must be between 1 and 32 characters! |

  @testcase-06
    @invalid-register
  Scenario Outline: Verify invalid email message
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user can see the error "<message error>"

    Examples:
      | password  | firstname | lastname | phone     | message error                               |
      | Aketza123 | Aketza    | Garcia   | 609946055 | E-Mail Address does not appear to be valid! |

  @testcase-07
    @invalid-register
  Scenario Outline: Verify invalid phone message
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user can see the error "<message error>"

    Examples:
      | password  | firstname | lastname | message error                                  |
      | Aketza123 | Aketza    | Garcia   | Telephone must be between 3 and 32 characters! |

  @testcase-08
    @invalid-register
  Scenario Outline: Verify invalid password message
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user accept the policy check
    When the user clicks the register button
    Then the user can see the error "<message error>"

    Examples:
      | firstname | lastname | phone     | message error                                 |
      | Aketza    | Garcia   | 609946055 | Password must be between 4 and 20 characters! |

  @testcase-09
    @invalid-register
  Scenario Outline: Verify invalid confirm password message
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user accept the policy check
    When the user clicks the register button
    Then the user can see the error "<message error>"

    Examples:
      | password  | firstname | lastname | phone     | message error                                  |
      | Aketza123 | Aketza    | Garcia   | 609946055 | Password confirmation does not match password! |

  @testcase-10
    @invalid-register
  Scenario Outline: Verify policy privacy policy not checked message
    And the user provides the firstname "<firstname>"
    And the user provides the lastname "<lastname>"
    And the user provides the phone "<phone>"
    And the user provides the register mail
    And the user provides the register password "<password>"
    And the user provides the register password again "<password>"
    When the user clicks the register button
    Then the user can see the policy error "<message error>"

    Examples:
      | password  | firstname | lastname | phone     | message error                                  |
      | Aketza123 | Aketza    | Garcia   | 609946055 | Warning: You must agree to the Privacy Policy! |




