Feature: Cobb Search

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"
When User goes to "Search" page
Then User clicks List View

Scenario: Lesson Planet resource card buttons
When User chooses a Lesson Planet "resource"
And User clicks on the See Full Review button
Then "Lesson Planet: Curated OER" resource RRP is displayed
When User clicks on the Go to Resource button
Then "Lesson Planet: Curated OER" resource is opened in a new tab

Scenario: Lesson Planet collection card buttons
When User chooses a Lesson Planet "collection"
And User clicks on the See Folder button
Then "Lesson Planet: Curated OER" collection RRP is displayed

Scenario: Site Specific CTLS resource card buttons
When User chooses a CTLS "resource"
And User clicks on the See Full Review button
Then "CTLS" resource RRP is displayed
When User clicks on the Go to Resource button
Then "CTLS" resource is opened in a new tab

Scenario: Site Specific CTLS collection card buttons
When User chooses a CTLS "collection"
And User clicks on the See Folder button
Then "CTLS" collection RRP is displayed

Scenario: Proprietary Discovery Education resource card buttons
When User chooses a Proprietary resource
And User clicks on the See Full Review button
Then "Discovery Education" resource RRP is displayed
When User clicks on the Go to Resource button
Then "Discovery Education" resource is opened in a new tab

Scenario: Houghton Mifflin Harcourt folder card buttons
When User chooses an HMH folder
And User clicks on the Folder Details button
Then "Houghton Mifflin Harcourt" folder RRP is displayed
When User clicks on the Open Folder button
Then Folder navigation page is displayed

Scenario: Lesson Planet resource card
When User chooses a Lesson Planet "resource"
Then Observe "Lesson Planet: Curated OER" card in List view
And User clicks Tiled View
Then Observe "Lesson Planet: Curated OER" card in Tiled view
And User clicks Thumbnail View
Then Observe "Lesson Planet: Curated OER" card in Thumbnail view

Scenario: Site Specific CTLS resource card
When User chooses a CTLS "resource"
Then Observe "CTLS" card in List view
And User clicks Tiled View
Then Observe "CTLS" card in Tiled view
And User clicks Thumbnail View
Then Observe "CTLS" card in Thumbnail view

Scenario: Proprietary Discovery Education resource card
When User chooses a Proprietary resource
Then Observe "Discovery Education" card in List view
And User clicks Tiled View
Then Observe "Discovery Education" card in Tiled view
And User clicks Thumbnail View
Then Observe "Discovery Education" card in Thumbnail view

Scenario: Lesson Planet collection card
When User chooses a Lesson Planet "collection"
Then Observe "Lesson Planet: Curated OER" card in List view
And User clicks Tiled View
Then Observe "Lesson Planet: Curated OER" card in Tiled view
And User clicks Thumbnail View
Then Observe "Lesson Planet: Curated OER" card in Thumbnail view

Scenario: Site Specific CTLS collection card
When User chooses a CTLS "collection"
Then Observe "CTLS" card in List view
And User clicks Tiled View
Then Observe "CTLS" card in Tiled view
And User clicks Thumbnail View
Then Observe "CTLS" card in Thumbnail view

Scenario: Houghton Mifflin Harcourt folder card
When User chooses an HMH folder
Then Observe "Houghton Mifflin Harcourt" card in List view
And User clicks Tiled View
Then Observe "Houghton Mifflin Harcourt" card in Tiled view
And User clicks Thumbnail View
Then Observe "Houghton Mifflin Harcourt" card in Thumbnail view