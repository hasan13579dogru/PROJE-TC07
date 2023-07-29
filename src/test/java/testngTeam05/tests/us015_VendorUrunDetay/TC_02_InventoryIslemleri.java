package testngTeam05.tests.us015_VendorUrunDetay;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

        //Sayfanın altında yer alan Inventory" butonuna tıkla
        ReusableMethods.click(alloverPage.inventory);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //SKU değerini gir
        alloverPage.sku.sendKeys("Team05");

        //Manage Stock checkbox'a tıkla
        ReusableMethods.click(alloverPage.manageStockChecboxk);

        //Stock Qty alanına stok miktarını gir
        alloverPage.stockQty.clear();
        alloverPage.stockQty.sendKeys("100");

        //Sold individually checkbox'a tıkla
        ReusableMethods.click(alloverPage.soldIndividuallyChecboxk);

        //Submit'e tıklar
        ReusableMethods.click(alloverPage.submitButton);
        ReusableMethods.bekle(2);

        //Products' a tıkla gelen sayfada eklenen ürünün görüldüğünü doğrula
        ReusableMethods.click(alloverPage.product);
        Assert.assertTrue(alloverPage.productMouse.isDisplayed());
        ReusableMethods.webElementResmi(alloverPage.productMouse);

        //Product sayfasında eklenen ürünün yanında SKU degerinin yazılı olduğunu doğrula
//        System.out.println("Sku = " + alloverPage.productSku.getText());
//        System.out.println("StockStatus = " + alloverPage.productStockStatus.getText());
//        System.out.println("Man. stok"+alloverPage.productManageStock.getText());

        Assert.assertTrue(alloverPage.productSku.isDisplayed());

        Assert.assertTrue(alloverPage.productManageStock.isDisplayed());

        //seçilen stock durumunun bu sayfada görünür oldugunu doğrula
        Assert.assertTrue(alloverPage.productStockStatus.isDisplayed());







    }

}
