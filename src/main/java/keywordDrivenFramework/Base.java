package keywordDrivenFramework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver1;
    public Properties prop;

    public ExtentReports reports;
    public ExtentTest logger;

    //creating a constructor
    public Base(){
        //code will generate file Reports.html and put the report there
        reports = new ExtentReports("src\\test\\java\\keywordDrivenFrameworkTests\\Report.html");

    }


    public WebDriver init_driver(String browserName){
        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
            driver1 = new ChromeDriver();
            driver1.manage().window().maximize();

        }

        else if(browserName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
            driver1 = new FirefoxDriver();
            driver1.manage().window().maximize();
        }

        else if(browserName.equals("Edge")){
            System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
            driver1 = new EdgeDriver();
            driver1.manage().window().maximize();
        }

        return driver1;

    }


    public Properties init_properties(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/main/java/keywordDrivenFramework/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }



}
