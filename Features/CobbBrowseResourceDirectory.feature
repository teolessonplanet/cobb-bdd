Feature: Cobb Browse Resource Directory Main Page

Background:
Given User logs in with "i_o_csl_cobb@lp.com" and "test123"
When User hovers over Discover dropdown
And User clicks on "Browse Resource Directory" button from header

Scenario Outline: Directory Main Page "<subject>" subject link & thumbnail
When User clicks on "<subject>" link from Directory Main Page
Then Check subject page url "<url>"
Then Check subject page title "<title>"
When User goes to "Browse Resource Directory" page
When User clicks on "<subject>" thumbnail from Directory Main Page
Then Check subject page url "<url>"
Then Check subject page title "<title>"

Examples: 
| subject | title | url |
| Health | Health Teacher Resources | lesson-plans/health |
| Language Arts | Language Arts Teacher Resources | lesson-plans/language-arts |
| Languages | Languages Teacher Resources | lesson-plans/languages |
| Math | Math Teacher Resources | lesson-plans/math |
| Physical Education | Physical Education Teacher Resources | lesson-plans/physical-education |
| Science | Science Teacher Resources | lesson-plans/science |
| Social Studies | Social Studies Teacher Resources | lesson-plans/social-studies |
| Special Education | Special Education Teacher Resources | lesson-plans/special-education |
| Visual and Performing Arts | Visual and Performing Arts Teacher Resources | lesson-plans/visual-and-performing-arts |

Scenario: Show All buttons
Then Observe the bottom of each subject card displayed on Directory main page
When User clicks Show All button from Health Category
Then "Health" category modal is displayed

Scenario Outline: Directory Main Page subjects "<subSubject>" link
When User clicks on "<subSubject>" sub-Subject link
Then Check subject page title "<title>"

Examples: 
| subSubject | title | 
| Wellness & Safety | Wellness & Safety Teacher Resources |
| Social and Emotional Learning | Social and Emotional Learning Teacher Resources |
| Growth and Development | Growth and Development Teacher Resources |
| Sex Education | Sex Education Teacher Resources |
| Research | Research Teacher Resources|
| Literature | Literature Teacher Resources |
| Graphic Organizer | Graphic Organizer Teacher Resources |
| Genre Types | Genre Types Teacher Resources |
| English Language Development | English Language Development Teacher Resources |
| American Sign Language | American Sign Language Teacher Resources |
| French | French Teacher Resources |
| Spanish | Spanish Teacher Resources|
| Measurements | Measurement Teacher Resources |
| Teaching Math | Teaching Math Teacher Resources |
| Algebra | Algebra Teacher Resources |
| Graphing | Graphing Teacher Resources |
| Anaerobic Activity | Anaerobic Activity Teacher Resources |
| Dance Physical Education | Dance Teacher Resources |
| Water Activities | Water Activities Teacher Resources |
| Sports Skills | Sports Skills Teacher Resources |
| Natural Science | Natural Science Teacher Resources |
| Scientists | Scientists Teacher Resources |
| Biology | Biology Teacher Resources |
| Applied Science | Applied Science Teacher Resources |
| 21st Century Learning Skills| 21st Century Learning Skills Teacher Resources |
| Geography | Geography Teacher Resources |
| Flags | Flags Teacher Resources |
| History| History Teacher Resources |
| Developmental & Behavioral Disorder | Developmental & Behavioral Disorders Teacher Resources |
| Physical Disabilities | Physical Disabilities Teacher Resources |
| Special Needs Teacher Resources | Special Needs Teacher Resources Teacher Resources |
| Accommodations | Accommodations Teacher Resources |
| Music | Music Teacher Resources |
| Dance Visual and Performing Arts | Dance Teacher Resources |
| Visual Arts | Visual Arts Teacher Resources |
| Film Studies | Film Studies Teacher Resources |