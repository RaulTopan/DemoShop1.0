package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver; //a chemat clasa driver driver


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // initializare chrome dirver
    }
}