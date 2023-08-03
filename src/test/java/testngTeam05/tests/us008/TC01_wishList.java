package testngTeam05.tests.us008;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.Zip;
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
    // Click on "Quick View" buttons one by one And add to cart
    // go homePage
    //  Click wishlist(on the right side of the page)
    //Click checkout button
    //Verify that Billing Details is visible
    //Fill in the Billing Details
    // Click( pay at the door )button
    //Click PLACE ORDER button

    private WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());
//DropDown VisibleText

        Select select ;

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
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //ReusableMethods.bekle(2);

        //aramabutonuna automatic crusher,chess,Electric Rice Cooker,Electric Frying pan yazdır ve wishlist butonuna bas
        alloverPage.searchButton.sendKeys("Automatic crusher",Keys.ENTER);
        //ReusableMethods.bekle(2);
        alloverPage.AutomaticcrusherWishbtn.click();
        ReusableMethods.bekle(2);

         alloverPage.searchButton.sendKeys("Electric Rice Cooker",Keys.ENTER);
        alloverPage.electricRiceCookerwishbtn.click();
        ReusableMethods.bekle(2);

        /*alloverPage.searchButton.sendKeys("chess",Keys.ENTER);
        alloverPage.chessWishButton.click();
        ReusableMethods.bekle(2);*/



//verify the visibility of added items
//Assert.assertTrue(alloverPage.addedItems.isDisplayed());

   //Click "Quick View" and close

        //actions.moveToElement(alloverPage.quickViewButton).click();
        //ReusableMethods.bekle(2);
       //alloverPage.electricRiceCookerButton.click();

        //
        alloverPage.wishListButton.click();
        ReusableMethods.bekle(2);

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.click(alloverPage.quickViewButton1);
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ESCAPE).perform();
        //alloverPage.quickViewKapatma.click();
       ReusableMethods.bekle(2);

       //
       //alloverPage.wishListButton.click();
        //ReusableMethods.bekle(2);
       // actions.sendKeys(Keys.PAGE_DOWN).perform();


        ReusableMethods.click(alloverPage.quickViewButton2);
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.bekle(2);


       //alloverPage.quickViewKapatma.click();


       //Add the items to Cart(Electric Rice Cooker,Atomatic Crusher,Chess)
       alloverPage.addToCartButton1.click();
       ReusableMethods.bekle(2);

        //alloverPage.addToCartButton2.click();
        //ReusableMethods.bekle(2);

        //Click wishlist

        // go homePage
        //actions.sendKeys(Keys.HOME).perform();
        //  Click wishlist(on the right side of the page)
        //alloverPage.wishListButton.click();//anasayfa en ust
        //ReusableMethods.bekle(2);

        //Click the Cart button(on the right side of the page)
        alloverPage.cartButton.click();
        ReusableMethods.bekle(2);

        //Click checkout button
        alloverPage.checkoutCart.click();//kasaya gitme
        ReusableMethods.bekle(3);

        //Verify that Billing Details is visible
        Assert.assertTrue(alloverPage.billingDetailsYazisi.isDisplayed());

         ReusableMethods.bekle(2);
        //Fill in the Billing Details Radio Buton

        alloverPage.billingFirstName.sendKeys(Keys.CONTROL + "a", Keys.CLEAR, Keys.CONTROL,
                ConfigReader.getProperty("userUserName"),
                Keys.TAB, ConfigReader.getProperty("userUserlastName"),
                Keys.TAB,
                Keys.TAB, ConfigReader.getProperty("userCountry"),
                Keys.TAB, ConfigReader.getProperty("userStreetAdress"),
                Keys.TAB, Keys.TAB, ConfigReader.getProperty("userZipCode"),
                Keys.TAB, ConfigReader.getProperty("userCity"),
                Keys.TAB, ConfigReader.getProperty("userProvince"),
                Keys.TAB, ConfigReader.getProperty("userPhone"));
        ReusableMethods.bekle(3);

      /* alloverPage.billingFirstName.sendKeys("firstName",
           Keys.TAB,"last name",
        Keys.TAB,"company");
       ReusableMethods.bekle(2);
       actions.sendKeys(Keys.PAGE_DOWN).perform();





      alloverPage.houseNumberAndStreetName.click();


       alloverPage.houseNumberAndStreetName.sendKeys("house number");
       alloverPage.town.click();
    alloverPage.town.sendKeys("Costa");

        alloverPage.stateNameFlores.click();
       /* Keys.TAB, "Zip Code",
                Keys.TAB,"Phone",
       Keys.TAB,"Email address",Keys.ENTER);*/

       ReusableMethods.bekle(2);




        /*  public static void alertprompt(String text) {
            Driver.getDriver().switchTo().alert().sendKeys(text);
        }

        //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7")*/

       // Click( wire tranfer )button
        alloverPage.wireTransferButton.click();
       //Click PLACE ORDER button
        alloverPage.placeOrderButton.click();
        //Assert.assertTrue(alloverPage.placeOrderButton.isDisplayed());


        /*
        DROPBOX VERI GIRIS
        WebElement dropDownElement=driver.findElement(By.id("dropdown"));
        Select selectObj= new Select(dropDownElement);

        // select 3rd item at index 2,
        selectObj.selectByIndex(2);

        //select item with value attribute 1
        selectObj.selectByValue("1");

        //select by visible text
        selectObj.selectByVisibleText("Option 2");*/









    }


    }

 /*  AYHAN
        WebElement titleRadiButton= driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadiButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1990     ")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("bulut")
                .sendKeys(Keys.TAB)
                .sendKeys("kendim")
                .sendKeys(Keys.TAB)
                .sendKeys("ulu cadde no 95")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Teksas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("05100")
                .sendKeys(Keys.TAB)
                .sendKeys("5551254568")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();*/
