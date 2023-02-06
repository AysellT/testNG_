package tests.package01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_IlkTest {

    //qualityDemy web sayfasina gidin
    // cookies i kabul edin
    // login linkine tiklayin
    // email ve password bilgilerini girerek login butonuna tiklayin
    // categories dropdown dan all courses secenegine tiklayin
    // acilan sayfada olan derslerden The English Master Course dersine tiklayin
    // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
    // stripe secenegini secerek pay with stripe e tiklayin
    // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin

    QualityDemyPage quality = new QualityDemyPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void QualityDemyTest(){

        //qualityDemy web sayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("qdUrl"));

        // cookies i kabul edin
        quality.cookies.click();

        // login linkine tiklayin
        quality.loginLink.click();

        // email ve password bilgilerini girerek login butonuna tiklayin
        quality.emailBox.sendKeys(ConfigurationReader.getProperty("qdGecerliUsername"));
        quality.passwordBox.sendKeys(ConfigurationReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(2);
        quality.loginButton.click();

        // categories dropdown dan all courses secenegine tiklayin
        actions.moveToElement(quality.categories).clickAndHold(quality.categories).perform();
        actions.moveToElement(quality.allCourses).click(quality.allCourses).perform();
        ReusableMethods.bekle(5);

        // acilan sayfada olan derslerden The English Master Course dersine tiklayin
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);
        quality.secondPages.click();

        // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        quality.english.click();

        quality.buyNowButton.click();
        ReusableMethods.bekle(3);
        quality.checkoutButton.click();

        // stripe secenegini secerek pay with stripe e tiklayin
        quality.stripeOptions.click();
        quality.payWithStripeButton.click();

        // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin
        quality.payWithCard();

    }
    //qualityDemy web sayfasina gidin
    // cookies i kabul edin
    // login linkine tiklayin
    // email ve password bilgilerini girerek login butonuna tiklayin
    // anasayfadan java kursunu secelim
    // acilan sayfada ders add to wishlist e eklenir
    // urunun eklendigi test edilir
    // eklenilen urun wishlistten cikarilir
    //cikarildigi test ediliri

    @Test
    public void test02(){

        Driver.getDriver().get(ConfigurationReader.getProperty("qdUrl"));
        quality.cookies.click();
        quality.loginLink.click();
        quality.emailBox.sendKeys(ConfigurationReader.getProperty("qdGecerliUsername"));
        quality.passwordBox.sendKeys(ConfigurationReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(2);
        quality.loginButton.click();

        // anasayfadan java kursunu secelim
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        quality.javaKursu.click();
        ReusableMethods.bekle(2);

        // acilan sayfada ders add to wishlist e eklenir
        quality.addWishlistButton.click();

        // urunun eklendigi test edilir
        actions.scrollToElement(quality.wishlistIcon).perform();
        ReusableMethods.bekle(2);
        actions.moveToElement(quality.wishlistIcon)
                .click(quality.goTowishlistButton).perform();
        ReusableMethods.bekle(2);
        Assert.assertTrue(quality.javaKursu.isDisplayed());

        // eklenilen urun wishlistten cikarilir
        quality.wishListRemove.click();
        ReusableMethods.bekle(2);
        quality.yesButton.click();

        //cikarildigi test edilir
        Assert.assertFalse(quality.javaKursu.isDisplayed());
    }



}
