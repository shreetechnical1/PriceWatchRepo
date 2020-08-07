package keywordDrivenFramework;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KeywordEngine {

    public WebDriver driver1;
    public Properties prop;

    public static Workbook book;
    public static Sheet sheet;

    public Base base;
    public WebElement e;

    public final String KEYWORD_SHEET_PATH = "src/main/java/keywordDrivenFramework/priceWatchKeyword.xlsx";

    public void startExecution(String sheetName){

        //String locatorName = null;
        //String locatorValue = null;

        FileInputStream file = null;
        try {
            file = new FileInputStream(KEYWORD_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            //get the workbook
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //get the sheet from workbook
        sheet = book.getSheet(sheetName);

        int k = 0; //counter for columns

        for(int i = 0; i<sheet.getLeftCol(); i++){

            //get the first row of the sheet and get the column values
            String locatorName = sheet.getRow(i+1).getCell(k+1).toString().trim();
            String locatorValue = sheet.getRow(i+1).getCell(k+2).toString().trim();
            String key = sheet.getRow(i+1).getCell(k+3).toString().trim();
            String value = sheet.getRow(i+1).getCell(k+4).toString().trim();

            //Now we will write switch statements for browser actions

            switch (key){
                case "open browser":
                    base = new Base();
                    prop =  base.init_properties();
                    if(value.isEmpty() || value.equalsIgnoreCase("NA")){
                        driver1 = base.init_driver(prop.getProperty("browser"));
                    }

                    else{
                        driver1 = base.init_driver(value);
                    }
                    break;

                case "enter url":
                    if(value.isEmpty() || value.equalsIgnoreCase("NA")){
                        driver1.get(prop.getProperty("url"));
                    }
                    else{
                        driver1.get(value);
                    }
                    break;

                case "quit":
                    driver1.quit();
                    break;

                default:
                    break;

            }

            //swich cases for different selenium locators like id, cssSelector, XPATH
            switch (locatorName){
                case "id":
                 e =  driver1.findElement(By.id(locatorValue));
                 if(key.equalsIgnoreCase("click")){
                    e.click();
                 }

                 else if(key.equalsIgnoreCase("sendkeys")){
                     e.sendKeys(value);
                 }
                 locatorName = null;
                 break;

                case "cssSelector":
                    e =  driver1.findElement(By.cssSelector(locatorValue));
                    if(key.equalsIgnoreCase("click")){
                       e.click();
                    }

                    else if(key.equalsIgnoreCase("sendkeys")){
                       e.sendKeys(value);
                    }
                    locatorName = null;
                    break;

                default:
                    break;

            }


        }


    }

}
