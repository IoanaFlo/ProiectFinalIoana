import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test(description = "Selecting a product and add it to the cart")
    public void addProductToCartTest() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        Thread.sleep(3000);
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product was added to the cart.");
        ExtentTestNGITestListener.getTest().pass("The added test was passed successfully!");

    }


    @Test(description = "This test ,select a item,added to the cart and then proceed to checkout.")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickSelectProduct();
        Thread.sleep(1000);
        checkoutPage.getPageTitle();
        assertEquals("Awesome Granite Chips", checkoutPage.getPageTitle().getText());
        checkoutPage.clickAddToCartButton();
        Thread.sleep(2000);
        checkoutPage.clickCartIcon();
        assertEquals("Your cart", checkoutPage.getPageTitle().getText());
        Thread.sleep(2000);
        checkoutPage.clickCheckoutButton();
        assertEquals("Your information", checkoutPage.getPageTitle().getText());
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The cart icon was selected and proceed to checkout");
        ExtentTestNGITestListener.getTest().pass("The test passed successful!");
    }

    @Test(description = "This test search a product after 'mouse' keyword then select a product named 'Refined Frozen Mouse' then added to the cart,proceed to checkout and introducing the information date to continue checkout.")
    public void informationToCheckout() throws InterruptedException {
        checkoutPage.enterSearch();
        checkoutPage.clickSearch();
        Thread.sleep(2000);
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
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'mouse' keyword initiated,select product and insert personal information to checkout.");
        ExtentTestNGITestListener.getTest().pass("The test passed with success!");

    }

    @Test(description = "Changing quantity test and asserting that the price is updated correctly.")
    public void quantityTest() throws InterruptedException {
        checkoutPage.clickAddProductLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddProductLicensedSteelGlovesToCartButton();
        checkoutPage.clickCartButton();
        Thread.sleep(1000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of Licensed Steel Gloves product is: " + checkoutPage.priceProduct());
        System.out.println(checkoutPage.priceProduct());
        Thread.sleep(1000);
        double expectedTotal = checkoutPage.priceProduct() * 2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product after updating should be:" + expectedTotal);
        checkoutPage.clickPlusQuantity();
        Thread.sleep(1000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product after update is:" + checkoutPage.priceProduct());
        assertEquals(checkoutPage.priceProduct(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the Licensed Steel Gloves product is matching the expected result.");
    }

    @Test(description = "We calculate the product total with the taxes price.")
    public void totalPriceResultTest() throws InterruptedException {
        checkoutPage.clickAddProductLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddProductLicensedSteelGlovesToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.priceProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The taxes of the product is: " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.taxPrice() + checkoutPage.priceProduct();
        Thread.sleep(1000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total is:" + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is:" + checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);

    }

    @Test(description = "We calculate the products Licensed Steel Gloves and Incredible Concrete Hat total.")
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
    @Test(description = "We calculate the products Licensed Steel Gloves and Incredible Concrete Hat total and refresh button.")
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
 //       assertEquals(checkoutPage.totalPrice2(), expectedTotal);
        checkoutPage.clickRefreshButton();
        Thread.sleep(3000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected result is " +checkoutPage.getPageTitle());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual result is " +checkoutPage.getPageMessage());
        assertEquals(checkoutPage.getPageMessage(), checkoutPage.getPageTitle());
//
    }
}
