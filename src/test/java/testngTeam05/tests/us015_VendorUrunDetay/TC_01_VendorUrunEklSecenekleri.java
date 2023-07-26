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
