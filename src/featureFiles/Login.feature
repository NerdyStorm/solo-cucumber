Feature: Login Feature

    @Login
    Scenario: Login to Techfios with valid credentials
    When User navigates to "https://www.techfios.com/billing"
    When User enters valid "username" as "demo@techfios.com"
    And User enters valid "password" as "abc123"
    And User clicks submit button
    Then User should be redirected to the dashboard page

    @LoginFillCustomerInfoFromDB
    Scenario: Login to Techfios with valid credentials
    When User navigates to "https://www.techfios.com/billing"
    When User enters valid "username" as "demo@techfios.com"
    And User enters valid "password" as "abc123"
    And User clicks submit button
    Then User should be redirected to the dashboard page
    When User clicks on "Customers" Button
    When User clicks on "Add Customer" Button
    Then User should be on the "Add Contact" page
    When User automatically fills in data from DB
    
