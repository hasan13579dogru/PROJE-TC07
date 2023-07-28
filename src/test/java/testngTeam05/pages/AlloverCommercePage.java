package testngTeam05.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testngTeam05.utilities.Driver;

public class AlloverCommercePage {
    public AlloverCommercePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//p[text()='Copy email']")
    public WebElement copyFakeMail; //fake mail sitesindeki maili kopyalar


    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerButton; //anasayfadaki register butonu

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement userName; //register clikinde acilan username box

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement yourEmailAddress; //registerden sonraki email box

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement registerPassword; //registerden sonraki password box

    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement iAgreeClick; //register islemindeki I agree to the privacy policy kutusu

    @FindBy(xpath = "//button[@name='register']")
    public WebElement registerSignUp; //register islemindeki signup button


    @FindBy(xpath = "//div[@id='customer_login']")
    public WebElement ilerlemekIcinTiklaYazisi;


    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement registersignOut;

    @FindBy(xpath = "//a[@class='showlogin']")
    public WebElement pleaseLoginYazisi;




































































    //mustafa dalkılıç

    //*[@id='username']
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernamemd;



    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement MyAccountmd;



/*






    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement MyAccountmd;
*/





    //*[text()='Addresses']

    @FindBy(xpath= "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']")
    public static WebElement adress;








































































    @FindBy(xpath = "//*[@id='reg_username']")
    public WebElement emailAdresAlanı; //diğer locatelerde sıkıntı yaşadığım için bunu oluşturdum(Mehtap)

    @FindBy(xpath = "(//figure)[2]")
    public WebElement ilkKulaklıkResmi; //kulaklık aradıktan sonra çıkan ilk ürün

    @FindBy(xpath = "//div[@ class=\"woocommerce-message alert alert-simple alert-icon alert-close-top alert-success\"]")
    public WebElement accountDetailsChangedMessage;

    @FindBy(xpath = "//a[text()='View cart']")
    public WebElement viewCart;//-->CART icona tıklandıktan sonra sepeti gözden geçirme için buton

    @FindBy(xpath = "//td[@class='product-thumbnail']")
    public WebElement sepettekiIlkUrun;

    @FindBy(xpath = "//*[@title='Plus']")
    public WebElement plusButton; //--> to increase quantitiy of product

    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCart; //sepette ürün miktarı artırıp azalttıktan sonra güncelleme için

    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement cartUpdateMessage;
    @FindBy(xpath = "//*[@title='Minus']")
    public WebElement minusButton;

    @FindBy(xpath = "//*[@class='wc-proceed-to-checkout']")
    public WebElement proceedToCheckoutButton;









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





































































































































//livdemirci








//Salih

































































































//enes






























































































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
//    @FindBy(xpath = "//input[@type='text']")
//    public  WebElement userName;

    @FindBy(xpath = "//*[@type='search']")
    public  WebElement search;

    @FindBy(xpath = "(//h3)[2]")
    public  WebElement searchedFirstItem;

//    @FindBy(xpath = "//*[@name='add-to-cart']")
//    public  WebElement addToCart;

    @FindBy(xpath = "//*[@class='w-icon-cart']")
    public  WebElement cart;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public  WebElement viewToCart;

    @FindBy(xpath = "//input[@type='text']")
    public  WebElement enterCoupon;

    @FindBy(xpath = "//*[@role='alert']")
    public  WebElement couponAlert;
    @FindBy(xpath = "//*[@name='apply_coupon']")
    public  WebElement applyCoupon;

    @FindBy(xpath = "//*[@class=\"remove remove_from_cart_button\"]")
    public  WebElement cartInClearProduct;//cart ici sil butonu

    @FindBy(xpath = "//*[text()='Log out']")
    public WebElement logout;

    @FindBy(xpath = "//*[text()='Close']")
    public WebElement close;  //cart ici close buton

    @FindBy(xpath = "(//*[@class='woocommerce-Price-amount amount'])[6]")
    public WebElement subtotalPrice;//indirimsiz fiyat


    @FindBy(xpath = "(//*[@class='woocommerce-Price-amount amount'])[7]")
    public WebElement totalPrice;//indirimli fiyat

    @FindBy(xpath = "//*[@class='wc-proceed-to-checkout']")
    public WebElement proceedToCheckout; //satın almayı onayla

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderButton; //billing adress onayla enson sayfa

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement endBillingFirstName; //billing first name  enson sayfa

    @FindBy(xpath = "//*[@id='payment_method_bacs']")
    public WebElement endPaymentMethods; //billing ödeme türü secimi wire transfer  enson sayfa

    @FindBy(xpath = "//p//i")
    public WebElement orderHasBeenReceived;//siparisiniz alindi yazısı
    @FindBy(xpath = "//*[@class='quantity-plus w-icon-plus']")
    public WebElement qantityPlus;//urun mikraını arttır

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkoutBoton;//urunleri ödeme ekranına gecis butonu

    @FindBy(xpath = "//*[@class='showcoupon']")
    public WebElement enterTCouponBillAdress;//urunleri ödeme ekranına gecis butonu
    @FindBy(xpath = "//*[@name='apply_coupon']")
    public WebElement applyCouponBillAdress;//urunleri ödeme ekranına gecis butonu
    @FindBy(xpath = "//input[@id='coupon_code']")
    public WebElement enterCouponBoxBillAdress;//urunleri ödeme ekranına gecis butonu

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement coupounAlertBillAdress;

    @FindBy(xpath = "//*[@id='payment_method_cod']")
    public WebElement paymentAtDoor;
    @FindBy(xpath = "(//*[@class='woocommerce-Price-amount amount'])[6]")
    public WebElement totalPricePayBill;//indirimli fiyat
    @FindBy(xpath = "(//*[@class='woocommerce-Price-amount amount'])[4]")
    public WebElement subtotalPricePayBill;//indirimsiz fiyat
    @FindBy(xpath = "//*[@href=\"https://allovercommerce.com/my-account-2/\"]")
    public WebElement myAccountmurat ;

    @FindBy(xpath = "//*[@href=\"https://allovercommerce.com/store-manager/\"]")
    public WebElement storeManagermurat ;
    @FindBy(xpath = "//*[@class=\"icon-box-icon icon-orders\"]")
    public WebElement orderInMyaccount  ;//myaccount taki order butonu
    @FindBy(xpath = "//*[@href=\"https://allovercommerce.com/my-account-2/view-order/27008/\"]")
    public WebElement orderinFirstidNo  ;//myaccount taki order daki ilk urun id










}






