package priceWatchPages;

import global.MainURLs;
import global.PriceWatchDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utils.Waits;

public class Login_Page extends PriceWatchDriver {

    private static By loginOnNavBar = By.cssSelector("a[title = 'Login to PriceWatch']");
    private static By userName = By.cssSelector("input[name = 'UserName']");
    private static By password = By.cssSelector("input[name = 'Password']");
    private static By loginButton = By.cssSelector(".btn.btn-default");
    private static By loginFailureMsg = By.cssSelector("#saveMessage");
    private static By registerNewUser = By.partialLinkText("Register");
    private static By registerUserName = By.cssSelector("#element-username");
    private static By registerPassword = By.cssSelector("#element-password");
    private static By registerEmail  = By.cssSelector("#element-email");
    private static By registerPhoneNumber = By.cssSelector("input[name = 'Phone']");
    private static By registerFirstName = By.cssSelector("#element-firstname");
    private static By registerLastName = By.cssSelector("#element-lastname");
    private static By registerButton = By.cssSelector(".btn.btn-default");
    private static By cancelLink = By.partialLinkText("Cancel");
    private static By registerSuccessMessage = By.cssSelector("span[id = 'saveMessage'][class = 'success-msg']");
    private static By verifyYourEmail = By.partialLinkText("Verify your Email");
    private static By verifyUserEmail = By.cssSelector("input[name = 'Email']");
    private static By verificationCode = By.cssSelector("input[name = 'EmailVerificationCode']");
    private static By verifyButton = By.cssSelector(".btn.btn-default");
    private static By resendVerificationCode = By.partialLinkText("Resend Verification");


    public static WebElement loginOnNavBar(){
        Waits.fluentWaitByLocator(driver, loginOnNavBar);
        return driver.findElement(loginOnNavBar);
    }

    public static WebElement userName(){
        Waits.fluentWaitByLocator(driver, userName);
        return driver.findElement(userName);
    }

    public static WebElement password(){
        Waits.fluentWaitByLocator(driver, password);
        return driver.findElement(password);
    }

    public static WebElement loginButton(){
        Waits.fluentWaitByLocator(driver, loginButton);
        return driver.findElement(loginButton);
    }

    public static WebElement loginFailureMsg(){
        //Waits.waitForWebElementToBeVisible(driver, loginFailureMsg());
        return driver.findElement(loginFailureMsg);
    }

    public static WebElement registerNewUser(){
        return driver.findElement(registerNewUser);
    }

    public static WebElement registerUserName(){
        Waits.fluentWaitByLocator(driver, registerUserName);
        return driver.findElement(registerUserName);
    }

    public static WebElement registerPassword(){
        Waits.fluentWaitByLocator(driver, registerPassword);
        return driver.findElement(registerPassword);
    }

    public static WebElement registerEmail(){
        Waits.fluentWaitByLocator(driver, registerEmail);
        return driver.findElement(registerEmail);
    }

    public static WebElement registerPhoneNumber(){
        Waits.fluentWaitByLocator(driver, registerPhoneNumber);
        return driver.findElement(registerPhoneNumber);
    }

    public static WebElement registerFirstName(){
        Waits.fluentWaitByLocator(driver, registerFirstName);
        return driver.findElement(registerFirstName);
    }

    public static WebElement registerLastName(){
        Waits.fluentWaitByLocator(driver, registerLastName);
        return driver.findElement(registerLastName);
    }

    public static WebElement registerButton(){
        Waits.fluentWaitByLocator(driver, registerButton);
        return driver.findElement(registerButton);
    }

    public static WebElement cancelLink(){

        return driver.findElement(cancelLink);
    }

    public static WebElement registerSuccessMsg(){
        Waits.waitForWebElementToBeVisible(driver, driver.findElement(registerSuccessMessage));
        return driver.findElement(registerSuccessMessage);
    }

    public static WebElement verifyUserEmail(){
        Waits.fluentWaitByLocator(driver, verifyUserEmail);
        return driver.findElement(verifyUserEmail);
    }

    public static WebElement verificationCode(){
        Waits.fluentWaitByLocator(driver, verificationCode);
        return driver.findElement(verificationCode);
    }

    public static WebElement verifyButton(){
        Waits.fluentWaitByLocator(driver, verifyButton);
        return driver.findElement(verifyButton);
    }

    public static WebElement resendVerificationCode(){

        return driver.findElement(resendVerificationCode);
    }

    public static void loginToPriceWatch(){
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.userName().sendKeys("kiddyt");
        Login_Page.password().sendKeys("123456");
        Login_Page.loginButton().click();
        Waits.waitForPageContent(driver, "Track." );
    }


}
