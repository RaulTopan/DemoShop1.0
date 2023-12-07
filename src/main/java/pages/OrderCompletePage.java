package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;


public class OrderCompletePage extends BasePage {
    public OrderCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "div > h1 > small")
    public WebElement orderCompletePageHeader;

    @FindBy (css = "div:nth-child(2) > div.text-center")
    public WebElement orderCompletedMessage;

    @FindBy (css = "div:nth-child(2) > a")
    public WebElement continueShoppingButton;

    public void ClickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }


}
