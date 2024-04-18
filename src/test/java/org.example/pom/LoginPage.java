package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[2]/div[7]/div/form/div[1]/input")
    private WebElement emailInput;

    @FindBy(xpath = "/html/body/div[2]/div[7]/div/form/div[2]/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"new_user\"]/div[4]/input")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[2]/div[7]/div/form/div[1]/ul")
    public WebElement emailError;

    @FindBy(xpath = "/html/body/div[2]/div[7]/div/form/div[2]/ul")
    public WebElement passwordError;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
    }
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public boolean isEmailErrorDisplayed() {
        return emailError.isDisplayed();
    }
    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }
}