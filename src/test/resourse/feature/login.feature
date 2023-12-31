Feature: Adactin login in edge 

Background:
Given User Open the browser
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

Scenario Outline: Login with Sequentional of data
When User enter the userName "<user>"
And User enter the password "<pass>"
And user click on login
Then Login is success
And User close the browser

Examples:
|user|pass|
|dharanm2008|canon5|
|dharanm2028|canon6|
|dharanm2038|canon7|
