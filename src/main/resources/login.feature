Feature: Login test suite

   Background: Navigate to the home page
     Given the user is on the home page

@testcase1
Scenario Outline: Verify valid user can login
  And the user provides the suername "username" and password "paswword"
  When the user cicks the login button
  Then the user is logged successfully and is into the inventory page

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |

@testcase2
Scenario Outline: Verify invalid user cannot login
    Then the user should be shown and invalid message