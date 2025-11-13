Feature: Validate product display functionality

@ProductDisplay @TC_PD_001 @Regression
Scenario: Validate the Thumbnails of the Product displayed in the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on the main bigger sized Thumbnail image displayed on the Product Display Page
Then Light box view of the main Thumnail image should be displayed with options to view the previous and next Thumnail images in Light box view.
When User click on left arrow key
Then Previous image of product should be displayed
When User click on x option
Then Light box view should close and the focus should go to the Product Display Page
And User click on the main bigger sized Thumbnail image displayed on the Product Display Page
When User press Esc key when thumbnails are displayed in light box view
Then Light box view should close and the focus should go to the Product Display Page

@ProductDisplay @TC_PD_002 @Regression
Scenario: Validate that Product Name, Brand and Product Code are displayed in the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then Proper Product Name, Brand and Product Code should be displayed for the different types of Products in the Product Display Page.

@ProductDisplay @TC_PD_003 @Regression
Scenario: Validate the availabilty status of the Product in the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then Proper avaialabilty statuses like In Stock, Out of Stock and Limited Stock should be displayed in the Availabilty section of the Product Display Page for the different types of Products.

@ProductDisplay @TC_PD_004 @Regression
Scenario: Validate the Price of the Product with and without tax is displayed in the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then Proper price with and without tax should be displayed for the different types of Products in the Product Display Page.

@ProductDisplay @TC_PD_005 @Regression
Scenario: Validate the default quanity for the Product is displayed as 1 in the Product Display Page, when there is no minimum quantity set for the Product

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And Check the Qty text field in the Product Display Page
Then Default quantity should be displayed one for this product which has not minimum quantity set
When Update the quantity by increasing it to more than one and click on Add to Cart button
Then Quantity should get updated accordingly and the User should be able to add the Product to cart without any issues.

@ProductDisplay @TC_PD_006 @Regression
Scenario Outline: Validate that negative, zero, or null quantity values should not be allowed on the Product Display Page

Given User is on the TutorialsNinja home page
Then User search product and verify by adding quantity to zero, negative or null then warning message should be displayed

@ProductDisplay @TC_PD_008 @Regression
Scenario: Validate the description of the Product in the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on description tab on product display page
Then Correct Description of the product without any spelling or grammatical mistakes should be displayed for different types of Products.

@ProductDisplay @TC_PD_009 @Regression
Scenario: Validate the specifications of the Product in the Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "Apple Cinema 30" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User Click on the Specification tab of the Product in the displayed Product Display page
Then Correct Specifications of the product without any spelling or grammatrical mistakes should be displayed for different types of Products.

@ProductDisplay @TC_PD_010 @Regression
Scenario: Validate the User is able to write a review for the Product from the Reviews tab of Product Display Page

Given User is on the TutorialsNinja home page
When User enters any existing product name "Apple Cinema 30" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User Click on the review tab of the Product in the displayed Product Display page
And User enter name in name text field
And User enter review text into the Your Review text are field
And User selects any rating radio button
And User click on continue button
Then User Success message with text - "Thank you for your review. It has been submitted to the webmaster for approval." should be displayed.

@ProductDisplay @TC_PD_011 @Regression
Scenario: Validate the Reviews tab when there are no reviews or zero reviews added

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User Click on the review tab of iMac Product in the displayed Product Display page
Then User must see "There are no reviews for this product." message under review Tab

@ProductDisplay @TC_PD_012 @Regression
Scenario: Validate all the fields in the Review tab are mandatory fields

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User Click on the review tab of iMac Product in the displayed Product Display page
Then User must see all the fields in the Reviews tab are mandatory.

@ProductDisplay @TC_PD_013 @Regression
Scenario: Validate Write a review link under Add to Cart button on the Product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then User click on write a review link under add to cart button of the product display page then review tab should come to focus

@ProductDisplay @TC_PD_014 @Regression
Scenario: Validate Write a review link under Add to Cart button on the Product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then User must see the correct average reviews and number of reviews count under Add to cart button

@ProductDisplay @TC_PD_015 @Regression
Scenario: Validate the count of reviews should be displayed in the Reviews tab label of the Product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then User must see the correct reviews count under reviews tab of product display page

@ProductDisplay @TC_PD_016 @Regression
Scenario: Validate submitting a review without filling the mandatory fields

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on review tab on product display page
And User click on continue button without providing Name, Your Review and Ratings and click on continue button
Then Proper warning messages informing the User to fill the mandatory fields to submit the review should be displayed.

