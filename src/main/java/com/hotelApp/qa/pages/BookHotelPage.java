package com.hotelApp.qa.pages;

import com.hotelApp.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookHotelPage extends TestBase
{
    //Define all the the Web Elements related to the page
    @FindBy(id ="first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "cc_num")
    WebElement cardNumber;

    @FindBy(id = "cc_type")
    WebElement selectCardType;

    @FindBy(id ="cc_exp_month")
    WebElement cardExpiryMth;

    @FindBy(id = "cc_exp_year")
    WebElement cardExpiryYear;

    @FindBy(id = "cc_cvv")
    WebElement cvvNumber;

    @FindBy(id = "book_now")
    WebElement bookNowBttn;

    @FindBy(id = "cancel")
    WebElement cancelBttn;
    //Initialize all the Web Elements
    public BookHotelPage()
    {
        PageFactory.initElements(driver,this);
    }

    //Define all the methods/ functionality associated with this page over here
    public void bookHotel()
    {
    firstName.sendKeys("Kumar Amit");
    lastName.sendKeys("Bhabra");
    address.sendKeys("63 Farmlands");
    cardNumber.sendKeys("1234567890123456");

    Select selectCardDropdown = new Select(selectCardType);
    selectCardDropdown.selectByVisibleText("VISA");

    Select cardExpiryMtdDropDown = new Select(cardExpiryMth);
    cardExpiryMtdDropDown.selectByVisibleText("April");

    Select cardExpiryYrDwopDown = new Select(cardExpiryYear);
    cardExpiryYrDwopDown.selectByVisibleText("2020");

    cvvNumber.sendKeys("123");
    bookNowBttn.click();

    }

}
