package testngTeam05.tests.us002_kayitliRegister;

import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC_01_kayitliLogin extends ExtentReport {
    /*
    Kayıtlı bir Username girilmeli
    Kayıtlı bir e-mail adresi girilmeli  (abc@abc.com formatında e mail adresi olmalı)
    Password girilebilmelidir. (Parola en az 12 karakter uzunluğunda olmalıdır. Daha güçlü hale getirmek için büyük ve küçük harfler, sayılar ve ! " ? $ % ^ & kullanılmalıdır. )
    SIGN UP butonuna tıklanmalı (Username, Email address ve Password girilmeden SIGN UP butonu tıklanabilir olmamalı)
    "An account is already registered with your email address." uyarı metni ve "Please log in." görülmeli

     */
    AlloverCommercePage alloverCommercePage = new AlloverCommercePage();
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Chrome","Allovercommerce Sitesi Kayitli email ile SignUp");

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        Assert.assertTrue(alloverCommercePage.anasayfaTitle.isDisplayed());
        extentTest.info("Allovercommerce sitesi anasayfasina gidildi.");

        alloverCommercePage.registerButton.click();
        extentTest.info("Anasayfada Register butonu tiklandi");

        alloverCommercePage.userName.sendKeys(ConfigReader.getProperty("registerUserName"));
        ReusableMethods.bekle(2);
        extentTest.info("Onceden kayitli bir userame girildi");

        alloverCommercePage.yourEmailAddress.sendKeys(ConfigReader.getProperty("registerMail"));
        ReusableMethods.bekle(2);
        extentTest.info("Onceden kayitli bir email girildi.");

        alloverCommercePage.registerPassword.sendKeys(ConfigReader.getProperty("registerPassword"));
        ReusableMethods.bekle(2);
        extentTest.info("Password bilgisi girildi");

        alloverCommercePage.registerSignUp.click();
        extentTest.info("'I agree to the privacy policy' butonuna tiklamadan SignUp butonu tiklandi");

        Assert.assertTrue(alloverCommercePage.ilerlemekIcinTiklaYazisi.isDisplayed());
        extentTest.info("Ilerlemek icin 'I agree to the privacy policy' butonunu tikla mesaji goruldu.");

        Driver.quitDriver();

    }


}







