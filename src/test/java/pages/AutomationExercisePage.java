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

    @FindBy (xpath = "//*[text()=' Signup / Login']")
    public WebElement linkSignUp;

    @FindBy (xpath = "//input[@name='name']")
    public WebElement boxName;

    @FindBy (xpath = "(//input[@name='email'])[2]")
    public WebElement boxEmail;

    @FindBy (xpath = "//button[text()='Signup']")
    public WebElement buttonSignUp;

    @FindBy (id="id_gender2")
    public WebElement radioButtonMrs;

    @FindBy (xpath = "//*[text()='Create Account']")
    public WebElement buttonCreateAccount;

    @FindBy (xpath = "//*[text()='Account Created!']")
    public WebElement textAccountCreated;

    @FindBy (xpath = "//*[text()=' Contact us']")
    public WebElement linkContactUs;

    @FindBy (xpath = "(//div[@class='col-sm-8'])[2]")
    public WebElement getInTouchElementi;

    @FindBy (xpath = "//input[@data-qa='name']")
    public WebElement boxNameContactUs;

    @FindBy (xpath = "//input[@name='upload_file']")
    public WebElement buttonChooseFile;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement buttonSubmit;

    @FindBy (xpath = "(//div[@style='display: block;'])[1]")
    public WebElement successMessage;

    @FindBy (xpath = "(//*[text()=' Home'])[2]")
    public WebElement buttonHome;

    @FindBy (xpath = "//h2[text()='Category']")
    public WebElement headerCategory;


}
