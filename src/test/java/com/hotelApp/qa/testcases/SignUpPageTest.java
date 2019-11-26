package com.hotelApp.qa.testcases;

import com.hotelApp.qa.base.TestBase;
import com.hotelApp.qa.pages.LoginPage;
import com.hotelApp.qa.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignUpPageTest extends TestBase
{
    SignUpPage signUpPage;
    LoginPage loginPage;

    public SignUpPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        loginPage = new LoginPage();
        signUpPage = loginPage.clickNewUserReg();
    }

    @Test
    public void newUserRegTest()
    {
        signUpPage.validateNewUserRegister();
    }

   /* @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    */
}
