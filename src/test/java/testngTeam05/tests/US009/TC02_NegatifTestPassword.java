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
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC02_NegatifTestPassword  {

    @Test
    public void test01() {
        // Kullanıcı adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        String allovercommerceHandle = Driver.getDriver().getWindowHandle();

        //Register a tıklar
        AlloverCommercePage commercePage = new AlloverCommercePage();
        commercePage.registerButton.click();
        ReusableMethods.bekle(3);

        //Register ekranından, Sign Up sekmesini kullanarak "Become a Vendor" linki ile giriş yapar
        commercePage.becomeAVendor.click();
        ReusableMethods.bekle(3);

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


        //Verification Code text kutusuna geldiğinde "Verification code sent to your email: abc@abc.com." mesajını görür
        commercePage.verificationCodeSG.click();
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
        commercePage.vendorverificationCodeSG.sendKeys(passwordAlma);

        Assert.assertTrue(commercePage.verificationYazisi.isDisplayed());

        //Hatalı password:Küçük harf ve special karakter içermeyen bir şifre girer
        commercePage.vendorPasswordSG.sendKeys(ConfigReader.getProperty("password1"),Keys.TAB,ConfigReader.getProperty("password1"),Keys.ENTER);







    }
}

