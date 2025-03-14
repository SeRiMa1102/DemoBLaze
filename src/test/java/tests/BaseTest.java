package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ProductPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    LoginPage loginPage;
    CartPage cartPage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notification");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
