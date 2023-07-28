package testngTeam05.tests.us20_VCouponUse;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;
public class TC02_VCouponUse {
    @Test
    public void test02() {
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
//        6-Click to cart and enter the checkout buton
        alloversPage.cart.click();
        ReusableMethods.visibleWait(alloversPage.viewToCart, 5);
        alloversPage.checkoutBoton.click();
        ReusableMethods.bekle(3);

        //     7-Enter VALİD coupon number  to "Enter coupon code here…"area. Click to Apply coupon.
//        Verify "Coupon code applied successfully." text is vissible
        alloversPage.enterTCouponBillAdress.click();
        ReusableMethods.bekle(2);
        alloversPage.enterCouponBoxBillAdress.sendKeys(ConfigReader.getProperty("validCouponNumber"));
        ReusableMethods.bekle(2);
        alloversPage.applyCouponBillAdress.click();
        System.out.println(alloversPage.coupounAlertBillAdress.getText());
        Assert.assertEquals(alloversPage.coupounAlertBillAdress.getText(), "Coupon code applied successfully.");
        ReusableMethods.bekle(2);
//       8-reEnter VALİD coupon number  to "Enter coupon code here…"area.
//       Click to Apply coupon. Verify "Coupon code already applied!" text is vissible
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(2);
        alloversPage.enterTCouponBillAdress.click();
        alloversPage.enterCouponBoxBillAdress.sendKeys(ConfigReader.getProperty("validCouponNumber"));
        alloversPage.applyCouponBillAdress.click();
        ReusableMethods.bekle(2);
        System.out.println(alloversPage.couponAlert.getText());
        Assert.assertEquals(alloversPage.couponAlert.getText(), "Coupon code already applied!");
        //    9-Click to cart ,click to clear product,and close

        ReusableMethods.click(alloversPage.cart);
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloversPage.cartInClearProduct);
        ReusableMethods.bekle(2);
        alloversPage.close.click();

        //     10-logout from account
        ReusableMethods.click(alloversPage.signOut);
        ReusableMethods.visibleWait(alloversPage.logout, 5);
        alloversPage.logout.click();
        Driver.closeDriver();

    }
}