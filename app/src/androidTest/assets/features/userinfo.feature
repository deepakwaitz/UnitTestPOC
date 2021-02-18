Feature: User Info
  Scenario: Get UerInformation
    Given I have a list of Info in HomeScreen
    When I land on HomeScreen
    And Checking Internet Connection
    And If Network Connectivity Available Make API Call
    And If No Network thorough Error Message
    Then I should see "<result>" on the display