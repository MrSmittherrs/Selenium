Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I log in with username "<user>" and password "<password>"
    Then I should be logged in
    Examples:
    |user|password|
    |standard_user            |secret_sauce  |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |

