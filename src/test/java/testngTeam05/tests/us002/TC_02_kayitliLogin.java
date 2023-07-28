package testngTeam05.tests.us002;

import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC_02_kayitliLogin {
    @Test
    public void test02() {
        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();


        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


        alloverCommercePage.registerButton.click();

        alloverCommercePage.userName.sendKeys(ConfigReader.getProperty("registerUserName"));
        ReusableMethods.bekle(2);

        alloverCommercePage.yourEmailAddress.sendKeys(ConfigReader.getProperty("registerMail"));
        ReusableMethods.bekle(2);

        alloverCommercePage.registerPassword.sendKeys(ConfigReader.getProperty("registerPassword"));
        ReusableMethods.bekle(2);

        alloverCommercePage.iAgreeClick.click();
        alloverCommercePage.registerSignUp.click();

        Assert.assertTrue(alloverCommercePage.pleaseLoginYazisi.isDisplayed());

        Driver.quitDriver();

    }
}
