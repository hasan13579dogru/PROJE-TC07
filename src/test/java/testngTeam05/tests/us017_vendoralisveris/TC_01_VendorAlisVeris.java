package testngTeam05.tests.us017_vendoralisveris;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;

public class TC_01_VendorAlisVeris {
    //Vendor olarak alışveriş yapabilmeliyim.(My Account - Orders - Browse Product)
    //Ürün ve ürünler seçilip sepete eklenebilmeli
    //Chart - Chekout yapılarak alınacak ürün ve ürünler görülebilmeli
    //Fatura ayrıntıları (BILLING DETAILS) doldurulabilmeli
    //Toplam ödenecek rakam görüntülebilmeli
    //Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli
    //Place Order'a tıklanark alışverişin tamamlandığı görülebilmeli
    //My Account -Orders yapılan alışverişin ayrıntıları görülebilmeli

    AlloverCommercePage  alloverpage;
    Faker faker;
    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        alloverpage = new AlloverCommercePage();

        //Register butonuna tikla
        alloverpage.register.click();
        //Username, Your Email address, Password alanlarini doldur ve "I agree to the privacy policy" checkbox'ina tikla
        //SIGN UP butonuna bas
        alloverpage.reg_username.sendKeys(ConfigReader.getProperty("alloverMusteriName"),
                Keys.TAB,
                ConfigReader.getProperty("alloverVendorEmail"),
                Keys.TAB,
                ConfigReader.getProperty("alloverVendorSifre"),
                Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);

        String alreadyRegistered = alloverpage.accountAlreadyRegisteredText.getText();

        if (alreadyRegistered.equals("An account is already registered with your email address. Please log in.")){
            vendorRegister();
        }

    }

    public void vendorRegister (){
        faker = new Faker();
        String vendorMusteriName = faker.name().toString();
        String vendorEmailAdress = faker.internet().emailAddress();
        String vendorPassword = faker.internet().password();
        //Register butonuna tikla
        alloverpage.register.click();
        //Username, Your Email address, Password alanlarini doldur ve "I agree to the privacy policy" checkbox'ina tikla
        //SIGN UP butonuna bas
        alloverpage.reg_username.sendKeys(vendorMusteriName,
                Keys.TAB,
                vendorEmailAdress,
                Keys.TAB,
                vendorPassword,
                Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);
    }
}
