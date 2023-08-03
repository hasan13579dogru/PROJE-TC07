package testngTeam05.tests.us004_shippingadress;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class Shipping_TC01 {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //signin butonuna tıklar

        AlloverCommercePage alloverPage = new AlloverCommercePage();


        //Kayıtlı email adresi ve şifresiyle sign in sekmesinden siteye giriş yapar
        alloverPage.signin.click();
        alloverPage.signInUserNameEmail.sendKeys(ConfigReader.getProperty("allovermusteriEmailAdresi"), Keys.TAB,
                ConfigReader.getProperty("allovermusteriSifresi"));
        alloverPage.signButton.click();
       // ReusableMethods.bekle(3);

        //sayfaya girdiğini doğrula

        Assert.assertTrue(alloverPage.signouut.isDisplayed());

        //My Account elementinin gorunur oldugunu doğrula
        Assert.assertTrue(alloverPage.myAccountt.isDisplayed());
       // ReusableMethods.bekle(2);

        //My account Linkine tıkla
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        AlloverCommercePage.myAccountt.click();



        //"Açılan my account sayfasında adress Menüsünün görünür oldugunu doğrular"
        //ReusableMethods.bekle(3);
        Assert.assertTrue(alloverPage.adress.isDisplayed());

        // Click on “Addresses" button
        AlloverCommercePage.adress.click();

        //Click on “ADD” button below “Shipping Address"

        alloverPage.addShipping.click();

        //Enter the "FirstName" field
        alloverPage.firstNameShipping.clear();
        alloverPage.firstNameShipping.sendKeys(ConfigReader.getProperty("FirstName"));

        //Enter the "LastName" field

        alloverPage.lastNameShipping.clear();
        alloverPage.lastNameShipping.sendKeys(ConfigReader.getProperty("Lastname"));

        //Enter the "CompanyName" field
        alloverPage.companyNameShipping.clear();
        alloverPage.companyNameShipping.sendKeys(ConfigReader.getProperty("CompanyName"));

        //  Select Country/Region
        alloverPage.countryShipping.click();
        alloverPage.inputCountryShipping.sendKeys(ConfigReader.getProperty("CountryRegion"),Keys.ENTER);

        //Enter the "Street Adress" field
        alloverPage.streetAddressShippingOptional.clear();
        alloverPage.streetAddressShipping.sendKeys(ConfigReader.getProperty("StreetAddress"));

        //Enter the "Apertment Adress" field
        alloverPage.streetAddressShippingOptional.clear();
        alloverPage.streetAddressShippingOptional.sendKeys(ConfigReader.getProperty("Apartment"));


        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(3);

        //Enter the "zipcode" field
        alloverPage.postZıpCodeShipping.clear();
        alloverPage.postZıpCodeShipping.sendKeys(ConfigReader.getProperty("ZIPCode"));

        //Enter the "towncity" field
        alloverPage.townCityShipping.clear();
        alloverPage.townCityShipping.sendKeys(ConfigReader.getProperty("TownCity"));


        //  Select Province
        alloverPage.provinceShipping.click();
        alloverPage.inputProvinceShipping.sendKeys(ConfigReader.getProperty("Province"),Keys.ENTER);

        //Select submitButton
       // ReusableMethods.clickWithJS(alloverPage.submitButtonShipping);

        //Successful login is verified
        String expected="Address changed successfully.";
        String actual=alloverPage.verifyMassage.getText();

        Assert.assertEquals(actual,expected);

        //exit the page
        Driver.quitDriver();















    }
}
