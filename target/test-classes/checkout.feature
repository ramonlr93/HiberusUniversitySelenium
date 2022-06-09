@checkout
Feature: checkout test suite

  Background:
    Given the user is on the home page

  @usercheckout
    @smoke
  Scenario Outline: the user buys two products with already created address
    And the user adds one product to the cart "<product1>" and the user click the cart section
    And the user click the checkout button
    And the user enter his email "<email>" and password "<password>" and logs in
    And the user uses a already created billing address
    And the user uses a already created delivery address
    And the user select the delivery method
    And the user select the payment method
    When the user confirms the order
    Then The user get redirected to a page with a message that his order was successful "<urlsuccessfulorder>"

    Examples:
      | product1 | email               | password | urlsuccessfulorder                                              |
      | iPhone   | rbttm1999@gmail.com | 123abc   | http://opencart.abstracta.us/index.php?route=checkout/success   |

  @usercheckoutnewaddress
    @smoke
  Scenario Outline: the user buys two products with new created address
    And the user adds one product to the cart "<product>" and the user click the cart section
    And the user click the checkout button
    And the user enter his email "<email>" and password "<password>" and logs in
    And the user uses selects to create a new billing address
    And the user introduces his info "<name>" "<lastname>" "<address>" "<city>" "<country>" "<region>" for the new billing address
    And the user uses selects to create a new delivery address
    And the user introduces his info "<name>" "<lastname>" "<address>" "<city>" "<postcode>" "<country>" "<region>" for the new delivery address
    And the user select the delivery method
    And the user select the payment method
    When the user confirms the order
    Then The user get redirected to a page with a message that his order was successful "<urlsuccessfulorder>"

    Examples:
      | product | email               | password | name    | lastname | address         | city       | postcode | country | region     | urlsuccessfulorder                                              |
      | iPhone  | rbttm1999@gmail.com | 123abc   | Roberto | Teresa   | Calle falsa 123 | Valladolid | 47250    | Spain   | Valladolid | http://opencart.abstracta.us/index.php?route=checkout/success |

  @usercheckoutguest
  Scenario Outline: the user buys two products as a guest
    And the user adds one product to the cart "<product>" and the user click the cart section
    And the user click the checkout button
    And the user select to use a guest checkout
    And the user introduces his info "<name>" "<lastname>" "<email>" "<telephone>" "<address>" "<city>" "<country>" "<region>" for the new billing address
    And the user select the delivery method
    And the user select the payment method
    When the user confirms the order
    Then The user get redirected to a page with a message that his order was successful "<urlsuccessfulorder>"

    Examples:
      | product | email               | telephone | name    | lastname | address         | city       | country | region     | urlsuccessfulorder                                            |
      | iPhone  | rbttm1999@gmail.com | 1234      | Roberto | Teresa   | Calle falsa 123 | Valladolid | Spain   | Valladolid | http://opencart.abstracta.us/index.php?route=checkout/success |