@ProductDisplay @TC_PD_017 @Regression
Scenario: Validate the review text given while writing is accepted according to the specified number of characters

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on review tab on product display page
And User provide Name and Ratings
And User click on continue button
Then Proper warning message with the text - Warning: Review Text must be between twentyfive and thousand characters! should be displayed

@ProductDisplay @TC_PD_018 @Regression
Scenario: Validate adding the product to Wish List from the Product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on Add to Wish List option in the displayed Product Display page
Then Success message with text - Success: You have added Product Name to your wish list! is displayed
When User click on wish list link in the success message
And User must log in with credentials email "abcvda21@gmail.com" and password "abcvda21@gmail" of page
Then User should be taken to Wish List page and the product added is displayed in the Wish List page

@ProductDisplay @TC_PD_019 @Regression
Scenario: Validate adding the product to Wish List from the Product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on Add to Wish List option in the displayed Product Display page
Then Success message with text - Success: You have added Product Name to your wish list! is displayed
When User click on wish list link in the success message
And User must log in with credentials email "abcvda21@gmail.com" and password "abcvda21@gmail" of page
Then User should be taken to Wish List page and the product added is displayed in the Wish List page

@ProductDisplay @TC_PD_022 @Regression
Scenario: Validate related products section in product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on the Related Products section in the displayed Product Display Page
Then User should see the Product displayed in the Related Products section and is able ot click it and navigate to the Product Display Page of it.

@ProductDisplay @TC_PD_023 @Regression
Scenario: Validate navigating to the Product Display page by using the Product image in the Wish List page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to wishList button
And User click on Wishlist header option
And User click on the Image icon displayed under the Image section of the displayed Wish List page
Then User should be taken the Product Display page of the Product that is displayed in the Wish List page

@ProductDisplay @TC_PD_024 @Regression
Scenario: Validate navigating to the Product Display page by using the Product Name link in the Wish List page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to wishList button
And User click on Wishlist header option
And User click on the Product Name link displayed under the Product Name section of the displayed Wish List page
Then User should be taken the Product Display page of the Product that is displayed in the Wish List page

@ProductDisplay @TC_PD_025 @Regression
Scenario: Validate navigating to the Product Display page by using the Product Name link in Success message on adding the Product to Cart

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to cart button
And User click on Product Name link from the displayed success page
Then User should be taken to the Product Display page of the Product

@ProductDisplay @TC_PD_026 @Regression
Scenario: Validate navigating to the Product Display page by using the Product Image in the Shopping Cart page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to cart button
And User click on Shopping cart link from the displayed success page
And User click on the Product image from the displayed Shopping Cart page
Then User should be taken to the Product Display page of the Product

@ProductDisplay @TC_PD_027 @Regression
Scenario: Validate navigating to the Product Display page by using the Product Name link in the Shopping Cart page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to cart button
And User click on product name link from the displayed success page
Then User should be taken to the Product Display page of the Product

@ProductDisplay @TC_PD_029 @Regression
Scenario: Validate navigating to the Product Display page by using the Product Image in the 'Cart' button toggle box

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "HP LP3065" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to cart button
And User click on cart button which is in black color beside the search icon button on the top of the page
And User click on the Product Image in the displayed toggle box
Then User should be taken to the Product Display page of the Product

@ProductDisplay @TC_PD_030 @Regression
Scenario: validate navigating to the Product Display page by using the Product Name link in the cart button toggle box

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "HP LP3065" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User click on add to cart button
And User click on cart button which is in black color beside the search icon button on the top of the page
And User click on the Product name link in the displayed toggle box
Then User should be taken to the Product Display page of the Product

@ProductDisplay @TC_PD_031 @Regression
Scenario: Validate the Reward Points displayed in the Product Display page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "Apple Cinema 30" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then User must see correct reward points are displyed in displayed product display page

@ProductDisplay @TC_PD_032 @Regression
Scenario: Validate the original price of the Product without offer in the Product Display page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "Apple Cinema 30" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
Then User must see original price of product without offer as strike off in the displayed product display page

@ProductDisplay @TC_PD_033 @Regression
Scenario: Validate the prices of the Product when purchased in bulk

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "Samsung Galaxy Tab 10.1" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User will update the quantity as ten
And click on Add to cart button
Then User should see 10X price of product under cart bar

@ProductDisplay @TC_PD_035 @Regression
Scenario: Validate Page Title, Page Heading and Page URL of the Product Display page

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User must see correct the Page Title, Page Heading and Page URL of the displayed Product Display page

@ProductDisplay @TC_PD_037 @crossBrowser @Regression
Scenario: Validate the Product Display page functionality in all the supported environments

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User must click on displayed product in search result
And User must see correct the Page Title, Page Heading and Page URL of the displayed Product Display page