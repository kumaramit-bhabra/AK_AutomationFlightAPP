package com.hotelApp.qa.testcases;

import com.hotelApp.qa.base.TestBase;
import com.hotelApp.qa.pages.SearchHotelPage;
import com.hotelApp.qa.pages.LoginPage;
import com.hotelApp.qa.pages.SelectHotelPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectHotelPageTest extends TestBase
{
    LoginPage loginPage;
    SearchHotelPage homePage;
    SelectHotelPage selectHotelPage;

    public SelectHotelPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
        selectHotelPage = homePage.validateSearchHotelFunctionality();
    }

    //Define any test cases that you want to validate on this particular page
    @Test


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
