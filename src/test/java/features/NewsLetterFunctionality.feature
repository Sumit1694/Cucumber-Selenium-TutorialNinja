Feature: validate newsLetter functionality

@NewsLetter @TC_NL_001 @Regression
Scenario: Validate navigating to Newsletter Subscription page from My Account page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Subscribe/Unsubscribe link to newsLetter link
Then User should be taken to newsletter subscription page

@NewsLetter @TC_NL_002 @Regression
Scenario: Validate navigating to Newsletter Subscription page using Right Column options

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Newsletter Right Column option
Then User should be taken to newsletter subscription page

@NewsLetter @TC_NL_003 @Regression
Scenario: Validate navigating to Newsletter page by selecting the option from Right Column options before login

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User click on Newsletter Right Column option
Then User is landed to login account page
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
Then User should be taken to newsletter subscription page

@NewsLetter @TC_NL_004 @Regression
Scenario: Validate navigating to Newsletter page by selecting the option using Newsletter Footer option before login

Given User is on the TutorialsNinja home page
When Click on Newsletter link from the Footer of the page
Then User is landed to login account page
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
Then User should be taken to newsletter subscription page

@NewsLetter @TC_NL_005 @Regression
Scenario: Validate navigating to Newsletter page by selecting the option using Newsletter Footer option after login

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Newsletter Right Column option
Then User should be taken to newsletter subscription page

@NewsLetter @TC_NL_006 @Regression
Scenario: Validate Back button in the Newsletter Subscription page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Newsletter Right Column option
Then User should be taken to newsletter subscription page
When User click back button present on newsletter subscription page
Then User should be on my Account page

@NewsLetter @TC_NL_007 @Regression
Scenario: Validate udpating the Subscribe option in the Newsletter Subscription page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Newsletter Right Column option
Then User should be taken to newsletter subscription page
When Select Yes radio option if No is displayed as selected by default or Select No radio option if Yes is displayed as selected by default
Then User click on continue button on newsLetter page
And User should see success message with text Success: Your newsletter subscription has been successfully updated! should be displayed and the User should be taken to My Account page
Then User click on Newsletter Right Column option
And User should be taken to Newsletter Subscription page and the Updated option should be displayed as selected

@NewsLetter @TC_NL_008 @Regression
Scenario: Register a new Account by opting for Newsletter and check the Newsletter Subscription page

Given User is on the TutorialsNinja home page
When User creates new account and select yes radio button of subscription and land on myAccount page
Then User should be landed on account success page
And User click on Newsletter Right Column option
Then User should be taken to Newsletter Subscription page and Yes radio option should be displayed as selected by default

@NewsLetter @TC_NL_009 @Regression
Scenario: Register a new Account by not opting for Newsletter and check the Newsletter Subscription page

Given User is on the TutorialsNinja home page
When User creates new account and select no radio button of subscription and land on myAccount page
Then User should be landed on account success page
And User click on Newsletter Right Column option
Then User should be taken to Newsletter Subscription page and No radio option should be displayed as selected by default

@NewsLetter @TC_NL_010 @Regression
Scenario: Validate the Breadcrumb of Newsletter Subscription page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Newsletter Right Column option
Then User should see breadcrumb of Newsletter subscription page and breadcrumb is working properly

@NewsLetter @TC_NL_011 @Regression
Scenario: Validate the Page URL, Page Heading and Page Title of Newsletter Subscription page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Newsletter Right Column option
Then Valiate correct Page URL, Page Heading and Page Title should be displayed in the Newsletter Subscription page

@NewsLetter @TC_NL_013 @crossBrowser @Regression
Scenario: Validate the Newsletter Subscription page  functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on Subscribe/Unsubscribe link to newsLetter link
Then User should be taken to newsletter subscription page
