Feature: Navigation Menu

  @wip
  Scenario Outline: Navigate to <module>-<subModule>
    Given The user is on the login page
    And The user logs in as a "Sales Manager"
    When The user navigates to "<module>" - "<subModule>" module
    Then The title of the page contains "<title>"

    Examples:
      | module     | subModule       | title           |
      | Fleet      | Vehicles        | Car             |
      | Fleet      | Vehicle Costs   | Vehicle Costs   |
      | Customers  | Accounts        | Accounts        |
      | Activities | Calls           | Calls           |
      | Activities | Calendar Events | Calendar Events |
      | System     | Jobs            | Jobs            |
      | Marketing  | Campaigns       | Campaigns       |