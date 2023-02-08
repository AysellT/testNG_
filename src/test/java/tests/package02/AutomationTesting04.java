package tests.package02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationTestingPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AutomationTesting04 {

    AutomationTestingPage automationTP = new AutomationTestingPage();

    Actions actions = new Actions(Driver.getDriver());

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void automationTesting04(){



        Driver.getDriver().get(ConfigurationReader.getProperty("automationtestingUrl"));

        automationTP.linkShop.click();
        automationTP.linkHome.click();

        softAssert.assertEquals(automationTP.arrivals.size(),3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        automationTP.lastArrival.click();

        ReusableMethods.bekle(2);

        softAssert.assertTrue(automationTP.buttonAddToBasket.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        automationTP.linkDescription.click();

        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        softAssert.assertTrue(automationTP.textDescription.getText().equals(""));

        softAssert.assertAll();

        Driver.closeDriver();
    }

}
