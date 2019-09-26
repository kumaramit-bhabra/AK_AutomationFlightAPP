package com.hotelApp.qa.pages;

import com.hotelApp.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends TestBase
{
    @FindBy(id = "username_show")
    WebElement userNameShow;

    @FindBy(linkText = "Search Hotel")
    WebElement searchHotel;

    @FindBy(linkText = "Booked Itinerary")
    WebElement bookedItinerary;

    @FindBy(linkText = "Change Password")
    WebElement changePassword;

    @FindBy(linkText = "Logout")
    WebElement logOut;

    @FindBy(id = "location")
    WebElement location;

    @FindBy(id = "hotels")
    WebElement hotels;

    @FindBy(id = "room_type")
    WebElement roomType;

    @FindBy(id = "room_nos")
    WebElement roomNo;

    @FindBy(id = "datepick_in")
    WebElement datePickIn;

    @FindBy(id = "datepick_out")
    WebElement datePickOut;

    @FindBy(id = "adult_room")
    WebElement adultRoom;

    @FindBy(id = "child_room")
    WebElement childRoom;

    @FindBy(id = "Submit")
    WebElement submitBttn;

    @FindBy(id = "Reset")
    WebElement resetBttn;


    public SearchHotelPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateLoggedUserName()
    {
       boolean loggedUserName = false;
        if(userNameShow.getAttribute("value").contains( prop.getProperty("username")))
        {
            loggedUserName = true;
        }
        return  loggedUserName;
    }

    public SelectHotelPage validateSearchHotelFunctionality() {
        selectingDropDownValues();
        submitBttn.submit();
        return new SelectHotelPage();
    }

    public String validateSearchHotelTitle() {
        return driver.getTitle();
    }

    public boolean validateResetFunctionality()
    {
        boolean resultForReset = false;
        Select locForResetFun = new Select(location);
        String selectLocDropDwnDefVal = locForResetFun.getFirstSelectedOption().getText();
        System.out.println(selectLocDropDwnDefVal);

        Select hotelForResetFun = new Select(hotels);
        String selectHotDropDwnDefVal = hotelForResetFun.getFirstSelectedOption().getText();

        Select roomTypeDropDown = new Select(roomType);
        roomTypeDropDown.selectByVisibleText("Deluxe");

        selectingDropDownValues();
        resetBttn.click();
        if (selectLocDropDwnDefVal.equals("- Select Location -"))
        {
            if (selectHotDropDwnDefVal.equals("- Select Hotel -"))
            {
                resultForReset = true;
            }
        }
        return resultForReset;
    }


    public void selectingDropDownValues()
    {
            Select selectLocDropDwn = new Select(location);
            selectLocDropDwn.selectByIndex(1);

            Select hotelDropDwn = new Select(hotels);
            hotelDropDwn.selectByValue("Hotel Sunshine");

            Select roomTypeDropDown = new Select(roomType);
            roomTypeDropDown.selectByVisibleText("Deluxe");

            Select noOfRoomDropDown = new Select(roomNo);
            noOfRoomDropDown.selectByIndex(2);
            datePickIn.clear();
            datePickOut.clear();
            datePickIn.sendKeys("15/09/2019");
            datePickOut.sendKeys("20/09/2019");

            Select adultRoomDropDown = new Select(adultRoom);
            adultRoomDropDown.selectByIndex(1);

            Select childrenPerRoomDropDown = new Select(childRoom);
            childrenPerRoomDropDown.selectByValue("2");
    }

    public BookedItinerary validateBookedItinerary()
    {
        return new BookedItinerary();
    }

    public ChangePassword validateChangePassword()
    {
        return new ChangePassword();
    }

    public LogOut validateLogOut()
    {
        return new LogOut();
    }

    //Title AdactIn.com - Search Hotel
}
