@checkout
Feature: Validate checkout test suite

  Background:
    Given the user is on the home page
    And the user adds items to the cart

  @testcase07
    @smoke
  Scenario Outline: validate checkout success
    And the user clicks on checkout button
    And the user provides the username "<email>" and password "<password>"
    And the user clicks the login button to checkout
    And the user selects add new data
    And the user fills the form
      | Javier     |
      | Cuadrado |
      | -  |
      | Plaza Mayor n3 5K    |
      |  - |
      | Medina del Campo       |
      | 47400      |
    And the user fills the form again
      | Javier     |
      | Cuadrado |
      |  - |
      | Plaza Mayor n3 5K    |
      |  - |
      | Medina del Campo       |
      | 47400      |
    When the user clicks continue on the methods and confirm the order
    Then the order is completed correctly and redirect to "<url>"
    Examples:
      | email | password |url|
      |   jajaja@yopmail.com    |    Hola1234#      | http://opencart.abstracta.us/index.php?route=checkout/success|

  @testcase08
  Scenario Outline: validate checkout success with saved data
    And the user clicks on checkout button
    And the user provides the username "<email>" and password "<password>"
    And the user clicks the login button to checkout
    When the user clicks on the continue buttons
    Then the order is completed correctly and redirect to "<url>"
    Examples:
      | email | password |url|
      |   jajaja@yopmail.com    |    Hola1234#      | http://opencart.abstracta.us/index.php?route=checkout/success|

  @testcase09
  Scenario Outline: validate checkout success as guest
    And the user clicks on checkout button
    And the user select made the checkout as guest
    And the user fills the form as guest
      | Javier     |
      | Cuadrado |
      | jejeje@yopmail.com  |
      | 555666434    |
      | -   |
      | Plaza Mayor n3 5K    |
      |  - |
      | Medina del Campo       |
      | 47400      |
    When the user finish the checkout as guest
    Then the order is completed correctly and redirect to "<url>"
    Examples:
      |url|
      | http://opencart.abstracta.us/index.php?route=checkout/success|
