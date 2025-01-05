package com.pshared.pages;

import com.pshared.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "username-inp")
    public WebElement userName;

    @FindBy(id = "password-inp")
    public WebElement password;

    @FindBy(css = "#signInSubmitButton")
    public WebElement signInButton;
}
