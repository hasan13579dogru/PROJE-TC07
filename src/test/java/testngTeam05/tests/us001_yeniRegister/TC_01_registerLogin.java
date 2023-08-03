package testngTeam05.tests.us001_yeniRegister;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

import java.util.Random;



public class TC_01_registerLogin extends ExtentReport {
    /*
    Username girilmeli (Küçük harf, büyük harf, rakam ve özel karakter içerebilmeli)
    e-mail adresi girilmeli (abc@abc.com formatında e mail adresi olmalı)
    Password girilebilmelidir. (Parola en az 12 karakter uzunluğunda olmalıdır. Daha güçlü hale getirmek için büyük ve küçük harfler, sayılar ve ! " ? $ % ^ & kullanılmalıdır. )
    "I agree to the privacy policy" tıklanmadan kayıt olunmamalı
    SIGN UP butonu tıklanabilir olmalı (Username, Email address ve Password girilmeden SIGN UP tıklandığında kayıt işlemi gerçekleşmemeli)
     */

    AlloverCommercePage alloverCommercePage = new AlloverCommercePage();
    Random random = new Random();
    @Test
    public void test01() {
        extentReports = new ExtentReports();
        extentTest = extentReports.createTest("Chrome","Allovercommerce Sitesi Yeni Kayit Islemi");


        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        String mainPageHandle = Driver.getDriver().getWindowHandle();

        Assert.assertTrue(alloverCommercePage.anasayfaTitle.isDisplayed());
        extentTest.info("Allovercommerce anasayfasina gidildi.");

        alloverCommercePage.registerButton.click();
        extentTest.info("Register butonuna tiklandi");

        int rndm = random.nextInt();

        alloverCommercePage.userName.sendKeys("Umran." + rndm);
        ReusableMethods.bekle(2);


        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get(ConfigReader.getProperty("fakemailSitesiUrl"));
        alloverCommercePage.copyFakeMail.click();
        ReusableMethods.bekle(2);


        Driver.getDriver().switchTo().window(mainPageHandle);
        alloverCommercePage.yourEmailAddress.sendKeys(Keys.CONTROL, "v");
        ReusableMethods.bekle(2);


        alloverCommercePage.registerPassword.sendKeys(ConfigReader.getProperty("us01Password"));
        ReusableMethods.bekle(2);
        extentTest.info("Username, email ve password girildi.");
        alloverCommercePage.registerSignUp.click();

        Assert.assertTrue(alloverCommercePage.ilerlemekIcinTiklaYazisi.isDisplayed());
        extentTest.info("'I agree to the privacy policy' butonu tiklanmadan SignUp islemi gerceklesmedi.");

        Driver.quitDriver();
    }


}
