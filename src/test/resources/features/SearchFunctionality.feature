Feature: Validate Search Functionality

@Search @TC_SF_001 @Regression
Scenario: Validate searching with an existing Product Name

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User should get search result "iMac" with respective search

@Search @TC_SF_002 @Regression
Scenario: Validate searching with a non existing Product Name

Given User is on the TutorialsNinja home page
When User enters any non existing product name "Fitbit" into the search text box field
And User clicks on button having search icon
Then User must see there is no product that matches the search criteria should be displayed in the Search Results page

@Search @TC_SF_003 @Regression
Scenario: Validate searching without providing any Product Name

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
Then User must see there is no product that matches the search criteria should be displayed in the Search Results page

@Search @TC_SF_004 @Regression
Scenario: Validate searching for a product after login to the Application

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User should get search result "iMac" with respective search

@Search @TC_SF_005 @Regression
Scenario: Validate searching by providing a search criteria which results in mulitple products

Given User is on the TutorialsNinja home page
When User enters the search criteria in the "Mac" text box field which can result in mutliple products
And User clicks on button having search icon
Then User must see More than one products should be displayed in the search results page

@Search @TC_SF_006 @Regression
Scenario: Validate all the fields in the Search functionality and Search page have placeholders

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
Then User must see proper placeholder for search textBox field
And User must see proper placeholder for search criteria textBox field

@Search @TC_SF_007 @Regression
Scenario: Validate searching using Search Criteria field

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
And User enters any existing product name "iMac" into the search criteria text box field
And User click on search button
Then User should get search result "iMac" with respective search

@Search @TC_SF_008 @Regression
Scenario: Validate Search using the text from the product description

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
And User enters any text "iLife" from the Product Description into the Search Criteria text box field
And User clicks on Search in product descriptions checkbox option
And User click on search button
Then User should get search result "iMac" with respective search

@Search @TC_SF_009 @Regression
Scenario: Validate Search by selecting the category of product

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
And User enters any existing product name "iMac" into the search criteria text box field
And User selects the correct category "Mac" of the given Product name into Category dropdown field
And User click on search button
Then User should get search result "iMac" with respective search
When User selects wrong category "PC" from category dropdown field
And User click on search button
Then User must see there is no product that matches the search criteria should be displayed in the Search Results page

@Search @TC_SF_010 @Regression
Scenario: Validate Search by selecting the category of product

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
And User enters any existing product name "iMac" into the search criteria text box field
And User selects the parent category of "Mac" the given Product Name into category dropdown field
And User click on search button
Then User must see there is no product that matches the search criteria should be displayed in the Search Results page
When User select search in subcategories checkbox field
And User click on search button
Then User should get search result "iMac" with respective search

@Search @TC_SF_011 @Regression
Scenario: Validate Search by selecting the category of product

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User select List option on search page
Then User should see single product in the List view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed
When User click on image of the product
Then User must be navigated to product "iMac" display page of product
When User click on name of the product
Then User must be navigated to product "iMac" display page of product
And User must clear search fields
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User select Grid option on search page
Then User should see single product in the Grid view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed
When User click on image of the product
Then User must be navigated to product "iMac" display page of product
When User click on name of the product
Then User must be navigated to product "iMac" display page of product

@Search @TC_SF_012 @Regression
Scenario: Validate List and Grid views when multiple Products are displayed in the search results

Given User is on the TutorialsNinja home page
When User enters any existing product name "Mac" into the search text box field
And User clicks on button having search icon
Then User must see More than one products should be displayed in the search results page
And User select List option on search page
Then User should see multiple products in the List view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed
When User clicks on every image of the product available in search result and verify user is navigated to same product page
When User clicks on every product name of the product available in search result and verify user is navigated to same product page
And User must clear search fields
When User enters any existing product name "Mac" into the search text box field
And User clicks on button having search icon
And User select Grid option on search page
Then User should see multiple products in the Grid view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed
When User clicks on every image of the product available in search result and verify user is navigated to same product page
When User clicks on every product name of the product available in search result and verify user is navigated to same product page

@Search @TC_SF_013 @Regression
Scenario: Validate navigating to Product Compare Page from Search Results page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User clicks on product compare link
Then User should see success message "Success: You have added iMac to your product comparison!" for added product!
And User clicks on product comparison link
Then User should be navigated to the "Product Comparison" page

@Search @TC_SF_014 @Regression
Scenario: Validate User is able to sort the Products displayed in the Search Results

Given User is on the TutorialsNinja home page
When User enters the search criteria in the "Mac" text box field which can result in mutliple products
And User clicks on button having search icon
Then User must see More than one products should be displayed in the search results page
And User selects several options from the Sort By dropdown and products are sorted according to option selected in the sort by dropdown

@Search @TC_SF_015 @Regression
Scenario: Validate the User can select how many produts can be displayed in the Search Results

Given User is on the TutorialsNinja home page
When User not entered anything into the "" search text box field
And User clicks on button having search icon
And User enters any existing product name "Mac" into the search criteria text box field
And User click on search button
Then User must see More than one products should be displayed in the search results page
And User selects the number of products to be displayed from the show dropdown and products listed on page does not exceeds the selected number from dropdown

@Search @TC_SF_016 @Regression
Scenario: Validate Search textbox field and the button having search icon are displayed on all the page of the Application

Given User is on the TutorialsNinja home page
Then User navigate to all the pages of the Application search box field and the button with Search icon should be displayed on all the page of the Application

@Search @TC_SF_017 @Regression
Scenario: Validate navigating to Search page from the Site Map page

Given User is on the TutorialsNinja home page
When User click on Site Map link in the footer options
And User clicks on Search link from the site map page
Then User should be navigated to search page

@Search @TC_SF_018 @Regression
Scenario: Validate Breadcrumb of the Search page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User is able to see breadcrumb option of searchPage
And Breakcrumb option should be working correctly

@Search @TC_SF_019 @Regression
Scenario: Validate we can use all the options of Search functionality using the Keybaord keys

Given User is on the TutorialsNinja home page
When User press Tab and Enter keys to perform Search operation and select several options in the Search page
Then User should be able to perform Search operation and select several options in the Search page using the Keyboard keys Tab and Enter

@Search @TC_SF_020 @Regression
Scenario: Validate Page Heading, Page URL and Page Title of the Search page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then Proper Page Heading, Page URL and Page Title should be displayed for Search page

@Search @TC_SF_022 @crossBrowser @Regression
Scenario: Validate the Search functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then Search functionality should work in all the supported browser

