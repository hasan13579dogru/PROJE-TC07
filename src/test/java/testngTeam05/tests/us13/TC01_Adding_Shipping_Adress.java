package testngTeam05.tests.us13;

import com.github.javafaker.Faker;
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

public class TC01_Adding_Shipping_Adress {


    @Test
    public void test01(){

        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();

        Faker faker = new Faker();



        //vendor https://www.allovercommerce.com/ a git

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        AlloverCommercePage alloverCommercePageSK = new AlloverCommercePage();
        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);

        alloverCommercePageSK.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmailSK"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorPasswordSK"));
        alloverCommercePageSK.signInButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());

        alloverCommercePage.signOut.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.VendorAddress);

        ReusableMethods.bekle(2);
        Assert.assertTrue(alloverCommercePage.ShippingAdd.isDisplayed());
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.ShippingAdd);

        ReusableMethods.click(alloverCommercePage.ShippinFirstName);
        //name,lastname,email,displayedname alanlarına yeni bilgiler gir
        faker = new Faker();
        String shippingName = faker.name().firstName();
        String shippingLastName = faker.name().lastName();
        String shippingCompanyName = faker.company().name();
        String shippingStreet = faker.address().streetAddress();
        String shippingApt = faker.address().streetName();
        String shipngZip = faker.address().zipCode();
        String shippingTown = faker.address().city();
        alloverCommercePage.ShippinFirstName.sendKeys(shippingName, Keys.TAB, shippingLastName,
                Keys.TAB, shippingCompanyName, Keys.TAB);
        ReusableMethods.click(alloverCommercePage.ShippinSelectCountry);
        WebElement selectCountry = alloverCommercePageSK.ShippinSelectCountry;
        Select country = new Select(selectCountry);
        country.selectByIndex(2);
        alloverCommercePage.ShippinStreet.sendKeys(shippingStreet, Keys.TAB, shippingApt,
                Keys.TAB, shipngZip, Keys.TAB, shippingTown, Keys.TAB);
        ReusableMethods.click(alloverCommercePage.ShippingSaveAdress);

        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.ShippingSuccesText);

        String actualSuccessText = alloverCommercePage.ShippingSuccesText.getText();
        String expectedSuccessText = "Address changed successfully.";
        Assert.assertEquals(actualSuccessText, expectedSuccessText);
        System.out.println(actualSuccessText);

        Driver.getDriver().close();
    }
}