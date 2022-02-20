package com.example.fork;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageTest
{
    public static final String UserId = "anam.naseer@gmail.com";
    public static final String Password = "Test@123";
    public static final String FirstName = "Anam";
    public static final String LastName = "Siddiquee";
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp()
    {
        final String rootDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",
            rootDir + "\\src\\test\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.thefork.com/");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        //Added hard wait to solve the captcha manually
        Thread.sleep(10000);
        mainPage.loginButton.click();

        //click on Accept cookies button
        WebElement accept_cookie = driver.findElement(By.xpath("//button[text()='Accept']"));

        wait.until(ExpectedConditions.visibilityOf(accept_cookie));
        accept_cookie.click();

        mainPage.emailID.sendKeys(UserId);

        mainPage.continueButton.click();
        mainPage.password.sendKeys(Password);

        wait.until(ExpectedConditions.visibilityOf(mainPage.password_text));

        assertEquals("Welcome AS,\n"
            + "Please enter your password", mainPage.password_text.getText());

        mainPage.continue_password.click();
        mainPage.personalInfoButton.click();
        assertEquals(FirstName, mainPage.fistName.getAttribute("value"));
        assertEquals(LastName, mainPage.lastName.getAttribute("value"));
        assertEquals(UserId, mainPage.emailInfo.getAttribute("value"));
    }

}
