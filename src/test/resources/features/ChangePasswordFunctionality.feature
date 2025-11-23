Feature: verify change password functionality

@changePassword @TC_CP_001 @Regression
Scenario: Validate navigating to Change Password page from My Account page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "rameshkolhapure@gmail.com" into email field
And User enters valid password "rameshkolhapure" into password field
And User clicks on login button
And User clicks on change your password link
Then User should be navigated to change password page

@changePassword @TC_CP_002 @Regression
Scenario: Validate navigating to Change Password page using Password Right column option

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "rameshkolhapure@gmail.com" into email field
And User enters valid password "rameshkolhapure" into password field
And User clicks on login button
And User clicks on password right column option
Then User should be navigated to change password page

@changePassword @TC_CP_003 @Regression
Scenario: Validate navigating to change password page from site map page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "rameshkolhapure@gmail.com" into email field
And User enters valid password "rameshkolhapure" into password field
And User clicks on login button
And User click on site map link from footer option
And User click on password link in the displayed site map page
Then User should be navigated to change password page

@changePassword @TC_CP_004 @Regression
Scenario: Validate changing the password

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
And Enter new password into the Password and Passwrod Confirm fields
And User click on continue button in change password page
Then Success message with text - Success: Your password has been successfully updated. should be displayed
When User logout and login with old password
Then Warning message with text - Warning: No match for E-Mail Address and/or Password. should be displayed
When User Login with new password
Then User should login successfully and taken to My Account page

@changePassword @TC_CP_005 @Regression
Scenario: Validate changing the password without entering anything into the fields in Change Password page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
And User clicks on continue button on change password page
Then Field level warning message should be displayed under the Password fields by not allowing the user to update the account with a blank password

@changePassword @TC_CP_006 @Regression
Scenario: Validate entering different password into the Password and Password Confirm fields while Changing the Password

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
And User enter new password in password field and enter different password in confirm password field
And User clicks on continue button on change password page
Then Field level warning message should be displayed under the confirm password fields by not allowing the user to update the password

@changePassword @TC_CP_007 @Regression
Scenario: Validate all the Password fields in the change password page are marked as mandatory

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
And User can see all the fields are mandatory with star mark and colour of star is red

@changePassword @TC_CP_008 @Regression
Scenario: Validate the text entered into the fields in Change Password field is toggled to hide its display

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
And User enter new password in password field and enter different password in confirm password field
Then Text entered into the password fields - password and password confirm should be toggled to hide its display instead of entered text user should see symbols

@changePassword @TC_CP_010 @Regression
Scenario: Validate Breadcrumb in the change password page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
Then User can see breadcrumb of change password page
And breadcrumb of change password page is working properly

@changePassword @TC_CP_011 @Regression
Scenario: Validate Page Heading, Page Title and Page URL in the Change Password page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
Then Validate Heading, title, and Url of change password page

@changePassword @TC_CP_013 @crossBrowser @Regression
Scenario: Validate the Change Password page functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on password right column option
Then User can see breadcrumb of change password page
