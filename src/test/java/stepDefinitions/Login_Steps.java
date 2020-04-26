package stepDefinitions;
import io.cucumber.java.Before;
import global.MainURLs;
import global.PriceWatchDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.*;


import priceWatchPages.Login_Page;
import utils.RandomGeneration;
import utils.Waits;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Login_Steps extends PriceWatchDriver {

    @Before
    public void openBrowser() throws IOException {
        setUp();

    }

    @Given("User loads PriceWatch URL")
    public void User_loads_PriceWatch_URL(){
        driver.get(MainURLs.URLList.PriceWatchURL);

    }

    @Given("User clicks on Login link")
    public void User_clicks_on_Login_link(){
        Login_Page.loginOnNavBar().click();
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String arg0, String arg1) {
        Login_Page.userName().sendKeys(arg0);
        Login_Page.password().sendKeys(arg1);
    }

    @When("clicks on Login button")
    public void clicks_on_Login_button() throws InterruptedException {
        Login_Page.loginButton().click();
        //Waits.waitForPageContent(driver, "Track." );
        Thread.sleep(2000);
    }


    @Then("Page URL should be {string}")
    public void page_URL_should_be(String str) {
        assertTrue(driver.getCurrentUrl().contains(str));

    }

    @Then("Browser should close")
    public void browser_should_close() {
        driver.quit();

    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        Login_Page.userName().sendKeys("abcabc");
        Login_Page.password().sendKeys("abcdef");

    }

    @Then("User should get login error message {string}")
    public void user_should_get_login_error_message(String msg) {
        assertEquals(Login_Page.loginFailureMsg().getText(), msg);
    }

    @When("User clicks on Register new user")
    public void user_clicks_on_Register_new_user() {
        Login_Page.registerNewUser().click();
    }

    @When("User enters username, password, email, phone number, first name, last name")
    public void user_enters_username_password_email_phone_number_first_name_last_name() {
        Login_Page.registerUserName().sendKeys(RandomGeneration.randomUserName());
        Login_Page.registerPassword().sendKeys("123456");
        Login_Page.registerEmail().sendKeys(RandomGeneration.randomUserEmail());
        Login_Page.registerPhoneNumber().sendKeys("4567866522");
        Login_Page.registerFirstName().sendKeys("John");
        Login_Page.registerLastName().sendKeys("Smith");
        Waits.waitForWebElementToBeVisible(driver, Login_Page.registerSuccessMsg());

    }

    @When("User clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        Login_Page.registerButton().click();
        Thread.sleep(3000);

    }

    @When("User clicks on cancel link")
    public void user_clicks_on_cancel_link() {
        Login_Page.cancelLink().click();
        Waits.waitForPageContent(driver, "Sign-in" );

    }

    @Then("User should get login success message {string}")
    public void user_should_get_login_success_message(String msg) {
        assertEquals(Login_Page.registerSuccessMsg().getText(), msg);
    }

    @After
    public void closeBrowser(){
        tearDown();
    }




}
