package testngTeam05.tests.us20_VCouponUse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC03_VCouponUse {

    @Test
    public void test03() {
//       1- Go to mainpage url
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        2- Click to "sign in"
        AlloverCommercePage alloversPage = new AlloverCommercePage();
        alloversPage.signIn.click();


//        3-Login with valid username and valid password to be vendor

        alloversPage.username.sendKeys(ConfigReader.getProperty("venUserName"), Keys.TAB, ConfigReader.getProperty("venPassword"), Keys.ENTER);
        ReusableMethods.bekle(3);
        //4 - Write "earphone" to searchBox click to enter
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
        ReusableMethods.kuponGirisiodemeSayfasi("validCouponNumber");

        Assert.assertEquals(alloversPage.coupounAlertBillAdress.getText(), "Coupon code applied successfully.");
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Vendor Entered VALİD coupon number");


//        8-Verify subtotal price is biger than total price , and discount amount is vissible; that the coupon was  used

        ReusableMethods.scroll(alloversPage.subtotalPricePayBill);
        String subtotal = alloversPage.subtotalPricePayBill.getText().replaceAll("[^0-9]", "");
        Integer subtotalInt = Integer.valueOf(subtotal);//aratoplam int deger
        System.out.println(subtotalInt);
        String total = alloversPage.totalPricePayBill.getText().replaceAll("[^0-9]", "");
        Integer totalInt = Integer.valueOf(total);//son kupon uygulanmıs fiyat int deger
        System.out.println(totalInt);
        ReusableMethods.bekle(2);
        Assert.assertTrue(subtotalInt > totalInt);
        Assert.assertTrue(alloversPage.removedPrice.isDisplayed());
//      9-Enter the billing adress and choose payment method
        alloversPage.endBillingFirstName.sendKeys(Keys.CONTROL + "a", Keys.CLEAR, Keys.CONTROL,
                ConfigReader.getProperty("userUserName"),
                Keys.TAB, ConfigReader.getProperty("userUserlastName"),
                Keys.TAB,
                Keys.TAB, ConfigReader.getProperty("userCountry"),
                Keys.TAB, ConfigReader.getProperty("userStreetAdress"),
                Keys.TAB, Keys.TAB, ConfigReader.getProperty("userZipCode"),
                Keys.TAB, ConfigReader.getProperty("userCity"),
                Keys.TAB, ConfigReader.getProperty("userProvince"),
                Keys.TAB, ConfigReader.getProperty("userPhone"));
        ReusableMethods.bekle(3);

//      10-Verify payment methods can select
        ReusableMethods.click(alloversPage.endPaymentMethods);
        Assert.assertTrue(alloversPage.endPaymentMethods.isSelected());
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloversPage.paymentAtDoor);
        Assert.assertTrue(alloversPage.paymentAtDoor.isSelected());

//      11-Verify total price is vissible
        Assert.assertTrue(alloversPage.totalPricePayBill.isDisplayed());
        //12- choose payment methods and finish the shooping
        Assert.assertTrue(alloversPage.paymentAtDoor.isSelected());
        ReusableMethods.visibleWait(alloversPage.placeOrderButton, 10);
        alloversPage.placeOrderButton.submit();
        ReusableMethods.bekle(2);

//     13- Verify "Thank you. Your order has been received." text is vissible
        ReusableMethods.visibleWait(alloversPage.placeOrderButton, 5);
        Assert.assertTrue(alloversPage.orderHasBeenReceived.isDisplayed());
//      14-Go to myaccount
        ReusableMethods.scrollEnd();
        ReusableMethods.click(alloversPage.myAccountm);
//       15-Verify account id vendor
        Assert.assertTrue(alloversPage.storeManager.isEnabled());
        ReusableMethods.tumSayfaResmi("Vendor MyAccount page");
//      16-click to order Verify product add the order
        alloversPage.orderInMyaccount.click();
//      17-Verify product is vissible in order ,close the window
        Assert.assertTrue(alloversPage.orderinFirstidNo.isDisplayed());
        ReusableMethods.tumSayfaResmi(" Vendor's shopping is vissible in order");

        Driver.closeDriver();

    }
}