Feature: test login functionality

  @LoginDemo
  Scenario: check login is successful with valid credentials
    Given user goes to "https://www.saucedemo.com/"
    When user provides correct user name
    And user provides correct password
    Then user clicks on login button
    Then verify user successfully logged in

    @LoginDemoNegative
    Scenario: check login is unsuccessful with invalid credentials
      Given user goes to "https://www.saucedemo.com/"
      When user provides incorrect user name
      And user provides incorrect password
      Then user clicks on login button
      Then verify user sees error message