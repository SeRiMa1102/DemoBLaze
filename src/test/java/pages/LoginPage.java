package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By LOGIN_AREA = By.id("login2");
    private static final By USER_FIELD = By.id("loginusername");
    private static final By USER_PASSWORD = By.id("loginpassword");
    private static final By LOGIN_BUTTON = By.cssSelector("[onclick=\"logIn()\"]");

    private static final By SIGNUP_AREA = By.id("signin2");
    private static final By USER_SIGN_FIELD = By.id("sign-username");
    private static final By PASSWORD_SIGN_FIELD = By.id("sign-password");
    private static final By SIGNUP_BUTTON = By.cssSelector("[onclick=\"register()\"]");
    private static final By LOGINACCES_ITEM = By.id("nameofuser");

    private static final String DEVICE_AREA = "//a[text()='%s']";

    @Step("Open main page")
    public LoginPage open () {
        log.info("Open main page");
        driver.get("https://www.demoblaze.com/");
        return this;
    }

    @Step("Log In: login - {user}, password - {password}")
    public LoginPage login(String user, String password) {
        log.info("Log In: login - {}, password - {}", user, password);

        driver.findElement(LOGIN_AREA).click();
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(USER_PASSWORD).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Sign Up: login - {user}, password - {password}")
    public LoginPage signUp(String user, String password) {
        log.info("Sign Up: login - {}, password - {}", user, password);

        driver.findElement(SIGNUP_AREA).click();
        driver.findElement(USER_SIGN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_SIGN_FIELD).sendKeys(password);
        driver.findElement(SIGNUP_BUTTON).click();
        return this;
    }
    @Step("Get error message from login page")
    public String getErrorMessage() {
        log.info("Get error message from login page");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    @Step("Check login with name = {input} successful")
    public boolean getUserName(String input) {
        log.info("Check login with name = {} successful", input);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(LOGINACCES_ITEM));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(LOGINACCES_ITEM, "Welcome " + input));
        String text = driver.findElement(LOGINACCES_ITEM).getText();
        return true;
    }

    @Step("Open page ProductPage")
    public ProductPage openProductPage(String product) {
        log.info("Open page ProductPage - {}", product);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.refreshed(
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Samsung galaxy s6']"))
//        ));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(DEVICE_AREA, product))));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight / 2)");
//        System.out.println(String.format(DEVICE_AREA, product));
        driver.findElement(By.xpath(String.format(DEVICE_AREA, product))).click();
        return new ProductPage(driver);
    }
}
