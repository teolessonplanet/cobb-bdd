Feature: Cobb Collection Builder

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"

Scenario Outline:  Collection Builder appearance on "<page>" page
When User goes to "<page>" page
Then Collection Builder is displayed
And My Resources button is displayed on "<page>" page
And Start Building button is displayed on "<page>" page
And Select Existing button is displayed
When User clicks on the "Select Existing" button from collection builder
And User chooses a collection
Then Edit button is displayed
When User clicks on the "Edit" button from collection builder
Then "Edit Folder" modal is displayed
And User closes the Edit Folder Modal
When On "<page>" page, user clicks on My Resources button
Then "Curriculum Manager" page title is "Curriculum Manager"
  
Examples: 
| page  |  
| Search |    
| Browse Resource Directory Subject |
| Curriculum Manager |    