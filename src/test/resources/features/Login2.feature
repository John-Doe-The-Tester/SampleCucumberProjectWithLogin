Feature: Login 2 - With parameters:

  Background:
    Given The user is on the login page

  #--with String----------------------------
  Scenario: Login as a Driver
    When The user logs in as a "Driver"
    Then The user is on the "Quick Launchpad" page

  Scenario: Login as a Sales Manager
    When The user logs in as a "Sales Manager"
    Then The user is on the "Dashboard" page

  Scenario: Login as a Store Manager
    When The user logs in as a "Store Manager"
    Then The user is on the "Dashboard" page



  #--with List--------------------------------
  Scenario: Login as a Driver 2
    When The user logs in with following credentials (list)
      | user1       |
      | UserUser123 |
    Then The user is on the "Quick Launchpad" page

  Scenario: Login as a Sales Manager 2
    When The user logs in with following credentials (list)
      | salesmanager101 |
      | UserUser123     |
    Then The user is on the "Dashboard" page

  Scenario: Login as a Store Manager 2
    When The user logs in with following credentials (list)
      | storemanager51 |
      | UserUser123    |
    Then The user is on the "Dashboard" page



  #--with Map---------------------------------
  Scenario: Login as a Driver 3
    When The user logs in with following credentials (map)
      | username | user1       |
      | password | UserUser123 |
    Then The user is on the "Quick Launchpad" page

  Scenario: Login as a Sales Manager 3
    When The user logs in with following credentials (map)
      | username | salesmanager101 |
      | password | UserUser123     |
    Then The user is on the "Dashboard" page

  Scenario: Login as a Store Manager 3
    When The user logs in with following credentials (map)
      | username | storemanager51 |
      | password | UserUser123    |
    Then The user is on the "Dashboard" page


