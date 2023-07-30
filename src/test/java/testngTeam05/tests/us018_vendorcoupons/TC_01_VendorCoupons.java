package testngTeam05.tests.us018_vendorcoupons;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExcelReader;
import testngTeam05.utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;


public class TC_01_VendorCoupons {
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
    public  WebDriver driver;
    Actions actions;


    @Test
    public void test01() {
        //Vendor olarak siteye kayit ol

        vendorOlarakKayitOl();

        //Acilan sayfadaki "not right now butonuna tiklat"
        alloverpage.WelcometoAlloverCommerce.click();
        ReusableMethods.scroll(alloverpage.coupons);
        ReusableMethods.bekle(2);
        //Sol Menudeki Coupons yazisinin uzerinde fareyi beklet, cikan add butonuna tiklat.
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(alloverpage.coupons).perform();
        actions.moveToElement(alloverpage.couponsAddNew).click().perform();

        //Code yazabilmeliyim
        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        String kuponNo = faker.code().ean13();
        String lorem = faker.lorem().toString();
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 5, dosyaYolu, kuponNo);
        //Description yaz
        alloverpage.codeAdd.sendKeys(kuponNo,Keys.TAB,lorem,Keys.TAB);
        //Discount Type; Percentage discount veya Fixed Product secildigi dogrulandi
        Select select =new Select(alloverpage.ddmDiscountType);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Percentage discount");

        select.selectByVisibleText("Fixed Product Discount");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Fixed Product Discount");

        //Coupon Amount gir
        alloverpage.couponAmonut.sendKeys("20",Keys.TAB);

        //Coupon expiry date gir
        LocalDate today = LocalDate.now();
        LocalDate fiveDaysLater = today.plusDays(5);
        int dayOfMonth = fiveDaysLater.getDayOfMonth();

        WebElement eklenenGun = Driver.getDriver().findElement(xpath("//*[@data-handler='selectDay']['" + dayOfMonth + "']"));


        if (fiveDaysLater.getDayOfMonth()!=today.getDayOfMonth()){
            alloverpage.nextMonth.click();
            eklenenGun = Driver.getDriver().findElement(xpath("//*[@data-handler='selectDay']['" + dayOfMonth + "']"));
            eklenenGun.click();
        }

        //Allow free shipping, Show on store secildi
        alloverpage.freeShipping.click();
        alloverpage.showOnStore.click();

        //Sag alt kosedeki submut butonuna tikla
        ReusableMethods.click(alloverpage.addButtonSubmit);
        //Kupon olustudugu dogrulandi
        Assert.assertTrue(alloverpage.editCoupon.isDisplayed());

    }


    public void vendorOlarakKayitOl() {

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


        //Register butonuna tikla
        alloverpage.register.click();

        //"Signup as a vendor?" yazisina tiklat.
        alloverpage.register_as_vendor.click();
        //"Vendor Registration" yazisinin gorundugunu dogrula
        String vendorRegistration = "Vendor Registration";
        String vendorRegistrationText = alloverpage.vendorRegistration.getText();
        Assert.assertTrue(vendorRegistration.equals(vendorRegistrationText));


        //Vendor sayfasindaki e-mail'e e-mail gir
        String fakeEmail = getEmailAdress();

        excelReader.writeCell(1, 3, dosyaYolu, fakeEmail);

        alloverpage.vendorRegistrationEmail.sendKeys(fakeEmail, Keys.TAB);


        //Send code butonuna tiklat
        alloverpage.verificationEmailButton.click();


//        alloverpage.verificationCode.sendKeys(getVerificationCode(), Keys.TAB, Keys.TAB, password,
//                Keys.TAB, password, Keys.TAB, Keys.ENTER);

        alloverpage.verificationCode.sendKeys(getVerificationCode(), Keys.TAB, Keys.TAB);

        //Vendor sayfasindaki sifreyi gir
        String sifre = sifreOlustur();
        excelReader.writeCell(1, 6, dosyaYolu, sifre);
        alloverpage.vendorPassword.sendKeys(sifre, Keys.TAB, sifre, Keys.TAB, Keys.ENTER);


    }

    public String getEmailAdress() {

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

    public String getVerificationCode() {
        ReusableMethods.switchToWindow(1);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        By xpath = xpath("//*[contains(text(), '[Allover Commerce]')]");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(xpath, "Email Verification"));
        Driver.getDriver().findElement(xpath("//*[@id=\"schranka\"]//tr[1]//td[1]")).click();
        WebElement iframe = Driver.getDriver().findElement(xpath("//iframe[@id='iframeMail']"));
        Driver.getDriver().switchTo().frame(iframe);

        String code = Driver.getDriver().findElement(tagName("b")).getText();
        System.out.println(code);
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.switchToWindow(0);
        ReusableMethods.bekle(1);

        String dosyaYolu = "src/test/java/testngTeam05/vendorMusteriBilgileri.xlsx";
        String sayfaIsmi = "Sayfa1";
        excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        excelReader.writeCell(1, 3, dosyaYolu, code);
        return code;
    }


    public String sifreOlustur() {
        String sifre = "";
        boolean flag = true;
        while (flag) {
            String rastgeleKelime = faker.lorem().word();
            String rastgeleSayi = faker.number().digits(4);
            String password = rastgeleKelime + rastgeleSayi;
            ReusableMethods.scroll(alloverpage.vendorPassword);
            ReusableMethods.bekle(1);
            alloverpage.vendorPassword.sendKeys(password);
            ReusableMethods.bekle(2);
            try {
                if (alloverpage.passwordStrengthGood.isDisplayed()) {
                    sifre = password;
                    flag = false;
                    alloverpage.vendorPassword.clear();
                } else {
                    alloverpage.vendorPassword.clear();
                }
            } catch (NoSuchElementException e) {
                System.out.println("deneniyor...");
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
