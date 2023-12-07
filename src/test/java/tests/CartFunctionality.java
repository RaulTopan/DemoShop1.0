package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.Homepage;
import pages.ProductPage;

public class CartFunctionality extends BaseTest {

    //This test will check if user is redirected to cart page when clicking on the cart logo from homepage
    @Test
    public void checkCartLogoFunctionality() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnTheCartButtonLogo();
        String cartHeaderLogoText = "Your cart";
        String cartURL = driver.getCurrentUrl();
        Assert.assertEquals("Error: You are not on cart page.", cartHeaderLogoText, cartPage.cartHeaderText.getText());
        Assert.assertTrue("Error: You are not on cart page.", cartURL.contains("/cart"));
    }

    @Test
    public void checkForEmptyCart() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnTheCartButtonLogo();
        String emptyCartText = "How about adding some products in your cart?";
        String cartURL = driver.getCurrentUrl();
        Assert.assertTrue("Error: You are not on cart page.", cartURL.contains("/cart"));
        Assert.assertEquals("Error: You have an item in your cart.", emptyCartText, cartPage.emptyCartText.getText());
    }

    @Test
    public void checkGreenBasketRedirectToHomepage(){
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnTheCartButtonLogo();
        String cartURL = driver.getCurrentUrl();
        String homePageURL = "https://fasttrackit-test.netlify.app/#/";
        Assert.assertTrue("Error: You are not on cart page.", cartURL.contains("/cart"));
        cartPage.clickOnTheGreenBasketLogo();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("Error: You are not on homepage.", homePageURL, currentURL);
    }

    @Test
    public void checkCartQuantitySingleItem() {
        Homepage homePage = new Homepage(driver);
        homePage.clickOnAddToCartButton1();
        Assert.assertTrue("Error: Cart quantity is not updated.", homePage.cartQuantity.isDisplayed());
        Assert.assertTrue("Error: Cart quantity is not updated.", homePage.cartQuantity.getText().equals("1"));
    }

    @Test
    public void checkCartQuantityUpdated(){
        Homepage homePage = new Homepage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnAddToCartButton1();
        Assert.assertTrue("Error: Cart quantity is not updated.", homePage.cartQuantity.isDisplayed());
        Assert.assertTrue("Error: Cart quantity is not updated.", homePage.cartQuantity.getText().equals("2"));
    }

    @Test
    public void checkContinueShoppingRedirectionToHomepage() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        String productsHomePageURL = "https://fasttrackit-test.netlify.app/#/products";
        cartPage.clickOnTheContinueShoppingButton();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("Error: You are not on homepage.", productsHomePageURL, currentURL);
    }

    @Test
    public void removeProductsFromCartFunctionality() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheTrashLogo();
        try {
            Assert.assertFalse("Error: Item is not removed - Items total is still displayed.", cartPage.itemsTotalText.isDisplayed());
            Assert.assertFalse("Error: Item is not removed - Tax is still displayed.", cartPage.taxText.isDisplayed());
            Assert.assertFalse("Error: Item is not removed - Total is still displayed.", cartPage.totalText.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openProductFromCartFunctionality() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        String productNameFromCart = cartPage.productText.getText();
        cartPage.clickOnTheProductText();
        String productPageURL = driver.getCurrentUrl();
        String productNameFromProductPage = productPage.productTitle.getText();
        Assert.assertTrue("Error: You are not on product page.", productPageURL.contains("product/1"));
        Assert.assertEquals("Error: Title si not the same on both pages.", productNameFromCart, productNameFromProductPage);
    }

    @Test
    public void validateElementsFromCartPage() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        Assert.assertTrue("Error: Web element is missing.", cartPage.trashLogo.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.continueShoppingButton.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.checkoutButton.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.itemsTotalText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.taxText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.totalText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.productText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.cartHeaderText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.decreaseQtyButton.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", cartPage.increaseQtyButton.isDisplayed());
    }

    @Test
    public void checkIncreaseQtyFromCartPage() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        String itemTotalPriceAmountBefore = cartPage.itemTotalPriceAmount.getText();
        cartPage.clickOnIncreaseQtyButton();
        String itemTotalPriceAmountAfter = cartPage.itemTotalPriceAmount.getText();
        try {
            Assert.assertFalse("Error: Quantity/ price not updated.", itemTotalPriceAmountBefore.equals(itemTotalPriceAmountAfter));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkDecreaseQtyFromCartPage() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        String itemTotalPriceAmountBefore = cartPage.itemTotalPriceAmount.getText();
        cartPage.clickOnDecreaseQtyButton();
        String itemTotalPriceAmountAfter = cartPage.itemTotalPriceAmount.getText();
        try {
            Assert.assertFalse("Error: Quantity/ price not updated.", itemTotalPriceAmountBefore.equals(itemTotalPriceAmountAfter));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkCheckoutButtonFromCartFunctionality() {
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        homePage.clickOnAddToCartButton1();
        homePage.clickOnTheCartButtonLogo();
        cartPage.clickOnTheCheckoutButton();
        String productPageURL = driver.getCurrentUrl();
        Assert.assertTrue("Error: You are not on checkout page.", productPageURL.contains("checkout-info"));
        Assert.assertTrue("Error: Web element is missing.", checkoutPage.checkoutTitle.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", checkoutPage.addressInformationText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", checkoutPage.deliveryInformationText.isDisplayed());
        Assert.assertTrue("Error: Web element is missing.", checkoutPage.paymentInformationText.isDisplayed());
    }
}
