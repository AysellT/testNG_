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

    @FindBy (xpath = "//h3[text()='Mastering JavaScript']")
    public WebElement lastArrival;

    @FindBy (xpath = "//button[text()='Add to basket']")
    public WebElement buttonAddToBasket;

    @FindBy (xpath = "//*[text()='Description']")
    public WebElement linkDescription;

    @FindBy (xpath = "//div[@class='column']")
    public WebElement textDescription;




}
