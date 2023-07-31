package testngTeam05.tests.us002;

import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC_01_kayitliLogin {
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

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        Assert.assertTrue(alloverCommercePage.anasayfaTitle.isDisplayed());

        alloverCommercePage.registerButton.click();

        alloverCommercePage.userName.sendKeys(ConfigReader.getProperty("registerUserName"));
        ReusableMethods.bekle(2);

        alloverCommercePage.yourEmailAddress.sendKeys(ConfigReader.getProperty("registerMail"));
        ReusableMethods.bekle(2);

        alloverCommercePage.registerPassword.sendKeys(ConfigReader.getProperty("registerPassword"));
        ReusableMethods.bekle(2);

        alloverCommercePage.registerSignUp.click();
        Assert.assertTrue(alloverCommercePage.ilerlemekIcinTiklaYazisi.isDisplayed());

        Driver.quitDriver();

    }


}







