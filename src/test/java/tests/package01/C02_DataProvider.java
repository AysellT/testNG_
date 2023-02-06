package tests.package01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C02_DataProvider {

    QualityDemyPage demy_page = new QualityDemyPage();
    @DataProvider
    public static Object[][] gonderilecekLogin(){

        Object[][] gonderilecekMailPassword = {{ConfigurationReader.getProperty("qdYanlisMail1"),ConfigurationReader.getProperty("qdYanlisPass1")},
                {ConfigurationReader.getProperty("qdYanlisMail2"),ConfigurationReader.getProperty("qdYanlisPass2")},
                {ConfigurationReader.getProperty("qdYanlisMail3"),ConfigurationReader.getProperty("qdYanlisPass3")},
                {ConfigurationReader.getProperty("qdGecerliUsername"),ConfigurationReader.getProperty("qdGecerliPassword")}};

        return gonderilecekMailPassword;
    }
    @Test(dataProvider = "gonderilecekLogin")
    public void qualityTest(String gonderilecekMail,String gonderilecekPassword){
        Driver.getDriver().get(ConfigurationReader.getProperty("qdUrl"));
        demy_page.gonderilecekMailPassword(gonderilecekMail,gonderilecekPassword);
    }
}
