#This file has test cases for Track product page

  Feature: Track product page

    Scenario: Search product without size and color
      Given User logs in to PriceWatch
      When User enters track product URL without valid size and color
      And User clicks on search button for "error"
      Then User should get search error message "Could not load Price of the item. Please choose a desired size/color/other particulars of the product in the eCommerce website and provide the URL."

    Scenario: Search for a valid product
      Given User logs in to PriceWatch
      When User enters track product URL
      And User clicks on search button for "success"
      Then User should see item price and target price displayed
      And User should see the image of the product

    Scenario: Add product to tracking list
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      Then User should get track success message "Your desired target price is set. We will let you know thru registered email when the price drops to your target price."

    Scenario: Clear search functionality
      Given User logs in to PriceWatch
      When User enters track product URL
      And User clicks on search button for "success"
      And User clicks on clear button
      Then Target price and item price elements should not be displayed

    Scenario: Price graph
      Given User logs in to PriceWatch
      When User enters track product URL
      And User clicks on search button for "success"
      And User clears target price
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on clear button
      When User enters track product URL
      And User clicks on search button for "success"
      And User clears target price
      And User enters target price as "3000"
      And User clicks on Add tracking button for "success"
      And User clicks on graph icon
      Then Price graph should be displayed

    Scenario: Add desired price more than current price
      Given User logs in to PriceWatch
      When User enters track product URL
      And User clicks on search button for "success"
      And User clears target price
      And User enters target price as "5000"
      And User clicks on Add tracking button for "error"
      Then User should get track error message "Please provide a numeric value for your desired target price (less than the current Item Price)."












