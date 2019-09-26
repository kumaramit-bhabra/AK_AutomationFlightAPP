package com.hotelApp.qa.testcases;

import com.hotelApp.qa.base.TestBase;
import com.hotelApp.qa.pages.BookHotelPage;
import com.hotelApp.qa.pages.LoginPage;
import com.hotelApp.qa.pages.SearchHotelPage;
import com.hotelApp.qa.pages.SelectHotelPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookHotelPageTest extends TestBase
{
    LoginPage loginPage;
    SearchHotelPage searchHotelPage;
    SelectHotelPage selectHotelPage;
    BookHotelPage bookHotelPage;

    public BookHotelPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
        searchHotelPage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
        selectHotelPage = searchHotelPage.validateSearchHotelFunctionality();
        bookHotelPage = selectHotelPage.selectHotel();
    }

    @Test
    public void bookHotelTest()
    {
        bookHotelPage.bookHotel();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
