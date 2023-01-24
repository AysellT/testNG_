package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualityDemyPage {

    Actions actions = new Actions(Driver.getDriver());
    public QualityDemyPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement cookies;

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLink;

    @FindBy(id="login-email")
    public WebElement emailBox;

    @FindBy(id="login-password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Categories']")
    public WebElement categories;

    @FindBy(xpath = "(//*[text()='All courses'])[1]")
    public WebElement allCourses;

    @FindBy(xpath = "//a[text()='2']")
    public WebElement secondPages;

    @FindBy (xpath = "(//a[@class='course-title'])[5]")
    public WebElement english;

    @FindBy (xpath = "//button[text()='Buy now']")
    public WebElement buyNowButton;

    @FindBy (xpath = "//button[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy (xpath = "//div[@class='col-12']")
    public WebElement stripeOptions;

    @FindBy (xpath = "//button[text()='Pay with stripe']")
    public WebElement payWithStripeButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement payEmailBox;

    @FindBy(xpath = "//input[@name='cardNumber']")
    private WebElement cartNumberBox;

    @FindBy(xpath = "//div[@class='SubmitButton-IconContainer']")
    private WebElement payButton;

    public void payWithCard(){

        actions.sendKeys(payEmailBox,"aysltrg3@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("4242424242424242")
                .sendKeys(Keys.TAB).sendKeys("1125")
                .sendKeys(Keys.TAB).sendKeys("289")
                .sendKeys(Keys.TAB).sendKeys("visa").click(payButton).perform();

    }

    public void loginMethodu(){


    }
    @FindBy (xpath = "//h5[text()=' Java Kursu']")
    public WebElement javaKursu;

    @FindBy (xpath = "//button[@class='btn btn-add-wishlist ']")
    public WebElement addWishlistButton;

    @FindBy (xpath = "(//div[@class='icon'])[3]")
    public WebElement wishlistIcon;

    @FindBy (xpath = "//a[text()='Go to wishlist']")
    public WebElement goTowishlistButton;

    @FindBy(xpath = "//button[@onclick='handleWishList(this)']")
    public WebElement wishListRemove;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-yes']")
    public WebElement yesButton;


    public void gonderilecekMailPassword(String gonderilecekMail,String gonderilecekPassword){

        if (cookies.isDisplayed()) {
            cookies.click();
            loginLink.click();
            emailBox.sendKeys(gonderilecekMail);
            passwordBox.sendKeys(gonderilecekPassword);
            ReusableMethods.bekle(3);
        }else {
            loginLink.click();
            emailBox.sendKeys(gonderilecekMail);
            passwordBox.sendKeys(gonderilecekPassword);
            ReusableMethods.bekle(3);
        }
        loginButton.click();

    }
}
