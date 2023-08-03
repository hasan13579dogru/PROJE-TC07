package testngTeam05.tests.us20_VCouponUse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;



    public class TC01_VCouponUseNegative {

   @Test
         public void test01() {
//       1- Go to mainpage url
              Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        2- Click to "sign in"
              AlloverCommercePage alloversPage = new AlloverCommercePage();
              alloversPage.signIn.click();


//        3-Login with valid username and valid password to be vendor

              alloversPage.username.sendKeys(ConfigReader.getProperty("venUserName"), Keys.TAB, ConfigReader.getProperty("venPassword"), Keys.ENTER);
              ReusableMethods.bekle(3);

//        4-Write "earphone" to searchBox click to enter
            alloversPage.search.sendKeys("earphone");
            ReusableMethods.visibleWait(alloversPage.search, 5);
            alloversPage.search.sendKeys(Keys.ENTER);
//        5-Click to first ıtem ,increase the quantity of products and add to card
            alloversPage.searchedFirstItem.click();
            ReusableMethods.bekle(3);
            alloversPage.qantityPlus.click();
            alloversPage.addToCart.click();
//        6-Click to cart and click to
            alloversPage.cart.click();
            ReusableMethods.visibleWait(alloversPage.viewToCart, 5);
            alloversPage.checkoutBoton.click();
            ReusableMethods.bekle(3);

 //     7-Enter INVALİD coupon number  to "Enter coupon code here…"area. Click to Apply coupon.
//        Verify "This coupon has expired." text is vissible
            ReusableMethods.kuponGirisiodemeSayfasi("invalidCouponNumber");
            Assert.assertEquals(alloversPage.coupounAlertBillAdress.getText(), "This coupon has expired.");
            ReusableMethods.bekle(2);
            ReusableMethods.tumSayfaResmi("Vendor Enter INVALİD coupon number at checkout page");
            Driver.getDriver().navigate().refresh();
//       8-DON'T WRİTE coupon number  to "Enter coupon code here…"area. Click to Apply coupon. Verify "Please enter a coupon code." text is vissible
            ReusableMethods.kuponGirisiodemeSayfasi("emptyCouponNumber");
            Assert.assertEquals(alloversPage.coupounAlertBillAdress.getText(), "Please enter a coupon code.");
            ReusableMethods.tumSayfaResmi("Vendor doesn't Write CouponNumber");
//      9-Enter "NOT USEFULL  for this shoping" coupon number  to "Enter coupon code here…"area. Click to Apply coupon. Verify "The minimum spend for this coupon is $5,000.00." text is vissible    ReusableMethods.bekle(2);
            Driver.getDriver().navigate().refresh();
            ReusableMethods.bekle(2);
            ReusableMethods.kuponGirisiodemeSayfasi("notUsefullCouponNumber");
            Assert.assertEquals(alloversPage.couponAlert.getText(), "The minimum spend for this coupon is "+ConfigReader.getProperty("mincouponuse"));
            ReusableMethods.tumSayfaResmi("Vendor Enter NOT USEFULL  for this shoping coupon number");
 //    10-Click to cart ,click to clear product,and close
            ReusableMethods.clearCard();


  //     11-logout from account
            ReusableMethods.logout();
            Driver.closeDriver();

        }
}
