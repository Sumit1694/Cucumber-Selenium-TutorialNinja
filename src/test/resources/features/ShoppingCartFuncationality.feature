Feature: Validate Shopping cart functionality

@ShoppingCart @TC_SC_001 @Regression
Scenario: Add single product to cart from product listing

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed
When User click on shopping cart link in displayed success message in searchPage
Then User can see product is added in shopping cart

@ShoppingCart @TC_SC_002 @Regression
Scenario: Add product to cart from product detail page

Given User is on the TutorialsNinja home page
When User enters any existing product name "MacBook" into the search text box field
And User clicks on button having search icon
And User click on product name displayed in search result
Then User must see product title and price of the searched product
And User click on add to cart button for searched product product display page
Then Success message with text - 'Success: You have added MacBook to your shopping cart!' should be displayed
When User click on shopping cart link in displayed success message in searchPage
Then User can see product is added in shopping cart
And User can see correct price for this product

@ShoppingCart @TC_SC_003 @Regression
Scenario: Add product without login

Given User is on the TutorialsNinja home page
When User enters any existing product name "samsung galaxy" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for samsung galaxy product in search page
Then Success message with text - 'Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart!' should be displayed
When User click on shopping cart link in displayed success message in searchPage
Then User can see product is added in shopping cart

@ShoppingCart @TC_SC_004 @Regression
Scenario: Add multiple products to cart

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User search for three product iPhone, MacBook, samsung galaxy and adding to cart and verifying success message
When User click on shopping cart link in displayed success message in searchPage
Then User can see all three products are listed in shopping cart with quantity one each

@ShoppingCart @TC_SC_005 @Regression
Scenario: Add same product multiple times

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for iPhone product in search page
And User clear search field existing text
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for iPhone product in search page
When User click on shopping cart link in present in success message in searchPage
Then User can see only single product is added in cart with quantity two

@ShoppingCart @TC_SC_006 @Regression
Scenario: Add product with quantity from product page

Given User is on the TutorialsNinja home page
When User enters any existing product name "MacBook" into the search text box field
And User clicks on button having search icon
And User click on product name displayed in search result
And User increased quantity of MacBook to "3" in product display page
And User click on add to cart button for MacBook product in product display page
When User click on shopping cart link in present in success message in searchPage
Then User can see only single product is added in cart with quantity three

@ShoppingCart @TC_SC_007 @Regression
Scenario: Verify Out of Stock product cannot be added

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on product name displayed in search result
Then User can see availability as out of stock then user cannot add product product to cart or error message should be displayed!

@ShoppingCart @TC_SC_008 @Regression
Scenario: Verify cart displays correct product details

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
When User click on shopping cart link in present in success message in searchPage
Then User must see proper image visible, product name link, unit price, quantity field, line total.
And User must see currency symbol as well

@ShoppingCart @TC_SC_009 @Regression
Scenario: Verify product total calculation

Given User is on the TutorialsNinja home page
When User enters any existing product name "MacBook" into the search text box field
And User clicks on button having search icon
And User click on product name displayed in search result
And User increased quantity of MacBook to "3" in product display page
And User click on add to cart button for MacBook product in product display page
When User click on shopping cart link in present in success message in searchPage
Then User can see 3x price of MacBook product

@ShoppingCart @TC_SC_010 @Regression
Scenario: Verify grand total calculation with multiple products

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
And User clear search field existing text
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
Then User can see correct Grand Total price of products added in shopping cart

@ShoppingCart @TC_SC_011 @Regression
Scenario: Verify update quantity in cart

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
And User update quantity from 1 to 5 from quantity text box
And User click on update button
Then Success message with text - 'Success: You have modified your shopping cart!' should be displayed in shopping cart page
And User can see recalculated price according to quantity updated

@ShoppingCart @TC_SC_012 @Regression
Scenario: Verify Update quantity to zero

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
And User update quantity from 1 to 0 from quantity text box
And User click on update button
Then User can see "Your shopping cart is empty!" message

@ShoppingCart @TC_SC_013 @Regression
Scenario: Verify Update with invalid characters

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
And User update quantity from 1 to "abc" from quantity text box
And User click on update button
Then User can see "Your shopping cart is empty!" message

@ShoppingCart @TC_SC_014 @Regression
Scenario: Verify Remove a product

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for searched product
Then Success message with text - 'Success: You have added iMac to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
And User remove product from cart
Then User can see "Your shopping cart is empty!" message

@ShoppingCart @TC_SC_015 @Regression
Scenario: Verify Remove a product

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for iPhone product in search page
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed
And User clear search field existing text
When User enters any existing product name "MacBook" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for MacBook product in search page
Then Success message with text - 'Success: You have added MacBook to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
And User removes all listed products in shopping cart
Then User can see "Your shopping cart is empty!" message

@ShoppingCart @TC_SC_016 @Regression
Scenario: Verify empty cart message

Given User is on the TutorialsNinja home page
When User click on shopping cart header link
Then User can see "Your shopping cart is empty!" message

@ShoppingCart @TC_SC_017 @Regression
Scenario: Verify navigation to product page from cart

Given User is on the TutorialsNinja home page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for iPhone product in search page
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed
When User click on shopping cart link in present in success message in searchPage
And User click on product name link in shopping cart
Then Verify navigation to the product detail page and product name matches.

@ShoppingCart @TC_SC_023 @Regression
Scenario: Verify cart persistence after logout/login

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to cart button for iPhone product in search page
When User clicks on My Account Drop menu on MyAccountPage
And User clicks on logout option
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on shopping cart header link after loggedIn
Then User can see product is added in shopping cart

@ShoppingCart @TC_SC_025 @Regression
Scenario: Verify cart persistence after logout/login

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters mandatory registration details into fields
And User clicks on continue button on register account page
And User click on shopping cart header link
Then User can see "Your shopping cart is empty!" message

@ShoppingCart @TC_SC_031 @Regression
Scenario: Verify adding large quantity

Given User is on the TutorialsNinja home page
When User enters any existing product name "MacBook" into the search text box field
And User clicks on button having search icon
And User click on product name displayed in search result
And User increase quantity for MacBook to one thousand
And User click on add to cart button for MacBook product in product display page
When User click on shopping cart link in present in success message in searchPage
Then User can see high quantity is getting accepted