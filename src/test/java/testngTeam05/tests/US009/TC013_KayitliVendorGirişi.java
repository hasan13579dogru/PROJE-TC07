package testngTeam05.tests.US009;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC013_KayitliVendorGirişi {
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

        commercePage.userNameEmailAddressSG.sendKeys(ConfigReader.getProperty("vendorKayitliEmail"),Keys.TAB);
        commercePage.verificationCodeSG.sendKeys(ConfigReader.getProperty("password15"));

        //Password yazar. Password: kucuk harf, büyük harf, rakam ve special karakter içermeli
        commercePage.vendorPasswordSG.sendKeys(ConfigReader.getProperty("password12"),Keys.TAB,ConfigReader.getProperty("password12"),Keys.ENTER);

    }
}
