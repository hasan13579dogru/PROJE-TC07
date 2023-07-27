package testngTeam05.tests.us015_VendorUrunDetay;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.util.List;

public class TC_03_ShippingIslemleri {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Select select;
    @Test
    public void inventoryStokTest() {
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        //Vendor https://allovercommerce.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        // sign in butonuna tıklayarak kayıtlı Vendor email adresi ve şifresiyle giriş yap
        alloverPage.signIn.click();
        alloverPage.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmail"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorSifre"));
        alloverPage.signInButton.click();
        ReusableMethods.bekle(5);

        //My Account sayfasının açıldığını doğrula
        Assert.assertTrue(alloverPage.myAccountBaslik.isDisplayed());

        //Açılan my account sayfasında Store Manager Menüsünün görünür oldugunu doğrula
        Assert.assertTrue(alloverPage.storeManager.isDisplayed());

        //Store manager'a tıkla
        alloverPage.storeManager.click();

        //Store Manager sayfasının açıldığını doğrula
        Assert.assertTrue(alloverPage.storeManager.isDisplayed());

        //Product butonunun görünür olduğunu doğrula
        Assert.assertTrue(alloverPage.product.isDisplayed());

        //Products'ın üzerine gel açılan penceredeki Add New'e tıkla
        actions.moveToElement(alloverPage.product).perform();
        alloverPage.addNew.click();

        //Add Product sayfasının açıldığını doğrula
        Assert.assertTrue(alloverPage.addProductBaslik.isDisplayed());

        //Product title alanına eklemek istediği ürün adını girer
        alloverPage.productTitle.sendKeys("mouse");

        //Sag tarafta yer alan feature image bölümünden ürünün resmini ekler
        alloverPage.featureImage.click();
        ReusableMethods.bekle(2);
        alloverPage.mediaLibrary.click();

        alloverPage.mouseResmiFeature.click();
        alloverPage.selectFeature.click();
        ReusableMethods.bekle(3);

        // actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //Sag tarafta yer alan galeri image bölümünden ürünün resmini ekler
        ReusableMethods.click(alloverPage.galeryImage);
        alloverPage.mouseResmi.click();
        alloverPage.addToGalery.click();

/*
        WebElement dosyaSec = alloverPage.selectFile;
        String dosyaYolu = "C:\\Users\\EXCALIBUR\\Pictures\\Saved Pictures\\mouse.jpeg";
        dosyaSec.sendKeys(dosyaYolu);
        alloverPage.selectFile.click();
 */

        //Category Bölümünden eklediği ürünün ait oldugu kategoriyi seç
        ReusableMethods.click(alloverPage.categoriesCheckbox);



        //Sayfanın altında yer alan Shipping butonuna tıkla
        ReusableMethods.click(alloverPage.shipping);

        //Weight bölümüne ürün ağırlığını gir
        //Dimensions bölümünde length,width ve height değerlerini gir
        alloverPage.weight.sendKeys("0,200",Keys.TAB,"15",Keys.TAB,"10",Keys.TAB,"10");

        //"Shipping Class" Ddm'den "No shipping class" seç
        select=new Select(alloverPage.shippingClass);
        ReusableMethods.ddmIndex(alloverPage.shippingClass,0);

        //"Processing Time" Ddm'den süre seç
        select = new Select(alloverPage.processingTime);
        select.selectByVisibleText("3-5 business days");

        //Submit butonuna tıkl
        ReusableMethods.click(alloverPage.submitButton);

        //Yenilenen sayfada submit butonunun yanında yer alan view butonuna tıkla
        ReusableMethods.click(alloverPage.viewButton);

        //Acılan sayfada urun resminin altında yer alan specificationa tıkla
        ReusableMethods.switchToWindow(1);
        ReusableMethods.click(alloverPage.spesification);

        //Girilen weight ve dimensions değerlerinin görünür oldugunu dogrula
        Assert.assertTrue(alloverPage.spesificationWeight.isDisplayed());
        Assert.assertTrue(alloverPage.spesificationDimensions.isDisplayed());






    }
}
