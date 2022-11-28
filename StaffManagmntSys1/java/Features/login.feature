Feature: Login Tests

#Login to Staff Managmnt Systm
Scenario Outline: Login to nestsquare

Given user is already on Login Page
When user enters "<username>" and "<password>"
And user clicks on login button
Then user is on home page


Examples:
	| username | password |
	| S0075  | Abc!@1 | 	
		