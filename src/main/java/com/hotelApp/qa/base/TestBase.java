package com.hotelApp.qa.base;

import com.hotelApp.qa.util.UtilCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static WebDriver driver;
    public static Properties prop;

   public TestBase()
   {
       try
       {
       prop = new Properties();
       FileInputStream inputStream = new FileInputStream("C:\\Users\\Admin\\Documents\\GitHub Automation\\AK_AutomationFlightAPP\\src\\main\\java\\com\\hotelApp\\qa\\config\\config.properties");
       prop.load(inputStream);
       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       catch (IOException e) {
           e.printStackTrace();
       }

   }

   public static void initialization()
   {
       String browserName = prop.getProperty("browserName");

       if(browserName.equals("Chrome"))
       {
           System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
           driver = new ChromeDriver();
       }
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(UtilCommon.waitPageTimeOut,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(UtilCommon.implicitWaitTimeOut, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
       // System.out.println("Testing Git push in Test Base.java class");
   }

}
