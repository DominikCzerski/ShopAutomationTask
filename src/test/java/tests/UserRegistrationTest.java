package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.LandingPage;

import static org.assertj.core.api.Assertions.assertThat;

class UserRegistrationTest extends BaseTest {

    @Test
    @DisplayName("Verification of successful user registration")
    void verifySuccessfulUserRegistration() {
        LandingPage landingPage = new LandingPage(driver);
        assertThat(landingPage.logoPresent()).isTrue();
        landingPage.signIn();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.pasteEmail();
        authenticationPage.acceptCreateAccount();
        CreateAnAccountPage createAnAccount = new CreateAnAccountPage(driver);
        createAnAccount.fillThePersonalInfo("CustomerName", "CustomerLastName", "CustomerPassword", "8", 8, 26);
        assertThat(createAnAccount.nameAndLastNameCopied()).isTrue(); //After typing firstName and lastName registration form automatically adds the same info to the (name, last name) inputs below
        createAnAccount.fillPrimaryAddressInfo("CustomerCompany" , "Lubelska", 15);
        createAnAccount.fillSecondaryAddressInfo("CustomerCityName", "Arizona", 50000, 1, "AdditionalInfo", 726527267);
        createAnAccount.acceptRegistration();
        assertThat(createAnAccount.getMyAccountInfoListLabels()).isEqualTo(createAnAccount.actualAccountInfoList);
        landingPage.signOut();

    }
}
