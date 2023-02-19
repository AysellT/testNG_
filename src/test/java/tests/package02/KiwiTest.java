package tests.package02;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiTest {

    // https://www.kiwi.com sayfasina gidin
    // Cookies'i reddedin
    // Sayfa basliginin "Kiwi" icerdigini test edin
    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    // Sectiginiz dil ve para birimini dogrulayin
    // Ucus secenegi olarak tek yon secelim
    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

    Actions actions = new Actions(Driver.getDriver());
    KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void kiwiTest(){

        kiwiPage.kiwiGirisDilveParaSecimi();

        // Ucus secenegi olarak tek yon secelim
        ReusableMethods.bekle(2);
        kiwiPage.direction.click();
        kiwiPage.oneWay.click();

        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        kiwiPage.deleteDefaultCity.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(kiwiPage.boxFrom,"Istanbul").perform();
        actions.click(kiwiPage.istanbulTurkiye).perform();

        kiwiPage.boxTo.click();
        actions.sendKeys(kiwiPage.boxTo,"Prag").perform();
        kiwiPage.pragCekya.click();

        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        actions.click(kiwiPage.departure).perform();
        ReusableMethods.bekle(2);
        actions.click(kiwiPage.february8).perform();
        kiwiPage.buttonSetDates.click();
        ReusableMethods.bekle(2);
        kiwiPage.checkboxBooking.click();
        kiwiPage.buttonSearch.click();

        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        kiwiPage.optionDirect.click();

        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
        kiwiPage.optionEnUcuz.click();

        String priceStr = kiwiPage.textPrice.getText();
        priceStr = priceStr.replaceAll("\\D","");
        int price = Integer.parseInt(priceStr);
        Assert.assertTrue(price<5000);

        Driver.closeDriver();

    }

}
