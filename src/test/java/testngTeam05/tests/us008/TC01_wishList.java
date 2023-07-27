package testngTeam05.tests.us008;

import org.testng.annotations.Test;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;

public class TC01_wishList {
    //Go to (https://allovercommerce.com )site
    //Click on the search button
    //type(print)  latest chair and chess on the search bar
    //Click on the entry button
    //Click on the wishlist button to select the items
    //Verify that items are visible
    //CLİCK on the items pictures
    //Click on the selected items to view the attributes of the items
    //verify that the characteristics of the items appear
    //Add the items to cart
    //Click on the checkout button

    @Test
    public void test01() {
//https://allovercommerce.com sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("allovercecommerceUrl"));

    }
}
