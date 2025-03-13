package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
    @Test
    @Link("https://www.demoblaze.com/")
    @Flaky
    @Description("All tests")
    public void checkoutFull() {
        String str = "RinatTest";
        String product = "Samsung galaxy s6";
        Assert.assertTrue(loginPage.open().login(str, "password").getUserName(str));

        Assert.assertNotEquals(loginPage.openProductPage(product).pressToCart().getAddedSuccessMessage(), "");
        productPage.openCart().placeOrder().fillOrderAndPress();
        Assert.assertEquals(cartPage.resultMessage(), "Thank you for your purchase!");
    }
}
