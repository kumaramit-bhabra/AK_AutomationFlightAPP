package com.hotelApp.qa.testcases;

import com.hotelApp.qa.base.TestBase;
import com.hotelApp.qa.pages.BookHotelPage;
import com.hotelApp.qa.pages.SearchHotelPage;
import com.hotelApp.qa.pages.LoginPage;
import com.hotelApp.qa.pages.SelectHotelPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SelectHotelPageTest extends TestBase
{
    LoginPage loginPage;
    SearchHotelPage homePage;
    SelectHotelPage selectHotelPage;
    BookHotelPage bookHotelPage;

    public SelectHotelPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
        selectHotelPage = homePage.validateSearchHotelFunctionality();
    }

    //Define any test cases that you want to validate for this particular page
    @Test
    public void selectHotelTest()
    {
        bookHotelPage = selectHotelPage.selectHotel();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
