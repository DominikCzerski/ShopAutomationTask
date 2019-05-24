package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    WebDriver driver;

    public SearchPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    //Searched items
    @FindBy(css = "li:nth-of-type(1) .product-image-container")
    private WebElement firstAvailableProduct;
    @FindBy(css = "li:nth-of-type(2) .product-image-container")
    private WebElement secondAvailableProduct;
    @FindBy(css = "li:nth-of-type(3) .product-image-container")
    private WebElement thirdAvailableProduct;

    //Searched item overview
    @FindBy(linkText = "Add to cart")
    private WebElement addToCartBtn;

    //Added to cart modal
    @FindBy(className = "layer_cart_overlay")
    private WebElement modalClose;
    @FindBy(css = "[class='layer_cart_product col-xs-12 col-md-6'] h2")
    private WebElement productAddedToShoppingCartText;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedToCheckoutBtn;


    public void addFirstItemToShoppingCart() {
        addItemToShoppingCart(firstAvailableProduct);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        modalClose.click();
        }


   public void addSecondItemToShoppingCart() {
        addItemToShoppingCart(secondAvailableProduct);
    }

    public void addThirdItemToShoppingCart() {
        addItemToShoppingCart(thirdAvailableProduct);
    }

    private void addItemToShoppingCart(WebElement product) {
        Actions hoverOverItem = new Actions(driver);
        hoverOverItem.moveToElement(product).build().perform();
        addToCartBtn.click();
    }


    public String successfullyAddedItemText() {
        return productAddedToShoppingCartText.getText();
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }


}
