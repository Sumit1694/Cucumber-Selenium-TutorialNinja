Feature: Validate Product Compare Functionality

@ProductCompare @TC_PC_001 @Regression
Scenario: Validate adding the product for comparision from Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User hover the mouse cursor on Compare this Product option from the displayed Product Display Page
Then Tool tip with the text - "Compare this Product" should be displayed
When User selects Compare this Product option
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When Click on product comparision link from the displayed success message
Then User should be taken to the "Product Comparison" page with the details of the Product "iMac" that we have added for comparision

@ProductCompare @TC_PC_002 @Regression
Scenario: Validate adding the product for comparision from List View of Search Results page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User selects List view option
And User hover the mouse cursor on Compare this Product option from the displayed Product Display Page on search results
Then Tool tip with the text - "Compare this Product" should be displayed on the search page
When User selects Compare this Product option on result page
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When Click on product comparision link from the displayed success message
Then User should be taken to the "Product Comparison" page with the details of the Product "iMac" that we have added for comparision

@ProductCompare @TC_PC_003 @Regression
Scenario: Validate adding the product for comparision from Grid View of Search Results page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User selects Grid view option
And User hover the mouse cursor on Compare this Product option from the displayed Product Display Page on search results
Then Tool tip with the text - "Compare this Product" should be displayed on the search page
When User selects Compare this Product option on result page
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When Click on product comparision link from the displayed success message
Then User should be taken to the "Product Comparison" page with the details of the Product "iMac" that we have added for comparision

@ProductCompare @TC_PC_004 @Regression
Scenario: Validate adding the product for comparision from List View of Product Category or Sub Category page

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And In the displayed desktops category page, select list View option
And Hover the mouse cursor on Compare this Product option available on the Product that is displayed in the Product Category page
Then Tool tip with the text - "Compare this Product" should be displayed on product category page
When User select compare this product option
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When Click on product comparision link from the displayed success message
Then User should be taken to the "Product Comparison" page with the details of the Product that we have added for comparision

@ProductCompare @TC_PC_005 @Regression
Scenario: Validate adding the product for comparision from Grid View of Product Category or Sub Category page

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And In the displayed desktops category page, select grid View option
And Hover the mouse cursor on Compare this Product option available on the Product that is displayed in the Product Category page for grid view
Then Tool tip with the text - "Compare this Product" should be displayed on product category page for grid view
When User select compare this product option on grid view
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When Click on product comparision link from the displayed success message
Then User should be taken to the "Product Comparison" page with the details of the Product that we have added for comparision

@ProductCompare @TC_PC_007 @Regression
Scenario: Validate adding the product for comparision from Featured section on Home Page

Given User is on the TutorialsNinja home page
When Hover the mouse cursor on Compare this Product option from one of the Product displayed in the Featured section of Home Page
Then Tool tip with the text - "Compare this Product" should be displayed for featured Section
When User selects Compare this Product option on featured Section
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When Click on product comparision link from the displayed success message
Then User should be taken to the "Product Comparison" page with the details of the Product that we have added for comparision

@ProductCompare @TC_PC_008 @Regression
Scenario: Validate navigating to Product Compare page from Search results page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
When User clicks on Compare this Product option on searchPage
Then User should be taken to Product Compare page

@ProductCompare @TC_PC_009 @Regression
Scenario: Validate navigating to Product Compare page from Product Category page

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And User clicks on Product compare link on Desktops category page
Then User should be taken to Product Compare page

@ProductCompare @TC_PC_010 @Regression
Scenario: Validate Product Compare page when no products are added for comparison

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And User clicks on Product compare0 link on Desktops category page
Then User "You have not chosen any products to compare." should be displayed on product comparison page

@ProductCompare @TC_PC_011 @Regression
Scenario: Validate  the working of Continue button on the Product Compare page

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And User clicks on Product compare0 link on Desktops category page
And USer clicks on continue button
Then User should be navigated to Homepage

@ProductCompare @TC_PC_012 @Regression
Scenario: Validate the Breadcrumb that is displayed on the Product Compare page

Given User is on the TutorialsNinja home page
When User mouse hover on any menu say Desktops and select Show All Desktops option
And User clicks on Product compare0 link on Desktops category page
Then Check working of breadCrumb on product compare page

