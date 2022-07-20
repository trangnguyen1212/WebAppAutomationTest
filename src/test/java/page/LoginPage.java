package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "txtEmail")
    private WebElement email;
    @FindBy(id = "txtPassword")
    private WebElement password;
    @FindBy(id = "lblEmailErr")
    private WebElement errorEmail;
    @FindBy(xpath = "lblPasswordErr")
    private WebElement errorPassword;
    @FindBy(xpath = "btnLogin")
    private WebElement loginButton;
    @FindBy(xpath = "lblLoggedinSuccessfully")
    private WebElement loginSuccess;

    public void navigateToLogin(String url) {
        getDriver().get(url);
    }

    //Input email
    public void inputEmail(String emailText) {
        email.sendKeys(emailText);
    }

    //Input password
    public void inputPassword(String passwordText) {
        password.sendKeys(passwordText);
    }

    public boolean verifyErrorEmail(String errorMessage) {
        getWait().until(ExpectedConditions.visibilityOf(errorEmail));
        return errorEmail.getText().contains(errorMessage);
    }

    public boolean verifyErrorPassword(String errorMessage) {
        getWait().until(ExpectedConditions.visibilityOf(errorPassword));
        return errorPassword.getText().contains(errorMessage);
    }

    public void clickLoginButton () {
        getWait().until(ExpectedConditions.visibilityOf(loginButton)).click();
    }
    public boolean verifySuccessMessage(String successMessage) {
        getWait().until(ExpectedConditions.visibilityOf(loginSuccess));
        return loginSuccess.getText().contains(successMessage);
    }
}
