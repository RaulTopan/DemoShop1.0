package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.Homepage;
import pages.WishlistPage;

public class WishlistFunctionality extends BaseTest {

    @Test
    public void checkWishlistLogoFunctionality(){
        Homepage homePage = new Homepage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);
        homePage.clickOnTheWishlistLogo();
        String wishlistPageHeaderText = "Wishlist";
        String cartURL = driver.getCurrentUrl();
        Assert.assertEquals("Error: You are not on Wishlist page.", wishlistPageHeaderText, wishlistPage.wishlistHeaderText.getText());
        Assert.assertTrue("Error: You are not on Wishlist page.", cartURL.contains("/wishlist"));
    }

    @Test
    public void checkAddToWishlistButtonFunctionality() {
        Homepage homePage = new Homepage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);
        homePage.clickOnAddToWishButton1();
        String homeProductName = homePage.homeFirstProductName.getText();
        homePage.clickOnTheWishlistLogo();
        Assert.assertEquals("Error: The right product is not added in wishlist.",
                homeProductName, wishlistPage.wishFirstProductName.getText());
    }

    @Test
    public void checkAddToCartButtonFunctionalityFromWishlist() {
        Homepage homePage = new Homepage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnAddToWishButton1();
        homePage.clickOnTheWishlistLogo();
        String wishProductName = wishlistPage.wishFirstProductName.getText();
        wishlistPage.clickOnTheAddToCartButtonWish();
        homePage.clickOnTheCartButtonLogo();
        String cartProductName = cartPage.productText.getText();
        Assert.assertEquals("Error: The product is not added in cart.",
                wishProductName, cartProductName);
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.productText.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.trashLogo.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.continueShoppingButton.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.checkoutButton.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.itemsTotalText.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.taxText.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.totalText.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.cartHeaderText.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.decreaseQtyButton.isDisplayed());
        Assert.assertTrue("Error: The product is not added in cart.", cartPage.increaseQtyButton.isDisplayed());

    }
}
