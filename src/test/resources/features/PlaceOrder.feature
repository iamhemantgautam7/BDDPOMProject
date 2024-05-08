Feature: Place order

Background: User login
Given User is on Login Page
When User enters "standard_user" and "secret_sauce"
Then User should be on Home page

Scenario: Add Item to cart
Given User should be on Home page
When User add item to cart
Then Item must be added

Scenario: Checkout order
Given User is on cart page
When User do checkout
Then Should navigate to checkoout page

