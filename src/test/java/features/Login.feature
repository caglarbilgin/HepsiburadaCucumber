Feature: LoginFeature

  Scenario: Login with correct username and password
    Given Go to homepage
    And Hover to Element "HOVER_LOGIN"
    And Click "LOGIN_BUTTON" button
    And Enter the "USERNAME_INPUT" send key "sahabt321@gmail.com"
    And Enter the "PASSWORD_INPUT" send key "123sahabt"
    And Click "SIGNIN_BUTTON" button
    Then Check the "CHECK_LOGIN" information is correct

  Scenario: Login with incorrect username and password
    Given Go to homepage
    And Hover to Element "HOVER_LOGIN"
    And Click "LOGIN_BUTTON" button
    And Enter the "USERNAME_INPUT" send key "sahabt3211@gmail.com"
    And Enter the "PASSWORD_INPUT" send key "123sahabt"
    And Click "SIGNIN_BUTTON" button
    Then Check the "CHECK_LOGIN" information is correct
