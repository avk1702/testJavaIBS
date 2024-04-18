package org.example.tests;

import org.example.pom.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UITest extends BaseTest {

    @Test
    void testGBNotEmailLogin() throws InterruptedException {
        driver.get("https://gb.ru/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.enterEmail("login");
        loginPage.enterPassword("password");
        loginPage.clickLoginButton();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOf(loginPage.emailError));
        Assertions.assertTrue(loginPage.isEmailErrorDisplayed());
    }

    @Test
    void testGBWithoutPassword() throws InterruptedException {
        driver.get("https://gb.ru/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.enterEmail("login@login.ru");
        loginPage.clickLoginButton();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordError));
        Assertions.assertTrue(loginPage.isPasswordErrorDisplayed());
    }
}