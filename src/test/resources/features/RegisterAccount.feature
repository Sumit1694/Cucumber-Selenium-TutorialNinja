Feature: Validate Register Account functionality

@RegisterAccount @TC_RF_001 @Regression
Scenario: Validate Registering an Account with all mandatory details

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters mandatory registration details into fields
And User clicks on continue button on register account page
Then User should be logged in, taken to Account Succcess page and proper details should be displayed on the page
When User clicks on continue button on Account Success page
Then User should be taken to My Account page

@RegisterAccount @TC_RF_003 @Regression
Scenario: Validate Registering an Account with all details present on registration page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all registration details into fields
And User clicks on continue button on register account page
Then User should be logged in, taken to Account Succcess page and proper details should be displayed on the page
When User clicks on continue button on Account Success page
Then User should be taken to My Account page

@RegisterAccount @TC_RF_004 @Regression
Scenario: Validate proper notification messages are displayed for the mandatory fields when you dont provide any data into registration data fields and proceeds

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User clicks on continue button on register account page
Then User should be able to see all validation message for all mandatory fields

@RegisterAccount @TC_RF_005 @Regression
Scenario: Validate Registering an account when Yes option is selected for Newsletter field

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all registration details into fields
And User selects yes radio button for newsletter field
And User clicks on continue button on register account page
Then User should be logged in, taken to Account Succcess page and proper details should be displayed on the page
When User clicks on continue button on Account Success page
Then User should be taken to My Account page
When User clicks on Subscribe unsubscribe to newsletter link on my Account Page
Then User should able to see Yes option should be displayed as selected by default in the Newsletter page

@RegisterAccount @TC_RF_006 @Regression
Scenario: Validate Registering an account when Yes option is selected for Newsletter field

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all registration details into fields
And User selects no radio button for newsletter field
And User clicks on continue button on register account page
Then User should be logged in, taken to Account Succcess page and proper details should be displayed on the page
When User clicks on continue button on Account Success page
Then User should be taken to My Account page
When User clicks on Subscribe unsubscribe to newsletter link on my Account Page
Then User should able to see no option should be displayed as selected by default in the Newsletter page

@RegisterAccount @TC_RF_007 @Regression
Scenario: Validate diffrent ways of navigating to 'Register Account' page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then User should be taken to Register Account page
When User clicks on My Account Drop menu
And click on Login option
And click on continue button inside New Customer box
Then User should be taken to Register Account page
When User clicks on My Account Drop menu
And click on Login option
And click on Register option from the Right Column options
Then User should be taken to Register Account page

@RegisterAccount @TC_RF_008 @Regression
Scenario: Validate Registering an account by providing the existing account details

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters existing Account Details "abcz1" "Rane" "abcz1@gmail.com" "13245675434" "abcz1" "abcz1" into all the Fields
And User clicks on continue button on register account page
Then User must get warning message Warning: E-Mail Address is already registered!

@RegisterAccount @TC_RF_009 @Regression
Scenario: Validate Registering an account by providing an invalid email address into the E-mail field

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all registration details into fields with wrong email address
And User clicks on continue button on register account page
Then User must get proper field level warning message or page level warning message to provide valid email address should be displayed

@RegisterAccount @TC_RF_010 @Regression
Scenario: Validate Registering an account by using the keyboard keys.

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enter new Account Details into all the Fields by using keyboard keys
And User clicks on continue button on register account page
Then User should be logged in, taken to Account Succcess page and proper details should be displayed on the page

@RegisterAccount @TC_RF_011 @Regression
Scenario: Validate all the fields in the Register account page have the proper placeholders.

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then User must see proper placeholder text is present for every field

@RegisterAccount @TC_RF_012 @Regression
Scenario: Validate all the mandatory fields in the Register account page are marked with red color star symbol

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then User must see all mandatory fields with red star symbol on register accounts page

@RegisterAccount @TC_RF_013 @Regression
Scenario: Validate the details that are provided while Registering an account that are stored in the database

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all registration details into into registration fields
And User clicks on continue button on register account page
Then All registration details are successfully stored in database

@RegisterAccount @TC_RF_014 @Regression
Scenario: Validate whether the Mandatory field in Register account page are acceptiong only spaces

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters only spaces in mandatory registration details fields
And User clicks on continue button on register account page
Then User should get warning message for these Mandatory fields for spaces

@RegisterAccount @TC_RF_015 @Regression
Scenario: Validate whether the password fields in Register Account page are following Password Complexity Standards

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all registration details into fields with password not following standard
And User clicks on continue button on register account page
Then User should get warning message for following Password Complexity Standards

@RegisterAccount @TC_RF_016 @Regression
Scenario: Validate whether the fields in the Register account page are according the client requirements (eg: Height, Width, Number of characters, etc)

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then Check all the fields on register account page including the Continue button Text fields should abide to the Client requirements

@RegisterAccount @TC_RF_017 @Regression
Scenario: Validate whether the leading and trailing spaces entered into the Register Account fields are trimmed

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters all data into registration fields by adding leading and trailing spaces
And User clicks on continue button on register account page
Then User should be logged in, taken to Account Succcess page and proper details should be displayed on the page
When User clicks on continue button on Account Success page
Then User should be taken to My Account page
And User clicks on Edit your account information link
Then User should able to see account created by information after removing leading and trailing spaces

@RegisterAccount @TC_RF_018 @Regression
Scenario: Validate whether the 'Privacy Policy' checkbox option is not selected by default.

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then User should see the privacy policy checkbox is not selected bydefault

@RegisterAccount @TC_RF_019 @Regression
Scenario: Validate Registering account without checking 'Privacy Policy' checkbox option.

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then User should see the privacy policy checkbox is not selected bydefault
And User enters mandatory registration details into fields except privacyPolicyCheckbox
Then User clicks on continue button on register account page
And User must get warning message for privancy policy

@RegisterAccount @TC_RF_020 @Regression
Scenario: Validate Password text entered into Password field is toggled to hide its visiblity

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters some text into password field
Then Password text entered into Password fields need to be toggled to hide its visibilty

@RegisterAccount @TC_RF_021 @Regression
Scenario: Validate navigating to other pages using the options or links provided on the Register Account page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User clicks on links one by one present on Register Account page and verify navigated to same webpage and navigates back to register account page

@RegisterAccount @TC_RF_022 @Regression
Scenario: Validate the Breadcrumb, Page Heading, Page URL, Paage Title of Register Account page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then Proper Breadcrumb, Page Heading, Page URL and Page Title should be displayed

@RegisterAccount @TC_RF_023 @Regression
Scenario: Validate the UI of the Register Account page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then Proper and good UI should be displayed on the Register Account page

@RegisterAccount @TC_RF_024 @crossBrowser @Regression
Scenario: Validate Register Account functionality in all the supported browsers

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then Register Account functionality should work in all the supported browser