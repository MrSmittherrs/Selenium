Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I log in with username "<user>" and password "<password>"
    Then I should be logged in
    Examples:
    |user                     |password      |
    |standard_user            | secret_sauce |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |

  Scenario Outline: Login fails with invalid credentials
    Given I am on the login page
    When I log in with username "<user>" and password "<password>"
    Then I should see the error "<error>"
    Examples:
      | user            | password      | error                                                                     |
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | wrong_pass    | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce  | Epic sadface: Username is required                                        |
      | standard_user   |               | Epic sadface: Password is required                                        |