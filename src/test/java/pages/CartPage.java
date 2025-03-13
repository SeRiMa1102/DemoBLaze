package pages;

import io.qameta.allure.Step;
import models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    private static final By PLACE_ORDER_AREA = By.xpath("//button[text()='Place Order']");

    private static final By NAME_AREA = By.id("name");
    private static final By COUNTRY_AREA = By.id("country");
    private static final By CITY_AREA = By.id("city");
    private static final By CARD_AREA = By.id("card");
    private static final By MONTH_AREA = By.id("month");
    private static final By YEAR_AREA = By.id("year");

    private static final By PURCHASE_AREA = By.xpath("//button[@onclick=\"purchaseOrder()\"]");
    private static final By RESULT_AREA = By.xpath("//div[@data-animation]//h2");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click purchase button")
    public CartPage placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(PLACE_ORDER_AREA));
        driver.findElement(PLACE_ORDER_AREA).click();
        return new CartPage(driver);
    }

    @Step("Fill order form")
    public void fillOrderAndPress(Customer customer) {
        driver.findElement(NAME_AREA).sendKeys(customer.getFirstName());
        driver.findElement(COUNTRY_AREA).sendKeys(customer.getCountry());
        driver.findElement(CITY_AREA).sendKeys(customer.getCity());
        driver.findElement(CARD_AREA).sendKeys(customer.getCard());
        driver.findElement(MONTH_AREA).sendKeys(customer.getMonth());
        driver.findElement(YEAR_AREA).sendKeys(customer.getYear());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(PURCHASE_AREA));
        driver.findElement(PURCHASE_AREA).click();
    }

    @Step("Return result of transaction message")
    public String resultMessage() {
        return driver.findElement(RESULT_AREA).getText();
    }
}
