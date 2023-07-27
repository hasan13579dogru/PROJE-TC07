package testngTeam05.tests.us007;

import org.testng.annotations.Test;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;

public class TC01_comparisonItems {

    @Test
    public void test01() {

        //https://allovercommerce.com sitesine git
            Driver.getDriver().get(ConfigReader.getProperty("allovercecommerceUrl"));


    }
}
