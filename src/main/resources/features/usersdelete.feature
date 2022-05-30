Feature: (e2e) Delete users

  @DeleteUsers
  Scenario_ (e2e) Delete an user
    Given Go to the URL to delete the user
    When The following get request that delete the user
    Then the response for delete users is 200