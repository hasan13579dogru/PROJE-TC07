package testngTeam05.tests.us003_billingadress;

import org.testng.annotations.Test;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;

public class TC_01 {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
    }
}
