package testngTeam05.tests.us017_vendoralisveris;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExcelReader;
import testngTeam05.utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

public class TC_02_VenorAlisVerisNegative {
    //Vendor olarak alışveriş yapabilmeliyim.(My Account - Orders - Browse Product)
    //Ürün ve ürünler seçilip sepete eklenebilmeli
    //Chart - Chekout yapılarak alınacak ürün ve ürünler görülebilmeli
    //Fatura ayrıntıları (BILLING DETAILS) doldurulabilmeli
    //Toplam ödenecek rakam görüntülebilmeli
    //Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli
    //Place Order'a tıklanark alışverişin tamamlandığı görülebilmeli
    //My Account -Orders yapılan alışverişin ayrıntıları görülebilmeli

    AlloverCommercePage alloverpage;
    Faker faker;
    ExcelReader excelReader;
    @Test
    public void test02() throws IOException {
        //Vendor olarak alışveriş yapabilmeliyim.(My Account - Orders - Browse Product)--
        //Ürün ve ürünler seçilip sepete eklenebilmeli--
        //Chart - Chekout yapılarak alınacak ürün ve ürünler görülebilmeli--
        //Fatura ayrıntıları (BILLING DETAILS) doldurulabilmeli
        //Toplam ödenecek rakam görüntülebilmeli
        //Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli
        //Place Order'a tıklanark alışverişin tamamlandığı görülebilmeli
        //My Account -Orders yapılan alışverişin ayrıntıları görülebilmeli


        //Siteye git
       vendorOlarakKayitOl();

        //vendor olarak giris yapildi

        alloverpage.WelcometoAlloverCommerce.click();
        //Sayfa altindaki My Account'a tiklat
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverpage.myAccountOrders2);
        ReusableMethods.bekle(2);

        alloverpage.myAccountOrders.click();
        //MyAccount sayfasinda sol menude yer alan "orders" a tiklat.
        alloverpage.myAccountOrders.click();
        //Browse products'a tikla
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(alloverpage.browseProductText)).click();

        //Urun ve urunleri sepete ekle
        List<WebElement> urunListesi = alloverpage.addToChart;

        int i = 0;
        while (i < urunListesi.size()) {
            try {
                ReusableMethods.click(urunListesi.get(i));
                ReusableMethods.bekle(1);
                i++;

            } catch (NoSuchElementException | ElementClickInterceptedException e) {
                i++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        ReusableMethods.click(alloverpage.cartIcon);
        ReusableMethods.bekle(1);
        //Urunlerin sepete eklendigini dogrula
        Assert.assertTrue(alloverpage.viewCart.isDisplayed());

        //Chekout butonuna tiklat.
        alloverpage.checkoutCart.click();

        //alınacak ürün ve ürünler görülebilmeli
        List<WebElement> sepeteEklenenUrunler = alloverpage.yourOrder;

        for (WebElement each : sepeteEklenenUrunler) {
            Assert.assertTrue(each.isDisplayed());
            System.out.println(each.getText());
        }

        //Fatura ayrintilarinda zorunlu gelen alanlari bos birak
        //Siparis butonuna tiklat
        ReusableMethods.click(alloverpage.placeOrderButton);
        Assert.assertTrue(alloverpage.billingZipCode.isDisplayed());
        Assert.assertTrue(alloverpage.billingLastName.isDisplayed());
        Assert.assertTrue(alloverpage.billingStreetAdress.isDisplayed());
        Assert.assertTrue(alloverpage.billingFirstName.isDisplayed());
        Assert.assertTrue(alloverpage.billingFirstNameOrder.isDisplayed());
        Assert.assertTrue(alloverpage.billingPhone.isDisplayed());
        //Alisverisin tamamlanamadigi goruldu

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

    public String sifreOlustur() throws IOException {
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

