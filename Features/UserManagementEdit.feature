Feature: Edit User

  Scenario: Edit a user
    Given user launches the Browser
    And user enters the "URL"
    When user enters the "Admin" and "admin123"
    And click on the Login button
    And clicks on Admin menu
    #And then select User management
    #When user clicked on the Users submenu
    #Then title should be "System Users" should be present
    And User enters the username to search "aliciia"
    When Click on Search button
    Then verify if the username is "aliciia"
    And click on the username
    Then click on the edit button
    And Change the user role to "Admin"
    And click on Save Button
    Then verify that the message "Successfully Updated"
