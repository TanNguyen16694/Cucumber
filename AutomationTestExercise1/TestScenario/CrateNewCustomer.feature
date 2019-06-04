Feature: Create New Customer

Scenario: Verify New Customer can be created
		Given A user login system successfully
		When User Click menu Create New Customer 
		Then User is taken to Create New Customer Page
		When User input all valid information of and click button create
		Then New Customer be able to create successfully
		

		