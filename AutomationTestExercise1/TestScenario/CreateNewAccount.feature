Feature: Create New Account

Scenario: Verify New Account can be created
		Give User have created Customer
		When User click menu Create Account
		Then User is taken to Create New Account Page
		When User input all valid information and click button create
		Then New Account be able to crate successfully