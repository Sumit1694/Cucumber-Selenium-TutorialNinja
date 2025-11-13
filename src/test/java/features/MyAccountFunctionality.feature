Feature: Validate My Account functionality

@MyAccount @TC_MA_001 @Regression
Scenario: Validate navigating to My Account page on login

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
Then User should be taken to My Account page

@MyAccount @TC_MA_002 @Regression
Scenario: Validate navigating to My Account page using My Account option

When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User click on My Account link from my Account dropdown
Then User should be taken to My Account page

@MyAccount @TC_MA_003 @Regression
Scenario: Validate navigating to My Account page using Right Column options

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on order history link from my Account page
When User click on My Account link from my Account dropdown
Then User should be taken to My Account page

@MyAccount @TC_MA_004 @Regression
Scenario: Validate navigating to My Account page using My Account option in Site Map page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on site map link from footer option
When User click on my Account link from displayed site map page
Then User should be taken to My Account page

@MyAccount @TC_MA_005 @Regression
Scenario: Validate Breadcrump in My Account page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
Then User should be taken to My Account page
When User can see my Account Page breadcrumb is displayed
And also my Account page breadcrumb should be working as per expected
Then User should be taken to My Account page

@MyAccount @TC_MA_006 @Regression
Scenario: Validate Page URL, Page Heading and Page Title of the My Account page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
Then User should be taken to My Account page
When Verify the Page URL, Page Title and Page Heading is correct for My Account page

@MyAccount @TC_MA_008 @crossBrowser @Regression
Scenario: Validate the My Account page functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
Then User should be taken to My Account page
