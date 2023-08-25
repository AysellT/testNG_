package tests.package02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeknosaPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TeknosaTest {

    // 1- https://www.teknosa.com/ adresine gidin
    // 2- Arama cubuguna "oppo" yazin
    // 3- Cikan sonuc sayisini yazdirin
    // 4- Cikan ilk urune tiklayin
    // 5- Sepete ekleyiniz
    // 6- Sepetime git'e tiklayin
    // 7- consol da "Siparis Ozeti" webelementinin text'ini yazdirin
    // 8- Alisverisi tamamlayin'a tikla
    // 9- Son olarak "Teknosa'ya hos geldiniz" webelementinin text'ini yazdirin

    TeknosaPage teknosa = new TeknosaPage();
    Actions actions = new Actions(Driver.getDriver());
    private static final Logger logger = LogManager.getLogger(TeknosaTest.class);
    @Test
    public void teknosaTest() {

        logger.info("Test method is started");
        Driver.getDriver().get(ConfigurationReader.getProperty("teknosaUrl"));

        actions.sendKeys(teknosa.aramaKutusu, "Oppo").sendKeys(Keys.ENTER).perform();
        logger.info("Oppo secildi");

        //System.out.println(teknosa.aramaSonucSayisi.getText());

        actions.click(teknosa.ilkUrun).perform();

        actions.click(teknosa.buttonSepeteEkle).perform();
        logger.info("Oppo sepete eklendi");

        ReusableMethods.bekle(2);

        actions.click(teknosa.buttonSepetimeGit).perform();

        System.out.println(teknosa.siparisOzeti.getText());

        teknosa.buttonAlisverisiTamamla.click();

        System.out.println(teknosa.hosgeldinizYazisi.getText());
        logger.info("Test method is finished");

        Driver.closeDriver();

    }

}
