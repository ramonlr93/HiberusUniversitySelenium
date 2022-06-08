Feature: Validate Pet

  @petGet
  Scenario Outline: Validate that the response of the pet request is 200
    Given the following get request that brings us the pet
    And the response is 200
    Then the body response contains the "<id>" of the pet
    Examples:
    |id     |
    |123456 |

  @petPost
  Scenario Outline: Validate post
    Given the following post request that add pets
    And the response is 200 for the post
    Then the body response contains the "<name>" of the pet created

    Examples:
      | name |
      | Oli  |

  @petDelete
  Scenario: Validate delete pet
    Given the following post request that add pets
    And the following delete request that delete pets
    And the response is 204 for the delete
    Then the body response is empty


  @petStatus
  Scenario Outline: Validate status pet
    Given the following post request that add pets
    And the following get request that get pets by "<status>"
    And the response is 200 for the get by status
    Then the body response contains the "<name>" of the pet created

    Examples:
      | name | status    |
      | Oli  | available |





