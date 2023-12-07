package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css="body > div.fade.modal.show > div > div")
    public WebElement loginForm;

    @FindBy(css = "#user-name")
    public WebElement usernameInput; // folosit la randul 23 prin actiunea sendkeys

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(css = "body > div.fade.modal.show > div > div > div.login_wrapper > div > form > button")
    public WebElement loginButton;

    @FindBy(css = "#responsive-navbar-nav > div:nth-child(2) > span > span > button > svg")
    public WebElement logoutButton;

    @FindBy(css = "body > div.fade.modal.show > div > div > div.login_wrapper > div > form > p")
    public WebElement invalidLoginTextError;

    @FindBy(css = "#responsive-navbar-nav > div:nth-child(2) > span > span > span")
    public WebElement validLoginText;

    @FindBy(css = "body > div.fade.modal.show > div > div > div.login_wrapper > div > form > p")
    public WebElement usernameValidationErrorMessageText;

    @FindBy(css = "body > div.fade.modal.show > div > div > div.login_wrapper > div > form > p")
    public WebElement passwordValidationErrorMessageText;

    @FindBy(css = "body > div.fade.modal.show > div > div > div.modal-header > button > span:nth-child(1)")
    public WebElement loginFormCloseButton;

    //Methods
    public void clickCloseButtonOnLoginForm() {
        loginFormCloseButton.click();
    }
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogoutButton() { logoutButton.click();}
}
