package com.hotelApp.qa.testcases;

import com.hotelApp.qa.base.TestBase;
import com.hotelApp.qa.pages.LoginPage;
import com.hotelApp.qa.pages.SearchHotelPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase
{
    LoginPage loginPage;
    SearchHotelPage searchHotelPage;

    public LoginPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
    }

    @Test (priority = 1)
    public void welcomeTextDisplayedTest()
    {
        String message = loginPage.validateWelcomeText();
        Assert.assertEquals(message, "Welcome to AdactIn Group of Hotels\n" +
                "       ");
    }

    @Test (priority = 2)
    public void newUserRegLinkDisplayedTest()
    {
        String regLink = loginPage.validateNewUserRegLink();
        Assert.assertEquals(regLink,"New User Register Here");
    }

    @Test (priority = 3)
    public void forgotPasswordLinkDisplayedTest()
    {
        String forgotPWLink = loginPage.validateForgotPasswordLink();
        Assert.assertEquals(forgotPWLink,"Forgot Password?");
    }

    @Test (priority = 4)
    public void successfulLoginTest() {
        String userName = prop.getProperty("username");
        String loggedUName;
        searchHotelPage = loginPage.validateLogin(userName, prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
