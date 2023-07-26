package testngTeam05.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testngTeam05.utilities.Driver;

public class AlloverCommercePage {
    public AlloverCommercePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    /*
    @FindBy(xpath = )
    public WebElement loginbuton;

     */








































































































































































































































































































































































































































































































































































































    // yusuf
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(css = "[id=username]")
    public WebElement signInUserNameOrEmail;

    @FindBy(css = "[id=password]")
    public WebElement signInPassword;

    @FindBy(css = "[name=login]")
    public WebElement signInButton;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement product;

    @FindBy(xpath = "(//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_product_manage moz_class'])[1]")
    public WebElement addNew;

    @FindBy(xpath = "//*[@class='page_collapsible_content_holder']")
    public WebElement liste;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[7]")
    public WebElement linked;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[8]")
    public WebElement seo;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[10]")
    public WebElement advenced;

    @FindBy(id = "pro_title")
    public WebElement productTitle;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElement selectFile;

    @FindBy(id = "featured_img_display")
    public WebElement featureImage;

    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement mediaLibrary;

    @FindBy(xpath = "//*[@id='__attachments-view-54']/li[3]/div/div")
    public WebElement mouseResmiFeature;

    @FindBy(xpath = "//*[@id='__wp-uploader-id-0']/div[4]/div/div[2]/button")
    public WebElement selectFeature;

    @FindBy(css = "img[id=gallery_img_gimage_0_display]")
    public WebElement galeryImage;

    @FindBy(xpath = "(//div[@class='thumbnail'])[8]")
    public WebElement mouseResmi;

    @FindBy(xpath = "(//*[text()='Add to Gallery'])[3]")
    public WebElement addToGalery;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[1]/input")
    public WebElement categoriesCheckbox;

    @FindBy(css = "[id=sku]")
    public WebElement sku;

    @FindBy(css = "[id=manage_stock]")
    public WebElement manageStockChecboxk;

    @FindBy(css = "[id=stock_qty]")
    public WebElement stockQty;

    @FindBy(css = "[id=sold_individually]")
    public WebElement soldIndividuallyChecboxk;

    @FindBy(css = "[id=wcfm_products_simple_submit_button]")
    public WebElement submitButton;

    @FindBy(xpath = "(//img[@class='attachment-thumbnail size-thumbnail'])[1]")
    public WebElement productMouse;

    @FindBy(xpath = "//*[text()='Team05']")
    public WebElement productSku;

    @FindBy(xpath = "//*[text()='Published']")
    public WebElement productStockStatus;

    @FindBy(xpath = "//*[text()=' (100)']")
    public WebElement productManageStock;


}
