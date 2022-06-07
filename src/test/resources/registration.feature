@registration
Feature: validate registration test suite

  Scenario Outline: Navigate to the register page
    Given the user is on the register page
    When user enter <firstName>, <lastName>, <email>, <telephone>, <password> and <confirmPassword>
    And choose if he wants to accept newsletter
    And agree with privacy policy
    And clicks on continue button
    Then user should see the success message
    Examples:
      | firstName | lastName | email                    | telephone | password  | confirmPassword |
      | "Jodie"   | "Foster" | "cavikov604@game4hr.com" | 999999999 | Caviko609 | Cavico609        |



