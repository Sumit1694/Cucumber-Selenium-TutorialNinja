Feature: Validate HomePage functionality

@HomePage @TC_HP_001 @Regression
Scenario: Validate navigating to Home Page from Shopping Cart page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for iPhone product in search page
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed
When User click on shopping cart link in displayed success message in searchPage
And User click contine button on shopping cart page
Then User must be landed to homepage

@HomePage @TC_HP_003 @Regression
Scenario: Validate navigating to Home page from any page of the Applcation using Logo

Given User is on the TutorialsNinja home page
When User click on About Us footer link
Then User is landed on About Us page
When User click on the Logo Your Store in our application
Then User must be landed to homepage

@HomePage @TC_HP_004 @Regression
Scenario: Validate navigating to Home page from any Category Page which dont have any products

Given User is on the TutorialsNinja home page
When User hover on desktop
And User click on PC(o) link present in desktop menu
Then User is landed on PC page which has zero products
And User click on continue button present on PC page
Then User must be landed to homepage

@HomePage @TC_HP_005 @Regression
Scenario: Validate Hero Images and its slider options in the Home page

Given User is on the TutorialsNinja home page
Then User can see Hero Images and slider options on the displayed Home page

@HomePage @TC_HP_006 @Regression
Scenario: Validate four featured products should be displayed in the Home Page

Given User is on the TutorialsNinja home page
Then User can see four products in featured section of homePage
And All the option of the Products in the Featured section should be working correctly

@HomePage @TC_HP_007 @Regression
Scenario: Validate Partner Carousel section and its slider options in the Home page

Given User is on the TutorialsNinja home page
Then Check the Partner Carousel Logo images and slider options on the displayed Home page

@HomePage @TC_HP_008 @Regression
Scenario: Validate navigating to Home Page using Home icon option of the Breadcrumb in different pages of the Application

Given User Open the Application URL and navigate to different pages of the Application and by clicking on home breadcrumb user must landed to homePage

@HomePage @TC_HP_010 @crossBrowser @Regression
Scenario: Validate the Home page functionality in all the supported environments

Given User is on the TutorialsNinja home page
Then User must be landed to homepage