package testngTeam05.tests.us003_my_account_billingaddress;

import org.testng.annotations.Test;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;

public class BillingAddress {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


    }
}


