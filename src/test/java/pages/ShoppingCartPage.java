package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    //Summary section
    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedToCheckoutFromSummaryBtn;
    @FindBy(css = ".icon-trash")
    private WebElement trashIcon;
    @FindBy(css = "#cart_title")
    private WebElement cartTitle;
    @FindBy(css = ".alert-warning")
    private WebElement emptyShoppingCartWarningBanner;
    //Adress section
    @FindBy(css = "[cols]")
    private WebElement commentTextArea;
    @FindBy(css = "[action] .button-medium")
    private WebElement proceedToCheckoutFromAddressBtn;
    //Shipping section
    @FindBy(css = "tr td:nth-of-type(3)")
    private WebElement shippingInformationText;
    @FindBy(css = "#cgv")
    private WebElement termsOfServiceCheckbox;
    @FindBy(css = ".standard-checkout span")
    private WebElement proceedToCheckoutFromShippingBtn;
    //Payment section
    @FindBy(linkText = "Pay by bank wire (order processing will be longer)")
    private WebElement payByBankWireBtn;
    @FindBy(linkText = "Pay by check (order processing will be longer)")
    private WebElement payByCheckBtn;
    @FindBy(css = ".cheque-indent")
    private WebElement payByBankWireInformation;
    @FindBy(css = "#cart_navigation [type]")
    private WebElement acceptMyOrderBtn;
    //Order confirmation section
    @FindBy(css = ".cheque-indent .dark")
    private WebElement orderCompleteConfirmationText;


    public void proceedToCheckoutFromSummary() {
        proceedToCheckoutFromSummaryBtn.click();
    }

    public void addComment(String comment) {
        commentTextArea.sendKeys(comment);
    }

    public void proceedToCheckoutFromAddress() {
        proceedToCheckoutFromAddressBtn.click();
    }

    public String shippingInformation() {
        return shippingInformationText.getText();
    }

    public void acceptTermsOfService() {
        termsOfServiceCheckbox.click();
    }

    public void proceedToCheckoutFromShipping() {
        proceedToCheckoutFromShippingBtn.click();
    }

    public boolean payByBankWirePresent() {
        return payByBankWireBtn.isDisplayed();
    }
    public boolean payByCheckPresent() {
        return payByCheckBtn.isDisplayed();
    }

    public void selectPayByWire() {
        payByBankWireBtn.click();
    }

    public String payByBankWireInformation() {
        return payByBankWireInformation.getText();
    }

    public void acceptMyOrder() {
        acceptMyOrderBtn.click();
    }

    public String orderCompleteInformation() {
        return orderCompleteConfirmationText.getText();
    }

    public void deleteAnItem() {
        trashIcon.click();
        cartTitle.click();
    }
    
    public String emptyShoppingCartText() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return emptyShoppingCartWarningBanner.getText();
    }

    public String emptyShoppingCartBackgroundColour() {
        return emptyShoppingCartWarningBanner.getCssValue("background-color");
    }
}
