Feature: Create New Deposit

Scenario: Verify New Deposit can be created
		Give User have created Deposit
		When User click menu Deposit
		Then User is taken to Create New Deposit Page
		When User input all valid information of deposit and click button create
		Then New Deposit be able to crate successfully