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
    SearchHotelPage homePage;
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
        homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void searchHotelTest()
    {
        selectHotelPage = homePage.validateSearchHotelFunctionality();
        selectHotelPage.validateSearchResultsDisplayed();
        Assert.assertEquals(selectHotelPage.validateSearchResultsDisplayed(),"Select Hotel");
    }

   @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
