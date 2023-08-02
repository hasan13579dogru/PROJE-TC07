package testngTeam05.tests.us11_vendorGiris;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class tc01_vendorLogin extends ExtentReport {
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();
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
    softAssert.assertTrue(alloverCommercePage.signOut.isDisplayed());
    extentTest.info("Vendor kayitli olan username ve pw yi girdi ve sing in click yapildi");


    //My account a tiklar
    ReusableMethods.scrollEnd();
    ReusableMethods.bekle(2);
    alloverCommercePage.myAccountButton.click();
    Assert.assertTrue(Driver.getDriver().getTitle().contains("My Account"));
    ReusableMethods.bekle(2);
    extentTest.info("sign in yapildi, sayfa en alta scroll edildi ve my account'a tiklandi");

    //Dashboard altindaki sekmelerin gorunurlugunu test et
    js.executeScript("window.scrollTo(0,400)");
    softAssert.assertTrue(alloverCommercePage.storeManager.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.myAccountOrders.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.Downloads.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.Addresses.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.Accountdetails.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.Wishlist.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.SupportTickets.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.Followings.isDisplayed());
    softAssert.assertTrue(alloverCommercePage.Logout.isDisplayed());
    extentTest.info("Dashboard altinda yer alan buttonlarin gorunurlugu test edildi");

    //Dashboard altindaki menulere girilebilmeli
  alloverCommercePage.storeManager.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.myAccountOrders.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.Downloads.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.Addresses.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.Accountdetails.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.Wishlist.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.SupportTickets.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.Followings.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  alloverCommercePage.Logout.click();
  System.out.println(Driver.getDriver().getTitle());
  ReusableMethods.bekle(2);
  Driver.getDriver().navigate().back();

  extentTest.info("My Account'da Dashboard altindaki tum sayfalar acildi");




softAssert.assertAll();

}
}
