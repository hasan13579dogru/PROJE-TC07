package testngTeam05.tests.us19_CouponUse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC02_CouponUse {
    @Test
    public void test02() {
//        1- Go to mainpage url
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        2- Click to "sign in"
        AlloverCommercePage alloversPage = new AlloverCommercePage();
        alloversPage.signIn.click();


//        3-Enter a valid username and valid password to be user
        alloversPage.username.sendKeys(ConfigReader.getProperty("userName"), Keys.TAB, ConfigReader.getProperty("passwordAllo"), Keys.ENTER);
        ReusableMethods.bekle(3);

//        4-Write "earphone" to searchBox click to enter
        alloversPage.search.sendKeys("earphone");
        ReusableMethods.visibleWait(alloversPage.search, 5);
        alloversPage.search.sendKeys(Keys.ENTER);


//        5-Click to first ıtem and add to card
        alloversPage.searchedFirstItem.click();
        ReusableMethods.bekle(3);
        alloversPage.addToCart.click();
//       6-Click to cart and click to view to card
        alloversPage.cart.click();
        ReusableMethods.visibleWait(alloversPage.viewToCart, 5);
        alloversPage.viewToCart.click();
        ReusableMethods.bekle(3);


//       7-Enter "VALİD coupon number"  to "Enter coupon code here…"area. Click to Apply coupon.
//       Verify "Coupon code applied successfully." text is vissible
        alloversPage.enterCoupon.sendKeys(ConfigReader.getProperty("validCouponNumber"));
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(alloversPage.applyCoupon);
        ReusableMethods.click(alloversPage.applyCoupon);
        ReusableMethods.bekle(3);
        alloversPage.couponAlert.getText().equals("Coupon code applied successfully.");
        Assert.assertEquals(alloversPage.couponAlert.getText(), ("Coupon code applied successfully."));
        System.out.println(alloversPage.couponAlert.getText());

//      8-Enter USED coupon number  to "Enter coupon code here…"area. Click to Apply coupon.
        // Verify "Coupon code already applied!" text is vissible
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(2);
        alloversPage.enterCoupon.sendKeys(ConfigReader.getProperty("validCouponNumber"));
        ReusableMethods.scroll(alloversPage.applyCoupon);

        ReusableMethods.bekle(2);
        ReusableMethods.click(alloversPage.applyCoupon);

        Assert.assertEquals(alloversPage.couponAlert.getText(), "Coupon code already applied!");
        System.out.println(alloversPage.couponAlert.getText());

 //     9-Click to cart ,click to clear product and close

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
