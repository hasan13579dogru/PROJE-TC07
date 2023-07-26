package testngTeam05.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/*
POM(Page Object Model)
    Test senaryolarının daha az kod ile yazılması ve bakımının daha kolay yapılmasına olanak sağlayan yazılım test
    yontemidir. TestNG'de ve CUCUMBER'da  POM kalıbını kullanırız.
 */

public class Driver {
    private Driver(){
        /*
        Driver class tan obje olusturmanın önüne geçmek için default constructor'ı
        private yaparak bunun onune geçebiliriz.
        Bu kalıba da Singleton Pattern denir.

         */
    }
    static WebDriver driver;
    public static WebDriver getDriver(){

        /*
        .properties dosyasına key olarak browser ve degerini asagıda oluşturdugumuz switch case lerden birini seçeriz
        ve seçtiğimiz driver calisir
         Testlerin baska browser'larda ne sonuc veriyor test etmek gerekebilir.
         */
        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                    default://yanlış bir şey girerse default olarak chrome driver çalışır
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();

            }
            /*
            Driver 'ı her cagırdıgımızda yeni bir pencere açılmasının önüne geçmek için if blogu
            içinde Eger driver'a deger atanmamışsa değer ata,eğer deger atanmışsa
            driver'ı aynı sayfada return et.
             */

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        //if bloguna koymamızın nedeni her biri için ayrı browser açmasın
        //halihazırda değer atanmış bir browser varsa onun üzerinden işlemlerini yapsın
       //yani diver.get() yaptıgımızda bir adrese gidiyorsa bu deger atanmış halidir.
        return driver;

    }
    public static void closeDriver(){
        if (driver!=null){//-->driver'a deger ATANMIŞSA
            driver.close();
            driver=null;//-->driver' ı kapattıktan sonra boşalt
        }


    }
    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;//--> driver'i tekrar null yapmamizin sebebi, diger methodlarda
//--> driver'i kullanmak icin
        }

    }

}
