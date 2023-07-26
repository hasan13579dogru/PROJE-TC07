package testngTeam05.tests.us005_accountdetails;

import com.github.javafaker.Faker;
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

public class TC01_AccountDetailsGoruntuleme extends ExtentReport {
    Faker faker=new Faker();
    String rastgeleKelime = faker.lorem().word();
    String rastgeleSayi = faker.number().digits(4);

    String sifre = rastgeleKelime + rastgeleSayi;



    @Test
    public void test01() {


        extentTest=extentReports.createTest("Extent Report","Test Raporu");

        //Kullanıcı https://allovercommerce.com sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("allovercommerce sitesine gidildi");

        //signin butonuna tıklar
        AlloverCommercePage alloverCommercePage= new AlloverCommercePage();
        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);
        extentTest.info("Anasayfadaki signin butonuna tıklandı");

        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(ConfigReader.getProperty("alloverMusteriName"),
                Keys.TAB,ConfigReader.getProperty("alloverMusteriSifre"));
        extentTest.info("Kullanıcı adı ve şifre alanlarına kayıtlı username ve password girildi");

       //signin butonuna tıkla
        alloverCommercePage.signIn.click();
        extentTest.info("Sayfaya giriş için signin e tıklandı");
        ReusableMethods.bekle(2);

        //sayfaya girdiğini doğrula
        Assert.assertTrue(alloverCommercePage.signOut.isDisplayed());
        extentTest.pass("Sayfaya giriş yapıldığı doğrulandı");

        //My Account elementinin gorunur oldugunu doğrula


        Assert.assertTrue(alloverCommercePage.myAccount.isDisplayed());
        extentTest.info("My Account gorunur oldugu dogrulandı");
        ReusableMethods.bekle(2);
        //My account Linkine tıkla
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
      alloverCommercePage.myAccount.click();
        extentTest.info("My Account'a tıklandı");

        ReusableMethods.bekle(4);

        //My Account sayfasının açıldığını sayfa title ile doğrula
        String expectedTitle="My Account - Allover Commerce";
        String actualTitle=Driver.getDriver().getTitle().toString();
        System.out.println(actualTitle);
       Assert.assertEquals(actualTitle,expectedTitle);
       extentTest.pass("My Account sayfasının açıldığı doğrulandı");

       //Account details menüsüne tıkla
        ReusableMethods.click(alloverCommercePage.accountDetailsMenu);
        extentTest.info("Account details'e tıklandı");

        //Account details görünür oldugunu doğrula
        Assert.assertTrue(alloverCommercePage.accountDetailsSayfaYazısı.getText().equals("Account details"));
        extentTest.pass("Account details'in görünür oldugu doğrulandı");

        ReusableMethods.bekle(2);

        //name,lastname,email,displayedname alanlarına yeni bilgiler gir
        faker=new Faker();
        String newName=faker.name().firstName();
        System.out.println("newName = " + newName);
        String newLastName=faker.name().lastName();
        System.out.println("newLastName = " + newLastName);
        String newDisplayedName= faker.name().username();
        System.out.println("newDisplayedName = " + newDisplayedName);
        String newEmail=faker.internet().emailAddress();
        System.out.println("newEmail = " + newEmail);

        alloverCommercePage.accountFirstName.clear();
        alloverCommercePage.accountLastName.clear();

        alloverCommercePage.accountFirstName.sendKeys(newName,Keys.TAB,newLastName,
                Keys.TAB,newDisplayedName,Keys.TAB,newEmail);
        extentTest.info("firstname,lastname,displayedname,email alanlarına değiştirilmek istenilen bilgiler girildi");

        //Biography alanına text gir(iframe içinde oldugu için geçiş yapmak gerekiyor
        Driver.getDriver().switchTo().frame("user_description_ifr");
        alloverCommercePage.biography.clear();
        alloverCommercePage.biography.sendKeys(ConfigReader.getProperty("biography"));
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Biography alanına text girildi");

        ReusableMethods.bekle(2);

        //Change password alanındaki mevcut şifre, yeni şifre ve yeni şifrenin doğrulaması alanlarını doldur
        alloverCommercePage.currentPassword.sendKeys(ConfigReader.getProperty("alloverMusteriSifre"));
        alloverCommercePage.newPassword.sendKeys(sifre,Keys.TAB,sifre);
        System.out.println("sifre = " + sifre);
        extentTest.info("Change password alanındaki mevcut şifre, yeni şifre ve yeni şifrenin doğrulaması alanları dolduruldu");

        //save changes butonuna tıkla
       // alloverCommercePage.saveChangesButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Save butonuna tıklandı");

        //"Account details changed successfully" mesajının görünür oldugunu doğrula



    }

}
