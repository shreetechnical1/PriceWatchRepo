package utils;

import global.PriceWatchDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits extends PriceWatchDriver {

    public static void fluentWaitByLocator(WebDriver driver, By anylocator) {
        new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).until((WebDriver d) -> d.findElement(anylocator));
    }


    //Wait for element to be visible
    public static void waitForWebElementToBeVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, 4500).until(ExpectedConditions.visibilityOf(element));
    }

    //Wait for element to be clickable
    public static void waitForWebElementToBeClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, 2000).until(ExpectedConditions.elementToBeClickable(element));
    }

    //implict wait
    public static void implicitWaits(int Wait) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //Wraps an explicit wait and an assertion that the page contains specified Content
    public static void waitForPageContent(WebDriver driver, final String Content) {
        new WebDriverWait(driver, 2000).until((WebDriver d) -> d.getPageSource().contains(Content));
    }






}
