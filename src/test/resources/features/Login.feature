Feature: Login

  Background:
    Given The user is on the login page


  Scenario Outline: AC-1: Login as a <userType>
    When The user logs in as a "<userType>"
    Then The user is on the "<pageSubTitle>" page

    Examples:
      | userType      | pageSubTitle    |
      | Driver        | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |


  Scenario Outline: AC-1:  Can not login with invalid credentials - Negative Scenario
    When The user tries to login with "<username>" and "<password>"
    Then The user can not login and page title is "Login"

    Examples:
      | username        | password    |
      | salesmanager101 |             |
      |                 | UserUser123 |
      |                 |             |
      | abcdefgh        | UserUser123 |
      | storemanager51  | aad3412!    |
      | asdaw           | sdf323'+%   |


  Scenario: AC-2: User can not login without credentials
    And The user logs in as a "Driver"
    When The user copy the URL and then logs out
    And Paste the copied URL to the browser
    Then The user is still on the login page

  #This scenario could be split into three different scenario
  Scenario: AC-3: Warning Messages
    When The user clicks on login btn while username field is empty
    Then "Please fill out this field." message should be displayed in "username" field

    When The user enters any username and click on login btn while password field is empty
    Then "Please fill out this field." message should be displayed in "password" field

    When The user enters wrong username and password
    Then "Invalid user name or password." message should be displayed


  Scenario: AC-4: Password field bullet sign
    When The user enters anything into password field
    Then The password field must be seen in bullet sign


  Scenario: AC-5: Forgot Password page title
    When The user clicks on Forgot your password? link
    Then The user lands on the "Forgot Password" page


  #This scenario will fail because user can not reset the password
  Scenario: AC-5: Reset Password
    And The user clicks on Forgot your password? link
    When The user enters any username "user1" and clicks on request btn
    Then The user successfully reset the password


  Scenario: AC-5: Reset Password - Negative Scenario
    And The user clicks on Forgot your password? link
    When The user enters any username "blablabla :)" and clicks on request btn
    Then The user gets a warning message containing "There is no active user with username or email address"


  #This scenario will fail because remember me btn not works as expected
  Scenario: AC-6: Remember me
    And The user clicks on RememberMe btn and logs in with following credentials
      | username | user1       |
      | password | UserUser123 |
    When The user logs out and go to login page again
    Then The user is on the "Quick Launchpad" page


  Scenario: AC-7: Enter key on keyboard
    When The user enters "user1" into "username" field
    And Hit the enter key on keyboard
    And The user enters "UserUser123" into "password" field
    And Hit the enter key on keyboard
    Then The user is on the "Quick Launchpad" page



  #This cenario will fail because we don't see the same username in the profile menu
  Scenario: AC-8: All users can see their usernames in profile menu
    And The user logs in with following credentials map
      | username | salesmanager101 |
      | password | UserUser123     |
    When The user clicks on profile menu
    Then The user can see his own username "salesmanager101" in the profile menu

# additional scenarious
  Scenario: The leading and trailing spaces entered into the Username field are trimmed
    When The user tries to login with "        storemanager51     " and "UserUser123"
    Then The user is on the "Dashboard" page


  Scenario: All the fields in the Login page have the proper placeholders
    Then Username and password input boxes have proper placeholders


  Scenario: Color  of "LOGIN"  button
    Then the user should see the background color of "LOGIN" button as "#0c84a3"


  Scenario: Copying of the text entered into the Password field
    Given the user enters valid credentials to password input box
    Then the system should not allow user to copy password


  Scenario: Password is not visible in the Page Source
    Given the user enters valid credentials to password input box
    Then the password is not visible in the Page Source
