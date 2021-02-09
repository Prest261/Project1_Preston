Feature: Login works

	Scenario Outline: Login and Password works
		Given The user is on the login page
		When the user types "<email>" email
		When the user types "<password>" password
		When the user clicks the login button
		Then the main page button should show up
		
		Examples:
		| email			| password		| main page		|
		| cho@gmail.com	| password1		| main page		|