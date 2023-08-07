package testngTeam05.tests.us005_accountdetails;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ExtentReport;
import testngTeam05.utilities.ReusableMethods;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TC01_AccountDetailsGoruntuleme extends ExtentReport {
    //Yeni sifre olusturmak icin -->Faker classtan sifre olusturdugumda karakter sayısı ve buyuk kucuk harf
    //sartlarını sağlamadığı ıcın bu sekilde bir yontem kullandım.
    Faker faker=new Faker();
    String rastgeleKelime = faker.lorem().word();
    String rastgeleSayi = faker.number().digits(8);
    String sifre = rastgeleKelime + rastgeleSayi;

    @Test
    public void test01() throws IOException {

        extentTest=extentReports.createTest("Extent Report","Test Raporu");


        //Kullanıcı https://allovercommerce.com sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("allovercommerce sitesine gidildi");


        //signin butonuna tıklar
        AlloverCommercePage alloverCommercePage= new AlloverCommercePage();
        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);
        extentTest.info("Anasayfadaki signin butonuna tıklandı");


        //dataları excel tablosundan alacağız
        String dosyaYolu ="src/test/java/testngTeam05/musteriBilgileri.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(2).toString());
        ReusableMethods.bekle(1);
        alloverCommercePage.ilkSayfapassword.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString());
        extentTest.info("Kullanıcı adı ve şifre alanlarına kayıtlı username ve password girildi");

       //signin butonuna tıkla

        alloverCommercePage.signInButton.click();



        extentTest.info("Sayfaya giriş için signin e tıklandı");
        ReusableMethods.bekle(2);

        //sayfaya girdiğini doğrula
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());
        ReusableMethods.webElementResmi(alloverCommercePage.welcomeToAlloverCommerceYazısı);
        extentTest.pass("Sayfaya giriş yapıldığı doğrulandı");

        //My Account sayfasına git ve gittiğini doğrula(Signout tıkladığımızda my account sayfası geliyor)
        alloverCommercePage.signOut.click();


        Assert.assertTrue(alloverCommercePage.myAccount.isDisplayed());
        extentTest.info("My Account gorunur oldugu dogrulandı");
        ReusableMethods.bekle(2);


        //My Account sayfasının açıldığını sayfa title ile doğrula
        String expectedTitle="My Account - Allover Commerce";
        String actualTitle=Driver.getDriver().getTitle().toString();
        System.out.println(actualTitle);
       Assert.assertEquals(actualTitle,expectedTitle);
        ReusableMethods.webElementResmi(alloverCommercePage.welcomeToAlloverCommerceYazısı);
       extentTest.pass("My Account sayfasının açıldığı doğrulandı");

       //Account details menüsüne tıkla
            ReusableMethods.click(alloverCommercePage.accountDetailsMenu);
        extentTest.info("Account details'e tıklandı");

        //Account details görünür oldugunu doğrula
        Assert.assertTrue(alloverCommercePage.accountDetailsSayfaYazısı.isDisplayed());
        ReusableMethods.tumSayfaResmi("AccountDetailsGorunurlugu");
        extentTest.pass("Account details'in görünür oldugu doğrulandı");

        //action class ile sayfayı az aşağı indirip take screenshot al!!!!!!!!!!1
        //Kullanıcı hesap detaylarını görebilmeli

        ReusableMethods.bekle(2);

        //name,lastname,email,displayedname alanlarındaki bilgileri yeni bilgiler ile değiştir
        //Bilgiler fakerClass ile girildi
        faker=new Faker();
        String newName=faker.name().firstName();
        System.out.println("newName = " + newName);
        String newLastName=faker.name().lastName();
        System.out.println("newLastName = " + newLastName);
        String newDisplayedName= faker.name().username();
        System.out.println("newDisplayedName = " + newDisplayedName);

        //Veri girilecek alanlar önce silindi sonra veri gönderildi
        alloverCommercePage.accountFirstName.clear();
        alloverCommercePage.accountLastName.clear();
        //email alanını değiştirmedim aynısını yazdırdım!!!!!!!!!!!!!!!!!
        alloverCommercePage.accountFirstName.sendKeys(newName,Keys.TAB,newLastName,
                Keys.TAB,newDisplayedName,Keys.TAB,workbook.getSheet("Sayfa1").getRow(1).getCell(2).toString());
        ReusableMethods.tumSayfaResmi("KullaniciBilgileri");
        extentTest.info("firstname,lastname,displayedname,email alanlarına değiştirilmek istenilen bilgiler girildi");

        //Biography alanına text gir(iframe içinde oldugu için geçiş yapmak gerekiyor
        Driver.getDriver().switchTo().frame(0);
        alloverCommercePage.biography.clear();
        alloverCommercePage.biography.sendKeys(ConfigReader.getProperty("biography"));
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Biography alanına text girildi");

        ReusableMethods.bekle(2);

        //Change password alanındaki mevcut şifre, yeni şifre ve yeni şifrenin doğrulaması alanlarını doldur
        alloverCommercePage.currentPassword.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString());
        alloverCommercePage.newPassword.sendKeys(sifre,Keys.TAB,sifre);


        //yeni sifre ve kullanici ismi bilgilerini mevcut excele yazdım
        workbook.getSheet("Sayfa1").getRow(1).createCell(1).setCellValue(sifre);
        workbook.getSheet("Sayfa1").getRow(1).createCell(0).setCellValue(newDisplayedName);
        //workbook.getSheet("Sayfa1").getRow(1).createCell(2).setCellValue(newEmail);

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fos.close();
        workbook.close();



        System.out.println("sifre = " + sifre);
        extentTest.info("Change password alanındaki mevcut şifre, yeni şifre ve yeni şifrenin doğrulaması alanları dolduruldu");

        ReusableMethods.bekle(2);

        //save changes butonuna tıkla
        ReusableMethods.click(alloverCommercePage.saveChangesButton);

        ReusableMethods.bekle(3);
        extentTest.info("Save butonuna tıklandı");

        //"Account details changed successfully" mesajının görünür oldugunu doğrula
        //screenshot ekle

        //siteden signout ardından logout tıkla
        ReusableMethods.scrollHome();
        ReusableMethods.click(alloverCommercePage.signOut);

        ReusableMethods.bekle(3);
        alloverCommercePage.logOut.click();
        ReusableMethods.bekle(2);

        //değişmiş sifre ile siteye giriş yap
        alloverCommercePage.userNameEmailAddress.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(2).toString());
        ReusableMethods.bekle(1);
        alloverCommercePage.ilkSayfapassword.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString());
        ReusableMethods.bekle(1);
        ReusableMethods.click(alloverCommercePage.signInButton);


        ReusableMethods.bekle(10);



    }
}
