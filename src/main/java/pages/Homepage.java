package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends BasePage {
    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "div > h1 > small")
    public WebElement homepageHeaderText;

    @FindBy(css = "span > span > span > button")
    public WebElement loginIcon;

    @FindBy (css = "#responsive-navbar-nav > div:nth-child(2) > span > a:nth-child(1) > svg > path")
    public WebElement cartButtonLogo;

    @FindBy (css = "div:nth-child(1) > div > div.text-muted.text-center.card-footer > button:nth-child(2) > svg > path")
    public  WebElement addToCartButton1;

    @FindBy (css = "div:nth-child(2) > div > div.text-muted.text-center.card-footer > button:nth-child(2) > svg > path")
    public WebElement addToCartButton2;

    @FindBy (css = "a:nth-child(1) > span")
    public WebElement cartQuantity;

    @FindBy (css = "div:nth-child(1) > div > div.text-muted.text-center.card-footer > button:nth-child(3) > svg > path")
    public WebElement addToWishButton1;

    @FindBy (css = "a:nth-child(2) > svg > path")
    public WebElement wishlistLogo;

    @FindBy (css = "div:nth-child(1) > div > div.text-center.card-body > a")
    public WebElement homeFirstProductName;

    public void clickOnTheLoginIcon() {
        loginIcon.click();
    }

    public void clickOnTheCartButtonLogo(){
        cartButtonLogo.click();
    }

    public void clickOnAddToCartButton1(){
        addToCartButton1.click();
    }

    public void clickOnAddToCartButton2(){
        addToCartButton2.click();
    }

    public void clickOnTheWishlistLogo() { wishlistLogo.click();}

    public void clickOnAddToWishButton1() { addToWishButton1.click();}

}