@cart
Feature: Cart Test Cases

  Background:
    Given the user is on the home page
    And the user clicks on the my account button
    And the user clicks on the login option
    And the user introduces "usuariopruebasam@qa.com" as email
    And the user introduces "usuariopruebas" as password
    And the user clicks the login button
    And the user is on the home page

  @pr-08
    @smoke
  Scenario Outline: Validate that the user can add a product correctly
    When the user adds the "<product name>" product
    Then the cart is with <number products> product and the correct price
    Examples:
      | product name | number products |
      | MacBook      | 1               |

  @pr-09
    @smoke
  Scenario Outline: Validate that the user can add 2 same products correctly
    When the user adds the "<product name>" product
    And the user adds the "<product name>" product
    Then the cart is with <number products> product and the correct price
    Examples:
      | product name | number products |
      | MacBook      | 2               |

  @pr-10
    @smoke
  Scenario Outline: Validate that the user can add 2 different products correctly
    When the user adds the "<product name 1>" product
    And the user adds the "<product name 2>" product
    Then the cart is with <number products> product and the correct price
    Examples:
      | product name 1 | product name 2 | number products |
      | MacBook        | IPhone         | 2               |

