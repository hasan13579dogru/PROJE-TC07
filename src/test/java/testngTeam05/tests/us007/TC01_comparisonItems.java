package testngTeam05.tests.us007;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.InputEvent;

public  class TC01_comparisonItems  {


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
Actions actions=new Actions(Driver.getDriver());
    private WebDriver driver;

    //go to https://allovercommerce.com site
    //Click search button
    //type pencil in the search button and select  product to compare
    //hover over the image and click the compare button
    //Click "START COMPARE!" buton
    //Click search button to add new products
    //type pencil in the search button and select  product to compare
    //hover over the image and click the compare button
    //Click "START COMPARE!" buton
   //remove all products from wishlist and screen

    @Test
    public void test01() throws AWTException {



        AlloverCommercePage alloverPage = new AlloverCommercePage();
        //https://allovercommerce.com sitesine git
            Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


       //Click search button
       alloverPage.searchButton.click();


       //type pencil in the search button and select  product to compare
        alloverPage.searchButton.sendKeys("pencil",Keys.ENTER);
        ReusableMethods.bekle(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(3);

       //  hover over the image and click the compare button
        // pencil 2
        actions.moveToElement(alloverPage.pencil2img).perform();
        alloverPage.pencil2CompBtn.click();
        ReusableMethods.bekle(3);

        //COMPARE SIYAH EKRAN KAPATMA MOUSE TEK TIKLAMA
        Robot robot = new Robot();
        robot.mouseMove(500,500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(2);



        //PENCIL 3 UZERİNE MOUSE GELMESİ
        actions.moveToElement(alloverPage.pencil3img).perform();
        alloverPage.pencil3CompButton.click();
        ReusableMethods.bekle(3);

       //Click "START COMPARE!" buton
        alloverPage.startCompare.click();
        ReusableMethods.bekle(3);

        //add the products to wishlist
        actions.moveToElement(alloverPage.wishListimgPencil2).perform();
       // alloverPage.wishListButtonPencil2.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverPage.wishListButtonPencil2);

        ReusableMethods.bekle(3);
       actions.moveToElement(alloverPage.wishListimgPencil3).perform();
      //  alloverPage.wishListButtonPencil3.click();
        ReusableMethods.bekle(3);
        ReusableMethods.click(alloverPage.pencil3CompekraniWishButton);

        //Click search button to select new products
        alloverPage.searchButton.sendKeys("ball",Keys.ENTER);
        ReusableMethods.bekle(3);




        //add new products(wishlist)
        //BALL
        //  hover over the image and click the compare button
        actions.moveToElement(alloverPage.ballimg).perform();
        ReusableMethods.bekle(2);
        alloverPage.ballCompButton.click();
        ReusableMethods.bekle(3);

        //COMPARE SIYAH EKRAN KAPATMA MOUSE TEK TIKLAMA

        robot.mouseMove(500,500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(2);
        //BASKETBALL
        actions.moveToElement(alloverPage.basketballimg).perform();
        ReusableMethods.bekle(2);
        alloverPage.basketballCompButton.click();
        ReusableMethods.bekle(3);


        //Click "START COMPARE!" buton
        alloverPage.startCompareBall.click();
        ReusableMethods.bekle(5);


     //remove all products from wishlist and screen
actions.moveToElement(alloverPage.pencil2).perform();
ReusableMethods.bekle(2);
ReusableMethods.click(alloverPage.pencil2);

    // actions.moveToElement(alloverPage.pencil3).perform();
     //ReusableMethods.bekle(3);
    // ReusableMethods.click(alloverPage.pencil3);

     actions.moveToElement(alloverPage.ball).perform();
     ReusableMethods.bekle(3);
     ReusableMethods.click(alloverPage.ball);

    // actions.moveToElement(alloverPage.basketball).perform();
    // ReusableMethods.bekle(3);
     //ReusableMethods.click(alloverPage.basketball);



         /*List<WebElement> compareButton= Collections.singletonList(driver.findElement
       (By.xpath("(//a[@class='compare btn-product-icon'])")));
        ReusableMethods.bekle(3);
        for(int i=0; i< compareButton.size();i++){
            compareButton= (List<WebElement>) driver.findElement
            (By.id("(//a[@class='compare btn-product-icon'])[1]"));
            compareButton.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();*/


      /*  //ÜRÜNLERİN FİYATLARINI YAZDIR
        WebElement fiyatListesi=driver.findElement(By.className("a-price-whole"));
        for (int i = 0; i < 50; i++) {
            i++;
            //System.out.println("fiyatListesi = " + fiyatListesi.getSize());
            System.out.println("fiyatListesi = " + fiyatListesi.getText());
        }

        WebElement[] fiyatListesi2=new WebElement[100];
        driver.findElements(By.xpath("a-price-whole"));
        for (int i = 0; i < fiyatListesi2.length; i++) {
            i++;
            //System.out.println("allDates = " + fiyatListesi2[i]);*/
        }



    }



