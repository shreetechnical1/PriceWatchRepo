package stepDefinitions;

import global.PriceWatchDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import priceWatchPages.ProductWatchList_Page;
import priceWatchPages.TrackProduct_Page;
import utils.Waits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductWatchList_Steps extends PriceWatchDriver {

    @Then("User should see {string} card")
    public void user_should_see_card(String site) {
        assertEquals(true, ProductWatchList_Page.checkecommSite(site));

    }

    @Then("User should see the new item added to the {string} card")
    public void user_should_see_the_new_item_added_to_the_card(String site) throws InterruptedException {
        assertEquals(true, ProductWatchList_Page.checkSizeOfItemsInEcommSite("bhphotovideo"));
    }

    @When("User clicks on previously removed products")
    public void user_clicks_on_previously_removed_products() {
        ProductWatchList_Page.viewPreviouslyRemovedProducts().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewActiveWatchList);

    }

    @Then("User should see the text {string}")
    public void user_should_see_the_text(String text) {
        assertTrue(driver.getPageSource().contains(text));
    }


    @When("User clicks on view currently unavailable products")
    public void userClicksOnViewCurrentlyUnavailableProducts() {
        ProductWatchList_Page.viewCurrentlyUnavailableProducts().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewActiveWatchList);
    }

    @And("User clicks on view active watch list")
    public void userClicksOnViewActiveWatchList() {
        ProductWatchList_Page.viewActiveWatchList().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewPreviouslyRemovedProducts);

    }

    @And("User expands ecomm card {string}")
    public WebElement userExpandsEcommCard(String ecomm) throws InterruptedException {
        WebElement card = ProductWatchList_Page.expandEcommCard(ecomm);
        return card;

    }

    @And("User clicks on edit target price for the ecomm card {string}")
    public void userClicksOnEditTargetPriceForTheEcommCard(String ecomm) throws InterruptedException {
        WebElement ecommCard = userExpandsEcommCard(ecomm);
        ecommCard.findElement(ProductWatchList_Page.editTargetPrice).click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
    }

    @Then("User should see the new target price {string} under ecomm card {string}")
    public void userShouldSeeTheNewTargetPriceUnderEcommCard(String price, String ecomm) throws InterruptedException {
        WebElement card1 = ProductWatchList_Page.expandEcommCard(ecomm);
        assertEquals(price, card1.findElements(By.tagName("td")).get(5).getText());
    }

    @And("User expands ecomm card {string} and clicks on edit target price")
    public void userExpandsEcommCardAndClicksOnEdiTargetPrice(String ecomm) throws InterruptedException {
        WebElement card = ProductWatchList_Page.expandEcommCard(ecomm);
        card.findElement(ProductWatchList_Page.editTargetPrice).click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
    }

    @Then("User expands ecomm card {string} and sees new target price {string}")
    public void userExpandsEcommCardAndSeesNewTargetPrice(String ecomm, String price) throws InterruptedException {
        WebElement card1 = ProductWatchList_Page.expandEcommCard(ecomm);
        assertEquals(price, card1.findElements(By.tagName("td")).get(5).getText());
    }

    @And("User expands ecomm card {string} and clicks on view product details")
    public void userExpandsEcommCardAndClicksOnViewProductDetails(String ecomm) throws InterruptedException {
        WebElement card = ProductWatchList_Page.expandEcommCard(ecomm);
        card.findElement(ProductWatchList_Page.viewProductDetails).click();
    }

    @Then("User sees the product details")
    public void userSeesTheProductDetails() {
        assertEquals("Apple 16 MacBook Pro (Late 2019, Space Gray)", ProductWatchList_Page.trackedproductDetailsModal().getAttribute("innerHTML"));
        assertTrue(driver.getPageSource().contains("apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb_1573663014_1520697.jpg"));

    }

    @And("User expands ecomm card {string} and clicks on view product price history")
    public void userExpandsEcommCardAndClicksOnViewProductPriceHistory(String ecomm) throws InterruptedException {
        WebElement card = ProductWatchList_Page.expandEcommCard(ecomm);
        card.findElement(ProductWatchList_Page.viewProductPriceHistory).click();
    }


    @Then("User sees price history chart")
    public void userSeesPriceHistoryChart() {
        assertTrue(ProductWatchList_Page.priceHistoryChart().isDisplayed());
    }


    @And("User expands ecomm card {string} and clicks on remove from tracking list")
    public void userExpandsEcommCardAndClicksOnRemoveFromTrackingList(String ecomm) throws InterruptedException {
        WebElement card = ProductWatchList_Page.expandEcommCard(ecomm);
        card.findElement(ProductWatchList_Page.removeFromTrackingList).click();
    }

    @And("User clicks on delete from tracking list")
    public void userClicksOnDeleteFromTrackingList() {
        ProductWatchList_Page.deleteFromTrackingList().click();
    }

    @Then("User expands ecomm card {string} and sees the product is removed")
    public void userExpandsEcommCardAndSeesTheProductIsRemoved(String ecomm) throws InterruptedException {
        WebElement card1 = ProductWatchList_Page.expandEcommCard(ecomm);
        assertEquals(null, card1);
    }

    @And("user clicks on back to product watch list button")
    public void userClicksOnBackToProductWatchListButton() {
        ProductWatchList_Page.backToProductWatchListButton().click();
    }

    @Then("User should see view currently unavailable products button")
    public void userShouldSeeViewCurrentlyUnavailableProductsButton() {
        assertTrue(ProductWatchList_Page.viewCurrentlyUnavailableProducts().isDisplayed());

    }

    @And("User clicks on view price history")
    public void userClicksOnViewPriceHistory() {
        ProductWatchList_Page.viewPriceHistory().click();
    }

    @Then("User should see price history chart")
    public void userShouldSeePriceHistoryChart() {
        assertTrue(ProductWatchList_Page.priceHistoryChart().isDisplayed());

    }

    @And("User should see product details button")
    public void userShouldSeeProductDetailsButton() {
        assertTrue(ProductWatchList_Page.viewProductDetails().isDisplayed());
    }


}
