package testngTeam05.tests.us001_register;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;

import java.util.Random;


public class TC_01_registerLogin {
    /*
    Username girilmeli (Küçük harf, büyük harf, rakam ve özel karakter içerebilmeli)
    e-mail adresi girilmeli (abc@abc.com formatında e mail adresi olmalı)
    Password girilebilmelidir. (Parola en az 12 karakter uzunluğunda olmalıdır. Daha güçlü hale getirmek için büyük ve küçük harfler, sayılar ve ! " ? $ % ^ & kullanılmalıdır. )
    "I agree to the privacy policy" tıklanmadan kayıt olunmamalı
    SIGN UP butonu tıklanabilir olmalı (Username, Email address ve Password girilmeden SIGN UP tıklandığında kayıt işlemi gerçekleşmemeli)
     */
    @Test
    public void test01() {

        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();


        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        String mainPageHandle = Driver.getDriver().getWindowHandle();

        alloverCommercePage.registerButton.click();

        Random random = new Random();
        int rndm = random.nextInt();

        alloverCommercePage.userName.sendKeys("Umran."+rndm);
        alloverCommercePage.registerSignUp.click();


       Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get(ConfigReader.getProperty("fakemailSitesiUrl"));
        alloverCommercePage.copyFakeMail.click();


        Driver.getDriver().switchTo().window(mainPageHandle);
        alloverCommercePage.yourEmailAddress.sendKeys(Keys.CONTROL,"v");


        alloverCommercePage.registerPassword.sendKeys("Umranatasoy.61");
        alloverCommercePage.registerSignUp.click();
        Assert.assertTrue(alloverCommercePage.ilerlemekIcinTikla.isDisplayed());



       alloverCommercePage.iAgreeClick.click();
        alloverCommercePage.registerSignUp.click();
        Assert.assertTrue(alloverCommercePage.registersignOut.isDisplayed());



        Driver.quitDriver();


    }

}
