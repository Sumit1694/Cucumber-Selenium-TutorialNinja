Feature: verify order history funcationality

@OrderHistory @TC_OH_001 @Regression
Scenario: Validate navigating to Order History page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on order history link under my account section
Then User should be navigated to the Order History page

@OrderHistory @TC_OH_002 @Regression
Scenario: Validate breadcrumb navigation for Order History page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on order history link under my account section
Then User should see correct navigation path Home > My Account > Order History

@OrderHistory @TC_OH_003 @Regression
Scenario: Validate message when no order history is available

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on order history link under my account section
Then User should see You have not made any previous orders! message in order history page if there is no order

@OrderHistory @TC_OH_004 @Regression
Scenario: Validate that past orders are listed correctly

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order history link under my account section
Then User should see All past orders with correct details Order ID Status Date Total Action should be displayed

@OrderHistory @TC_OH_005 @Regression
Scenario: Validate viewing order information from order history

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order history link under my account section
And User click on view button of any order
Then User should be redirected to the order information page showing all order details

@OrderHistory @TC_OH_006 @Regression
Scenario: Validate correct order status display

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order history link under my account section
Then User order status should correctly display as Pending, Processing, Complete etc.

@OrderHistory @TC_OH_007 @Regression
Scenario: Validate the order listing is shown in descending order by date

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order history link under my account section
Then User order status should correctly display as Pending, Processing, Complete etc.

@OrderHistory @TC_OH_008 @Regression
Scenario: Validate the order listing is shown in descending order by date

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order history link under my account section
Then User should see dates in descending order in order history page

@OrderHistory @TC_OH_009 @Regression
Scenario: Validate navigation back from order information page to order history page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order history link under my account section
And User click on view button of any order
And User click browser back button
Then User should navigates back to orderHistory page

@OrderHistory @TC_OH_011 @Regression
Scenario: Validate Order History page accessibility via My Account dropdown

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order History option from my Account drop down
Then User should navigates back to orderHistory page

@OrderHistory @TC_OH_012 @Regression
Scenario: Validate presence of all UI elements on Order History page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on order History option from my Account drop down
Then All required columns and headers should be displayed correctly