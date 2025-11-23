Feature: validate affiliate account functionality

@AffiliateAccount @TC_AF_001 @Regression
Scenario: Verify that user can navigate to Affiliate Account page from My Account

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
Then User should be redirected to Affiliate Account page

@AffiliateAccount @TC_AF_003 @Regression
Scenario: Verify that submitting empty form displays appropriate validation messages

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User click continue without entering details
Then User should see validation messages should be shown for all required fields

@AffiliateAccount @TC_AF_004 @Regression
Scenario: Verify successful Affiliate registration with valid details

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User enters all valid details into all the fields
Then User should see confirmation message Your Affiliate Account has been successfully created.

@AffiliateAccount @TC_AF_005 @Regression
Scenario: Verify that user cannot register Affiliate account without accepting Terms & Conditions

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User enters all valid details into all the fields excepts accepting Terms and conditions
Then User should see appropriate validation message for tearms and conditions

@AffiliateAccount @TC_AF_006 @Regression
Scenario: Verify Tax ID field does not accept special characters

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
Then User enters special characters in Tax field and fill all other details

@AffiliateAccount @TC_AF_007 @Regression
Scenario: Verify that Company Name accepts up to 50 characters

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
Then User enters company name of 50 characters and form should be submitted successfully

@AffiliateAccount @TC_AF_008 @Regression
Scenario: Verify system behavior when Company Name exceeds 50 characters

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
Then User enters company name of more than 50 characters and form should be submitted successfully

@AffiliateAccount @TC_AF_009 @Regression
Scenario: Verify user can update Affiliate details after registration

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User will fill all data into affiliate Account fields and success message will be displayed
Then User will click edit affiliate account information link and chnage payment method and success message will be displayed

@AffiliateAccount @TC_AF_010 @Regression
Scenario: Verify that user can change payment method between Bank Transfer, PayPal, and Cheque

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User will fill all data into affiliate Account fields and success message will be displayed
Then User will click edit affiliate account information link also user can change payment method everytime and get success message will be displayed

@AffiliateAccount @TC_AF_011 @Regression
Scenario: Verify that Bank Transfer option requires all mandatory bank details

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
Then User fill all fields in affiliate account page where payment method should be bank transfer and some fields of bank transfer must be empty and continue

@AffiliateAccount @TC_AF_012 @Regression
Scenario: Verify that valid PayPal Email is accepted

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User fill all fields in affiliate account page where payment method should be paypal with valid emailID and submit

@AffiliateAccount @TC_AF_013 @Regression
Scenario: Verify that invalid PayPal Email shows error message

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User fill all fields in affiliate account page where payment method should be paypal with invalid emailID and submit

@AffiliateAccount @TC_AF_015 @Regression
Scenario: Verify that Affiliate Tracking link generates a valid tracking code

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User enters all valid details into all the fields
Then User click Custom Affiliate Tracking Code link present under affiliate section and copy the valid tracking code

@AffiliateAccount @TC_AF_017 @Regression
Scenario: Verify that clicking continue on confirmation redirects user to My Account page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
When User click on register for an affiliate account link
And User should be redirected to Affiliate Account page
And User fill all fields in affiliate account page where payment method should be paypal with valid emailID and submit
Then User should be on my Account page