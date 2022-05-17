Feature: checkout test suite 

  Background: 
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks the login button

  Scenario Outline: Verify final price on the Checkout of somes products
    When the user clicks random "addProductButton" 3 times
    And clicks on the cart
    And checkout the product
    And input the fields checkout
    And clicks on the continue button
    Then total price of the order (Item total) is the sum of the amount of the products selected in the inventory.

    Examples:
      | username     | password     | addProducButton         |
      | standar_user | secret_sauce | elementAddProductButton |
              
  Scenario Outline: Place  an order
    When the user clicks random "addProductButton"
    And clicks on the cart
    And checkout the product
    And input the fields checkout
    And clicks on the continue button
    And clicks on the checkout button
    Then verify that the order has been successfully completed by displaying the message Your order has been dispatched, and will arrive just as fast as the pony can get there!  

    Examples:
      | username      | password     | addProductButton |
      | standard_user | secret_sauce | Sauce Labs Bolt  |
    
      

  