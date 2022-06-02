@cart
Feature: Cart Test Suite

Background:
  Given the user is on the home page

@removefromcart
Scenario Outline: Remove the item from cart
  And the user provides the username "<username>"
  And the user provides the password "<password>"
  And the clicks the login button
  And the user added 2 items to the cart
  And the user clicked the cart button
  When the user removes a product from the cart
  Then it shows that the product was removed

  Examples:
  | username      | password     |
  | standard_user | secret_sauce |