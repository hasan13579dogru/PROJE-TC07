package testngTeam05.tests.us12_vendorBillingAddress;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class Ac01_firstname_Lastname_Email_areOutomatic extends ExtentReport {
    SoftAssert softAssert = new SoftAssert();

    public void test01(){
        extentTest = extentReports.createTest("Extent Report","Test Raporu");
        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();

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







    }
}
