package testngTeam05.tests.us015_VendorUrunDetay;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC_02_InventoryIslemleri extends ExtentReport{
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void inventoryTesti() {
        extentTest = extentReports.createTest("Extent Report", "Inventory İşlemleri Test Raporu");
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        //https://allovercommerce.com/ adresine git, kayıtlı Vendor email adresi ve şifresiyle giriş yap
        //  ReusableMethods.vendorSignIn();
        ReusableMethods.bekle(3);
        extentTest.info("allovercommerce sitesine gidildi,kayıtlı Vendor email adresi ve şifresiyle giriş yapıldı");

        //My Account butonuna tıkla git
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

        //Category Bölümünden eklenecek ürünün ait oldugu kategoriyi seç
        ReusableMethods.click(alloverPage.categoriesCheckbox);
        extentTest.info("Kategori seçildi");
*/
        //Sayfanın altında yer alan Inventory" butonuna tıkla
        ReusableMethods.click(alloverPage.inventory);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Inventory butonuna tıklandı");

        //SKU değerini gir girildiğini ve doğrula
        alloverPage.sku.sendKeys("Team05");
        Assert.assertEquals(alloverPage.sku.getAttribute("value"),"Team05");
        extentTest.info("SKU değerini girildi ve doğrulandı");

        //Manage Stock checkbox'a tıkla ve tıklandığını doğrula
        ReusableMethods.click(alloverPage.manageStockChecbox);
        Assert.assertTrue(alloverPage.manageStockChecbox.isSelected());
        extentTest.info("Manage Stock checkbox'a tıklandı ve doğrulandıı");

        //Stock Qty alanına stok miktarını gir girildiğini ve doğrula
        alloverPage.stockQty.clear();
        alloverPage.stockQty.sendKeys("100");
        Assert.assertEquals(alloverPage.stockQty.getAttribute("value"),"100");
        extentTest.info("Stock Qty alanına stok miktarını girildi ve doğrulandı");

        //Sold individually checkbox'a tıkla ve tıklandığını doğrula
        ReusableMethods.click(alloverPage.soldIndividuallyChecbox);
        Assert.assertTrue(alloverPage.soldIndividuallyChecbox.isSelected());
        extentTest.info("Sold individually checkbox'a tıklandı ve doğrulandı");

        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Inventory");
        extentTest.info("Sayfa resmi alındı");
    }
}
