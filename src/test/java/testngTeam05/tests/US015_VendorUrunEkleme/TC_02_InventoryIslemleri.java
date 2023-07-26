package testngTeam05.tests.US015_VendorUrunEkleme;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC_02_InventoryIslemleri {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() {
        AlloverCommercePage alloverPage = new AlloverCommercePage();

        //Vendor https://allovercommerce.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Kayıtlı vendor email adresi ve şifresiyle sign in sekmesinden siteye giriş yapar
        alloverPage.signIn.click();
        alloverPage.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmail"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorSifre"));
        alloverPage.signInButton.click();
        ReusableMethods.bekle(5);

        // my account'a tıklar
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(alloverPage.myAccountButton);

        //"Açılan my account sayfasında Store Manager Menüsünün görünür oldugunu doğrular"
        Assert.assertTrue(alloverPage.storeManager.isDisplayed());

        //Store manager'a tıklar
        alloverPage.storeManager.click();

        //Açılan Store Manager sayfasında Products bölümünün görünür oldugunu doğrular
        Assert.assertTrue(alloverPage.product.isDisplayed());

        //Products yazısının uzerine geldiğinde görünen Add New yazısına tıklar
        actions.moveToElement(alloverPage.product).perform();
        alloverPage.addNew.click();

        //Product title alanına eklemek istediği ürün adını girer
        alloverPage.productTitle.sendKeys("mouse");

        //Sag tarafta yer alan feature image bölümünden ürünün resmini ekler
        alloverPage.featureImage.click();
        ReusableMethods.bekle(2);
        alloverPage.mediaLibrary.click();

        alloverPage.mouseResmiFeature.click();
        alloverPage.selectFeature.click();
        ReusableMethods.bekle(3);

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

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

        //Category Bölümünden eklediği ürünün ait oldugu kategoriyi işaretler
        ReusableMethods.click(alloverPage.categoriesCheckbox);

        //Sayfanın altında yer alan Inventory işlemini seçer
        ReusableMethods.click(alloverPage.inventory);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //SKU değeri girer
        alloverPage.sku.sendKeys("Team05");

        //Manage Stock checkbox'a tıklar
        ReusableMethods.click(alloverPage.manageStockChecboxk);

        //Stock Qty alanına stok miktarını girer
        alloverPage.stockQty.clear();
        alloverPage.stockQty.sendKeys("100");

        //Sold individually checkbox'a tıklar
        ReusableMethods.click(alloverPage.soldIndividuallyChecboxk);

        //Submit'e tıklar
        ReusableMethods.click(alloverPage.submitButton);
        ReusableMethods.bekle(2);

        //Sayfanın solunda yer alan Products' a tıklayıp gelen sayfada eklediği ürünü görür
        ReusableMethods.click(alloverPage.product);
        Assert.assertTrue(alloverPage.productMouse.isDisplayed());
        ReusableMethods.webElementResmi(alloverPage.productMouse);

        //Product sayfasında eklenen ürünün yanında SKU degerinin yazılı olduğunu görür
//        System.out.println("Sku = " + alloverPage.productSku.getText());
//        System.out.println("StockStatus = " + alloverPage.productStockStatus.getText());
//        System.out.println("Man. stok"+alloverPage.productManageStock.getText());

        Assert.assertTrue(alloverPage.productSku.isDisplayed());
        Assert.assertTrue(alloverPage.productStockStatus.isDisplayed());
        Assert.assertTrue(alloverPage.productManageStock.isDisplayed());




    }

}
