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
import testngTeam05.utilities.*;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TC01_AccountDetailsGoruntuleme extends ExtentReport {
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
        String sayfaIsmi ="Sayfa1";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);
        System.out.println(reader.getCellData(1, 0));


        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(reader.getCellData(1,2));
        ReusableMethods.bekle(1);
         alloverCommercePage.ilkSayfapassword.sendKeys(reader.getCellData(1,1));
        extentTest.info("Kullanıcı adı ve şifre alanlarına kayıtlı username ve password girildi");
        ReusableMethods.bekle(2);

        //signin butonuna tıkla

        alloverCommercePage.signIn.click();


      
        alloverCommercePage.signInButton.click();




        extentTest.info("Sayfaya giriş için signin e tıklandı");
        ReusableMethods.bekle(2);

        //sayfaya girdiğini doğrula
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());
        extentTest.pass("Sayfaya giriş yapıldığı doğrulandı");

        //My Account sayfasına git ve gittiğini doğrula(Signout tıkladığımızda my account sayfası geliyor)
        alloverCommercePage.signOut.click();


        Assert.assertTrue(alloverCommercePage.myAccount.isDisplayed());
        extentTest.info("My Account gorunur oldugu dogrulandı");
        ReusableMethods.bekle(2);


        //My Account sayfasının açıldığını sayfa title ile doğrula
        String expectedTitle="My Account - Allover Commerce";
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(actualTitle);
       Assert.assertEquals(actualTitle,expectedTitle);
       extentTest.pass("My Account sayfasının açıldığı doğrulandı");

       //Account details menüsüne tıkla
            ReusableMethods.click(alloverCommercePage.accountDetailsMenu);
        extentTest.info("Account details'e tıklandı");

        //Account details görünür oldugunu doğrula
        Assert.assertTrue(alloverCommercePage.accountDetailsSayfaYazısı.isDisplayed());
        extentTest.pass("Account details'in görünür oldugu doğrulandı");


        //Kullanıcı hesap detaylarını görebilmeli

        ReusableMethods.bekle(2);

        //name,lastname,email,displayedname alanlarındaki bilgileri yeni bilgiler ile değiştir
        faker=new Faker();
        String newName=faker.name().firstName();
        System.out.println("newName = " + newName);
        String newLastName=faker.name().lastName();
        System.out.println("newLastName = " + newLastName);
        String newDisplayedName= faker.name().username();
        System.out.println("newDisplayedName = " + newDisplayedName);

        //Mevcut bilgileri temizleyip yeni bilgiler gönder
        alloverCommercePage.accountFirstName.clear();
        alloverCommercePage.accountLastName.clear();

        //email değişmemeli!!!!!!!!!!!!!!!!!
        alloverCommercePage.accountFirstName.sendKeys(newName,Keys.TAB,newLastName,
                Keys.TAB,newDisplayedName,Keys.TAB,reader.getCellData(1,2));
        extentTest.info("firstname,lastname,displayedname,email alanlarına değiştirilmek istenilen bilgiler girildi");

        //Biography alanına text gir
        Driver.getDriver().switchTo().frame(0);
        alloverCommercePage.biography.clear();
        alloverCommercePage.biography.sendKeys(ConfigReader.getProperty("biography"));
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Biography alanına text girildi");

        ReusableMethods.bekle(2);

        //Change password alanındaki mevcut şifre, yeni şifre ve yeni şifrenin doğrulaması alanlarını doldur
        alloverCommercePage.currentPassword.sendKeys(reader.getCellData(1,1));
        alloverCommercePage.newPassword.sendKeys(sifre,Keys.TAB,sifre);

        System.out.println(sifre);
        //yeni sifre ve kullanici ismi bilgilerini mevcut excele yazdım
        reader.writeCell(1,1,dosyaYolu,sifre);
        reader.writeCell(1,0,dosyaYolu,newDisplayedName);

        extentTest.info("Change password alanındaki mevcut şifre, yeni şifre ve yeni şifrenin doğrulaması alanları dolduruldu");

        ReusableMethods.bekle(2);

        //save changes butonuna tıkla
        ReusableMethods.click(alloverCommercePage.saveChangesButton);

        ReusableMethods.bekle(3);
        extentTest.info("Save butonuna tıklandı");

        //"Account details changed successfully" mesajının görünür oldugunu doğrula
        Assert.assertTrue(alloverCommercePage.accountDetailsChangedMessage.isDisplayed());
        //screenshot ekle

        //siteden signout ardından logout tıkla
        ReusableMethods.scrollHome();
        ReusableMethods.click(alloverCommercePage.signOut);

        ReusableMethods.bekle(3);
        alloverCommercePage.logOut.click();
        ReusableMethods.bekle(2);

    }

}
