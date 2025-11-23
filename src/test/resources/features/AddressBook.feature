Feature: verify address book functionality

@addressBook @TC_AB_001 @Regression
Scenario: Validate navigation to Address Book page

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
Then User should be navigated to the Address Book page successfully

@addressBook @TC_AB_002 @Regression
Scenario: Verify presence of page heading

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
Then User should see Address Book Entries page heading

@addressBook @TC_AB_003 @Regression
Scenario: Verify presence of Add New Address button

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
Then User should see new address button in address book page

@addressBook @TC_AB_004 @Regression
Scenario: Validate adding a new address with valid details

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button
And User fill all details of new address in add address page
And User click continue btn on add address page
Then User should see success message Your address has been successfully added appeared

@addressBook @TC_AB_005 @Regression
Scenario: Validate mandatory field validations

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
Then User should see validation message for all the mandatory fields

@addressBook @TC_AB_006 @Regression
Scenario: Validate postcode field with invalid input

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details with invalid postcode field of new address in add address page
And User click continue btn on add address page
Then User should see correct error message of invalid postcode field

@addressBook @TC_AB_007 @Regression
Scenario: Validate address length constraint

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details with adress length exceeds max limit
And User click continue btn on add address page
Then User should see correct Error message indicating max length exceeded

@addressBook @TC_AB_009 @Regression
Scenario: Validate editing an existing address

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click Edit option in address book page
And User modify city field
And User click continue btn on add address page
Then User can see success message Your address has been successfully updated should appear

@addressBook @TC_AB_010 @Regression
Scenario: Validate cancel operation on edit address

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click Edit option in address book page
Then User updates city field and navigates back and come back to same page then city field should not be updated

@addressBook @TC_AB_011 @Regression
Scenario: Validate deleting an existing address

Given User is on the TutorialsNinja home page
When User clicks on My Account Drop menu
And User Selects Login option
And User enters valid email address "abcvda21@gmail.com" into email field
And User enters valid password "abcvda21@gmail" into password field
And User clicks on login button
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click delete option in address book page
Then User can see success message Your address has been successfully deleted in the address book page

@addressBook @TC_AB_012 @Regression
Scenario: Validate system prevents deleting default address

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click delete option of default address in address book page

@addressBook @TC_AB_013 @Regression
Scenario: Validate setting a new default address

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
Then User Edit newly added address and select as default address radio button and click continue

@addressBook @TC_AB_014 @Regression
Scenario: Verify only one default address is active

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User delete all address only default one should be remaining

@addressBook @TC_AB_015 @Regression
Scenario: Validate error message format and color

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User delete all address only default one should be remaining

@addressBook @TC_AB_017 @Regression
Scenario: Validate error message format and color

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User click new address button when new account created
And User fill all details of new address in add address page
And User click continue btn on add address page
And User should able to see newly added address in address book

@addressBook @TC_AB_019 @Regression
Scenario: Validate breadcrumb navigation

Given User is on the TutorialsNinja home page
When User creates new account and landed on my Account page
And User clicks on address book right column option
Then User click on breadcrumb verify page is refreshed and User remains on same page


