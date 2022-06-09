@register
Feature: validate registration test suite

  Background: Navigate to the Home page
    Given the user is on the home page

  @testcase01 @smoke
  Scenario Outline: Verify that the user can register successfully
    And the user access to MyAccountNavBarButton and access to RegisterMenu
    And the user is on the register page
    And the user provides new Personal Details "<firstname>", "<lastname>", "<email>" and "<telephone>"
    And the user provides and confirm the password "<password>", "<passwordConfirm>"
    And the user clicks the Privacy Policy checkButton
    When the user clicks the Continue button
    Then the user register successfully
     Examples:
      | firstname | lastname | telephone |     email    |   password   | passwordConfirm |
      |    Jack   |  Sparrow | 123456789 | @yopmail.com | hiberusfinal |   hiberusfinal  |

  @testcase02
  Scenario Outline: Verify that user cannot register because do not agree the privacy policy
    And the user access to MyAccountNavBarButton and access to RegisterMenu
    And the user is on the register page
    And the user provides new Personal Details "<firstname>", "<lastname>", "<email>" and "<telephone>"
    And the user provides and confirm the password "<password>", "<passwordConfirm>"
    When the user clicks the Continue button
    Then The user should be shown a Privacy Policy warning message
     Examples:
      | firstname | lastname | telephone |     email    |   password   | passwordConfirm |
      |    Jack   |  Sparrow | 123456789 | @yopmail.com | hiberusfinal |   hiberusfinal  |

  @testcase03
  Scenario Outline: Verify that the user cannot register because the user already exits
    And the user access to MyAccountNavBarButton and access to RegisterMenu
    And the user is on the register page
    And the user provides Personal Details "<firstname>", "<lastname>", "<email>" and "<telephone>"
    And the user provides and confirm the password "<password>", "<passwordConfirm>"
    And the user clicks the Privacy Policy checkButton
    When the user clicks the Continue button
    Then The user should be shown a Email Address is already registered warning message
     Examples:
      | firstname | lastname | telephone |             email              |   password   | passwordConfirm |
      |    Jack   |  Sparrow | 123456789 | nubrokakattoi-8879@yopmail.com | hiberusfinal |   hiberusfinal  |

  @testcase04
  Scenario: Verify that the user cannot register because the required fields were not filled out
    And the user access to MyAccountNavBarButton and access to RegisterMenu
    And the user is on the register page
    When the user clicks the Continue button
    Then The user should be shown all mandatory warnings messages

