Feature: Login Test Suite

Background:
  Given the user is in the home page
  And the user provides the username "username"
  And the user provides the password "password"
  When the clicks the login button

Scenario Outline: Verify valid user can login
  Then the user logged in succesfully

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |

Scenario Outline: Verify invalid user cant login
  Then a message error should be shown

  Examples:
  | username   | password     |
  | bad_user   | secret_sauce |