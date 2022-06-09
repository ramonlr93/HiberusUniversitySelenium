@login
Feature: Login Test Suite

  Background: Navigate to the login page
  Given the user is in the home page
  And the user clicks to go to the login page
  And the user is in the login page

    @loginok
    @smoke
    Scenario Outline: Verify a valid user can login
      And the user provides the username "<email>"
      And the user provides the password "<password>"
      When the user clicks the login button
      Then the user log in succesfully

      Examples:
        |         email           | password     |
        | robertoch1985@gmail.com | 12345       |

      @loginko
    Scenario Outline: Verify a no valid user cant login
      And the user provides the username "<email>"
      And the user provides the password "<password>"
      When the user clicks the login button
      Then the user cant login

      Examples:
        |         email           | password     |
        | robertoch1985@gmail.com | 55555        |