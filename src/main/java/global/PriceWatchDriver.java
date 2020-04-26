package global;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;


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

            case "Edge":
                System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

            case "RemoteDriverChromeMac":
                DesiredCapabilities chromemac1 = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.driver", "Documents/Selenium/chromedriver.exe");
                ChromeOptions options1 = new ChromeOptions();
                options1.addArguments("test-type");
                chromemac1.setCapability("chrome.binary","drivers/chromedriver.exe" );
                chromemac1.setCapability(ChromeOptions.CAPABILITY, options1);
                chromemac1.setPlatform(Platform.MAC);
                driver = new RemoteWebDriver(new
                        URL("http://192.168.1.69:4444/wd/hub"), chromemac1);

                break;

            case "RemoteDriverFirefoxMac":

                //DesiredCapabilities ffmac = DesiredCapabilities.firefox();
                //ffmac.setBrowserName("firefox");
               // ffmac.setPlatform(Platform.MAC);
                //driver = new RemoteWebDriver(new
                  //      URL("http://192.168.1.69:4444/wd/hub"), ffmac);
                System.setProperty("webdriver.gecko.driver","/Documents/Selenium/geckodriver.exe");
                FirefoxOptions ffmac = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.1.69:4444/wd/hub"), ffmac);
                break;








        }

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
