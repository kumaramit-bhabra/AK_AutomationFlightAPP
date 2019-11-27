package com.hotelApp.qa.base;

import com.hotelApp.qa.util.UtilCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
       FileInputStream inputStream = new FileInputStream("src//main//java//com//hotelApp//qa//config//config.properties");
       prop.load(inputStream);
       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       catch (IOException e) {
           e.printStackTrace();
       }

   }

   public static void initialization() throws MalformedURLException {

       String browserName = prop.getProperty("browserName");
//Changes made
       if(browserName.equals("Chrome"))
       {
           System.setProperty("webdriver.chrome.driver","src//main//java//com//hotelApp//qa//testData//chromedriver.exe");
           driver = new ChromeDriver();
           /*DesiredCapabilities cap = new DesiredCapabilities();
           cap.setBrowserName(BrowserType.CHROME);
           driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),cap);*/
       }
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(UtilCommon.waitPageTimeOut,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(UtilCommon.implicitWaitTimeOut, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
       // System.out.println("Testing Git push in Test Base.java class");
   }

}
