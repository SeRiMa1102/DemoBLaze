package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Link;
import models.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        Customer customer = Customer.builder()
                .firstName("Rinat")
                .country("Russia")
                .city("Moscow")
                .card("109004")
                .month("11")
                .year("2025")
                .build();

        productPage.openCart().placeOrder().fillOrderAndPress(customer);
        Assert.assertEquals(cartPage.resultMessage(), "Thank you for your purchase!");
    }
}
