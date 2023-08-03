package testngTeam05.tests.us003_billingadress;

import io.opentelemetry.sdk.trace.ReadableSpan;
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

import java.security.Key;

/*
Go to home page
Navigate to “Sign in” page
Sign in
Click on “My Account” button
Click on “Addresses" button
Click on “ADD” button below “Billing Address"
Enter “First Name” in first name field
Enter “Last Name” in last name field
Select Country/Region
Enter Street Adress in street adress field
Enter PostCode/ZIP in postcode/zip field
Enter Town/City in town/city field
Select State
Enter Phone Number in phone number field
Click on “Save Address Button”
See message “Address saved successfully”
Click on “Addresses" button
Verify that address is added successfully below “Billing Address”

 */

public class TC_01 {
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
        ReusableMethods.bekle(3);

        //sayfaya girdiğini doğrula

        Assert.assertTrue(alloverPage.signouut.isDisplayed());

        //My Account elementinin gorunur oldugunu doğrula
        Assert.assertTrue(alloverPage.myAccountt.isDisplayed());
        ReusableMethods.bekle(2);

        //My account Linkine tıkla
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        AlloverCommercePage.myAccountt.click();



        //"Açılan my account sayfasında adress Menüsünün görünür oldugunu doğrular"
        ReusableMethods.bekle(3);
        Assert.assertTrue(alloverPage.address.isDisplayed());


       // Click on “Addresses" button
        AlloverCommercePage.adress.click();

        AlloverCommercePage.address.click();


        //Click on “ADD” button below “Billing Address"

        AlloverCommercePage.addBilling.click();

        //Enter the "FirstName" field
        alloverPage.firstName.clear();
        alloverPage.firstName.sendKeys(ConfigReader.getProperty("FirstName"));
        alloverPage.lastName.clear();

        //Enter the "LastName" field
        alloverPage.lastName.sendKeys(ConfigReader.getProperty("Lastname"));

        //Enter the "CompanyName" field
        alloverPage.companyName.clear();
        alloverPage.companyName.sendKeys(ConfigReader.getProperty("CompanyName"));

        //  Select Country/Region
        alloverPage.countryRegion.click();
        alloverPage.inputCountry.sendKeys(ConfigReader.getProperty("CountryRegion"),Keys.ENTER);

        //Enter the "Street Adress" field
        alloverPage.streetAdressMd.clear();
        alloverPage.streetAdressMd.sendKeys(ConfigReader.getProperty("StreetAddress"));

        //Enter the "Apertment Adress" field
        alloverPage.apartmentAdress.clear();
        alloverPage.apartmentAdress.sendKeys(ConfigReader.getProperty("Apartment"));

        ReusableMethods.scroll(alloverPage.phone);


        //Enter the "zipcode" field
        alloverPage.zipCode.clear();
        alloverPage.zipCode.sendKeys(ConfigReader.getProperty("ZIPCode"));

        //Enter the "towncity" field
        alloverPage.townCityMd.clear();
        alloverPage.townCityMd.sendKeys(ConfigReader.getProperty("TownCity"));

        //ReusableMethods.scrollEnd();
        //ReusableMethods.bekle(5);


        //  Select Province
        alloverPage.province.click();
        alloverPage.provinceInput.sendKeys(ConfigReader.getProperty("Province"),Keys.ENTER);
        alloverPage.phoneMd.clear();
        alloverPage.phoneMd.sendKeys(ConfigReader.getProperty("Phone"));

        //Select submitButton
        //ReusableMethods.clickWithJS(alloverPage.submitBtn);


        //Successful login is verified

        String expected="Address changed successfully.";
        String actual=alloverPage.verifyMassage.getText();

        Assert.assertEquals(actual,expected);

        //exit the page
        Driver.quitDriver();






























    }
}
