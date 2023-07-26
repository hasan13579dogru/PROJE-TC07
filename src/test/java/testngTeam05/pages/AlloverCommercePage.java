package testngTeam05.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testngTeam05.utilities.Driver;

public class AlloverCommercePage {
    public AlloverCommercePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Ümran--11-100 satır aralığı 50 dahil
    /*
    @FindBy(xpath = )
    public WebElement loginbuton;

     */


































//Ümran atasoy son satır
//Mustafa--51-100 satır aralığı
















































        //Musta hoca son satır
    //Mehtap--101-150 satır aralığı

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement anasayfaSigninButon;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameEmailAddress;
       @FindBy(xpath = "//button[@name='login']")
    public WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public WebElement myAccount;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[4]")
    public WebElement accountDetailsMenu;

    @FindBy(xpath = "//input[@name='account_first_name']")
    public WebElement accountFirstName;
    @FindBy(xpath = "//*[@name='account_last_name']")
    public WebElement accountLastName;
    @FindBy(xpath = "//*[@name='account_display_name']")
    public WebElement accountDisplayName;
    @FindBy(xpath = "//*[@name='account_email']")
    public WebElement accountEmail;
    @FindBy(xpath = "//br")
    public WebElement biography;
    @FindBy(xpath = "//input[@name='password_current']")
    public WebElement currentPassword;
    @FindBy(xpath = "//input[@name='password_1']")
    public WebElement newPassword;
    @FindBy(xpath = "//input[@name='password_2']")
    public WebElement confirmPassword;
    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "(//h4)[2]")
    public WebElement accountDetailsSayfaYazısı;





















































































}



























