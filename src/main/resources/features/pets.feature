Feature: (e2e) Validate pets

  @GetPets
  Scenario: (e2e) Validate that the response of the pets request is 200
    Given the following get request that brings us the pets
    And the response is 200

