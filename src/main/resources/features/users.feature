Feature: (e2e) Validate users

  @GetUsers
  Scenario: (e2e) Validate that the response of the user request is 200
    Given Go to the URL
    When the following get request that brings us the users
    Then the response for users is 200


  @DeleteUsers
  Scenario: (e2e) Delete an user
    Given Go to the URL
    When The following get request that delete the user
    Then the response for delete users is 200