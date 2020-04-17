#This file has test cases for login functionality.

Feature: Login and registration

  Scenario: Successful login with valid credentials
    Given User loads PriceWatch URL
    And User clicks on Login link
    When User enters valid username "Kiddyt" and password "123456"
    And clicks on Login button
    Then Page URL should be "http://192.168.1.61/PriceWatch/trackproduct"


  Scenario: Login with invalid username or password
    Given User loads PriceWatch URL
    And User clicks on Login link
    When User enters invalid username and password
    And clicks on Login button
    Then User should get error message "ERROR! - Invalid username/password."


  Scenario: Test email verification message
    Given User loads PriceWatch URL
    And User clicks on Login link
    When User enters valid username "Kiddy" and password "123456"
    And clicks on Login button
    Then User should get error message "Your email is not verified. Please check your email for a verification code."


  Scenario: Register new user
    Given User loads PriceWatch URL
    And User clicks on Login link
    When User clicks on Register new user
    And User enters username, password, email, phone number, first name, last name
    And User clicks on register button
    Then User should get success message "Username registered successfully. An email verification code is sent to your registered email."



  Scenario: Cancel registration
    Given User loads PriceWatch URL
    And User clicks on Login link
    When User clicks on Register new user
    And User enters username, password, email, phone number, first name, last name
    And User clicks on cancel link
    Then Page URL should be "http://192.168.1.61/PriceWatch/login"










