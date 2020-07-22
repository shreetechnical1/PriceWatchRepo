package priceWatchPages;

import global.PriceWatchDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.GeneralFunctions;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

public class ProductWatchList_Page extends PriceWatchDriver {

    private static By productWatchListOnNavBar = By.partialLinkText("Product Watch List");
    private static By trackingList = By.cssSelector("#accordion");
    public static By viewPreviouslyRemovedProducts = By.cssSelector("mat-icon[title = 'View previously watched products']");
    private static By viewCurrentlyUnavailableProducts = By.cssSelector("mat-icon[class = 'icon mat-icon notranslate material-icons mat-icon-no-color'][title = 'View currently unavailable products']");
    public static By viewActiveWatchList = By.cssSelector("mat-icon[title = 'View active products watch list']");
    public static By editTargetPrice = By.cssSelector("mat-icon[title = 'Edit your target price']");
    public static By viewProductDetails = By.cssSelector("mat-icon[title = 'View product details']");
    public static By viewProductPriceHistory = By.cssSelector("mat-icon[title = 'View product price history']");
    public static By removeFromTrackingList = By.cssSelector("mat-icon[title = 'Remove from tracking list']");
    private static By trackedproductDetailsModal = By.cssSelector("span[id = 'MainContent_lblItemName']");
    public static By modalCloseButton = By.cssSelector(".btn.btn-default");
    public static By priceHistoryChart = By.cssSelector(".chartjs-render-monitor");
    public static By deleteFromTrackingList = By.cssSelector(".btn.btn-default");
    private static By backToProductWatchListButton = By.cssSelector("mat-icon[title = 'Back to product watch list']");
    private static By viewPriceHistory = By.cssSelector("mat-icon[title = 'View price history']");



    public static WebElement productWatchListOnNavBar() {
        Waits.fluentWaitByLocator(driver, productWatchListOnNavBar);
        return driver.findElement(productWatchListOnNavBar);
    }

    public static WebElement trackingList() {
        Waits.fluentWaitByLocator(driver, trackingList);
        return driver.findElement(trackingList);
    }

    public static WebElement removeFromTrackingList() {
        Waits.fluentWaitByLocator(driver, removeFromTrackingList);
        return driver.findElement(removeFromTrackingList);
    }

    public static WebElement viewPreviouslyRemovedProducts() {
        Waits.fluentWaitByLocator(driver, viewPreviouslyRemovedProducts);
        return driver.findElement(viewPreviouslyRemovedProducts);
    }

    public static WebElement viewCurrentlyUnavailableProducts() {
        Waits.fluentWaitByLocator(driver, viewCurrentlyUnavailableProducts);
        return driver.findElement(viewCurrentlyUnavailableProducts);
    }

    public static WebElement viewActiveWatchList() {
        Waits.fluentWaitByLocator(driver, viewActiveWatchList);
        return driver.findElement(viewActiveWatchList);
    }

    public static WebElement editTargetPrice() {
        Waits.fluentWaitByLocator(driver, editTargetPrice);
        return driver.findElement(editTargetPrice);
    }

    public static WebElement viewProductDetails() {
        Waits.fluentWaitByLocator(driver, viewProductDetails);
        return driver.findElement(viewProductDetails);
    }

    public static WebElement viewProductPriceHistory() {
        Waits.fluentWaitByLocator(driver, viewProductPriceHistory);
        return driver.findElement(viewProductPriceHistory);
    }

    public static WebElement trackedproductDetailsModal() {
        Waits.fluentWaitByLocator(driver, trackedproductDetailsModal);
        return driver.findElement(trackedproductDetailsModal);
    }

    public static WebElement priceHistoryChart() {
        Waits.fluentWaitByLocator(driver, priceHistoryChart);
        return driver.findElement(priceHistoryChart);
    }

    public static WebElement deleteFromTrackingList() {
        Waits.fluentWaitByLocator(driver, deleteFromTrackingList);
        return driver.findElement(deleteFromTrackingList);
    }

    public static WebElement backToProductWatchListButton() {
        Waits.fluentWaitByLocator(driver, backToProductWatchListButton);
        return driver.findElement(backToProductWatchListButton);
    }

    public static WebElement viewPriceHistory() {
        Waits.fluentWaitByLocator(driver, viewPriceHistory);
        return driver.findElement(viewPriceHistory);
    }

    //method to find the new card that we added
    public static boolean checkecommSite(String ecommSite){
        boolean flag = false;
        List<WebElement> cards = trackingList().findElements(By.className("card"));

        for (int i = 0; i < cards.size(); i++){
            if (cards.get(i).getText().contains(ecommSite)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    //method to check the number of items in the card
    public static boolean checkSizeOfItemsInEcommSite(String ecommSite) throws InterruptedException {
        boolean flag = false;
        List<WebElement> cards = trackingList().findElements(By.className("card"));

        for (int i = 0; i <cards.size(); i++){
            if (cards.get(i).getText().contains(ecommSite)){
                WebElement currentCard = cards.get(i);
                driver.findElement(By.partialLinkText(ecommSite)).click();
                //Thread.sleep(2000);
                List<WebElement> items = currentCard.findElements(By.cssSelector("mat-icon[title = 'Remove from tracking list']"));
                if (items.size() > 0){
                    flag = true;
                    break;
                }
            }
        }
          return flag;
    }

    //method to expand ecomm card
    public static WebElement expandEcommCard(String ecommSite) throws InterruptedException {
        List<WebElement> cards = trackingList().findElements(By.className("card"));
        WebElement currentCard = null;

        for(int i = 0; i<cards.size(); i++){
            if (cards.get(i).getText().contains(ecommSite)){
                currentCard = cards.get(i);
                driver.findElement(By.partialLinkText(ecommSite)).click();
                break;
            }
            else{
                currentCard = null;
            }
        }
        return currentCard;

    }


    //method to delete a product from tracking list
    public static void deleteProductFromTrackingList(String ecommSite) throws InterruptedException {
       List<WebElement> cards = trackingList().findElements(By.className("card"));

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().contains(ecommSite)) {
                WebElement currentCard = cards.get(i);
                driver.findElement(By.partialLinkText(ecommSite)).click();
                //Thread.sleep(2000);
                List<WebElement> items = currentCard.findElements(By.cssSelector("mat-icon[title = 'Remove from tracking list']"));

                while (items.size() > 0) {
                    items.get(0).click();
                    ProductWatchList_Page.deleteFromTrackingList().click();
                    cards = trackingList().findElements(By.className("card"));

                    if (driver.getPageSource().contains(ecommSite)) {
                        WebElement ecommCard = driver.findElement(By.partialLinkText(ecommSite));
                        if (ecommCard.isDisplayed()) {
                            driver.findElement(By.partialLinkText(ecommSite)).click();

                            items.clear();
                            currentCard = cards.get(i);
                            items = currentCard.findElements(By.cssSelector("mat-icon[title = 'Remove from tracking list']"));
                        } else {
                            items.clear();
                        }
                    } else {
                        items.clear();
                    }
                }
                break;
            }
        }
    }

}
