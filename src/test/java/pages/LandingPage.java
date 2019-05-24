package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LandingPage {

    WebDriver driver;

    public LandingPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    //Automation practice logo
    @FindBy(css = "[alt='My Store']")
    private WebElement automationPracticeLogo;
    //Landing header
    @FindBy(linkText = "Sign in")
    private WebElement signInBtn;
    @FindBy(linkText = "Sign out")
    private WebElement signOutBtn;
    //Search
    @FindBy(id = "search_query_top")
    private WebElement searchInput;
    @FindBy(name = "submit_search")
    private WebElement searchAcceptBtn;
    //Shopping cart
    @FindBy(css = "[title='View my shopping cart']")
    private WebElement shoppingCart;

    public boolean logoPresent() {
        return automationPracticeLogo.isDisplayed();
    }

    public void signIn() {
        signInBtn.click();
    }

    public void signOut() {
        signOutBtn.click();
    }

    public void searchFor(String searchItem) {
        searchInput.sendKeys(searchItem);
        searchAcceptBtn.click();
    }




}
