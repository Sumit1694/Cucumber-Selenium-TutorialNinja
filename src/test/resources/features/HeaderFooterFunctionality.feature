Feature: Verify Header and Footer functionality

@HeaderFooter @TC_HF_001 @Regression
Scenario: Verify presence of logo in the header

Given User is on the TutorialsNinja home page
Then Application logo should be visible in header

@HeaderFooter @TC_HF_002 @Regression
Scenario: Verify clicking logo navigates to Home Page

Given User is on the TutorialsNinja home page
When User click on about us link which takes user to page about us
And User click on logo
Then User is landed to homePage

@HeaderFooter @TC_HF_003 @Regression
Scenario: Verify Search box presence in header

Given User is on the TutorialsNinja home page
Then Search box should be visible in header

@HeaderFooter @TC_HF_004 @Regression
Scenario: Verify search functionality with valid product name

Given User is on the TutorialsNinja home page
Then User enter valid product in search box field and user must gets same product on search result

@HeaderFooter @TC_HF_005 @Regression
Scenario: Verify search functionality with invalid product name

Given User is on the TutorialsNinja home page
Then User enter invalid product in search box field and user must get no product found in search result message

@HeaderFooter @TC_HF_006 @Regression
Scenario: Verify Cart icon visibility

Given User is on the TutorialsNinja home page
Then User see cart icon displayed in header cart section

@HeaderFooter @TC_HF_007 @Regression
Scenario: Verify clicking Cart icon redirects to Shopping Cart page

Given User is on the TutorialsNinja home page
When User click on cart icon present in header
Then User should see a small dropdown should appear showing cart summary or your shopping cart is empty! message

@HeaderFooter @TC_HF_008 @Regression
Scenario: Verify dropdown items under Desktops menu

Given User is on the TutorialsNinja home page
Then User should see deskTop menu option verify suboptions

@HeaderFooter @TC_HF_009 @Regression
Scenario: Verify dropdown items under Laptops & Notebooks menu

Given User is on the TutorialsNinja home page
Then User should see Dropdown macs and windows suboptions

@HeaderFooter @TC_HF_010 @Regression
Scenario: Verify clicking Show All option under each category

Given User is on the TutorialsNinja home page
Then User should see Dropdown showAll options for each category

@HeaderFooter @TC_HF_011 @Regression
Scenario: Verify current page highlighting on menu

Given User is on the TutorialsNinja home page
Then User should see components Dropdown colour is highlighted when hoverover

@HeaderFooter @TC_HF_012 @Regression
Scenario: Verify My Account dropdown options

Given User is on the TutorialsNinja home page
Then User should see Login and register dropdown option in my Account dropdown

@HeaderFooter @TC_HF_013 @Regression
Scenario: Verify navigation from Login link in My Account dropdown

Given User is on the TutorialsNinja home page
Then User click on My Account Login option and user should be redirected to login page

@HeaderFooter @TC_HF_014 @Regression
Scenario: Verify presence of footer section

Given User is on the TutorialsNinja home page
Then User should see footer is visible at below of the page

@HeaderFooter @TC_HF_015 @Regression
Scenario: Verify Information section links in footer

Given User is on the TutorialsNinja home page
Then User should see links like About Us, Delivery Information, Privacy Policy, Terms & Conditions should be present

@HeaderFooter @TC_HF_016 @Regression
Scenario: Verify footer customer Service section links

Given User is on the TutorialsNinja home page
Then User should see links like Contact Us, Returns, Site Map should be present

@HeaderFooter @TC_HF_017 @Regression
Scenario: Verify Contact Us link navigation

Given User is on the TutorialsNinja home page
When User click on contact us in footer section
Then User should be redirected to Contact page

@HeaderFooter @TC_HF_018 @Regression
Scenario: Verify Returns link navigation

Given User is on the TutorialsNinja home page
When User click on returns in footer section
Then User should be redirected to returns page

@HeaderFooter @TC_HF_020 @Regression
Scenario: Verify copyright text

Given User is on the TutorialsNinja home page
Then User must see copyright text Correct year and brand name in footer section