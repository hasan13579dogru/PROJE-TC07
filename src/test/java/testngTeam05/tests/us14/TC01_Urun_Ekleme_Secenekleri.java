package testngTeam05.tests.us14;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngTeam05.pages.AlloverCommercePage;
import testngTeam05.utilities.ConfigReader;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

public class TC01_Urun_Ekleme_Secenekleri {
    Faker faker = new Faker();

    @Test
    public void vendorUrunEkleme(){


        //User should be able to see the options to add items as a Vendor

        AlloverCommercePage alloverCommercePage = new AlloverCommercePage();

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        AlloverCommercePage alloverCommercePageSK = new AlloverCommercePage();


        alloverCommercePage.anasayfaSigninButon.click();
        ReusableMethods.bekle(1);



        alloverCommercePageSK.signInUserNameOrEmail.sendKeys(ConfigReader.getProperty("alloverVendorEmailSK"), Keys.TAB,
                ConfigReader.getProperty("alloverVendorPasswordSK"));
        alloverCommercePageSK.signInButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(AlloverCommercePage.signOut.isDisplayed());

        //Vendor should be able to see product adding options

        AlloverCommercePage.signOut.click();
        ReusableMethods.bekle(2);

        ReusableMethods.click(alloverCommercePage.storeManager);
        ReusableMethods.scroll(alloverCommercePage.product);

        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.product);

        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.productAddnew);

        ReusableMethods.bekle(2);
        ReusableMethods.scroll(alloverCommercePage.productOptionsDdm);

        //There should be Simple Product, Variable Product, Grouped Product, External - Affiliate Product options

        Select select=new Select(alloverCommercePage.productOptionsDdm);
        select.selectByVisibleText("Simple Product");
        select.selectByVisibleText("Variable Product");
        select.selectByVisibleText("Grouped Product");
        select.selectByVisibleText("External/Affiliate Product");


        //Vendor should be able to add product image

        //Product Title,Short Description and Description should be able to write
        faker=new Faker();
        String addProductCategory=faker.lorem().word();
        String title=faker.lorem().paragraph(1);
        String shortDescriptionSK=faker.lorem().paragraph(4);
        String descriptionSK=faker.lorem().paragraph(10);
        String brand=faker.company().name();

        ReusableMethods.scroll(alloverCommercePage.productTitle);

        alloverCommercePage.productTitle.sendKeys(title);

        // ReusableMethods.webElementResmi(alloverCommercePage.productTitle);
        //ReusableMethods.bekle(3);
        //vendor should be to write shortdesciription

        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.click(alloverCommercePage.shortDescriptionSon);
        alloverCommercePage.shortDescriptionSon.sendKeys(shortDescriptionSK);
        //Confirm that vendor exited the first iframe(shortdescription)

        Driver.getDriver().switchTo().defaultContent();
        alloverCommercePage.storeManager.isDisplayed();

        //confirm that the category can be selected

        ReusableMethods.click(alloverCommercePage.categoriesCheckbox);
        Assert.assertTrue(alloverCommercePage.categoriesCheckbox.isSelected());
        //vendor should be able to add new category
        ReusableMethods.click(alloverCommercePage.addProductCategory); //+
        ReusableMethods.bekle(2);
        ReusableMethods.click(alloverCommercePage.categoryName);//+
        alloverCommercePage.categoryYaz.sendKeys(addProductCategory);//+
        ReusableMethods.ddmIndex(alloverCommercePage.parendCategory,2);//+
        ReusableMethods.click(alloverCommercePage.addKategoriButonu);//+
        ReusableMethods.bekle(5);
        String kayitSonrasiYazi=alloverCommercePage.addProductCategory.getText(); //+
        Assert.assertEquals(kayitSonrasiYazi,"+Add new Product brands");//+

        //confirm that the brand can be selected

        ReusableMethods.click(alloverCommercePage.productCheckBox);//+
        Assert.assertTrue(alloverCommercePage.productCheckBox.isSelected());//+

        alloverCommercePage.brandProductNameKutusu.sendKeys(brand);//+
        ReusableMethods.ddmIndex(alloverCommercePage.parentProductDdm,1);//+
        ReusableMethods.click(alloverCommercePage.addKategoriButonu);//+
        alloverCommercePage.brandAddButonu.click();//+
        ReusableMethods.bekle(4);//+


















     /*
     Driver.getDriver().switchTo().defaultContent();
            alloverCommercePage.descriptionSon.click();
            Driver.getDriver().switchTo().frame(alloverCommercePage.descriptionSon);
            alloverCommercePage.descriptionSon.click();
            //Kullanıcı Description'a yazı yazalabilmeli

            alloverCommercePage.descriptionSon.sendKeys("Kullanıslı Urunler");

            Driver.getDriver().switchTo().parentFrame();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
      */










        /*
        ReusableMethods.click(alloverCommercePage.productCheckBox);
        Assert.assertTrue(alloverCommercePage.productCheckBox.isSelected());
        alloverCommercePage.brandProductNameKutusu.click();
        alloverCommercePage.brandProductNameKutusu.sendKeys(brand);
        ReusableMethods.ddmIndex(alloverCommercePage.parentProductDdm,1);
        ReusableMethods.click(alloverCommercePage.addKategoriButonu);

       // ReusableMethods.ddmVisibleText(alloverCommercePage.brandProductNameKutusu,brand);


         */























    }

    }




