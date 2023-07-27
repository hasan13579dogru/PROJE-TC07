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

public class TC_01_VendorUrunEklSecenekleri {

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

        //"Sayfanın altındaki Inventory, Shipping, Attributes, Linked, Seo, Advanced
        //menülerinin görünürlüğünü doğrular"

       Assert.assertTrue(alloverPage.inventory.isDisplayed());
       Assert.assertTrue(alloverPage.shipping.isDisplayed());
       Assert.assertTrue(alloverPage.attributes.isDisplayed());
       Assert.assertTrue(alloverPage.linked.isDisplayed());
       Assert.assertTrue(alloverPage.seo.isDisplayed());
       Assert.assertTrue(alloverPage.advenced.isDisplayed());



    }
}
