@checkout
Feature: Checkout test suite

  Background:
    Given the user is on the home page
    And the user clicks the my account button
    And the user clicks the login link

  @testcase027
    @smoke
  Scenario Outline: Verify logged user can checkout (with an existing address)
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the Your Store link
    And the user adds a "<item1>" from homepage to cart
    And the user adds a "<item1>" from homepage to cart
    And the user clicks the checkout button
    And the user clicks the payment address continue button on checkout page
    And the user checks the terms and conditions button on checkout page
    And the user clicks the payment method continue button on checkout page
    When the user clicks the confirm order button on checkout page
    Then the order has been successfully processed

    Examples:
      | email                 | password | item1   |
      | gonex68008@falkyz.com | password | MacBook |

  @testcase028
  Scenario Outline: Verify logged user can checkout for first time (registering a new address)
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the Your Store link
    And the user adds a "<item1>" from homepage to cart
    And the user adds a "<item1>" from homepage to cart
    And the user clicks the checkout button
    And the user enter the first name payment "<first_name_payment>" on checkout page
    And the user enter the last name payment "<last_name_payment>" on checkout page
    And the user enter the company payment "<company_payment>" on checkout page
    And the user enter the address1 payment "<address1_payment>" on checkout page
    And the user enter the address1 payment "<address2_payment>" on checkout page
    And the user enter the city payment "<city_payment>" on checkout page
    And the user enter the post code payment "<post_code_payment>" on checkout page
    And the user selects a country payment "<country_payment>" on checkout page
    And the user selects a zone payment "<zone_payment>" on checkout page
    And the user clicks the payment address continue button on checkout page
    And the user checks the terms and conditions button on checkout page
    And the user clicks the payment method continue button on checkout page
    When the user clicks the confirm order button on checkout page
    Then the order has been successfully processed

    Examples:
      | email             | password | item1   | first_name_payment | last_name_payment | company_payment | address1_payment | address2_payment | city_payment | post_code_payment | country_payment | zone_payment |
      | gonex10@falkyz.com | password | MacBook | Miguel             | Casado            | Hiberus         | Calle 123        | Calle 321        | Valladolid   | 12345             | Spain           | Valladolid   |

  @testcase029
  Scenario Outline: Verify logged user can checkout registering a new address
    And the user provides the email "<email>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user is logged successfully
    And the user clicks the Your Store link
    And the user adds a "<item1>" from homepage to cart
    And the user adds a "<item1>" from homepage to cart
    And the user clicks the checkout button
    And the user clicks the new payment address button on checkout page
    And the user enter the first name payment "<first_name_payment>" on checkout page
    And the user enter the last name payment "<last_name_payment>" on checkout page
    And the user enter the company payment "<company_payment>" on checkout page
    And the user enter the address1 payment "<address1_payment>" on checkout page
    And the user enter the address1 payment "<address2_payment>" on checkout page
    And the user enter the city payment "<city_payment>" on checkout page
    And the user enter the post code payment "<post_code_payment>" on checkout page
    And the user selects a country payment "<country_payment>" on checkout page
    And the user selects a zone payment "<zone_payment>" on checkout page
    And the user clicks the payment address continue button on checkout page
    And the user checks the terms and conditions button on checkout page
    And the user clicks the payment method continue button on checkout page
    When the user clicks the confirm order button on checkout page
    Then the order has been successfully processed

    Examples:
      | email             | password | item1   | first_name_payment | last_name_payment | company_payment | address1_payment | address2_payment | city_payment | post_code_payment | country_payment | zone_payment |
      | gonex8@falkyz.com | password | MacBook | Miguel             | Casado            | Hiberus         | Calle 123        | Calle 321        | Valladolid   | 12345             | Spain           | Valladolid   |