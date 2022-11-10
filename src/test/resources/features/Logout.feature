Feature: Logout

  Background:
    Given The user is on the login page
    And The user logs in as a "sales manager"

  Scenario: AC-1: Logout by clicking on logout btn
    When The user clicks on logout btn in the profile menu
    Then The user ends up in "Login" page

  Scenario: AC-2: Can't go homepage with step-back btn
    And The user clicks on logout btn in the profile menu
    And The user ends up in "Login" page

    When The user clicks on step-back btn in the browser
    Then The user ends up in "Login" page

  Scenario: AC-3: Logout when close the open tabs
    When The user closes all the open tabs
    And The user navigates to "https://qa.perfleet.com/"
    Then The user ends up in "Login" page


  #This scenario will fail because nothing happens after 3 minutes
  Scenario: AC-4: AFK for three minutes
    When The user is inactive for 3 minutes consecutively
    Then The user ends up in "Login" page
