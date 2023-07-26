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

public class TC_03_InventoryStok {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Select select;
    @Test
    public void inventoryStokTest() {
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
        ReusableMethods.click(alloverPage.mouseResmi);
        alloverPage.addToGalery.click();

        //Category Bölümünden eklediği ürünün ait oldugu kategoriyi işaretler
        ReusableMethods.click(alloverPage.categoriesCheckbox);

        //Sayfanın altında yer alan Shipping işlemini seçer
        ReusableMethods.click(alloverPage.shipping);

        //Weight bölümüne değer girer
        //Dimensions bölümünden length,width ve height değerlerini girer
        alloverPage.weight.sendKeys("0,200",Keys.TAB,"15",Keys.TAB,"10",Keys.TAB,"10");

        //Shipping class dropdown menüsünden seçim yapar ***************************************************************
        select=new Select(alloverPage.shippingClass);
        ReusableMethods.ddmIndex(alloverPage.shippingClass,0);

        //Processing time bölümünden süre seçer
        select = new Select(alloverPage.processingTime);
        select.selectByVisibleText("3-5 business days");

        //Submit butonuna tıklar
        ReusableMethods.click(alloverPage.submitButton);

        //Yenilenen sayfada submit butonunun yanında yer alan view butonuna tıklar
        ReusableMethods.click(alloverPage.view);

        //Acılan sayfada urun resminin altında yer alan specificationa tıklar
        ReusableMethods.switchToWindow(1);
        ReusableMethods.click(alloverPage.spesification);

        //Girilen weight ve dimensions değerlerinin görünür oldugunu dogrular
        Assert.assertTrue(alloverPage.spesificationWeight.isDisplayed());
        Assert.assertTrue(alloverPage.spesificationDimensions.isDisplayed());




    }
}
