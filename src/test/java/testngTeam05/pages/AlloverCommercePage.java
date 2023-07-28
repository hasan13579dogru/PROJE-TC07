package testngTeam05.pages;

import com.github.javafaker.Commerce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testngTeam05.utilities.Driver;

import java.util.List;

public class AlloverCommercePage {
    public AlloverCommercePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }






















































































    //mustafa dalkılıç  

    //*[@id='username']
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernamemd;



    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement MyAccountmd;





    //*[text()='Addresses']

    @FindBy(xpath= "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']")
    public static WebElement adress;





























































































    //mehtap
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement anasayfaSigninButon;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameEmailAddress;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement ilkSayfapassword; //--> ilk sayfadaki şifre alanı

    @FindBy(xpath = "//span[.='Sign Out']")
    public static WebElement signOut;

    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public static WebElement myAccount;


    @FindBy(xpath = "//a[.='Log out']")//-->signout tıkladığımızda sayfada gelen log out yazısı
    public WebElement logOut;

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
    @FindBy(xpath = "//body[@id='tinymce']")
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

















































//Salih

































































































//enes



































































































//seda





































































































  // yusuf
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;   // Anasayfa Sign In /
    @FindBy(css = "[id=username]")
    public WebElement signInUserNameOrEmail;
    @FindBy(css = "[id=password]")
    public WebElement signInPassword;
    @FindBy(css = "[name=login]")
    public WebElement signInButton;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement myAccountBaslik; // Sayfa Başlığı
    @FindBy(xpath = "(//h2)[1]")
    public WebElement storeManagertBaslik; // Sayfa Başlığı
    @FindBy(xpath = "(//h2)[2]")
    public WebElement addProductBaslik; // Sayfa Başlığı
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccountButton; // Anasayfada en allttaki My Account butonu
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager; // Dashboard menu altındaki Store Manager
    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement product; //Store Manager sayfasındaki Product butoonu
    @FindBy(xpath = "(//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_product_manage moz_class'])[1]")
    public WebElement addNew; //Store Manager/Product/Add New

    //   Add Product sayfasındaki "Locate"ler
    @FindBy(id = "pro_title")
    public WebElement productTitle; // Ürün başlığı ekleme bölümü
    @FindBy(id = "featured_img_display")
    public WebElement featureImage; // resim ekleme: sağ taraftaki büyük çerçeve
    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement mediaLibrary;
    @FindBy(xpath = "//*[@id='__attachments-view-54']/li[3]/div/div")
    public WebElement mouseResmiFeature; // eklenen resim
    @FindBy(xpath = "//*[@id='__wp-uploader-id-0']/div[4]/div/div[2]/button")
    public WebElement selectFeature;
    @FindBy(css = "img[id=gallery_img_gimage_0_display]")
    public WebElement galeryImage; // resim ekleme: sağ taraftaki küçük çerçeve
    @FindBy(xpath = "(//div[@class='thumbnail'])[8]")
    public WebElement mouseResmi; // eklenen resim
    @FindBy(xpath = "(//*[text()='Add to Gallery'])[3]")
    public WebElement addToGalery;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[1]/input")
    public WebElement categoriesCheckbox; //  Add Product saffasındaki Categories

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;
    @FindBy(css = "[id=sku]")
    public WebElement sku;
    @FindBy(css = "[id=manage_stock]")
    public WebElement manageStockChecboxk;
    @FindBy(css = "[id=stock_qty]")
    public WebElement stockQty;
    @FindBy(css = "[id=sold_individually]")
    public WebElement soldIndividuallyChecboxk;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;
    @FindBy(id = "weight")
    public WebElement weight;
    @FindBy(id = "shipping_class")
    public WebElement shippingClass;
    @FindBy(id = "_wcfmmp_processing_time")
    public WebElement processingTime;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;
    @FindBy(id = "attributes_is_active_1")
    public WebElement colorCheckBox;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement colorSecim;
    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeCheckBox;
    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[3]")
    public WebElement sizeSecim;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[7]")
    public WebElement linked;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[8]")
    public WebElement seo;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[10]")
    public WebElement advenced;

    @FindBy(css = "[id=wcfm_products_simple_submit_button]")
    public WebElement submitButton; // Add Product sayfası en alttaki SUBMIT
    @FindBy(xpath = "(//img[@class='attachment-thumbnail size-thumbnail'])[1]")
    public WebElement productMouse;
    @FindBy(xpath = "//*[text()='Team05']")
    public WebElement productSku;
    @FindBy(xpath = "//*[text()='Published']")
    public WebElement productStockStatus;
    @FindBy(xpath = "//*[text()=' (100)']")
    public WebElement productManageStock;
    @FindBy(css = "[value=View]")
    public WebElement viewButton; // Add Product sayfası en alttaki VIEW
    @FindBy(xpath = "(//*[@class='nav-link'])[2]")
    public WebElement spesification; // VIEW tıkklanınca açılan sayfada eklenen ürünün altında
    @FindBy(xpath = "(//tbody//tr//td)[1]")
    public WebElement spesificationWeight;
    @FindBy(xpath = "(//tbody//tr//td)[2]")
    public WebElement spesificationDimensions;
















































    //livdemirci
    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement register;

    @FindBy(xpath = "//*[@id='reg_username']")
    public WebElement reg_username;

    @FindBy(xpath = "//*[text()='An account is already registered with your email address. ']")
    public WebElement accountAlreadyRegisteredText;


    @FindBy(xpath = "//*[@class='register_as_vendor']")
    public WebElement register_as_vendor;//signup sayfasindaki register as a vendor locate

    @FindBy(xpath = "//*[@class='page-title-wrap']")
    public WebElement vendorRegistration;//vendor sayfasindaki vendor registration yazisi

    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement vendorRegistrationEmail;//vendor sayfasindaki vendor registration e-mail

    @FindBy(xpath = "//*[@name='wcfm_email_verified_button']")
    public WebElement verificationEmailButton;//vendor sayfasindaki verification code butonu

    @FindBy(xpath = "//*[@name='wcfm_email_verified_input']")
    public WebElement verificationCode;//vendor sayfasindaki verification code'un girilecegi

    @FindBy(xpath = "//*[text()='Not right now']")
    public WebElement WelcometoAlloverCommerce;//vendor olarak kayit olduktan sonraki "not now butonu secmek icin"

    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public WebElement storeManagerMyAccount;//vendor'un store manager sayfasindaki myaccount

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    public WebElement myAccountOrders;//Myaccount sayfasindaki orders linki

    @FindBy(xpath = "//*[@class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]")
    public List<WebElement> addToChart;//Urunler sayfasindaki addToChart linki

    @FindBy(xpath = "//*[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement browseProduct;//Urunler sayfasindaki addToChart linki

    @FindBy(xpath = "//*[@id=\"password_strength\" and contains(@class, 'good')]")
    public WebElement passwordStrengthGood;//Istenilen sartlari saglayan sifreyi girmek icin yaziyi aliyoruz.

    @FindBy(xpath = "//*[@class='wcfm-text wcfm_ele '][1]")
    public WebElement vendorPassword;//Istenilen sartlari saglayan sifreyi girmek icin yaziyi aliyoruz.




































































    //hasan
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement searchButton;//ana sayfanın en ustundeki

    @FindBy(xpath = "//a[@class='wishlist block-type']")
    public  WebElement wishList;//ana sayfanın sag ust

    @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement CART;//ana sayfa sag ust

    @FindBy(xpath = "(//img[@role='presentation'])[1]")
    public  WebElement imgUrun;//secilen urun resmi(chair and kitchen table)

    @FindBy(xpath = "(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]")
    public WebElement wishListButtonChair;//secilen urunun yanındaki wishlistchair

    @FindBy(xpath = "//*[@class='yith-wcwl-wishlistexistsbrowse']")
    public  WebElement wishListButton;//secilen urunun yanındaki wishlist kitchentable

    @FindBy(xpath = "//*[@class='single_add_to_cart_button button alt']")
    public WebElement addToCart;//urunun sag tarafındaki addtocartbutton

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkoutCart;//anasayfa sepetin(CART)ALTINDAKİ checkout

    @FindBy(id = "//input[@id='billing_first_name']")
    public WebElement billingFirstName;//BİLLİNG DETAİLS altındaki name









































































//murat
    


}



































