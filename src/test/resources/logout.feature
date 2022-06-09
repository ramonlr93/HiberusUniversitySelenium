@logout
Feature: Validate Logout test suite

  @testcase34
    @smoke
  Scenario Outline: validate logout ok
    Given the user is on the home page
    And the user selects -My Account-
    And the user selects -Login-
    And the user is on login page
    And the user complete the login form with email "<email>" and password "<password>"
    And the user clicks login button
#    And The user can see -My account- page
    And the user selects -My Account-
    When the user clicks logout button
    Then the user is on logout page

    Examples:
      | email                 | password  |
      | cfradejas94@gmail.com | 1.Hiberus |