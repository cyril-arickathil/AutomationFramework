package org.example.pages;

import org.openqa.selenium.By;

public class PracticeFormsPage extends BasePage
{
    private By female_radioButton = By.id("");
    private By sports_hobbies_checkBox = By.id("");
    public boolean isFemaleSelected()
    {
        return find(female_radioButton).isSelected();
    }
    public void select_female_radioButton()
    {
        scrollToElementJS(female_radioButton);
        clickJS(female_radioButton);
    }
    public boolean select_hobbies_sports()
    {
        if (!find(sports_hobbies_checkBox).isSelected())
        {
            scrollToElementJS(sports_hobbies_checkBox);
            clickJS(sports_hobbies_checkBox);
        }
        return find(sports_hobbies_checkBox).isSelected();

    }
    public void deselect_hobbies_sports()
    {
        if (find(sports_hobbies_checkBox).isSelected())
        {
            scrollToElementJS(sports_hobbies_checkBox);
            clickJS(sports_hobbies_checkBox);
        }
    }
}
