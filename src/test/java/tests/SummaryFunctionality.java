package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SummaryFunctionality extends BaseTest {


    @Test
    public void checkCancelButtonFunctionalityFromCheckoutPage() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SummaryPage summaryPage = new SummaryPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        checkoutPage.firstNameText.sendKeys("dino");
        checkoutPage.lastNameText.sendKeys("dino");
        checkoutPage.addressText.sendKeys("Cluj");
        checkoutPage.ClickOnTheContinueCheckoutButton();
        summaryPage.ClickOnCancelButton();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("Error: You are not on the cart page.", currentURL.contains("cart"));
        Assert.assertTrue("Error: You are not on the cart page, Your cart title is not displayed.", cartPage.cartHeaderText.isDisplayed());
    }

    //retest
    @Test
    public void checkIfTaxAppendedToTotalPrice() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SummaryPage summaryPage = new SummaryPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        checkoutPage.firstNameText.sendKeys("dino");
        checkoutPage.lastNameText.sendKeys("dino");
        checkoutPage.addressText.sendKeys("Cluj");
        checkoutPage.ClickOnTheContinueCheckoutButton();
        Assert.assertFalse("Error: Total price should be bigger than Items Total price.",
                summaryPage.totalPrice.getText().equals(summaryPage.itemsTotalPrice.getText()));
    }

    @Test
    public void checkCompleteYourOrderButtonFunctionality(){
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
        String orderCompletedMessageExpected = "Thank you for your order!";
        summaryPage.ClickOnCompleteYourOrderButton();
        String currentURL = driver.getCurrentUrl();
        String orderCompleteMessageActual = orderCompletePage.orderCompletedMessage.getText();
        Assert.assertTrue("Error: You are not on the Order Complete page.", currentURL.contains("checkout-complete"));
        Assert.assertTrue("Error: You are not on the Order Complete page.", orderCompletePage.orderCompletePageHeader.isDisplayed());
        Assert.assertTrue("Error: You are not on the Order Complete page..", orderCompletePage.orderCompletedMessage.isDisplayed());
        Assert.assertTrue("Error: You are not on the Order Complete page..", orderCompletePage.continueShoppingButton.isDisplayed());
        Assert.assertEquals("Error: You are not on Order Complete page.",
                orderCompletedMessageExpected, orderCompleteMessageActual);
    }


}
