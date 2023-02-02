package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    /*
    JUnit'de kullandigimiz TestBase mantigini burada Driver class'i ile olusturacagiz
    bize driver donduren bir method olusturacagiz,TestBase'deki @Before test ile ayni islevi gorecek
     */

    private Driver(){
        //...
    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        String browser = ConfigurationReader.getProperty("browser");

        if (driver == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        // getDriver methodunu her cagirdigimizda yeni driver olusturmasin diye
        // eger bu method ilk defa driver olusturuyorsa yani driver==null ise
        // if 'in bodysindeki ayarlamalari yapip driver olustursun
        // Eger driver ilk defa olusturulmuyorsa yani driver!=null ise
        // zaten olusturulmus olan driver'i dondursun

        return driver;

    }

    public static void closeDriver() {

        // Burada yukarida yaptigimizin tam tersini yapacagiz
        // driver onceden olusturulmussa yani driver!=null ise
        // closeDriver methodu calissin
        // olusturulmamissa kapatacak bir driver yok demektir zaten :)

        if (driver != null) {
            driver.close();
            driver = null;
        }

    }

}
