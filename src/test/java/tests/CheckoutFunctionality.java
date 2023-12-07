package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.Homepage;
import pages.SummaryPage;

public class CheckoutFunctionality extends BaseTest {

    @Test
    public void checkCancelButtonRedirectionToCart() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        checkoutPage.ClickOnTheCancelButton();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("Error: You are not on the cart page.", currentURL.contains("cart"));
        Assert.assertTrue("Error: You are not on the cart page, Your cart title is not displayed.", cartPage.cartHeaderText.isDisplayed());
    }

    @Test
    public void checkErrorValidationForEmptyFirstNameField() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        String firstNameRestrictionMessageExpected = "First Name is required";
        checkoutPage.ClickOnTheContinueCheckoutButton();
        String firstNameRestrictionMessageActual = checkoutPage.firstNameRestrictionText.getText();
        Assert.assertTrue("Error: You should not be able to continue checkout.", checkoutPage.firstNameRestrictionText.isDisplayed());
        Assert.assertEquals("Error: You should not be able to continue checkout.",
                firstNameRestrictionMessageExpected, firstNameRestrictionMessageActual);

    }

    @Test
    public void checkErrorValidationForEmptyLastNameField() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        String lastNameRestrictionMessageExpected = "Last Name is required";
        checkoutPage.firstNameText.sendKeys("dino");
        checkoutPage.ClickOnTheContinueCheckoutButton();
        String lastNameRestrictionMessageActual = checkoutPage.lastNameRestrictionText.getText();
        Assert.assertTrue("Error: You should not be able to continue checkout.", checkoutPage.lastNameRestrictionText.isDisplayed());
        Assert.assertEquals("Error: You should not be able to continue checkout.",
                lastNameRestrictionMessageExpected, lastNameRestrictionMessageActual);
    }

    @Test
    public void checkErrorValidationForEmptyAddressField() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        String addressRestrictionMessageExpected = "Address is required";
        checkoutPage.firstNameText.sendKeys("dino");
        checkoutPage.lastNameText.sendKeys("dino");
        checkoutPage.ClickOnTheContinueCheckoutButton();
        String addressRestrictionMessageActual = checkoutPage.addressRestrictionText.getText();
        Assert.assertTrue("Error: You should not be able to continue checkout.", checkoutPage.addressRestrictionText.isDisplayed());
        Assert.assertEquals("Error: You should not be able to continue checkout.",
                addressRestrictionMessageExpected, addressRestrictionMessageActual);
    }

    @Test
    public void checkContinueCheckoutButtonFunctionalityFromCheckoutPage() {
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
        String summaryPageURL = driver.getCurrentUrl();
        String summaryPageTitleExpected = "Order summary";
        String summaryPageTitleActual = summaryPage.summaryTitle.getText();
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPageURL.contains("checkout-summary"));
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPage.summaryTitle.isDisplayed());
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPage.paymentInformationText.isDisplayed());
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPage.cashOnDeliveryText.isDisplayed());
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPage.shippingInformationText.isDisplayed());
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPage.chooChooDeliveryText.isDisplayed());
        Assert.assertTrue("Error: You are not on checkout summary page.", summaryPage.totalAmountText.isDisplayed());
        Assert.assertEquals("You are not on checkout summary page.", summaryPageTitleExpected, summaryPageTitleActual);
    }

}
