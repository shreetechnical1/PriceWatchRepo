
  Feature: Product watch list page

    Scenario:Add product to product watch list
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      Then User should see "bhphotovideo" card
      And User should see the new item added to the "bhphotovideo" card

    Scenario: View previously removed products
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      When User clicks on previously removed products
      Then Page URL should be "http://192.168.1.61/PriceWatch/trackproductlistdeleteditems"
      And User should see the text "Products in my old Tracking List."

    Scenario: View currently unavailable products
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      When User clicks on view currently unavailable products
      Then Page URL should be "http://192.168.1.61/PriceWatch/trackproductlistunavailable"
      And User should see the text "Currently unavailable Products in my Tracking List."

    Scenario: View active watch list
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      When User clicks on view currently unavailable products
      And User clicks on view active watch list
      Then Page URL should be "http://192.168.1.61/PriceWatch/trackproductlist"
      And User should see the text "My Favourite Products - Tracking List."

    Scenario: Edit target price
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      And User expands ecomm card "bhphotovideo" and clicks on edit target price
      And User clears target price
      And User enters target price as "2700"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      Then User expands ecomm card "bhphotovideo" and sees new target price "2700.00"

    Scenario: View product details
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      And User expands ecomm card "bhphotovideo" and clicks on view product details
      Then User sees the product details

    Scenario: View product price history
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      And User expands ecomm card "bhphotovideo" and clicks on view product price history
      Then User sees price history chart

    Scenario: Remove product from tracking list
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      And User expands ecomm card "bhphotovideo" and clicks on remove from tracking list
      And User clicks on delete from tracking list
      Then User expands ecomm card "bhphotovideo" and sees the product is removed

    Scenario: Back to product watch list
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      And User expands ecomm card "bhphotovideo" and clicks on remove from tracking list
      And user clicks on back to product watch list button
      Then User should see view currently unavailable products button

    Scenario: View price history
      Given User logs in to PriceWatch
      And User clicks on Product watch list
      And User deletes products from tracking list
      And User clicks on Track new product on the nav bar
      When User enters track product URL
      And User clicks on search button for "success"
      And User enters target price as "2500"
      And User clicks on Add tracking button for "success"
      And User clicks on Product watch list
      And User expands ecomm card "bhphotovideo" and clicks on remove from tracking list
      And User clicks on view price history
      Then User should see price history chart
      And User should see product details button



















