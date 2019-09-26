package com.hotelApp.qa.pages;

import com.hotelApp.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends TestBase
{
    //Define all the Web elements associated with this class

    @FindBy(id = "continue")
    WebElement continueBttn;

    @FindBy(id = "cancel")
    WebElement cancelBttn;

    @FindBy(className = "login_title")
    WebElement title;

    public SelectHotelPage()
    {
        PageFactory.initElements(driver, this);
    }

    //Define the methods/functions that can be performed from this page
    public boolean validateSearchResultsDisplayed()
    {
        return title.isDisplayed();
    }

    public BookHotelPage selectHotel()
    {
        int i = 0;
        driver.findElement(By.xpath("//input[@class = 'select_text']/parent::td/preceding-sibling::td//input[@id ='radiobutton_"+i+"']")).click();
        continueBttn.click();
        return new BookHotelPage();
    }
}
