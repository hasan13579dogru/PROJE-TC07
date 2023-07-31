package testngTeam05.tests.us001_register;

<<<<<<< HEAD
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
=======
import org.openqa.selenium.interactions.Actions;
>>>>>>> master
import org.testng.annotations.Test;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;



public class TC_01_Loginİslemi {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

    }

}
