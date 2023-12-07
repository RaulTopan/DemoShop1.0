package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage {
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div > h1 > small")
    public WebElement wishlistHeaderText;

    @FindBy (css = "div.text-center.card-body > a")
    public WebElement wishFirstProductName;

    @FindBy (css = "div.text-muted.text-center.card-footer > button:nth-child(2) > svg > path")
    public WebElement addToCartButtonWish;

    public void clickOnTheAddToCartButtonWish() { addToCartButtonWish.click();}
}







