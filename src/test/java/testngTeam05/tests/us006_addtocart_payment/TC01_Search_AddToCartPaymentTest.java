package testngTeam05.tests.us006_addtocart_payment;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;

public class TC01_Search_AddToCartPaymentTest {
    @Test
    public void test01() throws IOException {

        AlloverCommercePage alloverCommercePage= new AlloverCommercePage();

        //Kullanıcı https://allovercommerce.com sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


        //signin butonuna tıklar

        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);



        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(ConfigReader.getProperty("mehtapEmail"));
        alloverCommercePage.ilkSayfapassword.sendKeys(ConfigReader.getProperty("mehtapPassword"));
        ReusableMethods.bekle(2);

        //signin butonuna tıklar
        alloverCommercePage.signInButton.click();
        ReusableMethods.bekle(2);

        //sayfaya girdiğini doğrula
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(alloverCommercePage.welcomeToAlloverCommerceYazısı);

        //arama kutusunda "bag" arat
        alloverCommercePage.searchButton.sendKeys("bag",Keys.ENTER);
        ReusableMethods.bekle(2);
        //arama sonuçlarının geldiğini doğrula
        ReusableMethods.visibleWait(alloverCommercePage.sortBy,15);
        ReusableMethods.tumSayfaResmi("AramaSonucları");




        //7. Ikınci ürünü sepete ekle

        ReusableMethods.click(alloverCommercePage.ikinciUrun);
        ReusableMethods.bekle(2);
       // ReusableMethods.webElementResmi(alloverCommercePage.ikinciUrun);

        ReusableMethods.bekle(2);

        ReusableMethods.click(alloverCommercePage.sepeteEkle);
        ReusableMethods.bekle(2);

        //ürünün sepete eklendiğini doğrula(önce cart icon a tıkla-->view cart tıkla
        ReusableMethods.click(alloverCommercePage.CART);//sayfanın sağ üstündeki sepet ikonu
        ReusableMethods.bekle(2);

        alloverCommercePage.viewCart.click();
        ReusableMethods.visibleWait(alloverCommercePage.sepettekiIlkUrun,15);
        Assert.assertTrue(alloverCommercePage.sepettekiIlkUrun.isDisplayed());
        ReusableMethods.tumSayfaResmi("SepetResmi");

        //ürün mıktarını artır
        alloverCommercePage.plusButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.updateCart);
        Assert.assertTrue(alloverCommercePage.cartUpdateMessage.isDisplayed());
        ReusableMethods.visibleWait(alloverCommercePage.sepettekiIlkUrun,15);
        ReusableMethods.tumSayfaResmi("SepettekiArtanUrun");
        ReusableMethods.bekle(3);


        //ürün miktarını azalt
        alloverCommercePage.minusButton.click();
        alloverCommercePage.updateCart.click();
        Assert.assertTrue(alloverCommercePage.cartUpdateMessage.isDisplayed());

        ReusableMethods.bekle(5);
        ReusableMethods.tumSayfaResmi("SepettekiAzalanUrun");

        //proceed to checkout yap ve odeme kısmına geç
        ReusableMethods.click(alloverCommercePage.proceedToCheckoutButton);



        ReusableMethods.bekle(3);

        //Billing Details sayfasının açıldığını baslık ile doğrula
        String actualCheckoutTitle =Driver.getDriver().getTitle();
        String expectedCheckoutTitle = "Checkout - Allover Commerce";
        Assert.assertEquals(expectedCheckoutTitle,actualCheckoutTitle);
        Actions action= new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("BillingDetailsGörünümü");


      //Payment seceneklerinin görünür oldugunu dogrula
        Assert.assertTrue(alloverCommercePage.paymentMethods.isDisplayed());
        ReusableMethods.visibleWait(alloverCommercePage.paymentMethods,15);

        ReusableMethods.tumSayfaResmi("PaymentMethods");

        ReusableMethods.scrollEnd();

        //  Click on "Pay at the door"
        ReusableMethods.click(alloverCommercePage.payAtTheDoorButton);


        ReusableMethods.bekle(2);

        //Pay at the door butonunun seçili olduğunu doğrula
        Assert.assertTrue(alloverCommercePage.payAtTheDoorButton.isSelected());
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.eftButton);
        ReusableMethods.bekle(2);




        //Wire transfer EFT butonunun seçili olduğunu doğrula
        Assert.assertTrue(alloverCommercePage.eftButton.isSelected());


        //  Click on "Place order" button
        ReusableMethods.scroll(alloverCommercePage.placeOrderButton);
        ReusableMethods.click(alloverCommercePage.placeOrderButton);

        ReusableMethods.bekle(4);


        //  Verify the message of "Thank you . Your order has been received"

        Assert.assertTrue(alloverCommercePage.orderSuccessMessage.isDisplayed());
        ReusableMethods.visibleWait(alloverCommercePage.orderSuccessMessage,20);
        ReusableMethods.bekle(4);
        ReusableMethods.tumSayfaResmi("OrderMesajı");
        ReusableMethods.bekle(2);










    }
}
