package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//div[text()='Reject all']")
    public WebElement cookiesRejectAll;

    @FindBy (xpath = "//*[text()='TRY']")
    public WebElement language;

    @FindBy (xpath = "//select[@data-test='LanguageSelect']")
    public WebElement selectLanguage;

    @FindBy (xpath = "//select[@data-test='CurrencySelect']")
    public  WebElement selectCurrency;

    @FindBy (xpath = "//button[@data-test='SubmitRegionalSettingsButton']")
    public WebElement buttonSave;

    @FindBy (xpath = "//*[text()='TRY']")
    public WebElement text;

    public void kiwiGirisDilveParaSecimi(){
        // https://www.kiwi.com sayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("kiwiUrl"));

        // Cookies'i reddedin
        cookiesRejectAll.click();

        // Sayfa basliginin "Kiwi" icerdigini test edin
        String expectedTitle = "kiwi";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedTitle));

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        language.click();
        selectLanguage.click();
        Select select = new Select(selectLanguage);
        select.selectByValue("tr");
        selectCurrency.click();
        Select select1 = new Select(selectCurrency);
        select1.selectByVisibleText("Turkish lira - TRY");
        buttonSave.click();

        // Sectiginiz dil ve para birimini dogrulayin
        Assert.assertTrue(text.getText().contains("TRY"));

    }

    @FindBy (xpath ="(//button[@type='button'])[12]")
    public WebElement direction;

    @FindBy (xpath = "//a[@data-test='ModePopupOption-oneWay']")
    public WebElement oneWay;

    @FindBy (xpath = "//div[@data-test='PlacePickerInputPlace-close']")
    public WebElement deleteDefaultCity;

    @FindBy (xpath = "(//input[@data-test='SearchField-input'])[1]")
    public WebElement boxFrom;

    @FindBy (xpath = "(//div[@data-test='PlacePickerRow-wrapper'])[1]")
    public WebElement istanbulTurkiye;

    @FindBy (xpath = "(//input[@data-test='SearchField-input'])[2]")
    public WebElement boxTo;

    @FindBy (xpath = "//*[text()='Prag, Çekya']")
    public WebElement pragCekya;

    @FindBy (xpath = "//input[@data-test='SearchFieldDateInput']")
    public WebElement departure;

    @FindBy (xpath = "(//div[@data-test='DayContentContainer'])[8]")
    public WebElement february8;

    @FindBy (xpath = "//button[@data-test='SearchFormDoneButton']")
    public WebElement buttonSetDates;

    @FindBy (xpath = "//*[text()='Booking.com ile konaklama arayın']")
    public WebElement checkboxBooking;

    @FindBy (xpath = "//a[@data-test='LandingSearchButton']")
    public WebElement buttonSearch;

    @FindBy (xpath = "(//div[@class='Radio__IconContainer-sc-crlwn1-1 ixtoRa'])[1]")
    public WebElement optionDirect;

    @FindBy (xpath = "//span[text()='En ucuz']")
    public WebElement optionFirst;

    @FindBy (xpath = "(//span[@class=' length-8'])[4]")
    public WebElement textPrice;

}
