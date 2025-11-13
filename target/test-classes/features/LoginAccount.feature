Feature: Validate login account functionality

@LoginAccount @TC_LF_001 @Regression
Scenario: Validate login into the application using the valid credentials

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
Then User should get logged in and taken to account Page.

@LoginAccount @TC_LF_002 @Regression
Scenario: Validate login into the application using the invalid credentials

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters invalid email address "abc@yahoo.co.in" into email field
And User enters invalid password "fetgrd23454" into password field
And User clicks on login button
Then Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed

@LoginAccount @TC_LF_003 @Regression
Scenario: Validate login into the application using invalid email and valid password.

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters invalid email address "abc@yahoo.co.in" into email field
And User enters valid password "abcz1@gmail" into password field
And User clicks on login button
Then Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed

@LoginAccount @TC_LF_004 @Regression
Scenario: Validate logging into the application using valid email and invalid password

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcz1@gmail.com" into email field
And User enters invalid password "24356745" into password field
And User clicks on login button
Then Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed

@LoginAccount @TC_LF_005 @Regression
Scenario: Validate logging into the application without providing anhy credentials

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters nothing into email address "" into email field
And User enters nothing into password field "" into password field
And User clicks on login button
Then Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed

@LoginAccount @TC_LF_006 @Regression
Scenario: Validate Forgotten Password link is available in the Login page and is working

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
Then User should be taken to login page
And User must able to see Forgotten Password link on login page
When User selects forgotten password link
Then User should be taken to Forgotten Password page

@LoginAccount @TC_LF_007 @Regression
Scenario: validate logging into the application using keyboard keys (Tab and Enter)

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field by using keyboardkeys
And User enters valid password "abcvda21@gmail" into password field by using keyboardkeys
And User press enter on login button to get loggedIn
Then User should get logged in and taken to account Page.

@LoginAccount @TC_LF_008 @Regression
Scenario: validate logging into the application using keyboard keys (Tab and Enter)

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
Then User must able to see E-mail placeholder text "E-Mail Address" in E-Mail field
And User must able to see Password placeholder text "Password" in Password field

@LoginAccount @TC_LF_009 @Regression
Scenario: Validate logging into the application and browsing back using browsing back button

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
Then User is LoggedIn user do browser back still user must not loggedOut

@LoginAccount @TC_LF_011 @Regression
Scenario: validate logging into the application using inactive credintials

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail123" into password field
And User clicks on login button
Then Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed

@LoginAccount @TC_LF_013 @Regression
Scenario: Validate the text into Password field is toggled to hide its visiblity

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters invalid password "fetgrd23454" into password field
Then Text entered into the Password "password" field should be toggled to hide its visibility because of password field type

@LoginAccount @TC_LF_014 @Regression
Scenario: Validate the copying of the text entered into Password field

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters invalid password "fetgrd23454" into password field
And User select the text entered into the Password field and press Ctrl+C shorcut for copying
Then User should not able to copy password text

@LoginAccount @TC_LF_015 @Regression
Scenario: Validate the Password is not visible in Page Source

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters invalid password "fetgrd23454" into password field
Then Inspect the Password text field click on login button and inspect the Password text field

@LoginAccount @TC_LF_019 @Regression
Scenario: Validate user is able to navigate to diffrent pages from Login page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User clicks on Continue button under new customer section
Then User should be taken to Register Account page
And User clicks on links one by one present on login account page and verify navigated to same webpage and navigates back to login account page

@LoginAccount @TC_LF_020 @Regression
Scenario: Validate the different ways of navigating to the Login Page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User clicks on Login button from Register Account Page
Then User should be taken to login page
When User navigates back
And user clicks on Login button from rightcolumn Register Account Page
Then User should be taken to login page
When User clicks on My Account Drop menu
And User Selects Login option
Then User should be taken to login page

@LoginAccount @TC_LF_021 @Regression
Scenario: Validate the breadcrumb, Page Heading, Page Title and Page URLof login Page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
When User must able see Proper Breadcrumb, Page Heading, Page URL and Page Title

@LoginAccount @TC_LF_023 @crossBrowser @Regression
Scenario: Validate the Login page functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
When Login Account functionality should work in all the supported browser


