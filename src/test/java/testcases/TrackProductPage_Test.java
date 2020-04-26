package testcases;

import global.MainURLs;
import global.PriceWatchDriver;
import org.junit.Test;
import priceWatchPages.Login_Page;
import priceWatchPages.ProductWatchList_Page;
import priceWatchPages.TrackProduct_Page;
import utils.Waits;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackProductPage_Test extends PriceWatchDriver {


    @Test
    public void searchProductWithoutSizeAndColor() {
       Login_Page.loginToPriceWatch();
       TrackProduct_Page.productURLField().sendKeys("https://www.amazon.com/Minibee-Womens-Ruffle-Dresses-Pockets/dp/B074X2SGY5/ref=sr_1_3?dchild=1&keywords=dress&qid=1587507037&sr=8-3");
       TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.searchProductErrorMsg);
       assertEquals("Could not load Price of the item. Please choose a desired size/color/other particulars of the product in the eCommerce website and provide the URL.", TrackProduct_Page.searchProductErrorMsg().getText());
    }

    @Test
    public void searchForAValidProduct() {
        Login_Page.loginToPriceWatch();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        assertTrue(TrackProduct_Page.itemPrice().isDisplayed() && TrackProduct_Page.targetPrice().isDisplayed());
        assertTrue(driver.getPageSource().contains("apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb_1573663014_1520697.jpg"));
    }

    @Test
    public void addProductToTrackingList() throws InterruptedException {
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
        assertEquals("Your desired target price is set. We will let you know thru registered email when the price drops to your target price.", TrackProduct_Page.trackProductSuccessMsg().getText());
    }

    @Test
    public void clearSearch(){
        Login_Page.loginToPriceWatch();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.clearButton().click();
        assertFalse(driver.findElements(TrackProduct_Page.targetPrice).size()>0 && driver.findElements(TrackProduct_Page.itemPrice).size()>0);
    }

    @Test
    public void verifyPriceGraph(){
        Login_Page.loginToPriceWatch();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().clear();
        TrackProduct_Page.targetPrice().sendKeys("2500");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        TrackProduct_Page.clearButton().click();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().clear();
        TrackProduct_Page.targetPrice().sendKeys("3000");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductSuccessMsg);
        TrackProduct_Page.graphIcon().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.priceGraph);
        assertTrue(TrackProduct_Page.priceGraph().isDisplayed());

    }

    @Test
    public void verifyByAddingDesiredPriceMoreThanCurrentPrice(){
        Login_Page.loginToPriceWatch();
        TrackProduct_Page.productURLField().sendKeys(MainURLs.URLList.BhpPhotoURL + "/c/product/1520697-REG/apple_z0y0_mvvk_51_bh_mbp_tb_2_3ghz_8c_9th_gen_i9_32gb_1tb.html");
        TrackProduct_Page.searchButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.targetPrice);
        TrackProduct_Page.targetPrice().clear();
        TrackProduct_Page.targetPrice().sendKeys("5000");
        TrackProduct_Page.addToTrackingButton().click();
        Waits.fluentWaitByLocator(driver, TrackProduct_Page.trackProductErrorMsg);
        assertEquals("Please provide a numeric value for your desired target price (less than the current Item Price).", TrackProduct_Page.trackProductErrorMsg().getText());

    }
}
