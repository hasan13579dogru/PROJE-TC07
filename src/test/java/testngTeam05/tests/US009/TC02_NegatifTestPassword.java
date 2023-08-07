package testngTeam05.tests.US009;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC02_NegatifTestPassword extends ExtentReport {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("ExtentReport", "Test Raporu");
        // Kullanıcı adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        String allovercommerceHandle = Driver.getDriver().getWindowHandle();
        extentTest.info("Allovercommerce sitesine gidildi.");

        //Register a tıklar

        AlloverCommercePage commercePage = new AlloverCommercePage();
        commercePage.registerButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Register butonuna tıklandı.");

        //Register ekranından, Sign Up sekmesini kullanarak "Become a Vendor" linki ile giriş yapar
        commercePage.becomeAVendor.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up sekmesini kullanarak 'Become a Vendor' linki ile giriş yapıldı.");

        //Gecerli e mail adresini girer
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakemailSitesiUrlSG"));
        ReusableMethods.bekle(3);
        String fakeMailHandle = Driver.getDriver().getWindowHandle();
        commercePage.copyFakeMailSG.click();
        ReusableMethods.bekle(3);
        Driver.getDriver().switchTo().window(allovercommerceHandle);
        ReusableMethods.bekle(3);
        commercePage.userNameEmailAddressSG.sendKeys(Keys.CONTROL, "v");
        ReusableMethods.bekle(3);
        extentTest.info("Gecerli e mail adresini girildi.");

        //Verification cdoe text kutusuna tıklar
        commercePage.verificationCodeSG.click();
        extentTest.info("Verification cdoe text kutusuna tıklandı.");

        //Verification Code text kutusuna geldiğinde "Verification code sent to your email: abc@abc.com." mesajını görür
        Driver.getDriver().switchTo().window(fakeMailHandle);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(15);
        commercePage.fMailPasswordButton.click();
        ReusableMethods.bekle(5);

        WebElement verificationIframe=Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeMail']"));
        Driver.getDriver().switchTo().frame(verificationIframe);
        String passwordAlma= commercePage.fmailVerifacitionAlma.getText();
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().window(allovercommerceHandle);


        //Mail adresine gelen konu Verification Code text kutusuna girer
        commercePage.vendorverificationCodeSG.sendKeys(passwordAlma);
        extentTest.info("Verification Code text kutusuna girildi.");

        Assert.assertTrue(commercePage.verificationYazisi.isDisplayed());
        extentTest.info("Verification code sent to your email mesajı görüldü.");

        //Hatalı password:Küçük harf ve special karakter içermeyen bir şifre girer
        commercePage.vendorPasswordSG.sendKeys(ConfigReader.getProperty("password1"),Keys.TAB,ConfigReader.getProperty("password1"),Keys.ENTER);
        ReusableMethods.bekle(10);
        ReusableMethods.tumSayfaResmi("US09TC02");
        extentTest.info("Hatalı password ile giriş yapıldığı görüldü.");







    }
}

