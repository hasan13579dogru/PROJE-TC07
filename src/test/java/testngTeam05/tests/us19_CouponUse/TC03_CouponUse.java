package testngTeam05.tests.us19_CouponUse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC03_CouponUse {
    @Test
    public void test03() {
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


//        5-Click to "first ıtem" and "add to card"
        alloversPage.searchedFirstItem.click();
        ReusableMethods.bekle(3);
        alloversPage.addToCart.click();
//        6-Click to "cart" and click to "view to card"
        alloversPage.cart.click();
        ReusableMethods.visibleWait(alloversPage.viewToCart, 5);
        alloversPage.viewToCart.click();
        ReusableMethods.bekle(3);


//       7-Enter "VALİD coupon number"  to "Enter coupon code here…"area. Click to "Apply coupon"
        ReusableMethods.kuponGirisiSepetSayfasi("validCouponNumber");
        ReusableMethods.bekle(3);

//      8-Verify subtotal price is biger than total price that, the coupon is used
        System.out.println(alloversPage.couponAlert.getText());
        String subtotal = alloversPage.subtotalPrice.getText().replaceAll("[^0-9]", "");
        Integer subtotalInt = Integer.valueOf(subtotal);//aratoplam int deger
        System.out.println(subtotalInt);
        String total = alloversPage.totalPrice.getText().replaceAll("[^0-9]", "");
        Integer totalInt = Integer.valueOf(total);//son kupon uygulanmıs fiyat int deger
        System.out.println(totalInt);
        Assert.assertTrue(subtotalInt > totalInt);

//      9- click to proceedToCheckout
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloversPage.proceedToCheckout);
//      10-enter the billing adress and Verify  payment method is selected to be wire
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
        Assert.assertTrue(alloversPage.endPaymentMethods.isSelected());//ödeme türü wire olarak secili mi

        ReusableMethods.visibleWait(alloversPage.placeOrderButton, 10);
        alloversPage.placeOrderButton.submit();

//     11- Verify "Thank you. Your order has been received." text is vissible
        ReusableMethods.visibleWait(alloversPage.placeOrderButton, 5);
        Assert.assertTrue(alloversPage.orderHasBeenReceived.isDisplayed());
        Driver.closeDriver();


}




}
