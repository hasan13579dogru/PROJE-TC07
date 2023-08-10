package testngTeam05.tests.us007;

import testngTeam05.utilities.ExtentReport;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.InputEvent;



public  class TC01_comparisonItems extends ExtentReport {


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

        extentTest = extentReports.createTest("Extent Report", "Test Raporu");

        AlloverCommercePage alloverPage = new AlloverCommercePage();
        //https://allovercommerce.com sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("alloverCommerce sitesine gidildi");

        //Click search button
        alloverPage.searchButton.click();
        extentTest.info("search butonuna tıklandı");

        //type pencil in the search button and select  product to compare
        alloverPage.searchButton.sendKeys("pencil", Keys.ENTER);
        ReusableMethods.bekle(3);
        extentTest.info("search butonunda kalem aratıldı ve karsılastırmak icin urun secildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(3);

        //  hover over the image and click the compare button
        // pencil 2
        actions.moveToElement(alloverPage.pencil2img).perform();
        alloverPage.pencil2CompBtn.click();
        ReusableMethods.bekle(3);
        extentTest.info("karsılastırılacak urune tıklatıldı");
        //COMPARE SIYAH EKRAN KAPATMA MOUSE TEK TIKLAMA
        Robot robot = new Robot();
        robot.mouseMove(500, 500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(2);
        extentTest.info("Robot class kullanıldı(siyah ekranı gecmek icin)");


        //PENCIL 3 UZERİNE MOUSE GELMESİ
        actions.moveToElement(alloverPage.pencil3img).perform();
        alloverPage.pencil3CompButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("karsılastırma yapmak icin 2. urune tıklatıldı ");
        //Click "START COMPARE!" buton
        alloverPage.startCompare.click();
        ReusableMethods.bekle(3);
        extentTest.info("karsılastırma butonuna basıldı");
        //add the products to wishlist
        actions.moveToElement(alloverPage.wishListimgPencil2).perform();
        // alloverPage.wishListButtonPencil2.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverPage.wishListButtonPencil2);
        extentTest.info("secilen urun wishlist eklendi");


        ReusableMethods.bekle(3);
        actions.moveToElement(alloverPage.wishListimgPencil3).perform();
        //  alloverPage.wishListButtonPencil3.click();
        ReusableMethods.bekle(3);
        ReusableMethods.click(alloverPage.pencil3CompekraniWishButton);
        extentTest.info("2.urun wishlist e eklendi");
        //Click search button to select new products
        alloverPage.searchButton.sendKeys("ball", Keys.ENTER);
        ReusableMethods.bekle(3);
        extentTest.info("arama butonuna top yazdırıldı");

        //add new products(wishlist)
        //BALL
        //  hover over the image and click the compare button
        actions.moveToElement(alloverPage.ballimg).perform();
        ReusableMethods.bekle(2);
        alloverPage.ballCompButton.click();
        ReusableMethods.bekle(3);
       extentTest.info("karsilastıma icin 1. urun secildi");
        //COMPARE SIYAH EKRAN KAPATMA MOUSE TEK TIKLAMA

        robot.mouseMove(500, 500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.bekle(2);
        extentTest.info("Robot class kullanıldı(siyah ekranı gecmek icin)");
        //BASKETBALL
        actions.moveToElement(alloverPage.basketballimg).perform();
        ReusableMethods.bekle(2);
        alloverPage.basketballCompButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("karsılastırma icin 2.urun secildi");

        //Click "START COMPARE!" buton
        alloverPage.startCompareBall.click();
        ReusableMethods.bekle(5);
       extentTest.info("karsılastırma butonuna basildı");

        //remove all products from wishlist and screen
        actions.moveToElement(alloverPage.pencil2).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverPage.pencil2);
        extentTest.info("urunun ustune gelindi ve kapatıldı");
        // actions.moveToElement(alloverPage.pencil3).perform();
        //ReusableMethods.bekle(3);
        // ReusableMethods.click(alloverPage.pencil3);

        actions.moveToElement(alloverPage.ball).perform();
        ReusableMethods.bekle(3);
        ReusableMethods.click(alloverPage.ball);
        extentTest.info("urunun ustune gelindi ve kapatıldı");

         actions.moveToElement(alloverPage.basketball).perform();
        ReusableMethods.bekle(3);
        ReusableMethods.click(alloverPage.basketball);
        extentTest.info("urunun ustune gelindi ve kapatıldı");

    }

    }



