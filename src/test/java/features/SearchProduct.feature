Feature: Search and place the order of products
@SearchItem
Scenario Outline: Search experience of product on Home and Offers page
Given User is on the GreenCart land page
When User search with shortname <Name> and extract the product title
Then User searched with same <Name> shortname on offers page
And  validate product name in offers page matches with landing page
  Examples:
    | Name  |
    | Tom   |
    | Beet  |
