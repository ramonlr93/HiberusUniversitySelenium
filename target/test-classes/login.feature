@login
Feature: login test suite

  Background:
    Given the user is in the login page

  @uservalidlogin
    @smoke
  Scenario Outline: the user logs into the page
    And the user introduces his email "<email>" and password "<password>"
    When the user click the login button
    Then the user login successfully and is redirected to his account "<urlaccount>"

    Examples:
      | email               | password | urlaccount                                                    |
      | rbttm1999@gmail.com | 123abc   | https://opencart.abstracta.us/index.php?route=account/account |

  @userinvalidlogin
    @smoke
  Scenario Outline: the user failed to log into the page
    And the user introduces his email "<email>" and password "<password>"
    When the user click the login button
    Then the user cant log in and is redirected to the login page "<urlloginpage>" and shown a message

    Examples:
      | email           | password | urlloginpage                                                |
      | r1999@gmail.com | 123abc   | https://opencart.abstracta.us/index.php?route=account/login |

  @userredirectfromlogintoregister
  Scenario Outline: the user is redirected to the register from te login
    When the user click in the button to create a new account
    Then the user is redirected to the page of registration "<urlregister>"

    Examples:
      | urlregister                                                    |
      | https://opencart.abstracta.us/index.php?route=account/register |

  @userredirectfromlogintoregistermenu
  Scenario Outline: the user is redirected to the register from te login using the lateral menu
    When the user click in the section register in the menu
    Then the user is redirected to the page of registration "<urlregister>"

    Examples:
      | urlregister                                                    |
      | https://opencart.abstracta.us/index.php?route=account/register |


  @userredirectfromforgottenpassword
  Scenario Outline: the user is redirected to the password recovery page using the section under the login
    When the user click in the section forgotten password under the login
    Then the user is redirected to the page of password recovery "<urlforgottenpassword>"

    Examples:
      | urlforgottenpassword                                            |
      | https://opencart.abstracta.us/index.php?route=account/forgotten |