package testngTeam05.tests.us007;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Collections;
import java.util.List;

public class TC01_comparisonItems {


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
Actions actions=new Actions(Driver.getDriver());
    private WebDriver driver;
    //https://allovercommerce.com sitesine git
    //Click search button
    //type pencil in the search button and click
    //hover over the image and click the compare button
    //remove all selected products
    //add new products(wishlist)
    //delete compared products
    @Test
    public void test01() throws AWTException, InterruptedException {
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

        //pencil 2
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
        ReusableMethods.bekle(5);

        //add the products to wishlist
        actions.moveToElement(alloverPage.wishListimgPencil2).perform();
       // alloverPage.wishListButtonPencil2.click();
        ReusableMethods.click(alloverPage.wishListButtonPencil2);

        ReusableMethods.bekle(5);
       actions.moveToElement(alloverPage.wishListimgPencil3).perform();
      //  alloverPage.wishListButtonPencil3.click();
        ReusableMethods.click(alloverPage.wishListButtonPencil3);

        //Click search button to select new products
        alloverPage.searchButton.sendKeys("ball",Keys.ENTER);
        ReusableMethods.bekle(3);

        //  hover over the image and click the compare button

        //BALL
        actions.moveToElement(alloverPage.ballimg).perform();
        ReusableMethods.bekle(2);
        alloverPage.ballCompButton.click();
        ReusableMethods.bekle(3);

       //BASKETBALL
        actions.moveToElement(alloverPage.basketballimg).perform();
        ReusableMethods.bekle(2);
        alloverPage.basketballCompButton.click();
        ReusableMethods.bekle(3);


        //type pencil in the search button and click
        //hover over the image and click the compare button
        //remove all selected products



      //remove the selected products
      //  birinci urunu sıl ve 2. urunu sil

        //add new products(wishlist)

        //delete compared products


        //  hover over the image and click the compare button

        /*actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        //ITEM 1
        actions.moveToElement(alloverPage.pencil_locat).perform();
        alloverPage.pencil2CompareBtn.click();
        actions.sendKeys(Keys.ESCAPE);
        ReusableMethods.bekle(2);

        //ITEM 2
        actions.moveToElement(alloverPage.pencil6_locat).perform();
        alloverPage.pencil3CompareBtn.click();
        actions.sendKeys(Keys.ESCAPE);
        ReusableMethods.bekle(2);*/





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



