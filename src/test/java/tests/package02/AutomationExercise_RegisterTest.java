package tests.package02;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AutomationExercise_RegisterTest {

    //1- "automationExerciseUrl" anasayfasina gidin
    //2- sign up linkine tiklayin
    //3- Create an account bolumune email adresi girin
    //4- sign up butonuna basin
    //5- kisisel bilgilerini ve iletisim bilgilerini girin
    //6- Create Account butonuna basin
    //7- hesap olustugunu dogrulayin

    AutomationExercisePage automationExercisePage = new AutomationExercisePage();
    String userName;
    String userEmail;
    String userPassword;
    Faker faker = new Faker();


    @Test
    public void testResgister(){

        Driver.getDriver().get(ConfigurationReader.getProperty("automationExerciseUrl"));

        automationExercisePage.linkSignUp.click();

        userName = faker.name().firstName();
        userEmail = faker.internet().emailAddress();
        automationExercisePage.boxName.sendKeys(userName);
        automationExercisePage.boxEmail.sendKeys(userEmail);

        automationExercisePage.buttonSignUp.click();

        userPassword = faker.internet().password();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(automationExercisePage.radioButtonMrs)
                .sendKeys(Keys.TAB)
                .sendKeys(userName)
                .sendKeys(Keys.TAB)
                .sendKeys(userPassword)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Jaunary")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(userName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Texas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("657439")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).perform();

        automationExercisePage.buttonCreateAccount.click();

        Assert.assertTrue(automationExercisePage.textAccountCreated.isDisplayed());

        Driver.getDriver().close();

    }
}
