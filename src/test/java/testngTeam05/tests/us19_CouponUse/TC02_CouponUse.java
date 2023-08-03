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
        ReusableMethods.kuponGirisiSepetSayfasi("validCouponNumber");

        Assert.assertEquals(alloversPage.couponAlert.getText(), ("Coupon code applied successfully."));
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("user Enter VALİD coupon number");

//      8-reEnter USED coupon number  to "Enter coupon code here…"area. Click to Apply coupon.
        // Verify "Coupon code already applied!" text is vissible
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(2); ReusableMethods.kuponGirisiSepetSayfasi("validCouponNumber");
        Assert.assertEquals(alloversPage.couponAlert.getText(), "Coupon code already applied!");
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("user reEnter USED coupon number ");
        //     9-Click to cart ,click to clear product and close

        ReusableMethods.clearCard();

        //     10-logout from account
        ReusableMethods.logout();
        Driver.closeDriver();
    }
}
