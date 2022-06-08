@inventory
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the login page

  @testcase10
  Scenario Outline: validate inventory list size
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the laptops inventory
    Then the user see the inventory list with 5 items
    Examples:
      | email                  | password   |
      | ksanabriad@yopmail.com | katherinQA |

  @testcase11
  Scenario Outline: validate exist "<laptop>" in inventory list
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the laptops inventory
    Then the user see the "<laptopName>" in the inventory list
    Examples:
      | email                  | password   | laptopName |
      | ksanabriad@yopmail.com | katherinQA | Sony VAIO  |

  @testcase12
  Scenario Outline: Add a random laptop in the shopping cart
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the laptops inventory
    When the user add <number> random laptops
    Then the user see a success message
    Examples:
      | email                  | password   | number |
      | ksanabriad@yopmail.com | katherinQA | 1      |