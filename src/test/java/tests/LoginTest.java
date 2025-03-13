package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void checkNegativeLoginBeforeSigningInFull() {
        loginPage.open();
//        loginPage.login("sss", "test");
//        Assert.assertEquals(loginPage.getErrorMessage(), "Wrong password.");
    }

    @Test
    public void checkNegativeLoginBeforeSigningInZeroName() {
        loginPage.open();
        loginPage.login("", "test");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please fill out Username and Password.");
    }

    @Test
    public void checkNegativeLoginBeforeSigningInZeroPassword() {
        loginPage.open();
        loginPage.login("sss", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please fill out Username and Password.");
    }

    @Test
    public void checkNegativeLoginBeforeSigningInEmpty() {
        loginPage.open();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please fill out Username and Password.");
    }

//    @Test
//    public void checkPositiveSignUp() {
//        loginPage.open();
//        loginPage.signUp("RinatTest", "password");
//        Assert.assertEquals(loginPage.getErrorMessage(), "Sign up successful.");
//    }

    @Test
    public  void checkNegativeSignUp() {
        loginPage.open();
        //test in ci!!!
        loginPage.signUp("RinatTest", "1234");
        Assert.assertEquals(loginPage.getErrorMessage(), "This user already exist.");
    }

    @Test
    public void checkNegativeLoginAfterSigningInWrongPassword() {
        loginPage.open();
        loginPage.login("RinatTest", "1234");
        Assert.assertEquals(loginPage.getErrorMessage(), "Wrong password.");
    }

    @Test
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("RinatTest", "password");
        Assert.assertTrue(loginPage.getUserName("RinatTest"));
    }
}
