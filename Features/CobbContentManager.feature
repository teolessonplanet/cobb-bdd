Feature: Cobb Content Manager Page

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"
When User goes to "Content Manager" page

Scenario: Content Manager Main Page
Then "Content Manager" page title is "Content Manager"
And "Add, edit and manage the learning object repository (LOR)" sub-title is displayed
And Search text field is displayed
And Sort by dropdown is displayed
And Facet sidebar is displayed
And Resource cards list is displayed

Scenario: Search
Then User types "test" inside search bar
And User clicks the search icon
Then Search results are displayed on Content Manager Page for "test"
When User clicks the close button from search input
Then The keyword is not displayed anymore in the search input

Scenario: Cards List
Then Resource result list has Thumbnail image, Pool Name, Resource title, Resource type, Grade, Rating, Views, Description, Keyterms, Concepts, Additional tags, Standards, Quick View button, Hide from Search checkbox, 