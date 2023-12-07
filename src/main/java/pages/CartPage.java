package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "#root > div > div:nth-child(2) > div:nth-child(1) > div > div > div > h1 > small")
    public WebElement cartHeaderText;

    @FindBy (css = "div.text-center.container")
    public WebElement emptyCartText;

    @FindBy (css = "nav > a > svg > path")
    public WebElement greenBasketLogo;

    @FindBy (css = "a.btn.btn-danger")
    public WebElement continueShoppingButton;

    @FindBy (css = "a.btn.btn-success")
    public WebElement checkoutButton;

    @FindBy (css = "div:nth-child(5) > button > svg > path")
    public WebElement trashLogo;

    @FindBy (css = "tr:nth-child(1) > td:nth-child(1)")
    public WebElement itemsTotalText;

    @FindBy (css = "tr:nth-child(2) > td:nth-child(1)")
    public WebElement taxText;

    @FindBy (css = "tr:nth-child(3) > td:nth-child(1)")
    public WebElement totalText;

    @FindBy (css = "#item_1_title_link")
    public WebElement productText;

    @FindBy (css = "#root > div > div:nth-child(2) > div:nth-child(2) > div.row.row-cols-xl-1.row-cols-lg-1.row-cols-md-1.row-cols-sm-1.row-cols-1 > div > div > div > div:nth-child(1) > div > button:nth-child(1) > svg")
    public WebElement decreaseQtyButton;

    @FindBy (css = "#root > div > div:nth-child(2) > div:nth-child(2) > div.row.row-cols-xl-1.row-cols-lg-1.row-cols-md-1.row-cols-sm-1.row-cols-1 > div > div > div > div:nth-child(1) > div > button:nth-child(2) > svg")
    public WebElement increaseQtyButton;

    @FindBy (css = "div.row.row-cols-xl-1.row-cols-lg-1.row-cols-md-1.row-cols-sm-1.row-cols-1 > div > div > div > div:nth-child(2) > div")
    public WebElement itemPriceAmount;

    @FindBy (css = "div.row.row-cols-xl-1.row-cols-lg-1.row-cols-md-1.row-cols-sm-1.row-cols-1 > div > div > div > div:nth-child(3) > div")
    public WebElement itemTotalPriceAmount;

    public void clickOnTheGreenBasketLogo() {
        greenBasketLogo.click();
    }

    public void clickOnTheContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickOnTheCheckoutButton() {
        checkoutButton.click();
    }

    public void clickOnTheTrashLogo() {
        trashLogo.click();
    }

    public void clickOnTheProductText(){
        productText.click();
    }

    public void clickOnDecreaseQtyButton(){
        decreaseQtyButton.click();
    }

    public void clickOnIncreaseQtyButton(){
        increaseQtyButton.click();
    }


}

