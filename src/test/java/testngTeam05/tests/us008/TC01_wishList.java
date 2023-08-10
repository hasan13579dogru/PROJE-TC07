package testngTeam05.tests.us008;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;

public class TC01_wishList extends ExtentReport {
    //Go to (https://allovercommerce.com )site
    //click Signin button
    //Enter username or email address and password
    //click Signin button(emailbutton)
    //Search automatic crusher,chess,Electric Rice Cooker and press wishlist
    //Click wishlist
    //alloverPage.quickViewKapatma.click();
    //alloverPage.quickViewKapatma.click();
    //Add the items to Cart(Electric Rice Cooker,Atomatic Crusher,Chess)
    //Click the Cart button(on the right side of the page)
    //Click checkout button
    //Verify that Billing Details is visible
    //Fill in the Billing Details Radio Buton
    //Click PLACE ORDER button
    //confirm place order is visible

    private WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());


    Select select;

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Extent Report", "Test Raporu");
        AlloverCommercePage alloverPage = new AlloverCommercePage();
        //Go to (https://allovercommerce.com )site
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        ReusableMethods.bekle(4);
        extentTest.info("allovercommerce sitesine gidildi");

        //click Signin button
        alloverPage.anasayfaSigninButon.click();
        ReusableMethods.bekle(2);
        extentTest.info("signin butonuna tıklandı");


        //Enter username or email address and password
        alloverPage.userNameEmailAddress.sendKeys(ConfigReader.getProperty("Email"),
                Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
       extentTest.info("username or email ve password girildi");

        //click Signin button(emailbutton)
        alloverPage.signInButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("alttaki signin butonuna tıklandı");


        //Search automatic crusher,chess,Electric Rice Cooker and press wishlist
        alloverPage.searchButton.sendKeys("Automatic crusher", Keys.ENTER);

        ReusableMethods.click(alloverPage.AutomaticcrusherWishbtn);
        ReusableMethods.bekle(2);

        alloverPage.searchButton.sendKeys("Electric Rice Cooker", Keys.ENTER);
        ReusableMethods.click(alloverPage.electricRiceCookerwishbtn);
        ReusableMethods.bekle(2);
        //Click wishlist
        alloverPage.wishListButton.click();
        ReusableMethods.bekle(2);

       extentTest.info("automatic crusher,chess,Electric Rice Cooker urunler yazdırıldı ve wishlist butonuna tıklandı");



        //Click "Quick View" and close
        ReusableMethods.click(alloverPage.quickViewButton1);
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ESCAPE).perform();

        ReusableMethods.bekle(2);

        ReusableMethods.click(alloverPage.quickViewButton2);
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.bekle(2);
        extentTest.info("Quick View butonuna acıldı ve kapatıldı");




        //Add the items to Cart(Electric Rice Cooker,Atomatic Crusher,Chess)
        alloverPage.addToCartButton1.click();
        ReusableMethods.bekle(2);
        extentTest.info("Electric Rice Cooker,Atomatic Crusher,Chess urunleri sepete eklendi");


        //Click the Cart button(on the right side of the page)
        ReusableMethods.click(alloverPage.cartButton);
        ReusableMethods.bekle(2);
       extentTest.info("sepet acıldı");
        //Click checkout button
        alloverPage.checkoutCart.click();//kasaya gitme
        ReusableMethods.bekle(3);
        extentTest.info("kasaya gidildi");

        //Verify that Billing Details is visible
        Assert.assertTrue(alloverPage.billingDetailsYazisi.isDisplayed());
        extentTest.info("billing details yazisi dogrulandı");
        ReusableMethods.bekle(2);

        //Fill in the Billing Details Radio Buton

        alloverPage.billingFirstName.sendKeys("firstName",
                Keys.TAB, "last name",
                Keys.TAB, "company");
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        alloverPage.countryRegion.click();
        alloverPage.inputCountry.sendKeys(ConfigReader.getProperty("CountryRegion"),Keys.ENTER);

        alloverPage.streetAddressBilling.click();
        alloverPage.streetAddressBilling.sendKeys("house number", Keys.TAB, Keys.TAB, "Zip Code", Keys.TAB, "Costa", Keys.TAB, Keys.TAB, "5552032547");

        ReusableMethods.click(alloverPage.province);
        alloverPage.provinceInput.sendKeys(ConfigReader.getProperty("Province"),Keys.ENTER);

        ReusableMethods.bekle(2);

        ReusableMethods.click(alloverPage.wireTransferButton);
        actions.sendKeys(Keys.PAGE_DOWN);
        extentTest.info(" bosluklar dolduruldu");
        //Click PLACE ORDER button
        ReusableMethods.click(alloverPage.placeOrderButton);
        extentTest.info("PLACE ORDER butonuna tıklandı");

        //confirm place order is visible
        Assert.assertTrue(alloverPage.placeOrderButton.isDisplayed());
        ReusableMethods.webElementResmi(alloverPage.placeOrderButton);
      extentTest.info("place order yazisi dogrulandı ve elementin fotografı cekildi");

        ReusableMethods.tumSayfaResmi("hasan");
        extentTest.info("tum sayfa resmi cekildi");
    }
}









