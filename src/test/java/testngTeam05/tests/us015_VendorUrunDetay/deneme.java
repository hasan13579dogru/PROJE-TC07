package testngTeam05.tests.us015_VendorUrunDetay;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class deneme extends ExtentReport {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    AlloverCommercePage alloverPage;
    Select select;
    @BeforeClass
    public void before() {
        extentTest = extentReports.createTest("Extent Report", "Inventory İşlemleri Test Raporu");
        alloverPage = new AlloverCommercePage();

        //Vendor https://allovercommerce.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("allovercommerce sitesine gidildi");

        // sign in butonuna tıklayarak kayıtlı Vendor email adresi ve şifresiyle giriş yap
        alloverPage.signIn.click();
        alloverPage.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmail"), Keys.TAB,
                                                  ConfigReader.getProperty("alloverVendorSifre"));
        alloverPage.signInButton.click();
        ReusableMethods.bekle(5);
        extentTest.info("kayıtlı Vendor email adresi ve şifresiyle giriş yapıldı");

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

    }

    @Test(priority = 0)
    public void testCase02() {

        //Sayfanın altında yer alan Inventory" butonuna tıkla
        ReusableMethods.click(alloverPage.inventory);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Inventory butonuna tıklandı");

        //SKU değerini gir girildi ve doğrulandı
        alloverPage.sku.sendKeys("Team05");
        System.out.println("alloverPage.sku.getAttribute(\"value\") = " + alloverPage.sku.getAttribute("value"));
        Assert.assertEquals(alloverPage.sku.getAttribute("value"),"Team05");
        extentTest.info("SKU değerini girildi ve doğrulandı");

        //Manage Stock checkbox'a tıkla ve tıklandığını doğrula
        ReusableMethods.click(alloverPage.manageStockChecbox);
        Assert.assertTrue(alloverPage.manageStockChecbox.isSelected());
        extentTest.info("Manage Stock checkbox'a tıklandı ve doğrulandıı");

        //Stock Qty alanına stok miktarını gir girildi ve doğrulandı
        alloverPage.stockQty.clear();
        alloverPage.stockQty.sendKeys("100");
        Assert.assertEquals(alloverPage.stockQty.getAttribute("value"),"100");
        extentTest.info("Stock Qty alanına stok miktarını girildi ve doğrulandı");

        //Sold individually checkbox'a tıkla ve tıklandığını doğrula
        ReusableMethods.click(alloverPage.soldIndividuallyChecbox);
        Assert.assertTrue(alloverPage.soldIndividuallyChecbox.isSelected());
        extentTest.info("Sold individually checkbox'a tıklandı ve doğrulandı");
    }

    @Test(dependsOnMethods = "testCase02" ,priority = 1)
    public void testCase03() {

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

        // alloverPage.weight.sendKeys("0.200",Keys.TAB,"15",Keys.TAB,"10",Keys.TAB,"10");
        extentTest.info("Ürün ağırlık ve boyut bilgileri girildi ve doğrulandı");

        //"Shipping Class" Ddm'den "No shipping class" seç ve seçildiğini doğrula
        select=new Select(alloverPage.shippingClass);
        ReusableMethods.ddmIndex(alloverPage.shippingClass,0);
        Assert.assertEquals(alloverPage.shippingClass.getText(),"No shipping class");
        extentTest.info("Shipping Class Ddm'den No shipping class seçildi ve doğrulandı");

        //"Processing Time" Ddm'den süre seç ve seçildiğini doğrula
        select = new Select(alloverPage.processingTime);
        select.selectByIndex(4);
        System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"3-5 business days");
        extentTest.info("Processing Time Ddm'den süre seçildi ve doğrulandı");
    }

    @Test(dependsOnMethods = "testCase03" ,priority = 2)
    public void testCase04() {
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

        ReusableMethods.tumSayfaResmi("Spesification");
        extentTest.info("Sayfa resmi alındı");
    }
}
