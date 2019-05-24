package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AuthenticationPage extends BasePage{

    WebDriver driver;

    public AuthenticationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    //Create an account
    @FindBy(id = "email_create")
    private WebElement emailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountBtn;
    //Already registered
    @FindBy(id = "email")
    private WebElement signInEmailInput;
    @FindBy(id = "passwd")
    private WebElement singInPasswordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    public void pasteEmail() {
        randomNumber();
        emailInput.sendKeys("username" + randomNumber() + "@gmail.com");
    }

    public void acceptCreateAccount() {
        createAnAccountBtn.submit();
    }

    public String emailInputBackgroundColour() {
        return emailInput.getCssValue("background-color");
    }

    public void signIn(String email, String password) {
        signInEmailInput.sendKeys(email);
        singInPasswordInput.sendKeys(password);
        signInBtn.click();
    }
}
