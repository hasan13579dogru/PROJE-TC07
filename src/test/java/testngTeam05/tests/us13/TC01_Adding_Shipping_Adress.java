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
    public void test01() throws InterruptedException {

        AlloverCommercePage alloverCommercePage=new AlloverCommercePage();

        Faker faker=new Faker();


        //vendor shoul go to the https://www.allovercommerce.com/

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        AlloverCommercePage alloverCommercePageSK= new AlloverCommercePage();


        //Vendor should be able to click Sign In button
        //Sing up as a Vendor
        alloverCommercePage.anasayfaSigninButon.click();
        Assert.assertTrue(alloverCommercePage.anasayfaSigninButon.isDisplayed());
        ReusableMethods.bekle(1);
        //vendor click username or email and should be to enter
        alloverCommercePageSK.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmailSK"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorPassword"));

        alloverCommercePageSK.signInButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());

        //vendor should be able to click 'Addresses'
        alloverCommercePage.signOut.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.VendorAddress);
        ReusableMethods.bekle(2);


        //Vendor  should be able to click 'ADD' button below shipping address
        Assert.assertTrue(alloverCommercePage.ShippingAdd.isDisplayed());
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.ShippingAdd);
        Assert.assertTrue(alloverCommercePage.ShippinFirstName.isDisplayed());

        //Vendor should be able to enter alphabetic character in the name field
        ReusableMethods.click(alloverCommercePage.ShippinFirstName);
        alloverCommercePage.ShippinFirstName.clear();
        alloverCommercePage.ShippinStreet.clear();

        faker=new Faker();
        String shippingName=faker.name().firstName();
        String shippingLastName=faker.name().lastName();
        String shippingCompanyName=faker.company().name();
        String shippingStreet=faker.address().streetAddress();
        String shippingApt=faker.address().streetName();
        String shipngZip=faker.address().zipCode();
        String shippingTown=faker.address().city();
        //Vendor should be able to enter alphabetic character in the name field
        //Vendor should be able to enter alphabetic character in the Last name field
        //Vendor should be able to enter alphabetic character in Company Name field

        alloverCommercePage.ShippinFirstName.sendKeys(shippingName,Keys.TAB,shippingLastName,
                Keys.TAB,shippingCompanyName,Keys.TAB);
        ReusableMethods.click(alloverCommercePage.ShippinSelectCountry);
        //Vendor should be able to select Country/Region

        WebElement selectCountry= alloverCommercePageSK.ShippinSelectCountry;
        Select country=new Select(selectCountry);
        country.selectByIndex(2);

        //Vendor should be able to enter alphabetic character in the Street Address field
        //Vendor should be able to enter alphabetic character in the Town/City field
        //Vendor should be able to enter a combination of numaric characters in the ZIP Code field
        alloverCommercePage.ShippinStreet.sendKeys(shippingStreet,Keys.TAB,shippingApt,
                Keys.TAB,shipngZip,Keys.TAB,shippingTown,Keys.TAB);

        //Vendor shouldn't be able to click save address field if it is requried

        Assert.assertTrue(alloverCommercePage.ShippingSaveAdress.isDisplayed());

        ReusableMethods.click(alloverCommercePage.ShippingSaveAdress);

        ReusableMethods.bekle(2);
        //Validation message should be displayed
        ReusableMethods.click(alloverCommercePage.ShippingSuccesText);

         String actualSuccessText= alloverCommercePage.ShippingSuccesText.getText();
         String expectedSuccessText="Address changed successfully.";
         Assert.assertEquals(actualSuccessText,expectedSuccessText);
        System.out.println(actualSuccessText);

       Driver.getDriver().close();























    }








}
