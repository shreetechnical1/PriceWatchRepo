package testcases;

import global.MainURLs;
import global.PriceWatchDriver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import priceWatchPages.Login_Page;
import priceWatchPages.ProductWatchList_Page;
import priceWatchPages.TrackProduct_Page;
import utils.Waits;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductWatchList_Test extends PriceWatchDriver {

    @Test
    public void addProductToProductWatchList() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        assertEquals(true, ProductWatchList_Page.checkecommSite("bhphotovideo"));
        assertEquals(true, ProductWatchList_Page.checkSizeOfItemsInEcommSite("bhphotovideo"));
    }

    @Test
    public void viewPreviouslyRemovedProducts(){
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.viewPreviouslyRemovedProducts().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewActiveWatchList);
        assertTrue(driver.getCurrentUrl().contains("trackproductlistdeleteditems"));
        assertTrue(driver.getPageSource().contains("Products in my old Tracking List."));
    }

    @Test
    public void viewCurrentlyUnavailableProducts(){
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.viewCurrentlyUnavailableProducts().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewActiveWatchList);
        assertTrue(driver.getCurrentUrl().contains("trackproductlistunavailable"));
        assertTrue(driver.getPageSource().contains("Currently unavailable Products in my Tracking List."));
    }

    @Test
    public void viewActiveWatchList(){
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.viewCurrentlyUnavailableProducts().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewActiveWatchList);
        ProductWatchList_Page.viewActiveWatchList().click();
        Waits.fluentWaitByLocator(driver, ProductWatchList_Page.viewPreviouslyRemovedProducts);
        assertTrue(driver.getCurrentUrl().contains("trackproductlist"));
        assertTrue(driver.getPageSource().contains("My Favourite Products - Tracking List."));
    }

    @Test
    public void editTargetPrice() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        card.findElement(ProductWatchList_Page.editTargetPrice).click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().clear();
        TrackProduct_Page.targetPrice().sendKeys("2700");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card1 = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        assertEquals("2700.00", card1.findElements(By.tagName("td")).get(5).getText());
    }

    @Test
    public void viewProductDetails() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        card.findElement(ProductWatchList_Page.viewProductDetails).click();
        assertEquals("Apple 16 MacBook Pro (Late 2019, Space Gray)", ProductWatchList_Page.trackedproductDetailsModal().getAttribute("innerHTML"));
        assertTrue(driver.getPageSource().contains("apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb_1573663014_1520697.jpg"));
    }

    @Test
    public void viewProductPriceHistory() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        card.findElement(ProductWatchList_Page.viewProductPriceHistory).click();
        assertTrue(ProductWatchList_Page.priceHistoryChart().isDisplayed());
    }

    @Test
    public void removeProductFromTrackingList() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        card.findElement(ProductWatchList_Page.removeFromTrackingList).click();
        ProductWatchList_Page.deleteFromTrackingList().click();
        WebElement card1 = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        assertEquals(null, card1);
    }

    @Test
    public void backToProductWatchList() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        card.findElement(ProductWatchList_Page.removeFromTrackingList).click();
        ProductWatchList_Page.backToProductWatchListButton().click();
        assertTrue(ProductWatchList_Page.viewCurrentlyUnavailableProducts().isDisplayed());

    }

    @Test
    public void viewPriceHistory() throws InterruptedException {
        Login_Page.loginToPriceWatch();
        ProductWatchList_Page.productWatchListOnNavBar().click();
        ProductWatchList_Page.deleteProductFromTrackingList("bhphotovideo");
        TrackProduct_Page.trackNewProductOnNavBar().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        ProductWatchList_Page.productWatchListOnNavBar().click();
        WebElement card = ProductWatchList_Page.expandEcommCard("bhphotovideo");
        card.findElement(ProductWatchList_Page.removeFromTrackingList).click();
        ProductWatchList_Page.viewPriceHistory().click();
        assertTrue(ProductWatchList_Page.priceHistoryChart().isDisplayed());
        assertTrue(ProductWatchList_Page.viewProductDetails().isDisplayed());
    }


}
