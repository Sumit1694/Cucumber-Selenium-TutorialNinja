Feature: verify currency functionality

@currencyFunctionality @TC_CR_001 @Regression
Scenario: Validate the complete functionality of the Application by selecting Euro currency

Given User is on the TutorialsNinja home page
Then User changes currency to Euro and see complete application is changes into Euros

@currencyFunctionality @TC_CR_002 @Regression
Scenario: Validate the complete functionality of the Application by selecting pounds currency

Given User is on the TutorialsNinja home page
Then User changes currency to pounds and see complete application is changes into pounds

@currencyFunctionality @TC_CR_003 @Regression
Scenario: Validate the complete functionality of the Application by selecting  currency

Given User is on the TutorialsNinja home page
Then User changes currency to Dollars and see complete application is changes into Dollars