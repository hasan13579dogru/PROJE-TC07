package testngTeam05.tests.us19_CouponUse;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC01_CouponUseNegative {
    @Test
    public void test01() {
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
//        6-Click to "cart" and click to "view to card"
        alloversPage.cart.click();
        ReusableMethods.visibleWait(alloversPage.viewToCart, 5);
        alloversPage.viewToCart.click();
        ReusableMethods.bekle(3);


//        7-Enter INVALİD coupon number  to "Enter coupon code here…"area. Click to Apply coupon.
//        Verify "This coupon has expired." text is vissible
        alloversPage.enterCoupon.sendKeys(Keys.PAGE_DOWN, ConfigReader.getProperty("invalidCouponNumber"));
        ReusableMethods.bekle(2);
        alloversPage.applyCoupon.click();
        System.out.println(alloversPage.couponAlert.getText());
        Assert.assertEquals(alloversPage.couponAlert.getText(), "This coupon has expired.");

//       8-DON'T WRİTE coupon number  to "Enter coupon code here…"area.
//       Click to Apply coupon. Verify "Please enter a coupon code." text is vissible

        ReusableMethods.bekle(3);
        ReusableMethods.scroll(alloversPage.applyCoupon);
        alloversPage.applyCoupon.click();
        ReusableMethods.bekle(3);
        System.out.println(alloversPage.couponAlert.getText());
        Assert.assertEquals(alloversPage.couponAlert.getText(), "Please enter a coupon code.");

//       9-Enter "NOT USEFULL  for this shoping" coupon number  to "Enter coupon code here…"area.
//       Click to Apply coupon. Verify "The minimum spend for this coupon is $50.00." text is vissible
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(alloversPage.applyCoupon);
        alloversPage.enterCoupon.sendKeys(ConfigReader.getProperty("notUsefullCouponNumber"));
        alloversPage.applyCoupon.click();
        ReusableMethods.bekle(2);
        Assert.assertEquals(alloversPage.couponAlert.getText(), "The minimum spend for this coupon is $50.00.");
        System.out.println(alloversPage.couponAlert.getText());
//        10-Verify subtotal price is equal the total price that, the coupon is not used
        System.out.println(alloversPage.couponAlert.getText());
        String subtotal = alloversPage.subtotalPrice.getText().replaceAll("[^0-9]", "");
        Integer subtotalInt = Integer.valueOf(subtotal);//aratoplam int deger
        System.out.println(subtotalInt);
        String total = alloversPage.totalPrice.getText().replaceAll("[^0-9]", "");
        Integer totalInt = Integer.valueOf(total);//son kupon uygulanamamıs fiyat int deger
        System.out.println(totalInt);
        Assert.assertEquals(totalInt, subtotalInt);

 //     11-Click to cart ,click to clear product,and close

        ReusableMethods.click(alloversPage.cart);
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloversPage.cartInClearProduct);
        ReusableMethods.bekle(2);
        alloversPage.close.click();

 //     12-logout from account
        ReusableMethods.click(alloversPage.signOut);
        ReusableMethods.visibleWait(alloversPage.logout, 5);
        alloversPage.logout.click();
        Driver.closeDriver();

}
}
