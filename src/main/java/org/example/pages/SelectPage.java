package org.example.pages;

import org.openqa.selenium.By;

public class SelectPage extends BasePage {
    private final By select_option1 = By.id("selectWithoutMultiple");
    private final By select_option2 = By.id("selectWithMultipleEqualsMultiple");

    public void selectFromOption1(String value) {
        findDropDownByVisibleText(select_option1, value);
    }

    public void selectFromOption2(String value) {
        findDropDownByVisibleText(select_option2, value);
    }

    public void deSelectFromOption2(String value) {
        deselectFromDropDownByVisibleText(select_option2, value);
    }


}
