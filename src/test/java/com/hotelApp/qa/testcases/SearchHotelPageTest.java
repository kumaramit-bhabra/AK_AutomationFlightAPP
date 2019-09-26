package com.hotelApp.qa.testcases;

import com.hotelApp.qa.base.TestBase;
import com.hotelApp.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchHotelPageTest extends TestBase
{
    SearchHotelPage searchHotelPage;
    LoginPage loginPage;
    BookedItinerary bookedItinerary;
    ChangePassword changePassword;
    LogOut logOut;
    SelectHotelPage selectHotelPage;

    public SearchHotelPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
        searchHotelPage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void isUserLoggedInTest()
    {
        Assert.assertTrue(searchHotelPage.validateLoggedUserName(), "User is not logged in");
    }

    @Test
    public void searchHotelTitleTest()
    {
        Assert.assertEquals(searchHotelPage.validateSearchHotelTitle(),"AdactIn.com - Search Hotel", "Title of the page is not correct");
    }

    @Test
    public void searchHotelTest()
    {
        selectHotelPage = searchHotelPage.validateSearchHotelFunctionality();
    }

    @Test
    public void searchHotelResetTest()
    {
        Assert.assertTrue(searchHotelPage.validateResetFunctionality(),"Reset functionality is not working");
    }

   @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
