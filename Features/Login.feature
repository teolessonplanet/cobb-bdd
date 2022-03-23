Feature: Login

Background:
Given User goes to "Home" page
When User clicks on the Sign In button from Header
Then "Sign in to Lesson Planet" modal is displayed

Scenario: Login with invalid credentials
Given User enters username and password
	| username | test |
	| password | test |		
When User clicks on Sign In button from Login Modal
Then Invalid Error Login notification "Invalid login or password." is displayed

Scenario Outline: Login with <siteLicense> credentials
When User enters UserName as "<email>" and Password as "<password>"	
And User clicks on Sign In button from Login Modal
Then Username "<username>" is displayed in the header dropdown

Examples:

|siteLicense| email | password | username |
|QA Custom| i_o_csl_qa_custom@lp.com | test123 | Michelle T. |
|SBCEO | i_o_rsl_sbceo@lp.com | test123 | Connor K. |
|Henry | i_o_csl_henry@lp.com | test123 | Henry T. |