package testngTeam05.tests.us11_vendorGiris;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class tc01_vendorLogin extends ExtentReport {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


@Test
    public void test01(){
  extentTest = extentReports.createTest("Extent Report","Test Raporu");
    AlloverCommercePage alloverCommercePage = new AlloverCommercePage();

    //Vendor https://allovercommerce.com/ adresine gider
    Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
    extentTest.info("allovercommerceUrl sine gidildi");

    //Sign in sekmesine tiklar
    alloverCommercePage.signIn.click();
    extentTest.info("sign in sekmesine tiklandi");
    ReusableMethods.bekle(2);

    //Kayitli kullanici adi ve sifresine girer ve sign in e click yapar
    alloverCommercePage.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmailEn"),
            Keys.TAB, ConfigReader.getProperty("alloverVendorPasswordEn"));
    alloverCommercePage.signInButton.click();
    extentTest.info("Vendor kayitli olan username ve pw yi girdi ve sing in click yapildi");
    Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());


    //My account a tiklar
    ReusableMethods.scrollEnd();
    ReusableMethods.bekle(2);
    alloverCommercePage.myAccountButton.click();
    Assert.assertTrue(Driver.getDriver().getTitle().contains("My Account"));
    ReusableMethods.bekle(2);
    extentTest.info("sign in yapildi, sayfa en alta scroll edildi ve my account'a tiklandi");

    //Dashboard altindaki sekmelerin gorunurlugunu test et
    js.executeScript("window.scrollTo(0,400)");



















}
}
