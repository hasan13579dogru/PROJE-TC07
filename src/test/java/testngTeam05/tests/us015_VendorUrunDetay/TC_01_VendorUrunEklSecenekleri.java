package testngTeam05.tests.us015_VendorUrunDetay;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC_01_VendorUrunEklSecenekleri extends ExtentReport {

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Extent Report", "Inventory İşlemleri Test Raporu");
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        //https://allovercommerce.com/ adresine git, kayıtlı Vendor email adresi ve şifresiyle giriş yap
        ReusableMethods.vendorSignIn();
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

        //"Sayfanın altındaki Inventory, Shipping, Attributes, Linked, Seo, Advanced
        //menülerinin görünürlüğünü doğrular"
        js.executeScript("arguments[0].scrollIntoView(true);",alloverPage.inventory);
        ReusableMethods.bekle(2);
        Assert.assertTrue(alloverPage.inventory.isDisplayed());
        extentTest.info("inventory menüsünün görünür olduğu doğrulandı");
        Assert.assertTrue(alloverPage.shipping.isDisplayed());
        extentTest.info("Shipping menüsünün görünür olduğu doğrulandı");
        Assert.assertTrue(alloverPage.attributes.isDisplayed());
        extentTest.info("Attributes menüsünün görünür olduğu doğrulandı");
        Assert.assertTrue(alloverPage.linked.isDisplayed());
        extentTest.info("Linked menüsünün görünür olduğu doğrulandı");
        Assert.assertTrue(alloverPage.seo.isDisplayed());
        extentTest.info("Seo menüsünün görünür olduğu doğrulandı");
        Assert.assertTrue(alloverPage.advenced.isDisplayed());
        extentTest.info("Advanced menüsünün görünür olduğu doğrulandı");

        ReusableMethods.tumSayfaResmi("UrunEkSecenekleri");
        extentTest.info("Sayfa resmi alındı");



    }
}
