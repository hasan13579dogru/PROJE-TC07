package testngTeam05.tests.us018_vendorcoupons;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.*;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

public class TC_01_VendorCoupons extends ExtentReport {
    //Vendor olarak Coupons oluşturabilmeliyim (My Account - Coupons - Add New)
    //Code yazabilmeliyim
    //Description yazılabilmeli
    //Discount Type; Percentage discount veya Fixed Product Discount olarak seçilebilmeli
    //Coupon Amount yazılabilmeli
    //Coupon expiry date girilebilmeli
    //Allow free shipping, Show on store seçilebilmeli
    //Coupons oluşturulduğu görülmeli

    AlloverCommercePage alloverpage;
    Faker faker;
    ExcelReader excelReader;
    public WebDriver driver;


    @Test
    public void test01() throws IOException {
        //Vendor olarak siteye kayit ol
        extentTest = extentReports.createTest("Extent Report", "TC_01_VendorCoupons");
        vendorOlarakKayitOl();

        //Acilan sayfadaki "not right now butonuna tiklat"
        alloverpage.WelcometoAlloverCommerce.click();
        extentTest.info("Acilan sayfadaki \"not right now butonuna tiklatildi");

        ReusableMethods.scroll(alloverpage.coupons);
        ReusableMethods.bekle(2);
        //Sol Menudeki Coupons yazisinin uzerinde fareyi beklet, cikan add butonuna tiklat.
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(alloverpage.coupons).perform();
        actions.moveToElement(alloverpage.couponsAddNew).click().perform();
        extentTest.info("Sol Menudeki Coupons yazisinin uzerinde fareyi beklet, cikan add butonuna tiklatildi");

        //Code yazabilmeliyim
        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        String kuponNo = faker.code().ean13();
        String lorem = faker.lorem().toString();
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 5, dosyaYolu, kuponNo);


        alloverpage.codeAdd.sendKeys(kuponNo, Keys.TAB, lorem, Keys.TAB);
        ReusableMethods.bekle(5);

        extentTest.pass("Code yazilabildigi dogrulandi");

        //code yazildigi dogrulandi
        Assert.assertTrue(alloverpage.codeAdd.isDisplayed());
        extentTest.pass("code yazildigi dogrulandi");

        //Description yazildigi dogrulandi
        Assert.assertEquals(lorem, alloverpage.description.getAttribute("value"));
        extentTest.pass("Description yazildigi dogrulandi");

        //Discount Type; Percentage discount veya Fixed Product secildigi dogrulandi
        Select select = new Select(alloverpage.ddmDiscountType);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Percentage discount");

        select.selectByVisibleText("Fixed Product Discount");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Fixed Product Discount");
        extentTest.pass("Discount Type; Percentage discount veya Fixed Product secildigi dogrulandi");

        //Coupon Amount gir
        alloverpage.couponAmonut.sendKeys("20", Keys.TAB);
        extentTest.info("Coupon Amount girildi");
        //Coupon expiry date gir
        LocalDate today = LocalDate.now();
        LocalDate fiveDaysLater = today.plusDays(30);
        int dayOfMonth = fiveDaysLater.getDayOfMonth();
        extentTest.info("Coupon expiry date girildi");
        WebElement eklenenGun = Driver.getDriver().findElement(xpath("//*[@data-handler='selectDay']['" + dayOfMonth + "']"));


        if (fiveDaysLater.getDayOfMonth() != today.getDayOfMonth()) {
            ReusableMethods.bekle(5);
            alloverpage.nextMonth.click();
            eklenenGun = Driver.getDriver().findElement(xpath("//*[@data-handler='selectDay']['" + dayOfMonth + "']"));
            ReusableMethods.bekle(5);
            eklenenGun.click();
        }

