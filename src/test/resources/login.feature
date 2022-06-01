@login
Feature: Login test suite

  Background:
    Given the user is on the home page

    @loginok #Lanzaría el test con los dos examples
  Scenario Outline: Verify valid user can login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user is logged successfully

      @testexample1 #Si lanzamos este, se lanzará el scenario con este example
      Examples:
        | username      | password     |
        | standard_user | secret_sauce |

      @testexample2
      Examples:
        | username        | password     |
        | locked_out_user | secret_sauce |

      @loginko
  Scenario Outline: Verify valid user cannot login
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user should be shown and invalid message

    Examples:
      | username   | password      |
      | bad_user   | secret_sauce  |