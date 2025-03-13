package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    private static By PLACE_ORDER_AREA = By.xpath("//button[text()='Place Order']");

    private static By NAME_AREA = By.id("name");
    private static By COUNTRY_AREA = By.id("country");
    private static By CITY_AREA = By.id("city");
    private static By CARD_AREA = By.id("card");
    private static By MONTH_AREA = By.id("month");
    private static By YEAR_AREA = By.id("year");

    private static By PURCHASE_AREA = By.xpath("//button[@onclick=\"purchaseOrder()\"]");
    private static By RESULT_AREA = By.xpath("//div[@data-animation]//h2");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(PLACE_ORDER_AREA));
        driver.findElement(PLACE_ORDER_AREA).click();
    }

    public void fillOrderAndPress() {
        driver.findElement(NAME_AREA).sendKeys("Rinat");
        driver.findElement(COUNTRY_AREA).sendKeys("Russia");
        driver.findElement(CITY_AREA).sendKeys("Moscow");
        driver.findElement(CARD_AREA).sendKeys("109004");
        driver.findElement(MONTH_AREA).sendKeys("11");
        driver.findElement(YEAR_AREA).sendKeys("2025");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(PURCHASE_AREA));
        driver.findElement(PURCHASE_AREA).click();
    }

    public String resultMessage() {
        return driver.findElement(RESULT_AREA).getText();
    }
}
