package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()=' Products']")
    public WebElement linkProducts;

    @FindBy (xpath = "//*[text()='All Products']")
    public WebElement labelAllProducts;

    @FindBy (xpath = "//div[@class='col-sm-4']")
    public List<WebElement> listAllProducts;

    @FindBy (xpath = "(//a[@style='color: brown;'])[1]")
    public WebElement firstProduct;

    @FindBy (xpath = "//div[@class='product-information']")
    public WebElement productInformation;


}
