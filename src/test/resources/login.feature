Feature: Login test suite

    Background: Navigate to the home page
      Given the user is on the home page

    Scenario Outline: Verify valid user can login
      And the user provides the username "<username>" and password "<password>"
      When the user clicks the login button
      Then the user is logged successfully and is into the inventory page
      Examples:
       | username      | password     |
       | standard_user | secret_sauce |

    Scenario Outline: Verify invalid user cannot login
      And the user provides the username "<username>" and password "<password>"
      When the user clicks the login button
      Then The user should be shown an invalid message
      Examples:
       | username | password     |
       | bad_user | secret_sauce |