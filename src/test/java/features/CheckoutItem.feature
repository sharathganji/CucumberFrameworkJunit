Feature: Add Item to cart and checkout
 @CheckOutItem
Scenario Outline:  Verify ordered item and its quantity on Checkout page
Given User is on the GreenCart land page
When User search with shortname <Name> and extract the product title
And Added 3 times of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order
Examples:
| Name  |
| Cucu  |
