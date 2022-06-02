@checkout
Feature: Validate checkout test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase12
  @smoke
  Scenario Outline: validate product price in checkout
    And the user provides the username "<username>" and password "<password>"
    And the user clicks the login button
    And the user selects
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
    And the user clicks on the shopping cart
    And the user clicks checkout
    And the user provides the first name as "Jonatan" and last name as "Villen" and zip code as "50014"
    When the user clicks continue
    Then the user validates prices in checkout summary
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |