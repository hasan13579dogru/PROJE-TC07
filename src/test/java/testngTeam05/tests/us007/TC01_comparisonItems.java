package testngTeam05.tests.us007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.util.Collections;
import java.util.List;

public class TC01_comparisonItems {
Actions actions=new Actions(Driver.getDriver());
    private WebDriver driver;
    //https://allovercommerce.com sitesine git
    //Click search button
    //type pencil in the search button and click
    //  hover over the image and click the compare button
    //remove all selected products
    //add new products(wishlist)
    //delete compared products
    @Test
    public void test01() {
        AlloverCommercePage alloverPage = new AlloverCommercePage();
        //https://allovercommerce.com sitesine git
            Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
       //Click search button
       alloverPage.searchButton.click();
       //type pencil in the search button and select four products to compare

        //alloverPage.productName.sendKeys(ConfigReader.getProperty("pencil"));
        alloverPage.searchButton.sendKeys("pencil",Keys.ENTER);

        ReusableMethods.bekle(3);

       //  hover over the image and click the compare button


        List<WebElement> compareButton= Collections.singletonList(driver.findElement
       (By.id("(//a[@class='compare btn-product-icon'])[1]")));
        ReusableMethods.bekle(3);
        for(int i=0; i< compareButton.size();i++){
            compareButton= (List<WebElement>) driver.findElement
            (By.id("(//a[@class='compare btn-product-icon'])[1]"));
            compareButton.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }



    }
}
