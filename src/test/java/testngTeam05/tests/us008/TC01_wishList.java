package testngTeam05.tests.us008;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.util.Collections;
import java.util.List;

public class TC01_wishList {
    //Go to (https://allovercommerce.com )site
    //click Signin button
    //click Sign in button(email giris)
    //Enter username or email address and password
    //click Signin button(email girisini onaylaya en son buton)
    //Pull down the page
    //Hover over Automatic crusher and click on wishlist button
    //Click wishlist
    // Click on "Quick View" buttons one by one
    // go homePage
    //  Click wishlist(on the right side of the page)
    //Click checkout button
    //Verify that Billing Details is visible
    //Fill in the Billing Details
    // Click( pay at the door )button
    //Click PLACE ORDER button

    private WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {


        AlloverCommercePage alloverPage = new AlloverCommercePage();
        //Go to (https://allovercommerce.com )site
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        ReusableMethods.bekle(4);
        //click Signin button
        alloverPage.anasayfaSigninButon.click();
        ReusableMethods.bekle(2);//anasayfa sag ust

        //click Sign in button(email giris)

        //Enter username or email address and password
        alloverPage.userNameEmailAddress.sendKeys(ConfigReader.getProperty("Email"),
                Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);


        //click Signin button(email girisini onaylaya en son buton)
        alloverPage.signInButton.click();
        ReusableMethods.bekle(2);

        //Pull down the page
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

    /*  //Hover over Automatic crusher and click on wishlist button
        List<WebElement> productWishList=alloverPage.productWishList();
        actions.moveToElement(alloverPage.automaticCrusher).perform();
        alloverPage.wishListButton.click();
        actions.moveToElement(alloverPage.chessButton).perform();
        alloverPage.wishListButton.click();
        actions.moveToElement(alloverPage.electricFryingPan).perform();
        alloverPage.wishListButton.click();
        ReusableMethods.bekle(2);
        actions.moveToElement(alloverPage.electricRiceCooker).perform();
        alloverPage.wishListButton.click();
        ReusableMethods.bekle(2);*/

        List<WebElement> wishListElements = Collections.singletonList(driver.findElement(By.id("(//button[@class='btn btn-quickview" + " btn-outline btn-default btn-rounded btn-sm mr-lg-2'])[1]")));
        int i;
        for (i = 0; i < wishListElements.size(); i++)
            wishListElements = (List<WebElement>) driver.findElement(By.id("(//button[@class='btn btn-quickview +  btn-outline btn-default btn-rounded btn-sm mr-lg-2'])[1]"));
        wishListElements.get(i).click();
        System.out.println(driver.getTitle());
        driver.navigate().back();


        //Click wishlist
        alloverPage.wishListButton.click();
        // Click on "Quick View" buttons one by one


        // go homePage
        actions.sendKeys(Keys.HOME).perform();
        //  Click wishlist(on the right side of the page)
        alloverPage.wishListButton.click();//anasayfa en ust

        //Click the Cart button(on the right side of the page)
        alloverPage.cartButton.click();

        //Click checkout button
        alloverPage.checkoutCart.click();//kasaya gitme
        ReusableMethods.bekle(2);

        //Verify that Billing Details is visible
        Assert.assertTrue(alloverPage.billingDetailsYazisi.isDisplayed());


        //Fill in the Billing Details
        alloverPage.billingFirstName.sendKeys("firstName", Keys.ARROW_RIGHT, "lastName", Keys.TAB, "company",
                Keys.TAB, "country", Keys.TAB, "House number and street name", Keys.TAB, "Town", Keys.ARROW_RIGHT, "state"
                , Keys.TAB, "Zip Code", Keys.ARROW_RIGHT, Keys.TAB, "Email Address", Keys.ENTER);

// Click( wire tranfer )button
        alloverPage.wireTransferButton.click();
//Click PLACE ORDER button
        alloverPage.placeOrderButton.click();







        /*  //Click on the search button
        AlloverCommercePage alloverCommercePage=new AlloverCommercePage();
        alloverCommercePage.searchButton.click();
        ReusableMethods.bekle(2);
        //type(print)  latest chair and chess on the search button

        alloverCommercePage.productWishList.sendKeys("latest chair");


        //Click on the entry button
        alloverCommercePage.searchButton.click();
        //Click on the wishlist button to select the items
        alloverCommercePage.wishListButton.click();
        //Verify that items are visible
        Assert.assertTrue(alloverCommercePage.wishList.isDisplayed());
        //CLİCK on the items pictures

        //Click on the selected items to view the attributes of the items
        alloverCommercePage.selectFeature.click();
        //verify that the characteristics of the items appear
      // Assert.assertTrue(alloverCommercePage.);
        //Add the items to cart
        alloverCommercePage.addToCart.click();
        //Click on the checkout button
       alloverCommercePage.checkoutCart.click();

*/

    }


    }

