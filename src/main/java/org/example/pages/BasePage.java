package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected void get(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void fill(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void scrollToElementJS(By locator) {
        WebElement element = find(locator);
        String jsScript = "arguments[0].scrollIntoView();";
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript(jsScript, element);
    }

    protected void clickJS(By locator) {
        WebElement element = find(locator);
        String jsScript = "arguments[0].click();";
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript(jsScript, element);
    }

    protected boolean isElementPresent(By locator) {
        try {
            find(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    protected String getAlertMessage() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    protected WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    protected void dismissAlert() {
        switchTo().alert().dismiss();
    }

    protected Select selectDropDown(By locator) {
        return new Select(find(locator));
    }

    protected void findDropDownByIndex(By locator, int index) {
        selectDropDown(locator).selectByIndex(index);
    }

    protected void findDropDownByValue(By locator, String value) {
        selectDropDown(locator).selectByValue(value);
    }

    protected void deselectFromDropDownByVisibleText(By locator, String visibleText) {
        selectDropDown(locator).deselectByVisibleText(visibleText);
    }


    protected void findDropDownByVisibleText(By locator, String visibleText) {
        selectDropDown(locator).selectByVisibleText(visibleText);
    }

    protected void waitUntilElementIsVisible(By locator) {
        WebElement element;
        element = explicitWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilPresenceOfElementLocated(By locator) {
        WebElement element;
        element = explicitWait().until(
                ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    protected WebDriverWait explicitWait() {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    protected void switchToNewTab(String windowHandle) {
        switchTo().window(windowHandle);
    }

    protected void switchToFrameUsingIndex(int index) {
        switchTo().frame(index);
    }

    protected void switchToFrameUsingName(String nameOrId) {
        switchTo().frame(nameOrId);
    }
    protected void clickCheckBox(By locator)
    {
        if(!find(locator).isSelected()){
            clickJS(locator);
        }
    }

}
