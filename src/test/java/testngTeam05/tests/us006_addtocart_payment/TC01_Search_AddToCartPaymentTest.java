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

        String dosyaYolu ="src/test/java/testngTeam05/musteriBilgileri.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(2).toString());
        ReusableMethods.bekle(2);
        alloverCommercePage.ilkSayfapassword.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(5).toString());
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

        //ürünün sepete eklendiğini doğrula(önce cart icon a tıkla-->view cart tıkla
        alloverCommercePage.CART.click();
        ReusableMethods.bekle(2);

        alloverCommercePage.viewCart.click();
        Assert.assertTrue(alloverCommercePage.sepettekiIlkUrun.isDisplayed());

        //ürün mıktarını artır
        alloverCommercePage.plusButton.click();
        alloverCommercePage.updateCart.click();
       Assert.assertTrue(alloverCommercePage.cartUpdateMessage.isDisplayed());
        ReusableMethods.bekle(2);
       //sayısal bir doğrulama eklenebilir !!!!!

        //ürün miktarını azalt
        alloverCommercePage.minusButton.click();
        alloverCommercePage.updateCart.click();
        Assert.assertTrue(alloverCommercePage.cartUpdateMessage.isDisplayed());
        ReusableMethods.bekle(2);

        //proceed to checkout yap ve odeme kısmına geç

        alloverCommercePage.proceedToCheckoutButton.click();
        ReusableMethods.bekle(3);

        //Billing Details sayfasının açıldığını doğrula
        String actualCheckoutTitle =Driver.getDriver().getTitle();
        String expectedCheckoutTitle = "Checkout - Allover Commerce";
        Assert.assertEquals(expectedCheckoutTitle,actualCheckoutTitle);









    }
}
