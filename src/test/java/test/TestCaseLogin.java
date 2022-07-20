package test;

import core.BaseTest;
import org.testng.Assert;
import page.LoginPage;

public class TestCaseLogin extends BaseTest {
    public void TC01_LoginFailWhenInputWrongEmail() {
        LoginPage loginPage = new LoginPage(getDriver());
        //Go to LoginPage
        loginPage.navigateToLogin("url");
        //Enter a not existing email
        loginPage.inputEmail("345jfjf@gmail.com");
        //Enter password
        loginPage.inputPassword("23342@44545");
        loginPage.clickLoginButton();
        //Verify error message
        Assert.assertTrue(loginPage.verifyErrorEmail("The inputted email or password is not correct"));

    }

    public void TC02_LoginFailWhenInputWrongPass() {
        LoginPage loginPage = new LoginPage(getDriver());
        //Go to LoginPage
        loginPage.navigateToLogin("url");
        //Enter a correct email
        loginPage.inputEmail("trang@gmail.com");
        //Enter wrong password
        loginPage.inputPassword("jgkdkd@44545");
        loginPage.clickLoginButton();
        //Verify error message
        Assert.assertTrue(loginPage.verifyErrorPassword("The inputted email or password is not correct"));

    }

    public void TC02_LoginSuccess() {
        LoginPage loginPage = new LoginPage(getDriver());
        //Go to LoginPage
        loginPage.navigateToLogin("url");
        //Enter a correct email
        loginPage.inputEmail("trang@gmail.com");
        //Enter correct password
        loginPage.inputPassword("Jpg@1234567");
        loginPage.clickLoginButton();
        //Verify Welcome Page
        Assert.assertTrue(loginPage.verifySuccessMessage("You have logged-in successfully!"));

    }
}
