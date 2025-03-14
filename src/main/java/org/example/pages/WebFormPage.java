package org.example.pages;

import org.openqa.selenium.By;

public class WebFormPage extends BasePage {
    private By textInput_field = By.id("my-text-id");
    private By password_field = By.name("my-password");
    private By textArea_field = By.name("my-textarea");
    private By dropDownSelect = By.name("my-select");
    private By checkbox_1 = By.id("my-check-1");
    private By radioButton_2 = By.id("my-radio-2");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By form_submitted_info_1 = By.xpath("button[type='submit']");
    private By message = By.id("message");


    public String fill_webForm(String textInput, String password, String textAreaInput, String dropDownText) {
        fill(textInput_field, textInput);
        fill(password_field, password);
        fill(textArea_field, textAreaInput);
        findDropDownByVisibleText(dropDownSelect, dropDownText);
        clickCheckBox(checkbox_1);
        clickJS(radioButton_2);
        clickJS(submitButton);
        String submitMessage = find(message).getText();
        return submitMessage;
    }

}
