package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationTestingPage {


    public AutomationTestingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//a[text()='Shop']")
    public WebElement linkShop;

    @FindBy (xpath = "//a[text()='Home']")
    public WebElement linkHome;

    @FindBy (xpath = "//*[@class='products']")
    public List<WebElement> arrivals;

    @FindBy (xpath = "//*[text()='350.00']")
    public WebElement lastArrivalPrice;

    @FindBy (xpath = "(//a[@class='woocommerce-LoopProduct-link'])[3]")
    public WebElement lastArrival;
    @FindBy (xpath = "//button[text()='Add to basket']")
    public WebElement buttonAddToBasket;

    @FindBy (xpath = "//*[text()='Description']")
    public WebElement linkDescription;

    @FindBy (xpath = "//div[@class='column']")
    public WebElement textDescription;

    @FindBy (xpath = "//h2[text()='Product Description']")
    public WebElement text;




}
