package testngTeam05.tests.us19_CouponUse;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC01_CouponUseNegative extends ExtentReport{

    @Test
    public void test01() {
    extentTest = extentReports.createTest("Extent Report", "Test Raporu");

//        1- Go to mainpage url
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("allovercommerce sitesine gidildi");
//        2- Click to "sign in"
        AlloverCommercePage alloversPage = new AlloverCommercePage();
        alloversPage.signIn.click();
        extentTest.info("Anasayfadaki signin butonuna tıklandı");

//        3-Enter a valid username and valid password to be user
        alloversPage.username.sendKeys(ConfigReader.getProperty("userName"), Keys.TAB, ConfigReader.getProperty("passwordAllo"), Keys.ENTER);
        ReusableMethods.bekle(3);
        extentTest.info("dogru kullanıcı adı ve password girildi");

//        4-Write "earphone" to searchBox click to enter
        alloversPage.search.sendKeys("earphone");
        ReusableMethods.visibleWait(alloversPage.search, 5);
        alloversPage.search.sendKeys(Keys.ENTER);
        extentTest.info("arama kutusuna earphone yazılıp aratıldı");


//        5-Click to first ıtem and add to card
        alloversPage.searchedFirstItem.click();
        ReusableMethods.bekle(3);
        alloversPage.addToCart.click();
        extentTest.info("arama sonucunda ilk urun sepete eklendi");
//        6-Click to "cart" and click to "view to card"
        alloversPage.cart.click();
        ReusableMethods.visibleWait(alloversPage.viewToCart, 5);
        alloversPage.viewToCart.click();
        ReusableMethods.bekle(3);
        extentTest.info("sepet görüntülendi");


//        7-Enter INVALİD coupon number  to "Enter coupon code here…"area. Click to Apply coupon.
//        Verify "This coupon has expired." text is vissible
        ReusableMethods.kuponGirisiSepetSayfasi("invalidCouponNumber");
        Assert.assertEquals(alloversPage.couponAlert.getText(), "This coupon has expired.");
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("user Enter INVALİD coupon number at the Cart page");
        extentTest.pass("kupon anahtarı yanliş girildi,uyarı dogrulandı");
        //       8-DON'T WRİTE coupon number  to "Enter coupon code here…"area.
//       Click to Apply coupon. Verify "Please enter a coupon code." text is vissible

        ReusableMethods.kuponGirisiSepetSayfasi("emptyCouponNumber");
        ReusableMethods.bekle(2);
        Assert.assertEquals(alloversPage.couponAlert.getText(), "Please enter a coupon code.");
        ReusableMethods.tumSayfaResmi("user DON'T WRİTE coupon number");
       extentTest.pass("kupon bölümü bos bırakılıp kupon girildi ,cıkan uyarı dogrulandı");
//
//       9-Enter "NOT USEFULL  for this shoping" coupon number  to "Enter coupon code here…"area.
//       Click to Apply coupon. Verify "The minimum spend for this coupon is $5,000.00." text is vissible
        ReusableMethods.kuponGirisiSepetSayfasi("notUsefullCouponNumber");
        Assert.assertEquals(alloversPage.couponAlert.getText(), "The minimum spend for this coupon is $5,000.00.");
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("user Enter NOT USEFULL  for this shoping coupon");
        extentTest.pass("sartları uygun olmayan  kupon kodu girildi ,uyarı dogrulandi");

        //     10-Click to cart ,click to clear product,and close

        ReusableMethods.clearCard();
        extentTest.info("sepetteki urunler silindi");
        //     11-logout from account
        ReusableMethods.logout();
        extentTest.info("hesaptan cıkıs yapildi");
        Driver.closeDriver();


    }
}
