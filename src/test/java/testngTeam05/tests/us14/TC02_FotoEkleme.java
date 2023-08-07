package testngTeam05.tests.us14;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC02_FotoEkleme {




    @Test
    public void fotoEkleme(){


        //User should be able to see the options to add items as a Vendor

        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        AlloverCommercePage alloverCommercePageSK = new AlloverCommercePage();


        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);



        alloverCommercePageSK.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmailSK"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorPasswordSK"));
        alloverCommercePageSK.signInButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(AlloverCommercePage.signOut.isDisplayed());

        //Vendor should be able to see product adding options

        AlloverCommercePage.signOut.click();
        ReusableMethods.bekle(2);

        ReusableMethods.click(alloverCommercePage.storeManager);
        ReusableMethods.scroll(alloverCommercePage.product);

        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.product);

        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.productAddnew);
        //Product Title, Short Description ve Description yazılabilmeli


        ReusableMethods.bekle(3);



       ReusableMethods.click(alloverCommercePage.imgTikla);
       ReusableMethods.bekle(2);
        alloverCommercePage.selectFilesButton.click();


        String filePath = System.getProperty("user.home")+"/Users/apple/Desktop/img2.png ";

       ReusableMethods.uploadFilePath(filePath);


        alloverCommercePage.selectFeature.click();
       // alloverCommercePage.sonYuklemeSelect.click();





    }
}