@ProductCompare @TC_PC_013 @Regression
Scenario: Validate the success message which will be displayed after adding the Products for Comparison

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product name in search result
And User select Compare this Product option on Product Display Page
Then Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When User click on the Product Name link in the success message
Then User should be navigated to the respective product page
And User select Compare this Product option on Product Display Page
When User click on the Product Comparison link in the displayed success message
Then User should be taken to Product Compare page

@ProductCompare @TC_PC_014 @Regression
Scenario: Validate the Product Comparison page when only one product is added to the page for comparison

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product name in search result
And User select Compare this Product option on Product Display Page
When User click on the Product Comparison link in the displayed success message
Then User should be taken to Product Compare page
And User should able to see single product is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons

@ProductCompare @TC_PC_015 @Regression
Scenario: Validate the Product Comparison page when only two products are added to the page for comparison

Given User is on the TutorialsNinja home page
When user add two products in product comparison and see success message for added successfully
When User click on the Product Comparison link in the displayed success message on search page
Then User should able to see two products is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons

@ProductCompare @TC_PC_016 @Regression
Scenario: Validate the Product Comparison page when the same product is added twice to the page for comparison

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User clicks on compare this product option in search result page
And Success message with text - Success: You have added Product Name to your product comparison! should be displayed
And User clicks on button having search icon
And User clicks on compare this product option in search result page
When Click on product comparision link from the displayed success message in search page
And Validate that the product shoud be displayed in the Product Comparison page only one with all the proper product details and the buttons (Add to Cart and Remove buttons)

@ProductCompare @TC_PC_017 @Regression
Scenario: Validate the Product Comparison page when three products are added to the page for comparison

Given User is on the TutorialsNinja home page
When User add three products to product comparison and verify success messages
When User click on the Product Comparison link in the displayed success message on search page
Then User should able to see three products is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons

@ProductCompare @TC_PC_018 @Regression
Scenario: Validate the Product Comparison page when four products are added to the page for comparison

Given User is on the TutorialsNinja home page
When User add four products to product comparison page and verify success message
When User click on the Product Comparison link in the displayed success message on search page
Then User should able to see four products is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons

@ProductCompare @TC_PC_019 @Regression
Scenario: Validate that more than four products cannot be added to the Product Comparison page

Given User is on the TutorialsNinja home page
When User add five products in product comparison and verify success message
When User click on the Product Comparison link in the displayed success message on search page
Then Validate that lastest four products - Second Product Name to Fifth Product Name are displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons and the First added Product is automatically removed from the Product Comparison page as it allows only four products for comparision.

@ProductCompare @TC_PC_020 @Regression
Scenario: Validate adding the Products to cart from the Product Comparison page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User clicks on compare this product option in search result page
And Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When User click on the Product Comparison link in the displayed success message on search page
And User click on Add to Cart button of the Product from the Product Comparison page
And Success message with text - Success: You have added Product Name to your product comparison! should be displayed
And User click on shopping Cart link from displayed success message
Then validate that the products are successfully added to the Shopping Cart page from the Product Compare page.

@ProductCompare @TC_PC_021 @Regression
Scenario: Validate removing the Products from the 'Product Comparison' page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User clicks on compare this product option in search result page
And Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When User click on the Product Comparison link in the displayed success message on search page
And User click on Remove button of the Product from the Product Comparison page
And Success message with text - Success: You have modified your product comparison! should be displayed

@ProductCompare @TC_PC_022 @Regression
Scenario: Validate Page Title, Page Heading and Page URL of the Product Comparison page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User clicks on compare this product option in search result page
And Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When User click on the Product Comparison link in the displayed success message on search page
Then User check the Page Title, Page Heading and Page URL of the displayed Product Comparison page

@LoginAccount @TC_PC_024 @crossBrowser @Regression
Scenario: Validate the Product Comparison functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
Then User clicks on compare this product option in search result page
And Success message with text - Success: You have added Product Name to your product comparison! should be displayed
When User click on the Product Comparison link in the displayed success message on search page
Then User check the Page Title, Page Heading and Page URL of the displayed Product Comparison page