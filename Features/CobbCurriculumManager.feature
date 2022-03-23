Feature: Cobb Curriculum Manager Page

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"
When User hovers over Discover dropdown
And User clicks on "Curriculum Manager" button from header

Scenario: Curriculum Manager Page
Then URL is "https://staging.lessonplanet.com/my/curriculum_manager"
And "Curriculum Manager" page title is "Curriculum Manager"
And My Resources and Shared With Me Tabs are displayed
And The collection builder is displayed on the right
And Create a Folder button is displayed
And Upload Resource button is displayed
And Hide details button is displayed
And Sort By Dropdown is displayed
And My Favorites folder is displayed
And My Uploads folder is displayed
And A list of folders is displayed with: Title, Type, Status, Date and Actions button
When User clicks on the Actions button
Then Edit, Play, Assign, Publish, Copy To, Move To, Share, Delete and Activity options are displayed

Scenario: Upload button
When User clicks on the Upload Resource button
Then "Upload a File" modal is displayed

Scenario: Create New Folder button
When User clicks on the Create a Folder button
Then "Create a New Folder" modal is displayed

Scenario: My Favorites Folder
When User clicks on the My Favorites folder
Then A list of favorited resources are displayed
When User clicks on the favorite resource info icon
Then Resource type and status are displayed
When User clicks on the Actions button
Then Play, Assign, Go To and Unfavorite options are displayed
When User clicks on the "Assign Resource" button from Actions dropdown
Then "Assign Resource" modal is displayed
When User clicks on the "Go to" button from Actions dropdown
Then Resource RRP is displayed
When User clicks on the "Unfavorite" button from Actions dropdown
Then "Please Confirm" modal is displayed
When User clicks on the "Play" button from Actions dropdown
Then The collection player is displayed in a new tab

Scenario: My Uploads Folder
When User clicks on the My Uploads folder
Then A list of uploaded resources are displayed
When User clicks on the uploaded resource info icon
Then Resource type and status are displayed
When User clicks on the Actions button
Then Edit, Play, Assign and Delete options are displayed
When User clicks on the "Edit" button from Actions dropdown 
Then "Edit Your File Information" modal is displayed
#When User clicks on the Actions button
Then User clicks on the "Assign Resource" button from Actions dropdown
Then "Assign Resource" modal is displayed
When User clicks on the "Delete" button from Actions dropdown
Then "Please Confirm" modal is displayed
When User clicks on the "Play" button from Actions dropdown
Then The collection player is displayed in a new tab

Scenario: Folders list
When User clicks on the "Edit" button from Actions dropdown
Then "Edit Folder" modal is displayed
And User closes the Edit Folder Modal
When User clicks on the "Assign Folder" button from Actions dropdown
Then "Assign Folder" modal is displayed
When User clicks on the "Copy To" button from Actions dropdown
Then "Copy To" modal is displayed
When User clicks on the "Move To" button from Actions dropdown
Then "Move To" modal is displayed
When User clicks on the "Share Folder" button from Actions dropdown
Then "Share Folder" modal is displayed
When User clicks on the "Delete" button from Actions dropdown
Then "Please Confirm" modal is displayed
When User clicks on the "Activity" button from Actions dropdown
Then Activity section is displayed
And User closes Edit Folder
When User clicks on the "Play" button from Actions dropdown
Then The collection player is displayed in a new tab