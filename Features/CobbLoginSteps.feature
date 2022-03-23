Feature: Cobb Login

Scenario: Login with Cobb Credentials
Given User goes to "Home" page
When User clicks on the Sign In button from Header
Then "Sign in to Lesson Planet" modal is displayed
When User enters UserName as "i_o_csl_cobb@lp.com" and Password as "test123"	
And User clicks on Sign In button from Login Modal
Then Username "Jane M." is displayed in the header dropdown