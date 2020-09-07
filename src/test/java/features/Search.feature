Feature: SearchFeature

Scenario: Search product
Given Go to homepage
And Enter the "SEARCH_INPUT" send key "araba"
And Click "SEARCH_BUTTON" button
And wait
Then Write to file "SEARCH_LOG"
