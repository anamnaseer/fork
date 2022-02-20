package com.example.fork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage
{
    @FindBy(css = "input#identification_email")
    public WebElement emailID;

    @FindBy(css = "button._35vz9")
    public WebElement loginButton;

    @FindBy(css = "[data-testid='checkout-submit-email']")
    public WebElement continueButton;

    @FindBy(css = "input#password")
    public WebElement password;

    @FindBy(css = "[class='css-unbo6k eulusyj0']")
    public WebElement password_text;

    @FindBy(css = "[data-testid='submit-password']")
    public WebElement continue_password;

    @FindBy(css = "[aria-controls='user-space-user-information']")
    public WebElement personalInfoButton;

    @FindBy(css = "[name='firstName']")
    public WebElement fistName;

    @FindBy(css = "[name='lastName']")
    public WebElement lastName;

    @FindBy(css = "[name='email']")
    public WebElement emailInfo;

    public MainPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
