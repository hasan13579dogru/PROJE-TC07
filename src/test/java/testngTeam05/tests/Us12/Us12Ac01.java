package testngTeam05.tests.Us12;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class Us12Ac01 extends ExtentReport {
    @Test
    public void test01(){
        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();
        extentTest = extentReports.createTest("Extent Report","Test Raporu");
        SoftAssert softAssert = new SoftAssert();


        //Vendor https://allovercommerce.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("allovercommerceUrl sine gidildi");

        //signin butonuna tıklar
        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);
        extentTest.info("Anasayfadaki signin butonuna tıklandı");
        //Kayitli kullanici adi ve sifresine girer ve sign in e click yapar
        alloverCommercePage.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmailEn"),
                Keys.TAB, ConfigReader.getProperty("alloverVendorPasswordEn"));
        alloverCommercePage.signInButton.click();
        softAssert.assertTrue(alloverCommercePage.signOut.isDisplayed());
        extentTest.info("Vendor kayitli olan username ve pw yi girdi ve sing in click yapildi");

        //My account a tiklar
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        alloverCommercePage.myAccountButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("sign in yapildi, sayfa en alta scroll edildi ve my account'a tiklandi");

        //Addresses butonuna tiklanir
        alloverCommercePage.Addresses.click();
        softAssert.assertTrue(alloverCommercePage.ikonAddresses.isDisplayed());
        extentTest.info("Addresses butonuna tiklandi");

        //Billing Address altindaki add linkine tiklanir
        alloverCommercePage.billingAddressAltindakiAdd.click();
        softAssert.assertTrue(alloverCommercePage.BillingaddressYazisi.isDisplayed());
        extentTest.info("Billing Address altindaki 'add' button a tiklandir");

        //Firstname otomatik girili mi kontrol edilir
        softAssert.assertTrue(alloverCommercePage.firstNameBillingAddress.getText().isEmpty());
        //Lastname otomatik girili mi kontrol edilir
        softAssert.assertTrue(alloverCommercePage.lastNameBillingAddress.getText().isEmpty());
        //email otomatik girili mi kontrol edilir
        softAssert.assertTrue(alloverCommercePage.emailBillingAddress.getText().isEmpty());
        extentTest.info("Firstname ve lastname textboxlar otomatik gelmedi, email otomatik girili");

        softAssert.assertAll();

         }
}
