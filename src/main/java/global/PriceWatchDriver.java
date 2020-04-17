package global;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;


public class PriceWatchDriver {

    public static WebDriver driver;

    @Before
    public  void setUp() throws IOException {

        switch(global.MainURLs.URLList.DriverName){

            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

        }

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
