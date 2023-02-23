package tests.package02;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class AutomationExercise_TestActions {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

    AutomationExercisePage automationP = new AutomationExercisePage();

    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Test
    public void test01(){

        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("automationExerciseUrl"));

        //3. Verify that home page is visible successfully
        String expUrl = "automationexercise";
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expUrl));

        //4. Click on 'Contact Us' button
        automationP.linkContactUs.click();

        //5. Verify 'GET IN TOUCH' is visible
        softAssert.assertTrue(automationP.getInTouchElementi.isDisplayed());

        //6. Enter name, email, subject and message
        actions.click(automationP.boxNameContactUs)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Siparis teslim suresi")
                .sendKeys(Keys.TAB)
                .sendKeys("Siparis teslim suresi").perform();

        //7. Upload file
        String filePath = System.getProperty("user.home")+"/Desktop/Siparis teslim suresi.txt";
        automationP.buttonChooseFile.sendKeys(filePath);

        //8. Click 'Submit' button
        automationP.buttonSubmit.click();

        //9. Click OK button
        Driver.getDriver().switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        softAssert.assertTrue(automationP.successMessage.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        automationP.buttonHome.click();
        softAssert.assertTrue(automationP.headerCategory.isDisplayed());

        softAssert.assertAll();

        Driver.getDriver().quit();

    }
}
