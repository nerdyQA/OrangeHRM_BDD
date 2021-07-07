Feature: Login 

Scenario: verify login with valid and invalid credentials.
Given user launches the Browser
And user enters the "URL"
When user enters the "Admin" and "admin123"
And click on the Login button
Then page title should be "OrangeHRM"
#And click on logout button
#Then page title should be "OrangeHRM"
#And close the browser


 