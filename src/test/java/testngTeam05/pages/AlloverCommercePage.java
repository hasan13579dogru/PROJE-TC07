
package testngTeam05.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testngTeam05.utilities.Driver;

import java.util.List;

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


    //wish list  //div[@class="yith-wcwl-add-button"] 

    @FindBy(xpath = "//a[@class='showlogin']")
    public WebElement pleaseLoginYazisi;


    @FindBy(xpath = "(//p[@class='elementor-heading-title elementor-size-default'])[1]")
    public WebElement anasayfaTitle;




































































    //mustafa dalkılıç

    //*[@id='username']
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernamemd;





    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement MyAccountmd;














    @FindBy(xpath= "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']")
    public static WebElement address;








































































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

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
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
    public static WebElement signOut;//Siteye girdiğimizde signin signout oluyor

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
    public WebElement accountDetailsSayfaYazısı;//Account Details Sayfası başlığı


    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstNamee;

    @FindBy(xpath = "//select[@name='billing_country']")
    public WebElement billingCountryddm;
    @FindBy(xpath = "//input[@name='billing_address_1']")
    public WebElement billingAddress;

    @FindBy(xpath = "//h4[text()='Payment Methods']")
    public WebElement paymentMethods;

    @FindBy(xpath = "//input[@id='payment_method_cod']")
    public WebElement payAtTheDoorButton;

    @FindBy(xpath = "//input[@id='payment_method_bacs']")
    public WebElement eftButton;

    @FindBy(xpath = "//input[@id='payment_method_bacs']")
    public WebElement orderSuccessMessage;//ürün satın alma işleminin başarılı oldugunun mesajı

    @FindBy(xpath = "//p[text()='WELCOME TO ALLOVER COMMERCE...']")
    public WebElement welcomeToAlloverCommerceYazısı;//Sayfaya girdiğimizi doğrulamak için Siteye hoş geldiniz yazısı
   //arama sonuçlarının sonuncusu


    @FindBy(xpath="(//*[@class='product-wrap'])[2]")
    public WebElement ikinciUrun;

    @FindBy(xpath="(//select)[1]")
    public WebElement sortBy;


    @FindBy(xpath="//button[@name='add-to-cart']")
    public WebElement sepeteEkle;



































//Salih



















































































































//enes
    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--downloads\"]")
    public WebElement Downloads;//My account page
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']")
    public WebElement Addresses;//My account page
    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-account\"]")
    public WebElement Accountdetails;//My account page
    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wishlist\"]")
    public WebElement Wishlist;//My account page
    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--support-tickets\"]")
    public WebElement SupportTickets;//My account page
    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--followings\"]")
    public WebElement Followings;//My account page
    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout\"]")
    public WebElement Logout;//My account page
    @FindBy(xpath = "//*[@class=\"icon-box-icon text-grey mr-2\"]")
    public WebElement ikonAddresses;
    @FindBy(xpath = "(//*[@class=\"edit btn btn-link btn-primary btn-underline mb-4\"])[1]")
    public WebElement billingAddressAltindakiAdd;
    @FindBy(xpath = "//*[text()='Billing address']")
    public WebElement BillingaddressYazisi;
    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement firstNameBillingAddress;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement lastNameBillingAddress;
    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement emailBillingAddress;
    @FindBy(xpath = "//*[@id=\"billing_address_1\"]")
    public WebElement streetAddressBillingAddress;
    @FindBy(xpath = "//*[@id=\"billing_city\"]")
    public WebElement townCityBillingAddress;
   @FindBy(xpath = "//*[@id=\"billing_postcode\"]")
   public WebElement postCodeZipBilling;
   @FindBy(xpath = "//*[@id=\"billing_phone\"]")
   public WebElement phoneBilling;









































































































//seda








































