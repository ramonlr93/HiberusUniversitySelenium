Feature: (e2e) Validate users

  @users
  Scenario: (e2e) Validate that the response of the user request is 200
    Given the following get request that brings us the users
    And the response is 200

