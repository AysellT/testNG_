package tests.package02;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationTestingPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationTesting_Test04 {

    AutomationTestingPage automationTP = new AutomationTestingPage();

    Actions actions = new Actions(Driver.getDriver());

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void automationTesting04(){

        Driver.getDriver().get(ConfigurationReader.getProperty("automationtestingUrl"));

        automationTP.linkShop.click();
        automationTP.linkHome.click();

        softAssert.assertEquals(automationTP.arrivals.size(),3);

        actions.scrollToElement(automationTP.lastArrivalPrice).perform();
        ReusableMethods.bekle(2);
        actions.click(automationTP.lastArrival).perform();

        ReusableMethods.bekle(2);

        softAssert.assertTrue(automationTP.buttonAddToBasket.isDisplayed());

        actions.scrollToElement(automationTP.textDescription).perform();

        automationTP.linkDescription.click();

        softAssert.assertFalse(automationTP.textDescription.getText().equals(""));

        softAssert.assertAll();

        Driver.closeDriver();
    }

}
