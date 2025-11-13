Feature: verify MyAccountInfo-Account information functionality

@MyAccountInfoInfo @TC_MAI_001 @Regression
Scenario: Verify navigation to My Account Information page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully

@MyAccountInfo @TC_MAI_002 @Regression
Scenario: Verify all required fields are displayed on the page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And First Name, Last Name, E-Mail, and Telephone should be visible.

@MyAccountInfo @TC_MAI_003 @Regression
Scenario: Verify existing user information is pre-filled

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "rameshkolhapure@gmail.com" into email field
And User enters valid password "rameshkolhapure" into password field
And User clicks on login button
And User click on Edit your account information link
Then My Account Information page should open successfully
And All input fields should be pre-filled with current account data.

@MyAccountInfo @TC_MAI_004 @Regression
Scenario: Verify updating First Name with valid input

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User can change his first name in firstname field
And User click continue button in your personal details sections
And User can see success message “Success: Your account has been successfully updated.” should appear.

@MyAccountInfo @TC_MAI_005 @Regression
Scenario: Verify updating Last Name with valid input

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User can change his last name in lastName field
And User click continue button in your personal details sections
And User can see success message “Success: Your account has been successfully updated.” should appear.

@MyAccountInfo @TC_MAI_006 @Regression
Scenario: Verify updating email with valid input

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User can change his email in email field
And User click continue button in your personal details sections
And User can see success message “Success: Your account has been successfully updated.” should appear.

@MyAccountInfo @TC_MAI_007 @Regression
Scenario: Verify updating email with invalid input

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User can change his email in email field to wrong email format
And User click continue button in your personal details sections
And User can see error message for email field

@MyAccountInfo @TC_MAI_008 @Regression
Scenario: Verify Telephone field accepts only numeric values

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User cannot add characters in telephone field validates the correct behaviour

@MyAccountInfo @TC_MAI_009 @Regression
Scenario: Verify Telephone field with empty input

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then User can able to proceed with blank telephone field
And User click continue button in your personal details sections
And User can see validation message for telephone field

@MyAccountInfo @TC_MAI_010 @Regression
Scenario: Verify all mandatory fields validation when left blank

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
And User clear all the fields displayed in Edit your account information link
And User click continue button in your personal details sections
Then User can see validation messages for all the fields

@MyAccountInfo @TC_MAI_011 @Regression
Scenario: Verify Back button functionality

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User click browser back button on account information page
Then User is landed to MyAccount page

@MyAccountInfo @TC_MAI_012 @Regression
Scenario: Verify success message disappears after page refresh

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then My Account Information page should open successfully
And User can change his first name in firstname field
And User click continue button in your personal details sections
And User can see success message and it should disappear after page refresh

@MyAccountInfo @TC_MAI_013 @Regression
Scenario: Verify correct URL of My Account Information page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Edit your account information link
Then User can see url "https://tutorialsninja.com/demo/index.php?route=account/edit" in address bar