Feature: Place order
This feature is to implement place order functionality

Scenario: user Login
Given User is on Login page
When User enters "standard_user" and "secret_sauce" credentials
Then User should be on Home page

Scenario: Add Item to Cart
Given User should be on Home page
When User add item to cart
Then Item must be added

Scenario: Checkout Order
Given User is on cart page
When User do checkout 
Then Should navigat to Checkout page

#Scenario: Delete an Item
#Given Cart must have items
#When User delete an item
#Then Should delete item from cart


