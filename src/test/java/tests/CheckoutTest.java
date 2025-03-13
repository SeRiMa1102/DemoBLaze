package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
    @Test
    private void checkoutFull() {
        loginPage.open();
        loginPage.login("RinatTest", "password");
        Assert.assertTrue(loginPage.getUserName("RinatTest"));

        loginPage.openProductPage("Samsung galaxy s6");

        productPage.pressToCart();
        productPage.getAddedSuccessMessage();
        productPage.openCart();
//
        cartPage.placeOrder();
        cartPage.fillOrderAndPress();
        Assert.assertEquals(cartPage.resultMessage(), "Thank you for your purchase!");
    }
}