//seda

    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement MyAccountFooter; //  vendor ile griş yapıldıktan sonraki footerdaki my account
    @FindBy(xpath = "//a[text()='Addresses']") //vendordassbort addres
    public WebElement VendorAddress;
    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement ShippingAdd; // vendor-adress-shipping-add
    @FindBy(xpath = "(//input[@name='shipping_first_name'])[1]")
    public WebElement ShippinFirstName; // vendor-adress-shipping-add-shippingFirstName
    @FindBy(xpath = "//select[@id='shipping_country']")
    public WebElement ShippinSelectCountry; // vendor-adress-shipping-add-country
    @FindBy(xpath = "//input[@id='shipping_address_1']")
    public WebElement ShippinStreet; // vendor-adress-shipping-add-street
    ////button[@name='save_address']
    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement ShippingSaveAdress; // vendor-adress-shipping-add-saveadress butonu

    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement ShippingSuccesText; // vendor-adress-shipping-add-saveSucces























































































































































































































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
    public WebElement storeManagerBaslik; // Sayfa Başlığı
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
    @FindBy(xpath = "//*[@class='thumbnail']")
    public WebElement mouseResmiFeature; // eklenen resim
    @FindBy(xpath = "//*[@id='__wp-uploader-id-0']/div[4]/div/div[2]/button")
    public WebElement selectFeature;
    @FindBy(css = "img[id=gallery_img_gimage_0_display]")
    public WebElement galeryImage; // resim ekleme: sağ taraftaki küçük çerçeve
    @FindBy(xpath = "(//*[@id=\"__wp-uploader-id-3\"]/div[3]/div[2]/div/div[3]/ul/li)[1]")
    public WebElement mouseResmi; // eklenen resim
    @FindBy(xpath = "(//*[text()='Add to Gallery'])[3]")
    public WebElement addToGalery;
    @FindBy(xpath = "//input[@value='402']")
    public WebElement categoriesCheckbox; //  Add Product saffasındaki Categories
    // Inventory Menüsü "Locate"ler
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;
    @FindBy(css = "[id=sku]")
    public WebElement sku;
    @FindBy(css = "[id=manage_stock]")
    public WebElement manageStockChecbox;
    @FindBy(css = "[id=stock_qty]")
    public WebElement stockQty;
    @FindBy(css = "[id=sold_individually]")
    public WebElement soldIndividuallyChecbox;
    // Shipping Menüsü "Locate"ler
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;
    @FindBy(id = "weight")
    public WebElement weight;
    @FindBy(css = "#length")
    public WebElement length;
    @FindBy(css = "#width")
    public WebElement width;
    @FindBy(css = "#height")
    public WebElement height;
    @FindBy(id = "shipping_class")
    public WebElement shippingClass;
    @FindBy(css = "[id=_wcfmmp_processing_time]")
    public WebElement processingTime;
    // Attributes Menüsü "Locate"ler
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;
    @FindBy(id = "attributes_is_active_1")
    public WebElement colorCheckBox;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement colorSecim;
    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeCheckBox;
    @FindBy(xpath = "//*[@id=\"attributes\"]/div[3]/span[2]/span[1]/span/ul/li/input")
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
    @FindBy(css = "select[id=product_type] option:first-of-type")
    public WebElement simpleProductDdm;
    @FindBy(css = "#is_virtual")
    public WebElement virtualCheckBox;
    @FindBy(css = "#is_downloadable")
    public WebElement downloadableCheckBox;
    @FindBy(xpath = "//button[@id='__wp-uploader-id-1']")
    public WebElement selectFilesButton;
    @FindBy(id = "regular_price")
    public WebElement prise;
    @FindBy(id = "sale_price")
    public WebElement salePrise;




































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

    @FindBy(xpath = "//div//p[3]//a[2]")
    public WebElement WelcometoAlloverCommerce;//vendor olarak kayit olduktan sonraki "not now butonu secmek icin"

    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public WebElement storeManagerMyAccount;//vendor'un store manager sayfasindaki myaccount

    @FindBy(xpath = "//*[@id='main']//div//ul//li[3]")
    public WebElement myAccountOrders;//Myaccount sayfasindaki orders linki

    @FindBy(xpath = "//*[@class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]")
    public List<WebElement> addToChart;//Urunler sayfasindaki addToChart linki

    @FindBy(xpath = "//*[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement browseProduct;//Urunler sayfasindaki addToChart linki

    @FindBy(xpath = "//*[@id=\"password_strength\" and contains(@class, 'good')]")
    public WebElement passwordStrengthGood;//Istenilen sartlari saglayan sifreyi girmek icin yaziyi aliyoruz.

    @FindBy(xpath = "//*[@class='wcfm-text wcfm_ele '][1]")
    public WebElement vendorPassword;//Istenilen sartlari saglayan sifreyi girmek icin yaziyi aliyoruz.

    @FindBy(xpath = "//*[@class='cart-toggle']")
    public WebElement fiyatsizUrunAlert;//Satin alinamayan urun alert'i

    @FindBy(xpath = "//*[@class='cart-toggle']")
    public WebElement cartIcon;//Sepetteki urunler

    @FindBy(xpath = "//span[@class='cart-count'][1]")
    public WebElement sepetSayaci;//Sepetteki urun sayisi icin

    @FindBy(xpath = "//*[@class='cart-item-meta mini-item-meta']//a/span")
    public List<WebElement> sepeteEklenenUrunler;//Sepetteki urun listesi

    @FindBy(xpath = "//tbody//tr//td[contains(@class,'product-name')]//span")
    public List<WebElement> yourOrder;//Siparis gosterimi

    @FindBy(xpath = "//*[@class=\"cart-item-meta mini-item-meta\"]//a//span")
    public List<WebElement> shoppingCartUrunListesi;//Siparis gosterimi

    @FindBy(xpath = "//select[1]")
    public WebElement countryDdm;//Billing details countryDdm

    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement provinceDdm;//Billing details province

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement streetAdress;//Billing details street adress

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/'][1]")
    public WebElement myAccountOrders2;//myaccount

    @FindBy(xpath = "//*[@id='main']//div[3]//a")
    public WebElement browseProductText;

    @FindBy(xpath = "//*[@id='billing_postcode']")
    public WebElement postCode;

    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement townCity;

    @FindBy(xpath = "//*[@id='billing_phone']")
    public WebElement phone;

    @FindBy(xpath = "//*[@class='fas fa-check']")
    public WebElement orderVerification;

    @FindBy(xpath = "//*[text()='View']")
    public WebElement viewMyAccount;

    @FindBy(xpath = "//*[text()='Order details']")
    public WebElement orderDetails;

    @FindBy(xpath = "//*[text()='Billing First name']")
    public WebElement billingFirstNameOrder;

    @FindBy(xpath = "//*[text()='Billing Last name']")
    public WebElement billingLastName;

    @FindBy(xpath = "//*[text()='Billing Street address']")
    public WebElement billingStreetAdress;

    @FindBy(xpath = "//*[text()='Billing ZIP Code']")
    public WebElement billingZipCode;

    @FindBy(xpath = "//*[text()='Billing Phone']")
    public WebElement billingPhone;
//////////////////////////////////US2//////////////////////////
    @FindBy(xpath = "//*[@class='wcfmfa fa-gift']")
    public WebElement coupons;

    @FindBy(xpath = "//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']")
    public WebElement couponsAddNew;

    @FindBy(xpath = "//*[text()='Welcome to Allover Commerce!']")
    public WebElement welcomeToAlloverCommersYazisi;

    @FindBy(xpath = "//*[@class='wcfm-text wcfm_ele'][1]")
    public WebElement codeAdd;

    @FindBy(xpath = "//*[@id='discount_type']")
    public List<WebElement> discountType;

    @FindBy(xpath = "//select[1]")
    public WebElement ddmDiscountType;

    @FindBy(xpath = "//*[@id='coupon_amount']")
    public WebElement couponAmonut;

    @FindBy(xpath = "//*[@class='ui-datepicker-next ui-corner-all']")
    public WebElement nextMonth;

    @FindBy(xpath = "//*[@id='free_shipping']")
    public WebElement freeShipping;

    @FindBy(xpath = "//*[@id='show_on_store']")
    public WebElement showOnStore;

    @FindBy(xpath = "//*[@id='wcfm_coupon_manager_submit_button']")
    public WebElement addButtonSubmit;

    @FindBy(xpath = "//*[text()='Edit Coupon']")
    public WebElement editCoupon;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement description;



















































































































































































































































































































































































































































































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

    @FindBy(xpath = "(//a[text()='Add to cart'])[10]")
    public WebElement addToCart;//urunun altında yer alan add to chart

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkoutCart;//anasayfa sepetin(CART)ALTINDAKİ checkout

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstName;//BİLLİNG DETAİLS altındaki name









































































//murat
    













































































































































































































































































































    //murat
    @FindBy(xpath = "//input[@type='text']")
    public  WebElement username;

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
    public WebElement myAccountm ;

  //  @FindBy(xpath = "//*[@href=\"https://allovercommerce.com/store-manager/\"]")
   // public WebElement storeManager ;
    @FindBy(xpath = "//*[@class=\"icon-box-icon icon-orders\"]")
    public WebElement orderInMyaccount  ;//myaccount taki order butonu
    @FindBy(xpath = "//*[@href=\"https://allovercommerce.com/my-account-2/view-order/27008/\"]")
    public WebElement orderinFirstidNo  ;//myaccount taki order daki ilk urun id










}







