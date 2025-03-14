package org.example;

import static org.testng.Assert.*;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.SelectPage;
import org.example.pages.WebFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppTest extends BaseTest {
    private final HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testLogin() {
        loginPage.fill_username("admin");
        loginPage.fill_password("admin123");
        loginPage.click_login();
        String actualMessage =
                loginPage.get_errorMessage();
        assertFalse(actualMessage.contains("Epic"));
    }

    @Test
    public void test_successfullLogin() {
        loginPage.fill_username("standard_user");
        loginPage.fill_password("secret_sauce");
        loginPage.click_login();
        String actualMessage =
                loginPage.get_logo();
        assertEquals(actualMessage, "Swag Labs", "not logged in");

    }

    @Test
    public void test_simple_login() {
        loginPage.login("standard_user", "secret_sauce");
        loginPage.scrollToFooter();
    }

    @Test
    public void testForms() {
        boolean isFemaleRadioButtonSelected = practiceFormsPage.isFemaleSelected();
        if (!isFemaleRadioButtonSelected) {
            practiceFormsPage.select_female_radioButton();
        }
        assertTrue(isFemaleRadioButtonSelected, "female radio button is not selected");
        boolean isSportsSelected = practiceFormsPage.select_hobbies_sports();
        assertTrue(isSportsSelected, "sports is not selected in form");
    }

    @Test
    public void test_login() {
        String username = "cyril";
        String password = "cyril123";

        LoginPage loginPage = homePage.goToLoginPage();
        String alertMessage =
                loginPage.enterCredentials(username, password);
        assertEquals(alertMessage, "Please enter valid credentials", "mismatch found");
        loginPage.dismissAlertOn();
        // assertTrue(alertMessage.contains("Selenium"), "alert message is incorrect");

        //  var formsPage = homePage.goToFormPage();

    }

    @Test
    public void test_select() {
        homePage.goToHomePage();
        SelectPage selectPage = homePage.goToSelectPage();
        softAssert.assertEquals(1, 2, "\n mismatch to catch? \n");
        selectPage.selectFromOption1("two");
        selectPage.deSelectFromOption2("Emmental");
        softAssert.assertTrue(false,
                "\n this is soft assert and should fail \n");
        selectPage.selectFromOption2("Parmigiano");
        // assertTrue(false, "test should fail");
        softAssert.assertAll();

    }
    @Test
    public void test_webForm(){
        String expectedMessage = "Received!";
        homePage.goToHomePage();
        WebFormPage webFormPage = homePage.goToWebFromPage();
        String actualMessage=
        webFormPage.fill_webForm("admin", "admin123", "learning selenium", "Three");
        assertEquals(actualMessage, expectedMessage, "form could not be submitted!");




    }
}
