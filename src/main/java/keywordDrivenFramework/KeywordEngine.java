package keywordDrivenFramework;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KeywordEngine extends Base {

    public WebDriver driver1;
    public Properties prop;

    public static Workbook book;
    public static Sheet sheet1, sheet2;

    public Base base;
    public WebElement e;

    public final String KEYWORD_SHEET_PATH = "src/main/java/keywordDrivenFramework/priceWatchKeyword.xlsx";

    public void startExecution(String sheetName1, String sheetName2) throws InterruptedException {


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

        //get the suite sheet from workbook
        sheet1 = book.getSheet(sheetName1);

        //get the sheet from workbook (login sheet from workbook)
        sheet2 = book.getSheet(sheetName2);

        int p = 0;
        //Loop through suite sheet row
        for (int j = 0; j<sheet1.getLastRowNum();j++){
            //get the test case no and execution status

            String exec = sheet1.getRow(j+1).getCell(p+2).toString().trim();

            if(exec.equalsIgnoreCase("YES")){

                //TODO: Create extent report
                //logger = reports.startTest(sheet1.getRow(j+1).getCell(p+1).getStringCellValue());



                String tc_no_sheet1 = sheet1.getRow(j+1).getCell(p).toString().trim(); //get test case id from suite sheet


                int k = 0; //counter for columns for login sheet

                //loop through login sheet rows
                for(int i = 0; i<sheet2.getLastRowNum(); i++){

                    String tc_no_sheet2 = sheet2.getRow(i+1).getCell(k).toString().trim();
                    if(tc_no_sheet2 == tc_no_sheet1) {
                    //get the first row of the sheet and get the column values

                        String locatorName = sheet2.getRow(i+1).getCell(k+2).toString().trim();
                        String locatorValue = sheet2.getRow(i+1).getCell(k+3).toString().trim();
                        String key = sheet2.getRow(i+1).getCell(k+4).toString().trim();
                        String value = sheet2.getRow(i+1).getCell(k+5).toString().trim();

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

                            case "wait for page content":
                                new WebDriverWait(driver1, 4000).until((WebDriver d) -> d.getPageSource().contains(value));
                                break;

                            case "sleep":
                                Thread.sleep(4000);
                                break;

                            case "get page url":
                                assertTrue(driver1.getCurrentUrl().contains(value));
                                break;

                            default:
                                break;

                        }

                        //switch cases for different selenium locators like id, cssSelector, XPATH
                        switch (locatorName){
                            case "id":
                                e =  driver1.findElement(By.id(locatorValue));
                                if(key.equalsIgnoreCase("click")){
                                    e.click();
                                }

                                else if(key.equalsIgnoreCase("sendkeys")){
                                    e.sendKeys(value);
                                }

                                else if(key.equalsIgnoreCase("get text")){
                                    assertEquals(value, driver1.findElement(By.id(locatorValue)).getText());

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

                                else if(key.equalsIgnoreCase("get text")){
                                    assertEquals(value, driver1.findElement(By.cssSelector(locatorValue)).getText());
                                    break;

                                }
                                locatorName = null;
                                break;

                            default:
                                break;

                        }

                    }





                }


            }

            //reports.endTest(logger);
            //reports.flush();

        }


    }

}
