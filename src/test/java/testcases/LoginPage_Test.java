package testcases;

import global.MainURLs;
import global.PriceWatchDriver;
import org.junit.Test;
import priceWatchPages.Login_Page;
import utils.JDBCConnectionClass;
import utils.RandomGeneration;
import utils.Waits;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage_Test extends PriceWatchDriver {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.userName().sendKeys("kiddyt");
        Login_Page.password().sendKeys("123456");
        Login_Page.loginButton().click();
        Waits.waitForPageContent(driver, "Track." );
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("/trackproduct"));

    }

    @Test
    public void testInvalidUsernameOrPassword(){
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.userName().sendKeys("abcabc");
        Login_Page.password().sendKeys("abcdef");
        Login_Page.loginButton().click();
        assertEquals(Login_Page.loginFailureMsg().getText(), "ERROR! - Invalid username/password.");
    }

    @Test
    public void testEmailVerificationMsg(){
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.userName().sendKeys("Kiddy");
        Login_Page.password().sendKeys("123456");
        Login_Page.loginButton().click();
        assertEquals(Login_Page.loginFailureMsg().getText(), "Your email is not verified. Please check your email for a verification code.");
    }

    @Test
    public void testRegisterNewUser() throws InterruptedException {
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.registerNewUser().click();
        Login_Page.registerUserName().sendKeys(RandomGeneration.randomUserName());
        Login_Page.registerPassword().sendKeys("123456");
        Login_Page.registerEmail().sendKeys(RandomGeneration.randomUserEmail());
        Login_Page.registerPhoneNumber().sendKeys("4567866522");
        Login_Page.registerFirstName().sendKeys("John");
        Login_Page.registerLastName().sendKeys("Smith");
        Login_Page.registerButton().click();
        Thread.sleep(5000);
        assertEquals(Login_Page.registerSuccessMsg().getText(), "Username registered successfully. An email verification code is sent to your registered email.");
    }

    @Test
    public void testCancelRegistration(){
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.registerNewUser().click();
        Login_Page.registerUserName().sendKeys(RandomGeneration.randomUserName());
        Login_Page.registerPassword().sendKeys("123456");
        Login_Page.registerEmail().sendKeys(RandomGeneration.randomUserEmail());
        Login_Page.registerPhoneNumber().sendKeys("4567866522");
        Login_Page.cancelLink().click();
        Waits.waitForPageContent(driver, "Sign-in" );
        assertTrue(driver.getCurrentUrl().contains("PriceWatch/login"));

    }

    @Test
    public void testEmailVerificationWithCode() throws InterruptedException, SQLException, ClassNotFoundException {
        String email = RandomGeneration.randomUserEmail();
        driver.get(MainURLs.URLList.PriceWatchURL);
        Login_Page.loginOnNavBar().click();
        Login_Page.registerNewUser().click();
        Login_Page.registerUserName().sendKeys(RandomGeneration.randomUserName());
        Login_Page.registerPassword().sendKeys("123456");
        Login_Page.registerEmail().sendKeys(email);
        Login_Page.registerPhoneNumber().sendKeys("4567866522");
        Login_Page.registerFirstName().sendKeys("John");
        Login_Page.registerLastName().sendKeys("Smith");
        Login_Page.registerButton().click();
        Thread.sleep(5000);
        Login_Page.verifyYourEmailLink().click();
        Login_Page.verifyUserEmail().sendKeys(email);
        Login_Page.verificationCode().sendKeys(JDBCConnectionClass.connectToPriceWatchDBToGetEmailVerificationCode(email));
        Login_Page.verifyButton().click();
        Waits.fluentWaitByLocator(driver, Login_Page.registerSuccessMessage);
        assertEquals("Your email verification is successful.", Login_Page.registerSuccessMsg().getText());

    }

}
