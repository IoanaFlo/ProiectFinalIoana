import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 30);
    }

    //   Selecting a product and add it to the cart
    @Test(description = "Selecting a product and adding it to the cart")
    public void addProductToCartTest() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product was successfully added to the cart.");
        ExtentTestNGITestListener.getTest().pass("The added test has passed successfully!");

    }
    @Test(description = "Selecting a product and adding it to the cart")
    public void addToCartAwesomeGraniteChips() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product was successfully added to the cart.");
        ExtentTestNGITestListener.getTest().pass("The test was passed successfully!");

    }

    //   Selecting a product and add it to the cart and then continue shopping
    @Test(description = "Selecting a product and adding it to the cart, and then continuing shopping.")
    public void addProductToCartAndContinueShopping() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartIcon();
        checkoutPage.getPageTitle();
        checkoutPage.clickContinueShoppingButton();
        assertEquals("Products", checkoutPage.getPageTitle().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product was successfully added to the cart, and the process continued correctly for shopping.");
        ExtentTestNGITestListener.getTest().pass("The test was passed successfully!");

    }

    //   Added a product to the cart and then proceed to checkout
    @Test(description = "This test selects an item, adds it to the cart, and then proceeds to checkout.")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartIcon();
        assertEquals("Your cart", checkoutPage.getPageTitle().getText());
        checkoutPage.clickCheckoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The cart icon was selected and correctly proceed to checkout");
        ExtentTestNGITestListener.getTest().pass("The test passed successfully!");
        assertEquals("Your information", checkoutPage.getPageTitle().getText());

    }

    //   Search a product after 'mouse' keyword then select a product
    @Test(description = "This test searches for a product using the keyword 'mouse', selects a product named 'Refined Frozen Mouse', adds it to the cart, proceeds to checkout, and enters the necessary information to complete the checkout process.")
    public void informationToCheckout() throws InterruptedException {
        checkoutPage.enterSearch();
        checkoutPage.clickSearch();
        checkoutPage.getPageTitle();
        assertEquals("Products", checkoutPage.getPageTitle().getText());
        checkoutPage.clickMouseSelect();
        assertEquals("Refined Frozen Mouse", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartIcon();
        assertEquals("Your cart", checkoutPage.getPageTitle().getText());
        checkoutPage.clickCheckoutButton();
        assertEquals("Your information", checkoutPage.getPageTitle().getText());
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterAddress();
        checkoutPage.clickCheckoutButton();
        assertEquals("Order summary", checkoutPage.getPageTitle().getText());
        checkoutPage.clickCheckoutButton();
        assertEquals("Order complete", checkoutPage.getPageTitle().getText());
        assertEquals("Thank you for your order!", checkoutPage.getTextCentre().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "After initiating a search with the keyword 'mouse', the product is selected, and personal information is inserted to proceed with checkout.");
        ExtentTestNGITestListener.getTest().pass("The test passed with success!");

    }

    // Changing quantity test
    @Test(description = "Testing the change in quantity and asserting that the price is updated correctly.")
    public void quantityTest() throws InterruptedException {
        checkoutPage.clickAddProductLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddProductLicensedSteelGlovesToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of Licensed Steel Gloves product is: " + checkoutPage.priceProduct());
        System.out.println(checkoutPage.priceProduct());
        double expectedTotal = checkoutPage.priceProduct() * 2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product after updating should be:" + expectedTotal);
        checkoutPage.clickPlusQuantity();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product after update is:" + checkoutPage.priceProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product is matching the expected result.");
        assertEquals(checkoutPage.priceProduct(), expectedTotal);
    }

    // Bug report Test1
    @Test(description ="We calculate the total product price including taxes.")
    public void totalPriceResultTest() throws InterruptedException {
        checkoutPage.clickAddProductLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddProductLicensedSteelGlovesToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.priceProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The taxes of the product is: " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.taxPrice() + checkoutPage.priceProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total is:" + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is:" + checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);

    }
    //  Test2

    @Test(description = "We calculate the total for the products: Licensed Steel Gloves and Incredible Concrete Hat, including taxes.")
    public void totalPriceResultTest2() throws InterruptedException {
        checkoutPage.clickAddProductLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddProductLicensedSteelGlovesToCartButton();
        checkoutPage.clickHomepageButton();
        checkoutPage.clickAddProductIncredibleCH();
        checkoutPage.clickAddToCartButton3();
        checkoutPage.clickCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product is: " + checkoutPage.priceProductLSG());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of  the Incredible Concrete Hat product is: " + checkoutPage.priceProductICH());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The taxes of the product is: " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.priceProductLSG() + checkoutPage.priceProductICH() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total is:" + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is:" + checkoutPage.totalPrice2());
        assertEquals(checkoutPage.totalPrice2(), expectedTotal);
    }

    // Test3

    @Test(description = "We calculate the total for the products Licensed Steel Gloves and Incredible Concrete Hat, and the refresh button functionality.")
    public void totalPriceResultTestAndRefreshButton() throws InterruptedException {
        checkoutPage.clickAddProductLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddProductLicensedSteelGlovesToCartButton();
        checkoutPage.clickHomepageButton();
        checkoutPage.clickAddProductIncredibleCH();
        checkoutPage.clickAddToCartButton3();
        checkoutPage.clickCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product is: " + checkoutPage.priceProductLSG());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of  the Incredible Concrete Hat product is: " + checkoutPage.priceProductICH());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The taxes of the product is: " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.priceProductLSG() + checkoutPage.priceProductICH() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total is:" + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is:" + checkoutPage.totalPrice2());
        assertEquals(checkoutPage.totalPrice2(), expectedTotal);
        checkoutPage.clickRefreshButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected result is " + checkoutPage.getPageTitle());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual result is " + checkoutPage.getPageMessage());
        assertEquals("How about adding some products in your cart?", checkoutPage.getPageMessage());

    }
    // Canceling product to the cart Test
    @Test(description = "Select Awesome Soft Shirt product, add it to the cart, proceed to checkout, and then cancel.")
    public void selectASSProductAndCancel() throws InterruptedException {
        checkoutPage.clickAwesomeSoftShirt();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.clickCancelButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The Awesome Soft Shirt product is successfully added to the cart, and the 'cancel' button works correctly.");
        assertEquals("Your cart", checkoutPage.getPageTitle().getText());

    }


    // Add different quantity of products and then delete firestone Test
    @Test(description = "Add different quantities of products and then delete the firestone.")
    public void addQuantityAndDeleteOne() throws InterruptedException {
        // Add first product to the cart
        checkoutPage.clickAddCartButton();
        checkoutPage.clickCartIcon();
        assertTrue(checkoutPage.isProductInCart(), "Product should be in the cart after adding.");
        // Navigate back to homepage and add another product
        checkoutPage.clickHomepageButton();
        checkoutPage.clickAddCartButton();
        checkoutPage.clickCartIcon();
        checkoutPage.clickHomepageButton();
        checkoutPage.clickAwesomeSoftShirt();
        checkoutPage.clickAddCartButton2();
        checkoutPage.clickCartIcon();
        // Adding more quantity of the second product
        checkoutPage.increaseProductQuantity(1);  // Assuming this method increases the quantity of the second product
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The quantity of the first product is 2");
        // Navigate back to the cart
        checkoutPage.clickCartIcon();
        // Delete first product from the cart
        checkoutPage.clickDeleteButton();  // Assuming this method deletes the first product
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected result is 1 product left in the cart. ");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual result is no product name in the cart" );
       assertEquals("There should be 1 product left in the cart after deletion.",checkoutPage.getCartItemCount().getText());
    }


    // Checkout with an invalid address Test.
    @Test(description ="Select a product, add it to the cart, and then proceed to checkout with an invalid address.")
    public void addProductToCartTestAndCheckoutWithInvalidAddress() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product was successfully added to the cart.");
        ExtentTestNGITestListener.getTest().pass("The added test passed successfully!");
        checkoutPage.clickCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterInvalidAddress();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order should not proceed to checkout with an invalid address.");
        assertEquals( "Invalid address message",checkoutPage.getPageTitleOrderSummary().getText());



    }


}
