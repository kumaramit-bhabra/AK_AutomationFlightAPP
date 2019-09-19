package com.hotelApp.qa.pages;

import com.hotelApp.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase
{

    //define all the page elements associated with this class
    @FindBy(className = "login_title")
    WebElement pageHeader;

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "re_password")
    WebElement rePwd;

    @FindBy(id = "full_name")
    WebElement fullName;

    @FindBy(id = "email_add")
    WebElement emailAdd;

    @FindBy(id = "captcha")
    WebElement captchaImage;

    @FindBy(id = "captcha-form")
    WebElement captchaText;

    @FindBy(id = "tnc_box")
    WebElement tncChkBox;

    @FindBy(id = "Submit")
    WebElement regBttn;

    @FindBy(id = "Reset")
    WebElement resetBttn;

    public SignUpPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void validateNewUserRegister()
    {
        userName.sendKeys("tester123");
        password.sendKeys("amit3929");
        rePwd.sendKeys("amit3929");
        fullName.sendKeys("Tester");
        emailAdd.sendKeys("amit14nov@yahoo.com");
        captchaText.sendKeys(captchaImage.getText());
        tncChkBox.click();
        regBttn.click();
    }
}
