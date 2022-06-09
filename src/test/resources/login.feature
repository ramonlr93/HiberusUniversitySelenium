@login
Feature: Login test suite

  Background:
    Given the user is in the landing page
    And the user clicks the login button


  @smoke
    @testcase-1
  Scenario Outline: Verify valid user can login
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the user is logged

    Examples:
      | mail                 | password  |
      | manape79@hotmail.com | Manape195 |

  
  @testcase-2
  Scenario Outline: Verify invalid mail
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail                | password  |
      | manape7@hotmail.com | Manape195 |

  @testcase-3
  Scenario Outline: Verify invalid password
    And the user fills the mail "<mail>"
    And the user fills the password "<password>"
    When the user clicks on login button
    Then the error message is shown

    Examples:
      | mail                 | password |
      | manape79@hotmail.com | Manape19 |
