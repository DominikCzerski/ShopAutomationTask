package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LandingPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

class ItemDeletionTest extends BaseTest{

    @Test
    @DisplayName("Verification of deleting item from shopping cart")
    void verifySuccessfulItemDeleting() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.searchFor("blouse");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.addFirstItemToShoppingCart();
        searchPage.proceedToCheckout();
        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.deleteAnItem();
        //the assertion couldn't find an element, used assertions with wait = Awaitility
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->assertThat(shoppingCart.emptyShoppingCartText()).isEqualTo("Your shopping cart is empty."));
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->assertThat(shoppingCart.emptyShoppingCartBackgroundColour()).isEqualTo("rgba(254, 145, 38, 1)"));
    }
}
