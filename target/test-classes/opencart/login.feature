@login
Feature: Login test suite


  @smoke
    @testcase-01
  Scenario Outline: Verify valid user can login
    Given the user is in the main page
    And the user goes to login
    And the user provides the mail "<mail>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

    Examples:
      | mail                 | password  |
      | herceclase@gmail.com | David2001 |

  @testcase-02
  Scenario Outline: Verify invalid login
    Given the user is in the main page
    And the user goes to login
    And the user provides the mail "<mail>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user can see the error message

    Examples:
      | mail                 | password  |
      | aketza@gmail.com | David2001 |

