package stepDefinitions;

import global.MainURLs;
import global.PriceWatchDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import priceWatchPages.Login_Page;
import priceWatchPages.ProductWatchList_Page;
import priceWatchPages.TrackProduct_Page;
import utils.Waits;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackProductPage_Steps extends PriceWatchDriver {


    @Given("User logs in to PriceWatch")
    public void user_logs_in_to_PriceWatch() {
        Login_Page.loginToPriceWatch();
    }

    @When("User enters track product URL without valid size and color")
    public void userEntersTrackProductURLWithoutValidSizeAndColor() {
        TrackProduct_Page.productURLField().sendKeys("https://www.amazon.com/Minibee-Womens-Ruffle-Dresses-Pockets/dp/B074X2SGY5/ref=sr_1_3?dchild=1&keywords=dress&qid=1587507037&sr=8-3");
    }


    @When("User enters track product URL")
    public void user_enters_track_product_URL() {
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
    }

    @When("User clicks on search button for {string}")
    public void user_clicks_on_search_button(String msg) {
        TrackProduct_Page.searchButton().click();
        if(msg.equals("success")){
            Waits.fluentWaitByLocator(driver, TrackProduct_Page.itemPrice);
        }
        else{
            Waits.fluentWaitByLocator(driver, TrackProduct_Page.searchProductErrorMsg);

        }

    }

    @Then("User should get track error message {string}")
    public void user_should_get_track_error_message(String msg) {
        assertEquals("Please provide a numeric value for your desired target price (less than the current Item Price).", TrackProduct_Page.trackProductErrorMsg().getText());
    }


    @Then("User should see item price and target price displayed")
    public void user_should_see_item_price_and_target_price_displayed() {
        assertTrue(TrackProduct_Page.itemPrice().isDisplayed() && TrackProduct_Page.targetPrice().isDisplayed());

    }

    @Then("User should see the image of the product")
    public void user_should_see_the_image_of_the_product() {
        assertTrue(driver.getPageSource().contains("apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb_1573663014_1520697.jpg"));

    }

    @Given("User clicks on Product watch list")
    public void user_clicks_on_Product_watch_list() {
        ProductWatchList_Page.productWatchListOnNavBar().click();

    }

    @Given("User deletes products from tracking list")
    public void user_deletes_products_from_tracking_list() throws InterruptedException {
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");

    }

    @When("User enters target price as {string}")
    public void user_enters_target_price_as(String price) {
        TrackProduct_Page.targetPrice().sendKeys(price);

    }

    @When("User clicks on Add tracking button for {string}")
    public void user_clicks_on_Add_tracking_button(String msg) {
        TrackProduct_Page.addToTrackingButton().click();
        if(msg.equals("success")){
            Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        }
        else{
            Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductErrorMsg);
        }


    }

    @When("User clicks on clear button")
    public void user_clicks_on_clear_button() {
        TrackProduct_Page.clearButton().click();
    }

    @Then("Target price and item price elements should not be displayed")
    public void target_price_and_item_price_elements_should_not_be_displayed() {
        assertFalse(driver.findElements(TrackProduct_Page.targetPrice).size()>0 && driver.findElements(TrackProduct_Page.itemPrice).size()>0);
    }

    @When("User clears target price")
    public void user_clears_target_price() {
        TrackProduct_Page.targetPrice().clear();
    }

    @When("User clicks on graph icon")
    public void user_clicks_on_graph_icon() {
        TrackProduct_Page.graphIcon().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.priceGraph);

    }

    @Then("Price graph should be displayed")
    public void price_graph_should_be_displayed() {
        assertTrue(TrackProduct_Page.priceGraph().isDisplayed());

    }

    @After
    public void closeBrowser(){
        tearDown();
    }


    @And("User clicks on Track new product on the nav bar")
    public void userClicksOnTrackNewProductOnTheNavBar() {
        TrackProduct_Page.trackNewProductOnNavBar().click();
    }

    @Then("User should get track success message {string}")
    public void userShouldGetTrackSuccessMessage(String arg0) {
        assertEquals("Your desired target price is set. We will let you know thru registered email when the price drops to your target price.", TrackProduct_Page.trackProductSuccessMsg().getText());
    }
}
