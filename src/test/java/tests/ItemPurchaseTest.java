package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.LandingPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

import static org.assertj.core.api.Assertions.assertThat;

class ItemPurchaseTest extends BaseTest {

    @Test
    @DisplayName("Verification of multiple dresses purchase")
    void verifySuccessfulItemsPurchase() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.searchFor("dress");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.addFirstItemToShoppingCart();
        assertThat(searchPage.successfullyAddedItemText()).isEqualTo("Product successfully added to your shopping cart");
        searchPage.addSecondItemToShoppingCart();
        searchPage.addThirdItemToShoppingCart();
        searchPage.proceedToCheckout();
        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.proceedToCheckoutFromSummary();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn("test22345@se.pl", "tVgi7c5CXudCuY4");
        shoppingCart.addComment("I would like to add this comment to the comment section and it is at least 128 alphanumeric sentence checking if fieldis correct");
        shoppingCart.proceedToCheckoutFromAddress();
        assertThat(shoppingCart.shippingInformation()).isEqualTo("My carrier Delivery next day!");
        shoppingCart.acceptTermsOfService();
        shoppingCart.proceedToCheckoutFromShipping();
        assertThat(shoppingCart.payByBankWirePresent()).isTrue();
        assertThat(shoppingCart.payByCheckPresent()).isTrue();
        shoppingCart.selectPayByWire();
        assertThat(shoppingCart.payByBankWireInformation()).isEqualTo("You have chosen to pay by bank wire. Here is a short summary of your order:");
        shoppingCart.acceptMyOrder();
        assertThat(shoppingCart.orderCompleteInformation()).isEqualTo("Your order on My Store is complete.");
    }
}
