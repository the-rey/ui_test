@KitadelUserFeature
  Feature: to test basic functions

    @Positive
    Scenario: User Login Success
      Given user is on landing page
      When user clicked on sign in button
      Then user is on sign in page

      And user input "reynaldocadangan+2@gmail.com" to email box
      And user input "Cadanganpass123" to password box
      And user clicked log in
      And user clicked skip

      Then user is on homepage
      And user can see portfolio value

    @Negative
    Scenario: User Login Fail
      Given user is on landing page
      When user clicked on sign in button
      And user input "reynaldocadangan+2@gmail.com" to email box
      And user input "Cadanganpass123asd" to password box
      And user clicked log in
      Then user is not on homepage

    @Positive
    Scenario: User Login Forget Password
      Given user is on landing page
      When user clicked on sign in button
      And user clicked on forget password
      Then user is on forget password page

      When user type "reynaldocadangan+2@gmail.com" on forget email input
      And user click on send instructions
      Then user can see instruction is sent


    @Positive
    Scenario: User Sign Up with correct credentials
      Given user is on landing page
      When user clicked on sign up button
      Then user should be on sign up page

    @Positive
    Scenario: User Sign In from Sign up page
      Given user is on landing page
      When user clicked on sign up button
      And user clicked on log into your account button
      Then user is on sign in page


#      When user input "reynaldo@mailinator.com" to new email input
#      And user input "first name" to new first name input
#      And user input "last name" to new last name input
#      And user input "Password123" to new password input
#      And user re - input "Password123" to new retype password input
#      And user click create account
#      Then user is on second sign up page
