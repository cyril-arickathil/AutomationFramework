package org.example;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.PracticeFormsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest
{
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected PracticeFormsPage practiceFormsPage;
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage();
        basePage.setDriver(driver);
    }
    @AfterClass
    public void tearDown()
    {
       driver.quit();
    }
}
