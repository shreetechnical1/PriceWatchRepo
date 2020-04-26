package priceWatchPages;

import global.PriceWatchDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.util.List;

public class TrackProduct_Page extends PriceWatchDriver {

    private static By trackNewProductOnNavBar = By.partialLinkText("Track New Product");
    private static By productURLField = By.cssSelector("#productURL");
    private static By searchButton = By.cssSelector(".btn.btn-default");
    private static By linkAmazon = By.partialLinkText("Amazon");
    private static By linkWalmart = By.partialLinkText("Walmart");
    public static By targetPrice = By.cssSelector("#targetPrice");
    private static By addToTrackingButton = By.cssSelector("input[name = 'addItemTracking'][type = 'submit']");
    private static By itemInfo = By.cssSelector(".col-sm-4");
    public static By priceGraph = By.cssSelector(".chartjs-render-monitor");
    public static By trackProductSuccessMsg = By.cssSelector("#tracking-success-element");
    public static By searchProductErrorMsg = By.cssSelector("#product-error-element");
    public static By itemPrice = By.cssSelector("#MainContent_lblItemPrice");
    private static By clearButton = By.cssSelector("#clearProduct");
    public static By trackProductErrorMsg = By.cssSelector("#tracking-error-element");


    public static WebElement trackNewProductOnNavBar(){
        return driver.findElement(trackNewProductOnNavBar);
    }
    public static WebElement productURLField(){
        Waits.fluentWaitByLocator(driver, productURLField);
        return driver.findElement(productURLField);
    }

    public static WebElement searchButton(){
        Waits.fluentWaitByLocator(driver, searchButton);
        return driver.findElement(searchButton);
    }

    public static WebElement linkAmazon(){

        return driver.findElement(linkAmazon);
    }

    public static WebElement linkWalmart(){

        return driver.findElement(linkWalmart);
    }

    public static WebElement targetPrice(){
        Waits.fluentWaitByLocator(driver, targetPrice);
        return driver.findElement(targetPrice);
    }

    public static WebElement addToTrackingButton(){

        return driver.findElement(addToTrackingButton);
    }


    public static WebElement trackProductSuccessMsg(){
        Waits.waitForWebElementToBeVisible(driver, driver.findElement(trackProductSuccessMsg));
        return driver.findElement(trackProductSuccessMsg);
    }

    public static WebElement searchProductErrorMsg(){
        return driver.findElement(searchProductErrorMsg);
    }

    public static WebElement trackProductErrorMsg(){
        return driver.findElement(trackProductErrorMsg);
    }

    public static WebElement itemPrice(){
        Waits.waitForWebElementToBeVisible(driver, driver.findElement(itemPrice));
        return driver.findElement(itemPrice);
    }

    public static WebElement clearButton(){
        Waits.waitForWebElementToBeVisible(driver, driver.findElement(clearButton));
        return driver.findElement(clearButton);
    }

    public static WebElement itemInfo(){
        Waits.waitForWebElementToBeVisible(driver, driver.findElement(itemInfo));
        return driver.findElement(itemInfo);
    }

    public static WebElement graphIcon(){
        List<WebElement> graph = itemInfo().findElements(By.tagName("a"));
        return graph.get(0);
    }
    public static WebElement priceGraph(){
        Waits.waitForWebElementToBeVisible(driver, driver.findElement(priceGraph));
        return driver.findElement(priceGraph);
    }




}
