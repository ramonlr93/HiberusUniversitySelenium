Feature: (e2e) Validate pets

  @GetPets
  Scenario: (e2e) Validate that the response of the pets request is 200
    Given Go to the URL
    When the following get request that brings us the pets
    Then the response is 200


  @DeleteUsers
  Scenario: (e2e) Delete a pet
    Given Go to the URL
    When The following get request that delete the pet
    Then the response for delete pets is 200
