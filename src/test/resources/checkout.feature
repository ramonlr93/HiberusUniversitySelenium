@checkout
Feature: Checkout test suite

  Background:
    Given the user go to the home page
    And the user go to the login page

  @testcase8
  Scenario Outline: Verify valid user can checkout correctly for two method payment
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user go to the home page
    And the user add product to cart
      | MacBook |
      | iPhone  |
    And the user go to the cart page
    And the user click checkout button
    And the user choose the billing details and click continue
      | Flor          |
      | QA            |
      | Calle QA n970 |
      | Pueblo        |
      | 25555         |
      | Spain         |
      | Malaga        |
    And the user choose the delibery details and click continue
    And the user choose the delibery method, add comments and click continue
    And the user choose the payment "<payment>" method, checked checkbox and click continue
    When the user clicks the confirm order
    Then the order has been completed successfully and the message has been displayed

    Examples:
      | email               | password | payment  |
      | flor.qa@yopmail.com | 123456   | Transfer |
      | flor.qa@yopmail.com | 123456   | Cash     |
