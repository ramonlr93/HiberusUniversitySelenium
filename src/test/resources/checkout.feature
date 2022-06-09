@checkout
Feature: Validate Checkout test suite

  Background:
    Given the user is on the home page
    And The user clicks phones and pdas button
    And the user is on phones and pdas page
    And the user add the first product to the cart
    And The user clicks checkout option
    And The user is on checkout page

  @testcase22
    @smoke
  Scenario Outline: validate checkout ok
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    And the user clicks check of that delivery and billing addresses are the same
    And the user clicks continue in step 2
    And the user clicks flat shipping
    And the user clicks continue in step 4
    And the user clicks cash on delivery option
    And the user accepts check of terms and conditions
    And the user clicks continue in step 5
    When the user clicks confirm order button
    Then the user is on checkout success page

    Examples:
      | firstName | lastName   | email             | telephone | address1    | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | calle falsa | Valladolid | 47010    |


  @testcase23
  Scenario: validate checkout ko, the user can see all alerts when all fields unfilled
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And click country -please select- and region state -please select-
    When the user clicks continue button in step 2
    Then the user can see an alert
      | firstName   |
      | lastName    |
      | email       |
      | telephone   |
      | address     |
      | city        |
      | country     |
      | regionState |


  @testcase24
  Scenario Outline: validate checkout ko with an invalid format email
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | email |

    Examples:
      | firstName | lastName   | email                        | telephone | address1    | city       | postCode |
      | nomPrueba | apelPrueba | prue.,.,.,.....ba@prueba.com | 600600600 | calle falsa | Valladolid | 47010    |


  @testcase25
  Scenario Outline: validate checkout ko address with less than 3 characters in address
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | address |

    Examples:
      | firstName | lastName   | email             | telephone | address1 | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | a        | Valladolid | 47010    |


  @testcase26
  Scenario Outline: validate checkout ko address with more than 128 characters
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | address |

    Examples:
      | firstName | lastName   | email             | telephone | address1                                                                                                                                                                                  | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | Valladolid | 47010    |


  @testcase27
  Scenario Outline: validate checkout ko name with more than 32 characters
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | firstName |

    Examples:
      | firstName                          | lastName   | email             | telephone | address1 | city       | postCode |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | apelPrueba | prueba@prueba.com | 600600600 | calle    | Valladolid | 47010    |


  @testcase28
  Scenario Outline: validate checkout ko telephone with less than 3 characters
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | telephone |

    Examples:
      | firstName | lastName   | email             | telephone | address1 | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 60        | calle    | Valladolid | 47010    |


  @testcase29
  Scenario Outline: validate checkout ko telephone with more than 32 characters
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | telephone |

    Examples:
      | firstName | lastName   | email             | telephone                         | address1 | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 123456789012345678901234567890123 | calle    | Valladolid | 47010    |


  @testcase30
  Scenario Outline: validate checkout ko telephone with incorrect format
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | telephone |

    Examples:
      | firstName | lastName   | email             | telephone   | address1 | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600.+-*/654 | calle    | Valladolid | 47010    |


  @testcase31
  Scenario Outline: validate checkout ko city with less than 2 characters
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | city |

    Examples:
      | firstName | lastName   | email             | telephone | address1 | city | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | casdsad  | a    | 47010    |


  @testcase32
  Scenario Outline: validate checkout ko city with more than 128 characters
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    When the user clicks continue button in step 2
    Then the user can see an alert
      | city |

    Examples:
      | firstName | lastName   | email             | telephone | address1 | city                                                                                                                                                                                      | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | casdad   | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | 47010    |


  @testcase33
  Scenario Outline: validate checkout ko dont accept terms and conditions in step 5
    And the user clicks guest checkout
    And the user clicks continue in step 1
    And the user complete the form with first name "<firstName>" last name "<lastName>" email "<email>" telephone "<telephone>" address1 "<address1>" city "<city>" post code "<postCode>" country Spain option and region or state Almeria option
    And the user clicks check of that delivery and billing addresses are the same
    And the user clicks continue in step 2
    And the user clicks flat shipping
    And the user clicks continue in step 4
    And the user clicks cash on delivery option
    When the user clicks continue button in step 5
    Then the user can see a warning

    Examples:
      | firstName | lastName   | email             | telephone | address1    | city       | postCode |
      | nomPrueba | apelPrueba | prueba@prueba.com | 600600600 | calle falsa | Valladolid | 47010    |