Feature: Logout

  Background:
    Given the user is on the home page

  Scenario Outline: Verify valid user can login and can logout
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user logout successfully

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |



