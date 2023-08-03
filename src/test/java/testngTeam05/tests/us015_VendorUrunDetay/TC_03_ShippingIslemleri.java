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
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TC_03_ShippingIslemleri extends ExtentReport {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Select select;

    @Test
    public void shippingTesti() {
        extentTest = extentReports.createTest("Extent Report", "Inventory İşlemleri Test Raporu");
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        //https://allovercommerce.com/ adresine git, kayıtlı Vendor email adresi ve şifresiyle giriş yap
        //  ReusableMethods.vendorSignIn();
        ReusableMethods.bekle(3);
        extentTest.info("allovercommerce sitesine gidildi,kayıtlı Vendor email adresi ve şifresiyle giriş yapıldı");

        //My Account sayfasına git
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(alloverPage.myAccountButton);
        extentTest.info("My Account sayfasına gidildi");

        //My Account sayfasının açıldığını doğrula
        Assert.assertTrue(alloverPage.myAccountBaslik.isDisplayed());
        extentTest.info("My Account sayfasının açıldığı doğrulandı");

        //Açılan my account sayfasında Store Manager Menüsünün görünür oldugunu doğrula
        Assert.assertTrue(alloverPage.storeManager.isDisplayed());
        extentTest.info("Açılan my account sayfasında Store Manager Menüsünün görünür oldugu doğrulandı");

        //Store manager'a tıkla
        alloverPage.storeManager.click();
        extentTest.info("Store manager'a tıklandı");

        //Store Manager sayfasının açıldığını doğrula
        Assert.assertTrue(alloverPage.storeManagerBaslik.isDisplayed());
        extentTest.info("Store Manager sayfasının açıldığı doğrulandı");

        //Product butonunun görünür olduğunu doğrula
        Assert.assertTrue(alloverPage.product.isDisplayed());
        extentTest.info("Product butonunun görünür olduğu doğrulandı");

        //Products'ın üzerine gel açılan penceredeki Add New'e tıkla
        actions.moveToElement(alloverPage.product).perform();
        alloverPage.addNew.click();
        extentTest.info("Products butonu üzerine gelinip açılan penceredeki Add New'e tıklandı");

        //Add Product sayfasının açıldığını doğrula
        Assert.assertTrue(alloverPage.addProductBaslik.isDisplayed());
        extentTest.info("Add Product sayfasının açıldığı doğrulandı");
/*
        //Product title alanına eklemek istediği ürün adını gir
        alloverPage.productTitle.sendKeys("mouse");
        extentTest.info("Product title alanına eklenecek ürünün adı girildi");

        //Sag tarafta yer alan feature image bölümünden ürünün resmini ekle
        alloverPage.featureImage.click();
        ReusableMethods.bekle(2);
        //select files a tıkla
        alloverPage.selectFilesButton.click();
        ReusableMethods.uploadFilePath("C:\\Users\\EXCALIBUR\\Pictures\\Saved Pictures\\mouse1.jpeg");
        //select'e tıkla
        alloverPage.selectFeature.click();
        ReusableMethods.bekle(3);
        extentTest.info("feature image bölümünden ürünün resmieklendi");

        //Sag tarafta yer alan galeri image bölümünden ürünün resmini ekle
        ReusableMethods.click(alloverPage.galeryImage);
        alloverPage.mouseResmi.click();
        alloverPage.addToGalery.click();
        extentTest.info("galeri image bölümünden ürünün resmini eklendi");

        //Category Bölümünden eklediği ürünün ait oldugu kategoriyi seç
        ReusableMethods.click(alloverPage.categoriesCheckbox);
        extentTest.info("Kategori seçildi");
*/
        //Sayfanın altında yer alan Shipping butonuna tıkla
        ReusableMethods.click(alloverPage.shipping);
        extentTest.info("Shipping butonuna tıklandı");

        //Weight bölümüne ürün ağırlığını gir ve girildiğini doğrula
        alloverPage.weight.sendKeys("0.200");
        Assert.assertEquals(alloverPage.weight.getAttribute("value"),"0.200");

        //Dimensions bölümünde length,width ve height değerlerini gir ve girildiğini doğrula
        alloverPage.length.sendKeys("15");
        Assert.assertEquals(alloverPage.length.getAttribute("value"),"15");
        alloverPage.width.sendKeys("10");
        Assert.assertEquals(alloverPage.width.getAttribute("value"),"10");
        alloverPage.height.sendKeys("10");
        Assert.assertEquals(alloverPage.height.getAttribute("value"),"10");
        extentTest.info("Ürün ağırlık ve boyut bilgileri girildi ve doğrulandı");

        //"Shipping Class" Ddm'den "No shipping class" seç ve seçildiğini doğrula
        select=new Select(alloverPage.shippingClass);
        ReusableMethods.ddmIndex(alloverPage.shippingClass,0);
        Assert.assertEquals(alloverPage.shippingClass.getText(),"No shipping class");
        extentTest.info("Shipping Class Ddm'den No shipping class seçildi ve doğrulandı");

        //"Processing Time" Ddm'den süre seç ve seçildiğini doğrula
        select = new Select(alloverPage.processingTime);
        select.selectByIndex(4);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"3-5 business days");
        extentTest.info("Processing Time Ddm'den süre seçildi ve doğrulandı");

        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Shipping");
        extentTest.info("Sayfa resmi alındı");
    }
}
