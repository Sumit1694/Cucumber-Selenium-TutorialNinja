Feature: validate Gift certificate functionality

@GiftCertificate @TC_GC_001 @Regression
Scenario: Navigate to Purchase Gift Certificate page

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page

@GiftCertificate @TC_GC_002 @Regression
Scenario: Verify mandatory fields marked with star in red

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
And User should see all the mandatory fields have star mark with red colour

@GiftCertificate @TC_GC_003 @Regression
Scenario: Verify default Theme selection

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
And User should see a default theme Birthday or first option is selected by default

@GiftCertificate @TC_GC_004 @Regression
Scenario: Verify validation when required field left blank

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
When User fill all details in gift certificate page and leave Recipients Name field blank
Then verify warning message for Recipients Name field

@GiftCertificate @TC_GC_005 @Regression
Scenario: Verify validation for invalid email address

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
When User fill all details in gift certificate page but recipient email is invalid
Then verify warning message for Recipients Email field

@GiftCertificate @TC_GC_006 @Regression
Scenario: Verify minimum amount validation

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
When User fill all details in gift certificate page but amount is zero
Then verify warning message for amount field

@GiftCertificate @TC_GC_007 @Regression
Scenario: Verify successful gift certificate creation

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
When User fill all details in gift certificate page
Then verify success message for gift certificate

@GiftCertificate @TC_GC_008 @Regression
Scenario: Verify gift certificate appears in shopping cart

Given User is on the TutorialsNinja home page
When Click Gift Certificates from footer/extras
Then User should be taken to Gift Certificate page
When User fill all details in gift certificate page
Then verify success message for gift certificate
And User click continue button on purchase gift certificate page
And User must see gift certificate added to shopping cart with valid amount

