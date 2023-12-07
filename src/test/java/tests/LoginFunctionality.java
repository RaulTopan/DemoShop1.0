package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginFunctionality extends BaseTest { // conexiune la basetest pentru before and after methods

    @Test
    public void validateLoginCredentials() {
        // Instantiate page objects and perform test actions here
        Homepage homePage = new Homepage(driver);
        homePage.clickOnTheLoginIcon();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("Error: Username field is not displayed", loginPage.usernameInput.isDisplayed());
        Assert.assertTrue("Error: Password field is not displayed", loginPage.passwordInput.isDisplayed());
        Assert.assertTrue("Error: Login button is not displayed", loginPage.loginButton.isDisplayed());
    }

    @Test
    public void loginHappyFlow() {
        // Instantiate page objects and perform test actions here
        Homepage homepage = new Homepage(driver);
        homepage.clickOnTheLoginIcon();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("dino");
        loginPage.enterPassword("choochoo");
        loginPage.clickLoginButton();
        Assert.assertTrue("Error: Login has failed.", loginPage.validLoginText.isDisplayed());
        Assert.assertEquals("Error: Login has failed.", "Hi dino!", loginPage.validLoginText.getText());
    }


    @Test
    public void validateIncorrectCredentials() {
        Homepage homepage = new Homepage(driver);
        homepage.clickOnTheLoginIcon();

        String errorMessageInvalidCredentials = "Incorrect username or password!";
        LoginPage loginPage = new LoginPage(driver); //am initializat clasa ca sa pot folosi obiectelul loginPage si sa folosesc elementele din LoginPage
        loginPage.enterUsername("dino1");
        loginPage.enterPassword("choochoo");
        loginPage.clickLoginButton();
        Assert.assertTrue("Error: Element should be displayed.", loginPage.invalidLoginTextError.isDisplayed());
        Assert.assertEquals("Error: Text is incorrect displayed", errorMessageInvalidCredentials, loginPage.invalidLoginTextError.getText());
    }

    @Test
    public void checkLogoutFunctionality() {
        // Instantiate page objects and perform test actions here
        Homepage homepage = new Homepage(driver);
        homepage.clickOnTheLoginIcon();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("dino");
        loginPage.enterPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.clickLogoutButton();
        Assert.assertTrue("Error: Element missing.", loginPage.validLoginText.isDisplayed());
        Assert.assertEquals("Error: Logout has failed.", "Hello guest!", loginPage.validLoginText.getText());
    }

    @Test
    public void checkUsernameValidationError() {
        Homepage homepage = new Homepage(driver);
        homepage.clickOnTheLoginIcon();
        String usernameValidationErrorMessage = "Please fill in the username!";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        Assert.assertEquals("Error: Validation error message is incorrectly displayed.", usernameValidationErrorMessage,
                loginPage.usernameValidationErrorMessageText.getText());
    }

    @Test
    public void checkPasswordValidationError() {
        Homepage homepage = new Homepage(driver);
        homepage.clickOnTheLoginIcon();
        String passwordValidationErrorMessage = "Please fill in the password!";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("dino");
        loginPage.clickLoginButton();
        Assert.assertEquals("Error: Validation error message is incorrectly displayed.", passwordValidationErrorMessage,
                loginPage.passwordValidationErrorMessageText.getText());
    }

    @Test
    public void checkLoginFormCloseButtonFunctionality() {
        Homepage homepage = new Homepage(driver);
        homepage.clickOnTheLoginIcon();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("Error: Login form should not be displayed.", loginPage.loginForm.isDisplayed());
        loginPage.clickCloseButtonOnLoginForm();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("Error: Logout has failed.", "Hello guest!", loginPage.validLoginText.getText());
        try {
            //NoSuchElementException
            Assert.assertFalse("Error: Login form should not be displayed.", loginPage.loginForm.isDisplayed());
        } catch (Exception e){
            e.printStackTrace(); // TODO find a different solution
        }
    }
}
