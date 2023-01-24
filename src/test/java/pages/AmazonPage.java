package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // Bu class'da amazon'a her gelisimizde gerceklestirdigimiz locate ve bazi islemleri tanimlayacagiz
    // boylelikle aramaKutusunu veya arama sonuclarini gibi her testin icinde
    // yeniden locate etmemize gerek kalmayacak

    // pages package'inin icindeki tum class'lar bunun icin kullanilir

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucu;
}
