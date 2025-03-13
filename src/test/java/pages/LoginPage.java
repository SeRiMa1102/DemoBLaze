package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private static final By USERSIGN_FIELD = By.id("sign-username");
    private static final By PASSWORDSIGN_FIELD = By.id("sign-password");
    private static final By SIGNUP_BUTTON = By.cssSelector("[onclick=\"register()\"]");
    private static final By LOGINACCES_ITEM = By.id("nameofuser");

    private static final String DEVICE_AREA = "//a[text()='%s']";

    public void open () {
        driver.get("https://www.demoblaze.com/");
    }

    public void login(String user, String password) {
        driver.findElement(LOGIN_AREA).click();
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(USER_PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void signUp(String user, String password) {
        driver.findElement(SIGNUP_AREA).click();
        driver.findElement(USERSIGN_FIELD).sendKeys(user);
        driver.findElement(PASSWORDSIGN_FIELD).sendKeys(password);
        driver.findElement(SIGNUP_BUTTON).click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public boolean getUserName(String input) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(LOGINACCES_ITEM));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(LOGINACCES_ITEM, "Welcome " + input));

        String text = driver.findElement(LOGINACCES_ITEM).getText();
        System.out.println("Обновленный текст элемента: " + text);
        return true;
    }

    public void openProductPage(String product) {
        driver.findElement(By.xpath(String.format(DEVICE_AREA, product))).click();
    }
}
