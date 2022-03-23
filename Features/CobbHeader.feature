Feature: Cobb Header

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"

Scenario: Header Appearance
When User goes to "Home" page
Then Resources text is displayed
And Discover and User Dropdown are displayed
And Search input is empty
And "Search educational resources" placeholder is displayed inside the search input
And The search button with the magnifying glass icon is displayed
When User clicks the search input
Then The search button with the "Search" text is displayed 

Scenario Outline: Search Input functionality with different keywords
When User clicks the search input
Then The search button with the "Search" text is displayed 
When User types "<keyword1>" inside the search input
And User clicks the search button
Then "<keyword1>" is displayed inside the search input
And X is displayed in the search input
And The search button with the magnifying glass icon is displayed
And Search results are displayed for "<keyword>"
When User clicks on the X button
Then Search input is empty
And URL is "https://staging.lessonplanet.com/search"
And "Search educational resources" placeholder is displayed inside the search input
And The search button with the magnifying glass icon is displayed
And "Discover Resources" page title is "Showing all resources"
When User clicks the search input
And User types "<keyword2>" inside the search input
And User does not click the search button
Then "<keyword2>" is displayed inside the search input
And X is displayed in the search input
And The search button with the "Search" text is displayed
And Search is not performed
When User clicks outside the search input
Then The search button with the magnifying glass icon is displayed

Examples: 
| keyword1 | keyword2 |
| test | aaaa |
| abcdefghijk | aaaa |

Scenario: Discover dropdown options
When User hovers over Discover dropdown
And User clicks on "Discover Resources" button from header
Then URL is "https://staging.lessonplanet.com/search"
And "Discover Resources" page title is "Showing all resources"
When User hovers over Discover dropdown
And User clicks on "Browse Resource Directory" button from header
Then URL is "https://staging.lessonplanet.com/lesson-plans"
And "Browse Resource Directory" page title is "Educational Resources by Subject"
When User hovers over Discover dropdown 	
And User clicks on "Curriculum Manager" button from header
Then URL is "https://staging.lessonplanet.com/my/curriculum_manager"
And "Curriculum Manager" page title is "Curriculum Manager"
Then User hovers over Discover dropdown 	
And User clicks on "Curriculum Calendar" button from header
Then URL is "https://staging.lessonplanet.com/calendar"
And "Curriculum Calendar" page title is "Curriculum Calendar - Lesson Plan Ideas by Date"

Scenario: User dropdown options
When User hovers over User dropdown
And User clicks on "My Account" button from header
Then URL is "https://staging.lessonplanet.com/profile/account" 
And "My Account" page title is "My Account"
When User hovers over User dropdown
Then User clicks on "My Resources" button from header
Then URL is "https://staging.lessonplanet.com/my/curriculum_manager"
And "My Resources" page title is "Curriculum Manager"
When User hovers over User dropdown
Then User clicks on "Admin Manager" button from header
Then URL is "https://staging.lessonplanet.com/my/admin-manager/account/1571972/manager"
And "Admin Manager" page title is "Cobb County School District"
When User hovers over User dropdown
Then User clicks on "Sign Out" button from header
Then URL is "https://staging.lessonplanet.com/"
And "Sign Out" page title is "Lesson Plans & Worksheets for School Teachers"