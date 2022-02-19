Feature: Login Feature

    @Login
    Scenario: Login to Techfios with valid credentials
    When User navigates to "https://www.techfios.com/billing"
    When User enters valid "username" as "demo@techfios.com"
    And User enters valid "password" as "abc123"
    And User clicks submit button
    Then User should be redirected to the dashboard page
    
