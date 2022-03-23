Feature: Cobb Admin Manager

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"
When User goes to "Admin Manager" page

Scenario: Check Organization Name
Then "Cobb County School District" name is displayed

Scenario: District Page
Then "Cobb County School District" name is displayed
And Search button is displayed    
And Manage District button is displayed
And "Add Schools" button is displayed
When User hovers over "Add Schools" button
Then "Automated rostering is enabled. Please contact your system administrator to add a new school." popover text is displayed
And School list is displayed
And Every school has: School Name, Nr of teachers, Resources Uploaded, "Edit School" Action button and "See School Reporting" Action button

Scenario Outline: Search input text
Then User clicks the Search button 
And User enters "<keyword>"
Then Results are displayed for "<keyword>" text
Examples: 
| keyword |
| i_o_csl_cobb@lp.com |  
| test@test.com |
| Harry |
| blabla |

Scenario: Edit District Modal
When User clicks the "Manage District" button
And User clicks Edit District button
Then "Edit District" modal is displayed 
And "District Name" field with "Cobb County School District" name is displayed
And "District Name" info icon is displayed
When User hovers over "District Name" info icon
Then "If you'd like to change the district name, please contact Lesson Planet." popover for "District Name" info icon is displayed
And "District Shortname" field is displayed
And "District Shortname" info icon is displayed
When User hovers over "District Shortname" info icon
Then "This is a name your teachers and staff are used to seeing. It could be your district's initials or a shorter version of your district's name. 20 characters max." popover for "District Shortname" info icon is displayed
And All admins in this district are also Publishers option is displayed
And All teachers in this district are also Publishers option is displayed

Scenario: Manage District Page
When User clicks the "Manage District" button
Then "Cobb County School District" name is displayed
And Search button is displayed
And Account Manager breadcrumbs is displayed
And Edit District button is displayed
And Manage District Admins button is displayed
And "Add Teachers" button is displayed
When User hovers over "Add Teachers" button
Then "Automated rostering is enabled. Please contact your system administrator to add a new teacher." popover text is displayed
And Every District user has: Email, First Name, Last Name, "Admin" Role, "Edit District Admin" Action button and "Remove District Admin" Action button

Scenario: Manage District Admin Page
Then "Cobb County School District" name is displayed
When User clicks the "Manage District" button
Then District User list is displayed
And Account Manager breadcrumbs is displayed
And User clicks on the "Manage District Admin" button
And Search button is displayed
And Edit District button is displayed
And Account Manager breadcrumbs is displayed
And First user listed is the Owner with "Edit Owner" Action button and disabled Remove button
And Other users listed are district admins and have: Email, First Name, Last Name, "Edit District Admin" Action button and "Remove District Admin" Action button
And Add a District Admin button is displayed
When User clicks Add a District admin button
Then "Add a District Admin" modal is displayed 

Scenario: School Page
When User clicks on a school
Then "Adult Education @ Hawthorne" name is displayed
And Search button is displayed
And Account Manager breadcrumbs is displayed
And Edit District button is displayed
When User clicks Edit District button
Then "Edit School" modal is displayed
And User closes the modal
And Manage District Admins button is displayed
And "Add Teacher" button is displayed
When User hovers over "Add Teacher" button
Then "Automated rostering is enabled. Please contact your system administrator to add a new teacher." popover text is displayed
And The teachers list is displayed with: Email, First, Last, "Admin" or "Teacher" Role, Joined, "Edit Teacher" Action button and "Remove Teacher" Action button
When User clicks the Edit Teacher button
Then "Edit Teacher" modal is displayed

Scenario: Edit School Modal
When User clicks on a school
Then "Adult Education @ Hawthorne" name is displayed
And User clicks Edit District button
Then "Edit School" modal is displayed 
And "School Name" field with "Adult Education @ Hawthorne" name is displayed
And "School Shortname" field is displayed
And "School Shortname" info icon is displayed
When User hovers over "School Shortname" info icon
Then "This is a name your teachers and staff are used to seeing. It could be your school's initials or a shorter version of your school's name. 20 characters max." popover for "District Shortname" info icon is displayed
And All admins in this school are also Publishers option is displayed
And All teachers in this school are also Publishers option is displayed

Scenario: Manage School Admin Page
When User clicks on a school
And User clicks on the "Manage School Admin" button
Then Three Add a School Admin links are displayed
When User hovers over Add a School Admin
Then "Automated rostering is enabled. Please contact your system administrator to add a new school admin." popover text for add school admin is displayed