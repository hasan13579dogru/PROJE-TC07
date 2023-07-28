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



        //Kullanıcı https://allovercommerce.com sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


        //signin butonuna tıklar
        AlloverCommercePage alloverCommercePage= new AlloverCommercePage();
        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);



        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(ConfigReader.getProperty("mehtapEmail"));
        alloverCommercePage.ilkSayfapassword.sendKeys(ConfigReader.getProperty("mehtapPassword"));
        ReusableMethods.bekle(2);

        //signin butonuna tıkla
        alloverCommercePage.signInButton.click();
        ReusableMethods.bekle(2);

        //sayfaya girdiğini doğrula
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());

        //arama kutusunda "kulaklık" arat
        alloverCommercePage.searchButton.sendKeys("kulaklık",Keys.ENTER);
        ReusableMethods.visibleWait(alloverCommercePage.ilkKulaklıkResmi,15);

        //arama sonuçlarının geldiğini doğrula

        //İlk ürünü sepete ekle
        alloverCommercePage.ilkKulaklıkResmi.click();
        ReusableMethods.bekle(2);

        alloverCommercePage.addToCart.click();
        ReusableMethods.bekle(2);

        //ürünün sepete eklendiğini doğrula(önce cart icon a tıkla-->view cart tıkla
        alloverCommercePage.CART.click();
        ReusableMethods.bekle(2);

        alloverCommercePage.viewCart.click();
        Assert.assertTrue(alloverCommercePage.sepettekiIlkUrun.isDisplayed());
        ReusableMethods.bekle(2);

        //ürün mıktarını artır
        alloverCommercePage.plusButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.updateCart);
        Assert.assertTrue(alloverCommercePage.cartUpdateMessage.isDisplayed());
        ReusableMethods.bekle(2);


        //ürün miktarını azalt
        alloverCommercePage.minusButton.click();
        alloverCommercePage.updateCart.click();
        Assert.assertTrue(alloverCommercePage.cartUpdateMessage.isDisplayed());
        ReusableMethods.bekle(2);

        //proceed to checkout yap ve odeme kısmına geç
        ReusableMethods.click(alloverCommercePage.proceedToCheckoutButton);//SIKINTI



        ReusableMethods.bekle(3);

        //Billing Details sayfasının açıldığını doğrula
        String actualCheckoutTitle =Driver.getDriver().getTitle();
        String expectedCheckoutTitle = "Checkout - Allover Commerce";
        Assert.assertEquals(expectedCheckoutTitle,actualCheckoutTitle);

        alloverCommercePage.billingFirstNamee.sendKeys("Nathan",Keys.TAB,"Clou");
      ReusableMethods.ddmIndex(alloverCommercePage.billingCountryddm,5);
      alloverCommercePage.billingAddress.sendKeys("Norway",Keys.TAB,
              "Begie",Keys.TAB,
              //city name
              "Malatya",Keys.TAB,

//  Enter your State / County
              "doyran",Keys.TAB,
//  Enter zip code
              "87495",Keys.TAB,
//  Enter phone number
              "08888888888",Keys.TAB,
//  Enter e-mail
              Keys.TAB);

      //Payment seceneklerinin görünür oldugunu dogrula
        Assert.assertTrue(alloverCommercePage.paymentMethods.isDisplayed());

        //  Click on "Pay at the door" if it isn't sellected
        Actions action = new Actions(Driver.getDriver());
        action.click(alloverCommercePage.payAtTheDoorButton).perform();
        Assert.assertTrue(alloverCommercePage.payAtTheDoorButton.isSelected());

//  Click on "Wire tranfer/EFT" if it is sellected
        action.click(alloverCommercePage.eftButton).perform();
        Assert.assertTrue(alloverCommercePage.eftButton.isSelected());

//  Click on "Place order" button
        alloverCommercePage.placeOrderButton.click();
//  Verify the message of "thank you . Your order has been received










    }
}
