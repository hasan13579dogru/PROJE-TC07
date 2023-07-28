package testngTeam05.tests.us015_VendorUrunDetay;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC_04_AttributesIslemleri {

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


        //Sayfanın altında yer alan "Attributes" butonuna tıkla
        ReusableMethods.click(alloverPage.attributes);

        //Color Checkbox'ına tıkla
        alloverPage.colorCheckBox.click();

        //Ürün rengini gir
        alloverPage.colorSecim.sendKeys("Black",Keys.ENTER);

        //Size Checkbox'ına tıkla
        alloverPage.sizeCheckBox.click();

        //Ürün Size'ını seç
        alloverPage.sizeSecim.sendKeys("EkstraSmall",Keys.TAB);

        //"SUBMIT" butonuna tıkla
        ReusableMethods.click(alloverPage.submitButton);

        //Yenilenen sayfada submit butonunun yanında yer alan view butonuna tıkla
        ReusableMethods.click(alloverPage.viewButton);

        //Acılan sayfada urun resminin altında yer alan specificationa tıkla
        ReusableMethods.switchToWindow(1);
        ReusableMethods.click(alloverPage.spesification);

        //Color değerinin görüldüğünü doğrula



        //Size değerinin görüldüğünü doğrula


    }
}