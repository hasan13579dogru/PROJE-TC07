package testngTeam05.tests.us003_billingadress;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

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

        //Vendor https://allovercommerce.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Kayıtlı vendor email adresi ve şifresiyle sign in sekmesinden siteye giriş yapar
        alloverPage.signIn.click();
        alloverPage.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmail"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorSifre"));
        alloverPage.signInButton.click();
        ReusableMethods.bekle(3);

        //sayfaya girdiğini doğrula

        Assert.assertTrue(AlloverCommercePage.signOut.isDisplayed());

        //My Account elementinin gorunur oldugunu doğrula
        Assert.assertTrue(alloverPage.myAccount.isDisplayed());
                ReusableMethods.bekle(2);

        //My account Linkine tıkla
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        AlloverCommercePage.myAccount.click();



        //"Açılan my account sayfasında adress Menüsünün görünür oldugunu doğrular"
        ReusableMethods.bekle(3);

        //Assert.assertTrue(alloverPage.address.isDisplayed());

        //AlloverCommercePage.address.click();





        //Assert.assertTrue(alloverPage.address.isDisplayed());

        //AlloverCommercePage.address.click();





















    }
}
