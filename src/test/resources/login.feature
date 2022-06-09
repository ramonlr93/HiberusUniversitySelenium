@login
Feature: validate login page test suite

  Background: Navigate to the login page
    Given the user is on the login page

  @testcase04
  @smoke
  Scenario Outline: Verify user is succesfully logged
    And input email "<email>" in email field
    And input password "<password>" in password field
    When clics on Login button
    Then "<yourStore>" webpage is displayed
    Examples:
      | email                 | password      | yourStore                                                     |
      | ojmeneses@hiberus.com | encryptedPass | https://opencart.abstracta.us/index.php?route=account/account |