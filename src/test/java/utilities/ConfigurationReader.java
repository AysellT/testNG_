package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    /*
    configuration.properties file'indaki data'lari Java'da test olustururken
    okuyabilmasini saglayacak class, ConfigurationReader'dir.

    Java ile configuration.properties arasinda araci gorevi gorur.

    Test icinde istedigimiz zaman configuration.properties'daki datalari
    ConfigurationReader class'i uzerinden cagirabilmek icin bu class'a
    FileInputStream ile configuration.properties'i tanimlamamiz gerekir, bu islemi
    static blok icinde yaptik


     */

    static Properties properties ;

    static {

        String dosyaYolu = "configuration.properties";

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);
            //olustudugum properties'in icine fis'in okudugu herseyi herseyi yukledim

        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);
        // fis ile doldurdugum properties'den istedigim key'in karsiligini
        // bana getir dedim gerProperty(key) method'u ile

    }
}
