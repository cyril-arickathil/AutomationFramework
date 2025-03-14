package org.example.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage
{
    private By username_field = By.id("user-name");
    private By password_field = By.id("password");
    private By login_button = By.id("login-button");
    private By errorMessage = By.xpath("//button[@data-test='error-button']");
    private By logo = By.className("app_logo");
    private By footer_section = By.xpath("//div[@data-test='footer-copy']");
    private By female_radioButton = By.id("");

    private By usernameField = By.id("username-field");
    private By passwordField = By.id("password-field");
    private By loginButton = By.id("login-form-submit");



    public LoginPage goToLoginPage()
    {
        get("https://www.selenium.dev/selenium/web/login.html");
        return new LoginPage();
    }
    public void dismissAlertOn(){
        dismissAlert();
    }
    public String enterCredentials(String username, String password)
    {
        setUsername(username);
        setPassword(password);
        clickLogin();
        return getAlertMessage();
    }
    public void clickLogin()
    {
        click(loginButton);
    }
    public void setUsername(String username)
    {
        fill(usernameField, username);
    }

    public void setPassword(String password)
    {
        fill(passwordField, password);
    }
public void fill_username(String username)
{
    fill(username_field, username);
}
public void fill_password(String password)
{
    fill(password_field, password);
}
public void click_login()
{
    click(login_button);
}
public String get_errorMessage()
{
    return find(errorMessage).getText();
}
public String get_logo()
{
    return find(logo).getText();
}
public void login(String username, String password)
{
    fill_username(username);
    fill_password(password);
    click_login();
}
public void scrollToFooter()
{
    scrollToElementJS(footer_section);
}
public void click_radioButton_female()
{
    scrollToElementJS(female_radioButton);
    clickJS(female_radioButton);
}
}
