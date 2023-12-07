package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "div > h1 > small")
    public WebElement checkoutTitle;

    @FindBy (css = "div:nth-child(1) > div.section-title")
    public WebElement addressInformationText;

    @FindBy (css = "div.justify-content-between.row > div:nth-child(2) > div:nth-child(1)")
    public WebElement deliveryInformationText;

    @FindBy (css = "div.justify-content-between.row > div:nth-child(2) > div:nth-child(3)")
    public WebElement paymentInformationText;

    @FindBy (css = "div:nth-child(2) > a")
    public WebElement cancelButton;

    @FindBy (css = "form > div > div:nth-child(2) > button")
    public WebElement continueCheckoutButton;

    @FindBy (css = "div:nth-child(2) > p")
    public WebElement firstNameRestrictionText;

    @FindBy (css = "#first-name")
    public WebElement firstNameText;

    @FindBy (css = "#last-name")
    public WebElement lastNameText;

    @FindBy (css = "#address")
    public WebElement addressText;

    @FindBy (css = "div:nth-child(2) > p")
    public WebElement lastNameRestrictionText;

    @FindBy (css = "div:nth-child(2) > p")
    public WebElement addressRestrictionText;

    public void ClickOnTheCancelButton(){
        cancelButton.click();
    }

    public void ClickOnTheContinueCheckoutButton(){
        continueCheckoutButton.click();
    }


}
