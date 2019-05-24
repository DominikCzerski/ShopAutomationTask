package pages;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CreateAnAccountPage extends BasePage{

    WebDriver driver;

    public CreateAnAccountPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    //Personal information
    @FindBy(id = "id_gender1")
    private WebElement maleRadioBtn;
    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private WebElement dayOfBirth;
    @FindBy(id = "months")
    private WebElement monthOfBirth;
    @FindBy(id = "years")
    private WebElement yearOfBirth;
    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(name = "optin")
    private WebElement specialOffersCheckbox;
    //Your address
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "company")
    private WebElement companyNameInput;
    @FindBy(id = "address1")
    private WebElement addressLine1Input;
    @FindBy(id = "address2")
    private WebElement addressLine2Input;
    @FindBy(css = "#city")
    private WebElement cityNameInput;
    @FindBy(id = "id_state")
    private WebElement stateNameSelect;
    @FindBy(css = "#postcode")
    private WebElement zipCodeInput;
    @FindBy(id = "id_country")
    private WebElement countryNameSelect;
    @FindBy(id = "other")
    private WebElement additionalInfoInput;
    @FindBy(xpath = "/html//input[@id='phone']")
    private WebElement homePhoneInput;
    @FindBy(xpath = "/html//input[@id='phone_mobile']")
    private WebElement mobilePhoneInput;
    @FindBy(xpath = "/html//input[@id='alias']")
    private WebElement addressAliasInput;
    @FindBy(id = "submitAccount")
    private WebElement registerBtn;
    //My account
    @FindBy(css = "[class='col-xs-12 col-sm-6 col-lg-4']:nth-of-type(1) .myaccount-link-list")
    private List<WebElement> myAccountInfoList;


    public void fillThePersonalInfo(String firstName, String lastName, String password, String dayValue, int monthIndex, int yearIndex) {
        maleRadioBtn.click();
        customerFirstNameInput.sendKeys(firstName);
        customerLastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        Select drpDays = new Select(dayOfBirth);
        drpDays.selectByValue(dayValue);
        Select drpMonths = new Select(monthOfBirth);
        drpMonths.selectByIndex(monthIndex);
        Select drpYears = new Select(yearOfBirth);
        drpYears.selectByIndex(yearIndex);
        newsletterCheckbox.click();
        specialOffersCheckbox.click();
    }

    public void fillPrimaryAddressInfo(String companyName, String addressLine1, int addressLine2) {
        companyNameInput.sendKeys(companyName);
        addressLine1Input.sendKeys(addressLine1);
        addressLine2Input.sendKeys(String.valueOf(addressLine2));
    }

    public boolean nameAndLastNameCopied() {
        return (firstNameInput.getText().equals(customerFirstNameInput.getText()) && lastNameInput.getText().equals(customerLastNameInput.getText()));

    }


    public void fillSecondaryAddressInfo(String cityName, String stateName, int zipCode, int countryIndex, String additionalInfo, int phoneNumber) {
        cityNameInput.sendKeys(cityName);
        Select drpState = new Select(stateNameSelect);
        drpState.selectByVisibleText(stateName);
        zipCodeInput.sendKeys(String.valueOf(zipCode));
        Select drpCountry = new Select(countryNameSelect);
        drpCountry.selectByIndex(countryIndex);
        additionalInfoInput.sendKeys(additionalInfo);
        homePhoneInput.sendKeys(String.valueOf(phoneNumber));
        mobilePhoneInput.sendKeys(String.valueOf(phoneNumber));
        addressAliasInput.clear();
        addressAliasInput.sendKeys(("username" + randomNumber() + "@gmail.com"));
    }

    public void acceptRegistration() {
        registerBtn.click();
    }

    public List<String> getMyAccountInfoListLabels() {
        List<String> labelList = new ArrayList<>();
        for (WebElement webElement : myAccountInfoList) {
            labelList.add(webElement.getText());
        }
        return labelList;
    }

    public List<String> actualAccountInfoList = ImmutableList.of("ORDER HISTORY AND DETAILS\n" +
            "MY CREDIT SLIPS\n" +
            "MY ADDRESSES\n" +
            "MY PERSONAL INFORMATION");

    }


