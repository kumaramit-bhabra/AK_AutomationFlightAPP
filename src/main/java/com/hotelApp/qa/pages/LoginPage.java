package com.hotelApp.qa.pages;

import com.hotelApp.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory Object Repository

    @FindBy(id ="username")
    WebElement userName;

    @FindBy(id ="password")
    WebElement password;

    @FindBy(id ="login")
    WebElement loginButton;

    @FindBy(className = "content_left")
    WebElement welcomeMessage;

    @FindBy(linkText = "New User Register Here")
    WebElement newUserReg;

    @FindBy(linkText = "Forgot Password?")
    WebElement forgotPW;

//This is used for initializing the Page Objects / Objects Repository
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String validateWelcomeText()
    {
        String message;
        message = welcomeMessage.getText();
        return message;
    }

    public String validateNewUserRegLink()
    {
        String newUserReglink = newUserReg.getText();
        return newUserReglink;
    }

    public String validateForgotPasswordLink()
    {
        String forgotPWLink = forgotPW.getText();
        return forgotPWLink;
    }

    public SearchHotelPage validateLogin(String usName, String usPassword)
    {
        userName.sendKeys(usName);
        password.sendKeys(usPassword);
        loginButton.click();
        return new SearchHotelPage();
    }

    public SignUpPage clickNewUserReg()
    {
        newUserReg.click();
        return new SignUpPage();
    }
}
