Feature: Validate logout account functionality

@LogoutAccount @TC_LG_001 @Regression
Scenario: Validate Logging out by selecting Logout option from My Account dropmenu

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User clicks on My Account Drop menu on MyAccountPage
And User clicks on logout option
Then User should be taken to the Account Logout page and click on continue button
And User should see Login option inplace of Logout under the My Account dropmenu

@LogoutAccount @TC_LG_002 @Regression
Scenario: Validate Logging out by selecting Logout option from Right Column options

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User clicks logout option from right column
Then User should be taken to the Account Logout page and click on continue button
And User should see Login option inplace of Logout under the My Account dropmenu

@LogoutAccount @TC_LG_005 @Regression
Scenario: Validate Logout option is not displayed under My Account menu before logging in

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
Then User should not see logout option under myAccount drop menu

@LogoutAccount @TC_LG_006 @Regression
Scenario: Validate Logout option is not displayed under Right Column options before logging in

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
Then User should not see logout option in rightcolumn links

@LogoutAccount @TC_LG_008 @Regression
Scenario: Validate logging out and loggin in immediately after logout

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User clicks on My Account Drop menu on MyAccountPage
And User clicks on logout option
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
Then User must be logged in successfully

@LogoutAccount @TC_LG_009 @Regression
Scenario: Validate Account Logout page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User clicks on My Account Drop menu on MyAccountPage
And User clicks on logout option
Then Proper Page Heading, Page Title, Page URL and Breadcrumb should be displayed for Account Logout page

@LogoutAccount @TC_LG_009 @crossBrowser @Regression
Scenario: Validate the Logout functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User clicks on My Account Drop menu on MyAccountPage
And User clicks on logout option
Then User should be taken to the Account Logout page and click on continue button
And User should see Login option inplace of Logout under the My Account dropmenu


