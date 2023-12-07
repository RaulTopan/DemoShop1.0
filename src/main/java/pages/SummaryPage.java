package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SummaryPage extends BasePage {
    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "div > h1 > small")
    public WebElement summaryTitle;

    @FindBy (css = "div:nth-child(2) > div.row > div:nth-child(1) > div:nth-child(1)")
    public WebElement paymentInformationText;

    @FindBy (css = "div.row > div:nth-child(1) > div:nth-child(2)")
    public WebElement cashOnDeliveryText;

    @FindBy (css = "div.row > div:nth-child(1) > div:nth-child(3)")
    public WebElement shippingInformationText;

    @FindBy (css = "div:nth-child(1) > div:nth-child(4)")
    public WebElement chooChooDeliveryText;

    @FindBy (css = "tr.amount-total > td:nth-child(1)")
    public WebElement totalAmountText;

    @FindBy (css = "a.btn.btn-danger")
    public WebElement cancelButton;

    @FindBy (css = "tr:nth-child(1) > td.amount")
    public WebElement itemsTotalPrice;

    @FindBy (css = "tr:nth-child(2) > td.amount")
    public WebElement taxPrice;

    @FindBy (css = "tr.amount-total > td.amount")
    public WebElement totalPrice;

    @FindBy (css = "div:nth-child(2) > a.btn.btn-success")
    public WebElement completeYourOrderButton;


    public void ClickOnCancelButton(){
        cancelButton.click();
    }

    public void ClickOnCompleteYourOrderButton(){
        completeYourOrderButton.click();
    }








}