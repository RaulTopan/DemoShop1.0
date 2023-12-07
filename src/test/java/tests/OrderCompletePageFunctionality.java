package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

public class OrderCompletePageFunctionality extends BaseTest {

    @Test
    public void checkContinueShoppingButtonFunctionality(){
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SummaryPage summaryPage = new SummaryPage(driver);
        OrderCompletePage orderCompletePage = new OrderCompletePage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        checkoutPage.firstNameText.sendKeys("dino");
        checkoutPage.lastNameText.sendKeys("dino");
        checkoutPage.addressText.sendKeys("Cluj");
        checkoutPage.ClickOnTheContinueCheckoutButton();
        summaryPage.ClickOnCompleteYourOrderButton();
        orderCompletePage.ClickOnContinueShoppingButton();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("Error: You are not on Homepage.", currentURL.contains("fasttrackit-test.netlify.app/#/"));
        Assert.assertTrue("Error: You are not on the Homepage.", homePage.addToCartButton1.isDisplayed());
        Assert.assertTrue("Error: You are not on the Homepage.", homePage.addToCartButton2.isDisplayed());
        Assert.assertTrue("Error: You are not on the Homepage.", homePage.loginIcon.isDisplayed());
        Assert.assertTrue("Error: You are not on the Homepage.", homePage.cartButtonLogo.isDisplayed());
        Assert.assertTrue("Error: You are not on the Homepage.", homePage.homepageHeaderText.isDisplayed());
        Assert.assertTrue("Error: You are not on the Homepage.", homePage.addToWishButton1.isDisplayed());
    }
}
