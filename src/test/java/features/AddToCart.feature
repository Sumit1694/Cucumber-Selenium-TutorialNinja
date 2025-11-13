Feature: Validate Add to Cart functionality

@AddToCart @TC_ATC_001 @Regression
Scenario: Validate adding the product to Cart from Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And click on Add to cart button
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on the shopping cart! link in the displayed success message
Then User must see product successfully displayed in the shopping cart page

@AddToCart @TC_ATC_002 @Regression
Scenario: Validate adding the product to Cart from Wish List Page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to wishList button
And User click on wishList header option
And User click on Add to Cart icon option in the displayed My Wish List page
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
And User click on shopping cart header option
Then User must see product successfully displayed in the shopping cart page

@AddToCart @TC_ATC_003 @Regression
Scenario: Validate adding the product to Cart from Search Results Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And click on Add to cart button
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on cart button which is in black color beside the search icon button on the top of the page
And User click on View Cart option in the displayed box
Then User must see product successfully displayed in the shopping cart page

@AddToCart @TC_ATC_004 @Regression
Scenario: Validate adding the product to Cart from the Related Products section of the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "Apple Cinema 30" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User must click on any product displayed in related search section
And User click on add to cart button for that product
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed

@AddToCart @TC_ATC_005 @Regression
Scenario: Validate adding the product to Cart from the Products displayed in the category or sub-category page

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And User select Mac subcategory option from the left side options displayed
And User click on add to cart button that is availble on any of the Products of the displayed Category or Sub-category pages
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on the shopping cart! link in the displayed success message
Then User must see product successfully displayed in the shopping cart page

@AddToCart @TC_ATC_006 @Regression
Scenario: Validate adding the product to Cart from the Products displayed in the Featured section of Home page

Given User is on the TutorialsNinja home page
When User click on add to cart button on the product that is displayed in the featured section of the Home page
Then Success message with text - 'Success: You have added MacBook to your shopping cart!' should be displayed
When User click on the shopping cart! link in the displayed success message
Then User must see product successfully displayed in the shopping cart page

@AddToCart @TC_ATC_007 @Regression
Scenario: Validate adding the product to Cart from Product Comparison Page

Given User is on the TutorialsNinja home page
When User click on compare this product option and click on product comparison link from success message
And User click on Add to Cart button on the product that is displayed in the Product Comparison page
Then Success message with text - 'Success: You have added MacBook to your shopping cart!' should be displayed
When User click on the shopping cart! link in the displayed success message
Then User must see product successfully displayed in the shopping cart page

@AddToCart @TC_ATC_009 @crossBrowser @Regression
Scenario: Validate adding the product to Cart from Product Comparison Page

Given User is on the TutorialsNinja home page
When User click on add to cart button on the product that is displayed in the featured section of the Home page
Then Success message with text - 'Success: You have added MacBook to your shopping cart!' should be displayed

