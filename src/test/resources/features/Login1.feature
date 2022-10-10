@NV-1355
Feature: Login 1 - Without any parameter

  Background:
    Given The user is on the login page

  @NV-1352
  Scenario: Login as a driver
    When The user logs in as a driver
    Then The user is on the Quick Launchpad page

  @NV-1353
  Scenario: Login as a sales manager
    When The user logs in as a sales manager
    Then The user is on the Dashboard page

  @NV-1354
  Scenario: Login as a store manager
    When The user logs in as a store manager
    Then The user is on the Dashboard page


#  given: pre-condition
#  when: action
#  then: verification / assertion

#  and
#  but