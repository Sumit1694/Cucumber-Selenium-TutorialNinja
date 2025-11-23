Feature: Validate WishList functionality

@WishList @TC_WL_001 @Regression
Scenario: Add product to wish list from product listing page

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iMac to your wish list!' should be displayed

@WishList @TC_WL_002 @Regression
Scenario: Add product to wish list from product details page

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
Then Success message with text - 'Success: You have added iMac to your wish list!' should be displayed

@WishList @TC_WL_003 @Regression
Scenario: Verify wish list access without login

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
And User click on wishList link from success message
Then User is redirected to login page

@WishList @TC_WL_004 @Regression
Scenario: Verify Prevent duplicate entries in wish list

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iMac to your wish list!' should be displayed
And User click on wishList link from success message on search page
And User must see single product is added to wishList page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iMac to your wish list!' should be displayed
And User click on wishList link from success message on search page
And User must see single product is added to wishList page

@WishList @TC_WL_005 @Regression
Scenario: Add multiple products to wish list

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iMac to your wish list!' should be displayed
When User clears global search field
And User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iPhone to your wish list!' should be displayed
When User clears global search field
And User enters any existing product name "MacBook" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added MacBook to your wish list!' should be displayed
And User click on wishList link from success message on search page
And User must see all "3" products added to wishList page

@WishList @TC_WL_006 @Regression
Scenario: Remove a product from wish list

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iMac to your wish list!' should be displayed
And User click on wishList link from success message on search page
And User click remove button in wishList page
Then User must see all "0" products added to wishList page

@WishList @TC_WL_007 @Regression
Scenario: Verify removing one product does not affect others

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User search for three product iMac, iPhone and MacBook and adding to wishlist and verifying success message
And User click on wishList link from success message on search page
And User click remove button of first product displayed in wishList page
And User can see only selected product is removed and other two products are remains in the list

@WishList @TC_WL_008 @Regression
Scenario: Verify empty wishlist message

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User search for three product iMac, iPhone and MacBook and adding to wishlist and verifying success message
And User click on wishList link from success message on search page
And User removes all listed products in wishList page
Then User must see "Your wish list is empty." message

@WishList @TC_WL_009 @Regression
Scenario: Verify product details in wishList

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
Then Success message with text - 'Success: You have added iPhone to your wish list!' should be displayed
And User click on wishList link from success message on search page
And User can see img of product, product name, model, stock, unit price, action buttons

@WishList @TC_WL_010 @Regression
Scenario: Verify wish list link from header

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User click on wish list icon in header
Then User is redirected to wishList page

@WishList @TC_WL_011 @Regression
Scenario: Verify wish list counter updates

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
Then User will see if wishList header count is getting increased after product is added
And User will see if wishList header count is getting decresed after removing products from wishlist

@WishList @TC_WL_012 @Regression
Scenario: Verify wish list persistence after logout/login

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
When User clicks on My Account Drop menu on MyAccountPage
And User clicks on logout option
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User click on wish list icon on header section
And User must see all "1" products added to wishList page

@WishList @TC_WL_013 @Regression
Scenario: Verify new user has empty wish list

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Register option
And User enters mandatory registration details into fields
And User clicks on continue button on register account page
And User click on wish list icon in header
Then User must see "Your wish list is empty." message

@WishList @TC_WL_014 @Regression
Scenario: Verify add-to-wish-list after login redirect

Given User is on the TutorialsNinja home page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
And User click on wishList link present in success message on search page
And User enter "abcvda21@gmail.com" into email field
And User enter "abcvda21@gmail" into password field
And User click on login button
And User must see all "1" products added to wishList page

@WishList @TC_WL_015 @Regression
Scenario: Move product from wish list to cart

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
And User click on wishList link from success message on search page
And User click add to cart button for product added in wishlist
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed

@WishList @TC_WL_016 @Regression
Scenario: Verify product remains in wish list after add-to-cart

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iPhone" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
And User click on wishList link from success message on search page
And User click add to cart button for product added in wishlist
Then Success message with text - 'Success: You have added iPhone to your shopping cart!' should be displayed
And User can see img of product, product name, model, stock, unit price, action buttons

@WishList @TC_WL_017 @Regression
Scenario: Add out-of-stock product from wish list

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User enters any existing product name "iMac" into the search text box field
And User clicks on button having search icon
And User click on add to wishList button from product listing page
And User click on wishList link from success message on search page
Then Add to cart button must be disabled for out of stock product on my wishlist page