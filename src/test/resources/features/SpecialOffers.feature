Feature: validate Special offers functionality

@SpecialOffers @TC_SO_001 @Regression
Scenario: Validate that Special Offers link is visible and clickable from homepage

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page

@SpecialOffers @TC_SO_002 @Regression
Scenario: Validate the Special Offers page loads successfully

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
Then User click on special offers link from footer option and Measure page load time

@SpecialOffers @TC_SO_003 @Regression
Scenario: Validate that discounted products are listed under Special Offers

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page
And User should see only discounted products are listed in special offers page

@SpecialOffers @TC_SO_005 @Regression
Scenario: Verify old vs new price

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page
And User should see old price is strike through and new price is highlightes in special offers displayed products page

@SpecialOffers @TC_SO_006 @Regression
Scenario: Validate sorting options on Special Offers page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page
And User should see products are getting sorted based on option selected in sortby dropdown

@SpecialOffers @TC_SO_008 @Regression
Scenario: Validate that clicking on an offer product opens its detail page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page
And User click on offer product displayed in product details page
Then User should be navigated to product details page

@SpecialOffers @TC_SO_012 @Regression
Scenario: Validate expired offers are not displayed

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page
And User should see only discounted products are listed in special offers page not expired offers

@SpecialOffers @TC_SO_014 @Regression
Scenario: Validate guest user can view offers without login

Given User is on the TutorialsNinja home page
And User click on special offers link from footer option
Then User should be navigated to the Special Offers page
And User should see only discounted products are listed in special offers page

@SpecialOffers @TC_SO_015 @Regression
Scenario: Validate that Special Offers link is present in footer navigation

Given User is on the TutorialsNinja home page
Then User should see special offers link is present in footer section