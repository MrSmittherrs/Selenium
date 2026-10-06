Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I log in with username "testuser" and password "securepassword"
    Then I should be logged in