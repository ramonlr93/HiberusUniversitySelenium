Feature: Logout Test Suite

Background:
  Given the user is in the home page
  And the user provides the username "username"
  And the user provides the password "password"
  And the user clicks the login button
  And the user is in the page www.saucedemo.com/inventory.html

Scenario Outline: Verify a valid user can log out
  When the user clicks the logout button
  Then the user should have logged out and be in the log in page

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |