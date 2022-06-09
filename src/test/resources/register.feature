@register
Feature: register test suite

  Background:
    Given the user is on the register page

  @userregister
    @smoke
  Scenario Outline: the user registers into the page
    And the user introduces his name "<name>", last name "<lastname>", a random email "<email>", telephone "<telephone>" and password "<password>"
    And the user check the privacy policy checkbox
    When the user click the button continue
    Then the user will get redirected to page "<urlpagesuccessful>" that will indicate to the user that he has register correctly

    Examples:
      | name    | lastname | email          | telephone | password | urlpagesuccessful                                            |
      | Roberto | Teresa   | TEST@gmail.com | 12345678  | 123abc   | http://opencart.abstracta.us/index.php?route=account/success |

  @userregisterinvalidemail
    @smoke
  Scenario Outline: the user registers into the page with already used email
    And the user introduces his name "<name>", last name "<lastname>", email "<email>", telephone "<telephone>" and password "<password>"
    And the user check the privacy policy checkbox
    When the user click the button continue
    Then the page shows a error message

    Examples:
      | name    | lastname | email               | telephone | password |
      | Roberto | Teresa   | rbttm1999@gmail.com | 12345678  | 123abc   |

  @userregisteremptymandatoryfield
  Scenario Outline: the user cant register because he left the email field empty
    And the user introduces his name "<name>", last name "<lastname>", telephone "<telephone>" and password "<password>"
    And the user check the privacy policy checkbox
    When the user click the button continue
    Then the page shows a error message showing the field is empty and the user still is in the registration page "<urlpage>"

    Examples:
      | name    | lastname | telephone | password | urlpage                                                        |
      | Roberto | Teresa   | 12345678  | 123abc   | https://opencart.abstracta.us/index.php?route=account/register |


  @userregisternocheckprivacypolicy
  Scenario Outline: the user cant register because he left the privacy policy uncheck
    And the user introduces his name "<name>", last name "<lastname>", email "<email>", telephone "<telephone>" and password "<password>"
    When the user click the button continue
    Then the page shows a error message showing privacy policy is not checked and the user still is in the registration page "<urlpage>"

    Examples:
      | name    | lastname | email           | telephone | password | urlpage                                                        |
      | Roberto | Teresa   | TEST1@gmail.com | 12345678  | 123abc   | https://opencart.abstracta.us/index.php?route=account/register |