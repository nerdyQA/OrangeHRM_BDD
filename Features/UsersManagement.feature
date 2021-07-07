Feature: Users management Feature

  #@tag1
  Scenario Outline: Create two new Users
    Given user launches the Browser
    And user enters the "URL"
    When user enters the "Admin" and "admin123"
    And click on the Login button
    Then page title should be "OrangeHRM"
    And clicks on Admin menu
    And then select User management
    When user clicked on the Users submenu
    And click on Add new user
    And enter "<Emp Name>" and "<Username>" and "<Password>" and "<ConfirmPass>"
    And click on Save Button
    Then verify that the message "Successfully Saved" is displayed.
    

    Examples: 
      | Emp Name| Username | Password | ConfirmPass |
      | Garry White| garryy| garry@white123| garry@white123|
      | Alice Duval| aaliiccyy| alice@duval123| alice@duval123|

  #@tag2
  #Scenario: Edit a user
    #Given User is on the System User Screen
    #When User enters the username to search
    #And Click on Search button
    #Then verify if the username is "alicee"
    #And click on the username
    #Then click on the edit button
    #And Change the user role to "Admin"
    #And Click on Save button
    #Then verify that the message "Successfully Updated"
