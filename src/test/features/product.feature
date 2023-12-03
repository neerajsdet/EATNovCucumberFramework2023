Feature: Login Functionality


  Scenario: Successful login
    Given I am on the login page
    When I enter my valid username and password
    And click the login button
    Then I should be redirected to the dashboard
    And I should see a welcome message
