package org.example.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage
{
    private final By login_html = By.cssSelector("a[href='fedcm/login.html']");
    private final By formPage_html = By.cssSelector("a[href='formPage.html']");
    private final By selectPage_html = By.cssSelector("a[href='selectPage.html']");
    private final By webFormPage_html = By.cssSelector("a[href='web-form.html']");

    public void goToHomePage()
    {
        get("https://www.selenium.dev/selenium/web/");
     //   new HomePage();
    }
    public LoginPage goToLoginPage()
    {
        waitUntilElementIsVisible(login_html);
        scrollToElementJS(login_html);
        clickJS(login_html);
//        get("https://www.selenium.dev/selenium/web/login.html");
        return new LoginPage();
    }
    public WebFormPage goToWebFromPage()
    {
        waitUntilElementIsVisible(webFormPage_html);
        scrollToElementJS(webFormPage_html);
        clickJS(webFormPage_html);
       // get("https://www.selenium.dev/selenium/web/web-form.html");
        return new WebFormPage();
    }
    public FormsPage goToFormPage()
    {
        waitUntilElementIsVisible(formPage_html);
        scrollToElementJS(formPage_html);
        clickJS(formPage_html);
        get("https://www.selenium.dev/selenium/web/formPage.html");
        return new FormsPage();
    }
    public SelectPage goToSelectPage()
    {
        waitUntilElementIsVisible(selectPage_html);
        scrollToElementJS(selectPage_html);
        clickJS(selectPage_html);
        return new SelectPage();
    }
}
