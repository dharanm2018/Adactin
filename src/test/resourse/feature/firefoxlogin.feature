Feature: Adactin login in firefox

Background:
Given User Open the firefox browser
And User load the url

Scenario: Login with valid data
When User enter the userName 
And User enter the password
And user click on login
Then Login is success
And User close the browser

Scenario: Login with invalid data
When User enter the userName "dharanm"
And User enter the password "canon"
And user click on login
Then Login is success
And User close the browser

