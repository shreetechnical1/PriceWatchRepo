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
    private static By removeFromTrackingList = By.cssSelector("mat-icon[title = 'Remove from tracking list']");

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

    public static void deleteProductFromTrackingList(String ecommSite) throws InterruptedException {
        List<WebElement> cards = trackingList().findElements(By.className("card"));

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().contains(ecommSite)) {
                WebElement currentCard = cards.get(i);
                driver.findElement(By.partialLinkText(ecommSite)).click();
                Thread.sleep(2000);
                List<WebElement> items = currentCard.findElements(By.cssSelector("mat-icon[title = 'Remove from tracking list']"));

                while (items.size() > 0) {
                    items.get(0).click();
                    driver.findElement(By.cssSelector(".btn.btn-default")).click();
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
