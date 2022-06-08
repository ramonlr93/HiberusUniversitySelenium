@Cart
Feature: Validate cart test suite

  Background: Navigate to the home page
    Given the user is on the login page


  @testcase14
  Scenario Outline: The user is in the checkout page
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the laptops inventory
    And the user add <number> random laptops
    And the user see a success message
    And the user clicks the shopping cart icon
    And clicks the view cart link
    When the user clicks the checkout button
    Then The user is in the checkout page
    Examples:
      | email                  | password   | number |
      | ksanabriad@yopmail.com | katherinQA | 1      |