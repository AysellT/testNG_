package utilities;

public class ReusableMethods {

    /*
    JUnit'de oldugu gibi test'lerde kullanacagimiz bazi methodlari tekrar tekrar
    olusturmaktansa ReusableMethods class'inda bir kere olusturup
    kullanilacagi zaman bu class uzerinden cagiracagiz :)
     */

    public void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }

    }
}
