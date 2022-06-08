@login
Feature: Login Test Cases

  Background:
    Given the user is on the home page
    And the user clicks on the my account button
    And the user clicks on the login option

  @pr-01
  @smoke
  Scenario: Validate that the user can login correctly
    When the user introduces "usuariopruebasam@qa.com" as email
    And the user introduces "usuariopruebas" as password
    And the user clicks the login button
    Then the user sees on the menu, on my account, all the logged in options

  @pr-02
  Scenario: Validate that the page show an error message if the user does a login with incorrect credentials
    When the user introduces "bademailam@qa.com" as email
    And the user introduces "badpassword" as password
    And the user clicks the login button
    Then the user sees an error message that says "Warning: No match for E-Mail Address and/or Password."