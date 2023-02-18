package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeknosaPage {

    public TeknosaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//div[@class='plp-info']")
    public WebElement aramaSonucSayisi;

    @FindBy (xpath = "(//div[@class='prd-media'])[1]")
    public WebElement ilkUrun;

    @FindBy (id = "addToCartButton")
    public WebElement buttonSepeteEkle;

    @FindBy (xpath = "//a[@class='btn btn-secondary']")
    public WebElement buttonSepetimeGit;

    @FindBy (xpath="//div[@class='cart-sum-body']")
    public WebElement siparisOzeti;

    @FindBy (xpath = "//a[@type='button']")
    public WebElement buttonAlisverisiTamamla;

    @FindBy (xpath = "//div[@class='lrp-title']")
    public WebElement hosgeldinizYazisi;

}
