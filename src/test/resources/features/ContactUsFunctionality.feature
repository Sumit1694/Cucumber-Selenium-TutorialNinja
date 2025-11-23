Feature: validate contactUs functionality

@ContactUS @TC_CU_002 @Regression
Scenario: Validate navigating to Contact Us page from Footer options

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page

@ContactUS @TC_CU_004 @Regression
Scenario: Validate whether the required details and fields are displayed in the Contact Us page

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page
And User should see Our Location and Contact Form on contact us page

@ContactUS @TC_CU_005 @Regression
Scenario: Validate all the text fields in the Contact Us page are mandatory

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page
And User should see all the text fields are marked with star symbol as mandatory

@ContactUS @TC_CU_006 @Regression
Scenario: Validate submitting the Contact Form in Contact Us page by providing all the details

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page
When User fill all details in the contact us form and submit
Then User should see success message with text 'Your Enquiry has been Submitted!' should be displayed
When User click continue button
Then User should be landed to homePage

@ContactUS @TC_CU_007 @Regression
Scenario: Validate submitting the Contact Form in Contact Us page by not providing any details

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page
When User click submit button
Then All fields level messages should be displayed for mandatory text fields

@ContactUS @TC_CU_008 @Regression
Scenario: Validate entering invalid email address into the E-Mail Address field and submit the form

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page
And User fill all fields in contactUs page with invalid email input then email field level warning message should be displayed

@ContactUS @TC_CU_009 @Regression
Scenario: Validate submitting the Contact Form in Contact Us page by providing all the details after login

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page
And User should see logged in user name and email address in contact Us page
When User enters enquiry text in enquiry field
And User click on submit
Then User must see success Message with text Your Enquiry has been Submitted should be displayed
When User click continue button
Then User should be landed to homePage

@ContactUS @TC_CU_010 @Regression
Scenario: Validate the Breadcrumb of Contact Us page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When Click on Contact Us link from the Footer options
Then User should see breadCrumb of contactUs page

@ContactUS @TC_CU_011 @Regression
Scenario: Validate the Page URL, Page Heading and Page Title of Contact Us page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When Click on Contact Us link from the Footer options
Then User should see correct Page URL, Page Heading and Page Title should be displayed in the Contact Us page.

@ContactUS @TC_CU_013 @crossBrowser @Regression
Scenario: Validate the Contact Us page  functionality in all the supported environments

Given User is on the TutorialsNinja home page
When Click on Contact Us link from the Footer options
Then User should be taken to Contact Us page