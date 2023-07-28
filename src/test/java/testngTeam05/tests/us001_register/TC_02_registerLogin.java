package testngTeam05.tests.us001_register;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.util.Random;

public class TC_02_registerLogin {
    @Test
    public void test02() {

        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();


        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        String mainPageHandle = Driver.getDriver().getWindowHandle();

        alloverCommercePage.registerButton.click();

        Random random = new Random();
        int rndm = random.nextInt();

        alloverCommercePage.userName.sendKeys("Umran." + rndm);
        ReusableMethods.bekle(2);



        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get(ConfigReader.getProperty("fakemailSitesiUrl"));
        alloverCommercePage.copyFakeMail.click();
        ReusableMethods.bekle(2);


        Driver.getDriver().switchTo().window(mainPageHandle);
        alloverCommercePage.yourEmailAddress.sendKeys(Keys.CONTROL, "v");
        ReusableMethods.bekle(2);


        alloverCommercePage.registerPassword.sendKeys(ConfigReader.getProperty("us01Password"));
        ReusableMethods.bekle(2);

        alloverCommercePage.iAgreeClick.click();
        alloverCommercePage.registerSignUp.click();

        Assert.assertTrue(alloverCommercePage.registersignOut.isDisplayed());



        Driver.quitDriver();


    }

}
