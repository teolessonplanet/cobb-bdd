Feature: Cobb RRPs

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"
When User goes to "Search" page
Then User clicks List View

Scenario: Lesson Planet Resource RRP
Then User chooses a Lesson Planet "resource"
And User clicks on the See Full Review button
Then Observe detailed "Lesson Planet: Curated OER" resource RRP

Scenario: Lesson Planet Collection RRP
Then User chooses a Lesson Planet "collection"
And User clicks on the See Folder button
Then Observe detailed "Lesson Planet: Curated OER" collection RRP
When User clicks the See Full Reviews Link
Then Collection item RRP is displayed
When User closes the item RRP
Then See Full Review link is displayed

Scenario: Proprietary Discovery Education Resource RRP
When User chooses a Proprietary resource
And User clicks on the See Full Review button
Then Observe detailed "Discovery Education" resource RRP

Scenario: Houghton Mifflin Harcourt Folder RRP
When User chooses an HMH folder
And User clicks on the Folder Details button
Then Observe detailed "Houghton Mifflin Harcourt" folder RRP

Scenario: Site Specific CTLS Resource RRP
When User chooses a CTLS "resource"
And User clicks on the See Full Review button
Then Observe detailed "CTLS" resource RRP

Scenario: Site Specific Collection RRP
When User chooses a CTLS "collection"
And User clicks on the See Folder button
Then Observe detailed "CTLS" collection RRP
When User clicks the See Full Reviews Link
Then Collection item RRP is displayed
When User closes the item RRP
Then See Full Review link is displayed