        //Allow free shipping, Show on store secildi
        alloverpage.freeShipping.click();
        alloverpage.showOnStore.click();
        extentTest.info("Allow free shipping, Show on store secildi");
        //Sag alt kosedeki submit butonuna tikla
        ReusableMethods.click(alloverpage.addButtonSubmit);
        ReusableMethods.bekle(3);
        extentTest.info("Sag alt kosedeki submut butonuna tiklatildi");
        //Kupon olustudugu dogrulandi
        Assert.assertTrue(alloverpage.editCoupon.isDisplayed());
        extentTest.pass("cupon olustudugu dogrulandi");
    }


    public void vendorOlarakKayitOl() throws IOException {

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String zaman = time.format(dtf);
        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 6, dosyaYolu, zaman);


        alloverpage = new AlloverCommercePage();
        faker = new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Siteye gidildi");

        //Register butonuna tikla
        alloverpage.register.click();
        extentTest.info("Register butonuna tiklandi");
        //"Signup as a vendor?" yazisina tiklat.
        extentTest.info("signup as a vendor? yazisina tiklandi");
        alloverpage.register_as_vendor.click();
        //"Vendor Registration" yazisinin gorundugunu dogrula
        String vendorRegistration = "Vendor Registration";
        String vendorRegistrationText = alloverpage.vendorRegistration.getText();
        Assert.assertTrue(vendorRegistration.equals(vendorRegistrationText));
        extentTest.pass("Vendor Registration\" yazisinin gorundugunu dogrulandi");

        //Vendor sayfasindaki e-mail'e e-mail gir
        String fakeEmail = getEmailAdress();
        extentTest.info("Vendor sayfasindaki e-mail'e e-mail girildi");
        excelReader.writeCell(1, 3, dosyaYolu, fakeEmail);

        alloverpage.vendorRegistrationEmail.sendKeys(fakeEmail, Keys.TAB);


        //Send code butonuna tiklat
        alloverpage.verificationEmailButton.click();
        extentTest.info("Send code butonuna tiklatildi");

//        alloverpage.verificationCode.sendKeys(getVerificationCode(), Keys.TAB, Keys.TAB, password,
//                Keys.TAB, password, Keys.TAB, Keys.ENTER);

        alloverpage.verificationCode.sendKeys(getVerificationCode(), Keys.TAB, Keys.TAB);
        extentTest.info("Dogrulama kodu girildi");
        //Vendor sayfasindaki sifreyi gir
        String sifre = sifreOlustur();
        excelReader.writeCell(1, 6, dosyaYolu, sifre);
        alloverpage.vendorPassword.sendKeys(sifre, Keys.TAB, sifre, Keys.TAB);
        ReusableMethods.bekle(5);
        Driver.getDriver().findElement(By.xpath("//input[@id='wcfm_membership_register_button']")).click();
        extentTest.info("sifre bolumune sifre girildi");

    }

    public String getEmailAdress() throws IOException {

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);//yeni sekmede aciyorum
        Driver.getDriver().get("https://www.fakemail.net/");

        String fakeEmailAdress = Driver.getDriver().findElement(xpath("//*[@id='email']")).getText();
        ReusableMethods.switchToWindow(0);
        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 2, dosyaYolu, fakeEmailAdress);
        return fakeEmailAdress;
    }

    public String getVerificationCode() throws IOException {
        ReusableMethods.switchToWindow(1);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        By xpath = xpath("//*[contains(text(), '[Allover Commerce]')]");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(xpath, "Email Verification"));
        Driver.getDriver().findElement(xpath("//*[@id=\"schranka\"]//tr[1]//td[1]")).click();
        WebElement iframe = Driver.getDriver().findElement(xpath("//iframe[@id='iframeMail']"));
        Driver.getDriver().switchTo().frame(iframe);

        String dogrulamaKodu = Driver.getDriver().findElement(tagName("b")).getText();
        System.out.println(dogrulamaKodu);
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.switchToWindow(0);
        ReusableMethods.bekle(1);

        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 3, dosyaYolu, dogrulamaKodu);
        return dogrulamaKodu;
    }


    public String generateStrongPassword() {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numericChars = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?/";

        String allowedChars = uppercaseChars + lowercaseChars + numericChars + specialChars;
        return RandomStringUtils.random(12, allowedChars); // Örneğin, 12 karakter uzunluğunda bir şifre oluşturuyoruz
    }


    public String sifreOlustur() {

        String password = generateStrongPassword();
        String sifre = "";

        boolean flag = true;

        while (flag) {
            ReusableMethods.scroll(alloverpage.vendorPassword);
            ReusableMethods.bekle(1);
            alloverpage.vendorPassword.sendKeys(password);
            ReusableMethods.bekle(1);
            try {
                if (alloverpage.passwordStrengthStrong.getText().equals("Strong")||alloverpage.passwordStrengthGood.isDisplayed()) {
                    sifre = password;
                    flag = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println("deneniyor...");
                //alloverpage.vendorPassword.clear();
                sifreOlustur();
                sifre = password;
                flag = false;

            } finally {
                alloverpage.vendorPassword.clear();
            }
        }
        ReusableMethods.bekle(1);

        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 1, dosyaYolu, sifre);
        return sifre;
    }






}
