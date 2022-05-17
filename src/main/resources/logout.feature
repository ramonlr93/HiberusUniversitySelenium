Feature: Logout suite

  Background:
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks on login button
    And add two random products to cart

  @testcase13
  Scenario Outline: Verify valid user can logout

    When the user click on logout button
    Then the login page is shown

    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |