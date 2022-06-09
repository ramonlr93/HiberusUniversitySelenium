@checkout
Feature: Validate checkout test suite

  @testcase14
  Scenario Outline: The user have a success order
    Given the user is on the login page
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the laptops inventory
    And the user add <number> random laptops
    And the user see a success message
    And the user clicks the shopping cart icon
    And the user clicks the checkout link
    And The user is in the checkout page
    And the user clicks the billing continue button
    And the user clicks the delivery details continue button
    And the user clicks the delivery method continue button
    And the user clicks Agree terms
    And the user clicks the payment continue button
    When the user clicks the confirm order button
    Then the user should be shown a success order message

    Examples:
      | email                  | password   | number |
      | ksanabriad@yopmail.com | katherinQA | 1      |