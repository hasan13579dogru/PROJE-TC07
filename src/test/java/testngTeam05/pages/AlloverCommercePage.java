package testngTeam05.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testngTeam05.utilities.Driver;
import testngTeam05.utilities.ReusableMethods;

import java.util.List;

public class AlloverCommercePage {

    public AlloverCommercePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // yusuf
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;   // Anasayfa Sign In /
    @FindBy(css = "[id=username]")
    public WebElement signInUserNameOrEmail;
    @FindBy(css = "[id=password]")
    public WebElement signInPassword;
    @FindBy(css = "[name='login']")
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

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement anasayfaSigninButon;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameEmailAddress;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement ilkSayfapassword; //--> ilk sayfadaki şifre alanı

    @FindBy(xpath = "//span[text()='Sign Out']")


    public WebElement signOut;

    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public WebElement myAccount;
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


    //hasan
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signIN;
    @FindBy(xpath = "(//*[text()='Quick View'])[1]")
    public WebElement quickView;

    //SEPETE EKLEME
    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-13229\"]/td[5]/div/a")
    public WebElement addToCartButton2;

    ////urun cartbtn
    @FindBy(xpath = "(//a[text()='Add to cart'])[1]")
    public WebElement addToCartButton1;

    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement automaticCrusher;//kıyma makinesi resmini kapat
    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement chess;//satranc resmini kapat
    @FindBy(xpath = "(//*[@class='yith-wcwl-add-button'])")
    public WebElement WishList;//satranc
    @FindBy(xpath = "(//*[@class='add_to_wishlist single_add_to_wishlist'])[1]")
    public WebElement kıymaMakinesi;

@FindBy(xpath = "(//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[15]")
public WebElement electricFryingPan;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement signIn3;//3. signin buttonu


    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement searchButton;//ana sayfanın en ustundeki SEARCHBUTTON





    @FindBy(xpath = "(//img[@role='presentation'])[1]")
    public WebElement imgUrun;//secilen urun resmi(chair and kitchen table)

    @FindBy(xpath = "(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]")
    public WebElement wishListButtonChair;//secilen urunun yanındaki wishlistchair

    @FindBy(xpath = "(//button[text()='Quick View'])[1]")
    public WebElement quickViewButton1;

    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-13229\"]/td[5]/div/button")
    public WebElement quickViewButton2;


    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement getElectricRiceCookerButton;
    @FindBy(xpath = "(//a[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt'])[1]")
    public WebElement addToCart1;//electric rice cooker
    @FindBy(xpath = "(//a[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt'])[1]")
    public WebElement automaticCrusherAddToCart;//addtocart kıyma makinesi


    @FindBy(xpath = "(//a[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt'])[1]")
    public WebElement elctricFryingPanButton;//tava

    @FindBy(xpath = "//*[@class='single_add_to_cart_button button alt']")
    public WebElement addToCart2;//urunun sag tarafındaki addtocartbutton

    //CHECKOUT BUTONU(ADD TO CART)
    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkoutCart;//anasayfa sepetin(CART)ALTINDAKİ checkout






@FindBy(xpath = "(//button[@class='btn btn-quickview btn-outline btn-default btn-rounded btn-sm mr-lg-2'])[4]")
public WebElement electricFryingPanButton;//tava
    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-13229\"]/td[5]/div/button")
    public WebElement electricRiceCookerButton;

    //@FindBy(xpath = "(//button[@class='btn btn-quickview btn-outline btn-default btn-rounded btn-sm mr-lg-2'])[3]")
    //public WebElement chessButton;//
    @FindBy(xpath = "(//button[@class='btn btn-quickview btn-outline btn-default btn-rounded btn-sm mr-lg-2'])[2]")
    public WebElement automaticCusherButton;//





    // wish btn ana sayfa en ust
@FindBy(xpath = "//i[@class='w-icon-heart']")
public WebElement wishListButton;

//Automatic crusher wish btn
    @FindBy (xpath = "//*[@id=\"product-13229\"]/div[2]/div/div[4]/div[2]/div/a")
    public WebElement AutomaticcrusherWishbtn;

    //chess wish btn
    @FindBy(xpath = "//*[@id=\"product-19895\"]/div[2]/div/div[4]/div[2]/div/a")
    public WebElement chessWishButton;
    //*[@id="product-19895"]/div[2]/div/div[4]/div[2]/div/a

    //Electric Rice Cooker wish btn
    @FindBy (xpath = "//*[@id=\"product-13226\"]/div[2]/div/div[4]/div[2]/div/a")
    public WebElement electricRiceCookerwishbtn;


@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/a/i")
public  WebElement cartButton;
@FindBy(xpath = "//h3[text()='Billing details']")
public WebElement billingDetailsYazisi;

//billing details locate******************

@FindBy(xpath = "//span[text()='Uruguay']")
public WebElement countryNameUruguay;
@FindBy(xpath = "//input[@id='billing_address_1']")
public WebElement houseNumberAndStreetName;
@FindBy(xpath = "//*[@id='select2-billing_state-container']")
public WebElement stateNameFlores;
@FindBy(xpath = "//*[@id='billing_city']")
public WebElement town;


@FindBy(xpath = "//input[@id='billing_first_name']")
public  WebElement billingFirstName;
@FindBy(xpath= "//input[@id='payment_method_bacs']")
public WebElement wireTransferButton;
@FindBy(xpath = "//button[@id='place_order']")
public  WebElement placeOrderButton;
//quick view kapatma
@FindBy(xpath = "//button[@class='mfp-close']")
public  WebElement quickViewKapatma;

   //kalem karsılastırma butonu VE SİLME locate***************

    @FindBy (xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[5]/div/figure/a/img[2]")
    public WebElement pencil2img;
   @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[5]/div/figure/div[2]/a[2]")
   public WebElement pencil2CompBtn;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[4]/div/figure/a/img[2]")
    public WebElement pencil3img;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[4]/div/figure/div/a[2]")
    public WebElement pencil3CompButton;

// start compare buton***************************
    @FindBy(xpath = "//a[@class='btn btn-dark btn-rounded']")

    public WebElement startCompare;


    //wishlist ekleme locate önce resim sonra wishlist buttonu
    @FindBy(xpath ="//*[@id=\"main\"]/div/div/div/div/div/div[1]/div[2]/div/figure/a/img")
   public WebElement wishListimgPencil2;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[1]/div[3]/div/figure/a/img")
    public WebElement wishListimgPencil3;


   // @FindBy(xpath = "(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]")
   @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[1]/div[2]/div/figure/div/div/div/a")
   public WebElement wishListButtonPencil2;


  // @FindBy(xpath = "(//a[@class='add_to_wishlist single_add_to_wishlist'])[2]")
 @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[1]/div[2]/div/figure/div/div/div/a")
 public WebElement wishListButtonPencil3;


 //Yeni bir urun secildi ve resim locate alındı
 @FindBy(xpath = "(//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[3]")
 public WebElement ballimg;
@FindBy(xpath = "(//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[5]")
public WebElement basketballimg;

@FindBy(xpath = "(//a[@class='compare btn-product-icon'])[2]")
public WebElement basketballCompButton;
    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement ballCompButton;

    public static List<WebElement> productWishList() {

        return productWishList();
    }
}


































