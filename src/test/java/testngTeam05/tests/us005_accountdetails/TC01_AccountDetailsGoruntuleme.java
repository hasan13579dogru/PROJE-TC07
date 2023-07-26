package testngTeam05.tests.us005_accountdetails;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import javax.swing.*;

public class TC01_AccountDetailsGoruntuleme {
    Faker faker=new Faker();
    String rastgeleKelime = faker.lorem().word();
    String rastgeleSayi = faker.number().digits(4);

    String sifre = rastgeleKelime + rastgeleSayi;



    @Test
    public void test01() {

        //Kullanıcı https://allovercommerce.com sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //signin butonuna tıklar
        AlloverCommercePage alloverCommercePage= new AlloverCommercePage();
        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);

        //kullanıcıadı ve sifre alanlarına mevcut isim ve sifre bilgilerini girer
        alloverCommercePage.userNameEmailAddress.sendKeys(ConfigReader.getProperty("alloverMusteriName"),
                Keys.TAB,ConfigReader.getProperty("alloverMusteriSifre"));

        //sayfaya girdiğini doğrula signout locate edip yapılabilir

        alloverCommercePage.signIn.click();
        ReusableMethods.bekle(2);

        //My Account elementinin gorunur oldugunu doğrula
        ReusableMethods.scrollEnd();
        Assert.assertTrue(alloverCommercePage.myAccount.isDisplayed());

        //my account Linkine tıkla

        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

       alloverCommercePage.myAccount.click();

        ReusableMethods.bekle(4);

        //My Account sayfasının açıldığını sayfa title ile doğrula
        String expectedTitle="My Account - Allover Commerce";
        String actualTitle=Driver.getDriver().getTitle().toString();
        System.out.println(actualTitle);
       Assert.assertEquals(actualTitle,expectedTitle);

              //Account details menüsüne tıkla
        ReusableMethods.click(alloverCommercePage.accountDetailsMenu);

        //Account details görünür oldugunu doğrula
        Assert.assertTrue(alloverCommercePage.accountDetailsSayfaYazısı.getText().equals("Account details"));

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

        //Biography alanına text gir(iframe içinde oldugu için geçiş yapmak gerekiyor
        Driver.getDriver().switchTo().frame("user_description_ifr");
        alloverCommercePage.biography.clear();
        alloverCommercePage.biography.sendKeys(ConfigReader.getProperty("biography"));
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.bekle(2);

        alloverCommercePage.currentPassword.sendKeys(ConfigReader.getProperty("alloverMusteriSifre"));
        alloverCommercePage.newPassword.sendKeys(sifre,Keys.TAB,sifre);
        System.out.println("sifre = " + sifre);

        //save changes butonuna tıkla
        alloverCommercePage.saveChangesButton.click();
        ReusableMethods.bekle(3);

        //"Account details changed successfully" mesajının görünür oldugunu doğrula



    }

}
