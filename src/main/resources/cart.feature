Feature: Cart test suite

  Background: 
    Given the user is on the home page
    And the user provides the username "username"
    And the user provides the password "password"
    And the user clicks the login button

  Scenario Outline: delete product from the cart
    When the user clicks random "productButton" 2 times
    And clicks on the cart
    And clicks on a product "removeButton"
    Then the cart has no that "productName" product into the cart

    Examples:
      | username     | password     | producButton     | removeButton | productName             |
      | standar_user | secret_sauce | elementAddButton | removeButton | Sauce Labs Bolt T-Shirt |
              
  Scenario Outline: verify a product is into the inventory
    Then the product "productName" is shows in the inventory

    Examples:
      | username      | password     | productName             |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |
      

  Scenario Outline: add "product" product into the cart:
    When user clicks add button into the cart
    Then the cart has 1 into the icon number

    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |
      
      
  Scenario Outline: Delete product out of the cart from inventory
    When user clicks "addProductButton"
    And user clicks "removeProductButton"
    Then the cart has no icon number

    Examples: 
      | username      | password     | addProductButton | removeProductButton |
      | standard_user | secret_sauce | elementAddButton | elementRemoveButton |
  
  Scenario Outline: add 3 randoms products into the cart
    When user clicks random "addProductButton" "number" times
    Then the cart has 3 into the icon number

    Examples:
      | username      | password     | addProductButton | number |
      | standard_user | secret_sauce | elementAddButton | 3      |  

  Scenario Outline: sort the list alphabetically by the filter (Z to A)
    When user clicks Z to A select option
    Then the inventory list is sorted alphabetically

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: order the list from lowest to highest price
    When user clicks Low to High select option
    Then the inventory list is sorted from lowest to highest price 

   Examples:
      | username      | password     |
      | standard_user | secret_sauce |

