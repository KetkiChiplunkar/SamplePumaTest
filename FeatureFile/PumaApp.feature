Feature: Verify to Add to Cart functionality


Scenario: Add Product to the Cart

Given Navigate to Puma website
And Navigate to MEN category 
And Click on Running Shoes
And Select shoe from listing page
When Click on Add to Cart button
Then Verify that the cart has the correct shoe selected in previous step
