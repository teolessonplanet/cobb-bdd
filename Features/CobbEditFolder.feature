Feature: Cobb Edit Folder

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"

Scenario Outline: Edit Folder appearance on <page> page
When User goes to "<page>" page
Then Collection Builder is displayed
When User clicks on the "Create or Open" button from collection builder
And User chooses a collection
Then Edit button is displayed
When User clicks on the "Edit" button from collection builder
Then "Edit Folder" modal is displayed
When User clicks on the "Add" button from edit folder modal
Then The following options are displayed: Web Link, File Upload, Pixabay Image, Create Page, New Folder
When User clicks on the "More" button from edit folder modal
Then The following options are displayed in the dropdown: Publish, Assign, Copy To, Share and Activity

Examples: 
| page  |  
| Search |    
| Browse Resource Directory Subject |
| Curriculum Manager |  

Scenario: Edit Folder Modal buttons
When User goes to "Search" page
When User clicks on the "Create or Open" button from collection builder
And User chooses a collection
Then Edit button is displayed
When User clicks on the "Edit" button from collection builder
Then "Edit Folder" modal is displayed
And Folder Navigation button is displayed
And Folder Type is displayed
And Folder Title is displayed
And Add button is displayed
And Edit details button is displayed
And Play button is displayed
And More button is displayed
When User clicks on the "Folder Navigation" button from edit folder modal
Then A list of all folders is displayed
And Active Folder is displayed in the list
When User clicks on the "Play" button from edit folder modal
Then The collection player is displayed in a new tab
When User clicks on the "Assign Folder" button from More dropdown
Then "Assign Folder" modal is displayed
When User clicks on the "Copy To" button from More dropdown
Then Copy to section is displayed
When User clicks on the "Share Folder" button from More dropdown
Then "Share Folder" modal is displayed
When User clicks on the "Activity" button from More dropdown
Then Activity section is displayed
When User clicks on the "Edit Details" button from edit folder modal
Then Edit details section is displayed
When User clicks on the "Web Link" button from Add button
When Add a Web Link section is displayed
When User clicks on the "File Upload" button from Add button
Then Upload a File section is displayed
When User clicks on the "Pixabay Image" button from Add button
Then Add Pixabay Image Section is displayed
When User clicks on the "Create Page" button from Add button
Then Create a Page section is displayed
When User clicks on the "New Folder" button from Add button
Then Create a New Folder section is displayed