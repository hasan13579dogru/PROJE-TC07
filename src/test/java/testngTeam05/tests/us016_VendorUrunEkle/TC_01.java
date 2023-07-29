package testngTeam05.tests.us016_VendorUrunEkle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC_01 extends ExtentReport {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Select select;
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Extent Report", "Inventory İşlemleri Test Raporu");
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        //Vendor https://allovercommerce.com/ adresine git, kayıtlı Vendor email adresi ve şifresiyle giriş yap
        ReusableMethods.vendorSignIn();
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

        //Simple Product'ın default olarak geldiğini doğrula
        alloverPage.simpleProductDdm.getText();
        Assert.assertEquals(alloverPage.simpleProductDdm.getText(),"Simple Product");
        extentTest.info("Simple Product'ın default olarak geldiği doğrulandı");

        //Vitrual kutucuğunun seçilebilir olduğunu doğrula
        ReusableMethods.click(alloverPage.virtualCheckBox);
        Assert.assertTrue(alloverPage.virtualCheckBox.isSelected());
        alloverPage.virtualCheckBox.click();
        extentTest.info("Vitrual kutucuğunun seçilebilir olduğu doğrulandı");

        //Downloadable kutucuğunun seçilebilir olduğunu doğrula
        ReusableMethods.click(alloverPage.downloadableCheckBox);
        Assert.assertTrue(alloverPage.downloadableCheckBox.isSelected());
        alloverPage.downloadableCheckBox.click();
        extentTest.info("Downloadable kutucuğunun seçilebilir olduğu doğrulandı");

        //Price alanına bir değer yaz ve yazılabildiğini doğrula
        alloverPage.prise.sendKeys("50");
        Assert.assertEquals(alloverPage.prise.getAttribute("value"),"50");
        extentTest.info("Price alanına bir değer yazıldı ve yazılabildiğini doğrulandı");

        //Sale Price alanına bir değer yaz ve yazılabildiğini doğrula
        alloverPage.salePrise.sendKeys("60");
        Assert.assertEquals(alloverPage.salePrise.getAttribute("value"),"60");
        extentTest.info("Sale Price alanına bir değer yazıldı ve yazılabildiğini doğrulandı");

        //Product Title alanına ürün başlığını yaz ve yazılabildiğini doğrula
        alloverPage.productTitle.sendKeys("mouse");
        Assert.assertEquals(alloverPage.productTitle.getAttribute("value"),"mouse");
        extentTest.info("Product Title alanına ürün başlığı yazıldı ve yazılabildiği doğrulandı");

        //Category Bölümünden eklediğin ürünün ait oldugu kategoriyi seç ve seçildiğini doğrula
        ReusableMethods.click(alloverPage.categoriesCheckbox);
        Assert.assertTrue(alloverPage.categoriesCheckbox.isSelected());
        extentTest.info("Kategori seçildi");

        //Sag tarafta yer alan feature image bölümünden ürünün resmini ekle
        alloverPage.featureImage.click();
        ReusableMethods.bekle(2);
        //select files a tıkla
        alloverPage.selectFilesButton.click();
        ReusableMethods.uploadFilePath("C:\\Users\\EXCALIBUR\\Pictures\\Saved Pictures\\mouse1.jpeg");
        //select'e tıkla
        alloverPage.selectFeature.click();
        ReusableMethods.bekle(3);
        extentTest.info("feature image bölümünden ürünün resmi eklendi");

        //Sag tarafta yer alan galeri image bölümünden ürünün resmini ekle
        ReusableMethods.click(alloverPage.galeryImage);
        alloverPage.mouseResmi.click();
        alloverPage.addToGalery.click();
        extentTest.info("galeri image bölümünden ürünün resmini eklendi");

        //"SUBMIT" butonuna tıkla
        ReusableMethods.click(alloverPage.submitButton);
        extentTest.info("SUBMIT butonuna tıklandı");

        // Products butonuna tıkla
        js.executeScript("arguments[0].click();", alloverPage.product);
        ReusableMethods.click(alloverPage.product);
        extentTest.info("Products butonuna tıklandı");

        //Ürünün eklendiğini product kısmından doğrula
        ReusableMethods.click(alloverPage.product);
        Assert.assertTrue(alloverPage.productMouse.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Eklenen Ürün");
    }

}
