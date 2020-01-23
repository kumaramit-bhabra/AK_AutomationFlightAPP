package com.hotelApp.qa.base;

import com.hotelApp.qa.util.UtilCommon;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
           //The below is for running it on windows
           System.out.println("Operating system name is "+ System.getProperty("os.name"));
           String os = System.getProperty("os.name");
           if(os.contains("Windows"))
           {
               System.setProperty("webdriver.chrome.driver", "src//main//java//com//hotelApp//qa//testData//chromedriver.exe");
           }
           else
           //The below is for running it on unix
           System.setProperty("webdriver.chrome.driver","src//main//java//com//hotelApp//qa//testData//chromedriver");

           //System.setProperty("webdriver.chrome.driver","usr//local//bin//chromedriver");
           /*ChromeOptions options = new ChromeOptions();
           options.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
           options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
           options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
           options.addArguments("--headless"); // only if you are ACTUALLY running headless
           options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
           options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
           options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
           options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
           options.addArguments("--disable-gpu");
           //options.addArguments("--remote-debugging-port=9222");
           driver = new ChromeDriver(options);*/

           //Running it via Grid and on docker container installed locally
           DesiredCapabilities cap = new DesiredCapabilities();
           cap.setBrowserName(BrowserType.CHROME);
           driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),cap);
       }
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(UtilCommon.waitPageTimeOut,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(UtilCommon.implicitWaitTimeOut, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
       // System.out.println("Testing Git push in Test Base.java class");
   }

}
