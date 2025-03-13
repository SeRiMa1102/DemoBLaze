package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    public static final By ADD_TO_CART_AREA = By.xpath("//a[text()='Add to cart']");
    public static final By CART_AREA = By.id("cartur");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Cart product")
    public ProductPage pressToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(ADD_TO_CART_AREA));
        driver.findElement(ADD_TO_CART_AREA).click();
        return this;
    }

    @Step("Open page CartPage")
    public CartPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(CART_AREA));
        driver.findElement(CART_AREA).click();
        return new CartPage(driver);
    }

    @Step("Get alert text after added to cart")
    public String getAddedSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
