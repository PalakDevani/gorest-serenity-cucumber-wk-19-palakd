Feature: Testing different request on the gorest application

  Scenario: get user with name, email, gender, status and userID
    When User sends a GET request to list endpoint
    Then User must get back a valid status code two hundred

  Scenario: Create a new user & verify if the user is added
    When User sends a Post request to list endpoint
    Then User must get back a valid status code two hundred One

  Scenario: Check if the name, email, is updated for the userID
    When User sends a Put request to list endpoint
    Then User must get back a valid status code two hundred

  Scenario: Check the user is deleted successfully
    When User sends a Delete request to list endpoint
    Then User must get back a valid status code two hundred four