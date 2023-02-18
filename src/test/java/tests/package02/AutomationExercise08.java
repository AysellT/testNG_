package tests.package02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AutomationExercise08 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that  detail is visible: product name, category, price, availability, condition, brand

    AutomationExercisePage automationExercise = new AutomationExercisePage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void automationExercise08(){

        Driver.getDriver().get(ConfigurationReader.getProperty("automationExerciseUrl"));

        String expectedTitle = "automationexercise";
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedTitle));

        automationExercise.linkProducts.click();
        softAssert.assertTrue(automationExercise.labelAllProducts.isDisplayed());

        //List<WebElement> allProductsList = automationExercise.listAllProducts;
        //List<String> allProductsListStr = ReusableMethods.getElementsText(allProductsList);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        automationExercise.firstProduct.click();
        softAssert.assertTrue(automationExercise.productInformation.isDisplayed());

        softAssert.assertAll();
        Driver.getDriver().close();

    }

}
