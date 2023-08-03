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




public class TC_04_AttributesIslemleri extends ExtentReport {





    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void AttributesTesti() {
        extentTest = extentReports.createTest("Extent Report", "Inventory İşlemleri Test Raporu");
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        // https://allovercommerce.com/ adresine git, kayıtlı Vendor email adresi ve şifresiyle giriş yap
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
        Assert.assertTrue(alloverPage.storeManager.isDisplayed());
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
        //Sayfanın altında yer alan "Attributes" butonuna tıkla
        ReusableMethods.click(alloverPage.attributes);
        extentTest.info("Attributes butonuna tıklandı");

        //Color Checkbox'ına tıkla ve tıklandığını doğrula
        alloverPage.colorCheckBox.click();
        Assert.assertTrue(alloverPage.colorCheckBox.isSelected());
        extentTest.info("Color Checkbox'ına tıklandı ve doğrulandı");

        //Ürün rengini gir ve girildiğini doğrula
        alloverPage.colorSecim.sendKeys("Beyaz", Keys.ENTER);
        Assert.assertEquals(alloverPage.colorSecim.getAttribute("value"),"Beyaz");
        extentTest.info("Ürün rengi girildi ve doğrulandı");

        //Size Checkbox'ına tıkla ve tıklandığını doğrula
        ReusableMethods.click(alloverPage.sizeCheckBox);
        Assert.assertTrue(alloverPage.sizeCheckBox.isSelected());
        extentTest.info("Size Checkbox'ına tıklandı ve doğrulandı");

        //Ürün Size'ını seç ve siçildiğini doğrula
        ReusableMethods.click(alloverPage.sizeSecim);
        alloverPage.sizeSecim.sendKeys("EkstraSmall", Keys.TAB);
        Assert.assertEquals(alloverPage.sizeSecim.getAttribute("value"),"EkstraSmall");
        extentTest.info("Ürün Size'ı seçildi ve doğrulandı");

        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Attributes");
        extentTest.info("Sayfa resmi alındı");
    }
}