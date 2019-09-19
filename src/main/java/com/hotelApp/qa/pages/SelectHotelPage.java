package com.hotelApp.qa.pages;

import com.hotelApp.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends TestBase
{
    //Define all the Web elements associated with this class

    @FindBy(className = "login_title")
    WebElement selectHotel;

    public SelectHotelPage()
    {
        PageFactory.initElements(driver, this);
    }

    //Define the methods/functions that can be performed from this page
    public String validateSearchResultsDisplayed()
    {
        return selectHotel.getText();
    }
}
