
Feature: Login to the application
  I want to use this template for my feature file


  #Scenario Outline: Login to app
   #Given user is already on Login Page
#When user enters "<username>" and "<password>"
#And user clicks on login button
#Then user is on home page
#
#
#Examples:
#	| username | password |
#	| S0075  | Abc!@1 |

	
	  Scenario Outline: Add Staff
	  Given user is already on Login Page
And user enters "<username>" and "<password>" 
And user clicks on login button
And lands on the dashboard
When user selects Staff Profile Management
And user enters the staff details from <addStaff> in <RowNumber> sheet
Then user details are updated suuceesfully


Examples:
	|username|password| addStaff | RowNumber |
	|S0075| Abc!@1  |staffData| 1 |
