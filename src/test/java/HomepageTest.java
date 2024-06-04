import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

@Listeners(ExtentTestNGITestListener.class)


public class HomepageTest extends Hooks {
    public HomepagePage homepagePage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        homepagePage = new HomepagePage(driver);
        wait = new WebDriverWait(driver, 10);
    }
//    Searching in the search bar after 'mouse' keyword Test.
    @Test(description = "Searching in the search bar after 'mouse' keyword ")
    public void searchAfterMouseTest() throws InterruptedException {
        homepagePage.enterSearch();
        homepagePage.clickSearch();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'mouse' keyword initiated");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "We found two products : " + "Refined Frozen Mouse" + "and" + "Practical Metal Mouse");
        assertEquals("Refined Frozen Mouse", homepagePage.getMouseLink().getText());
        assertEquals("Practical Metal Mouse", homepagePage.getMouseLink2().getText());
    }
    //    Searching in the search bar after 'Chips' keyword Test.
    @Test(description = "Searching in the search bar after 'Chips' keyword ")
    public void searchAfterChipsTest() throws InterruptedException {
        homepagePage.enterSearch1();
        homepagePage.clickSearch();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'Chips' keyword initiated");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "We found Awesome 'Granite Chips product'" );
        assertEquals("Awesome Granite Chips", homepagePage.getChipsLink().getText());
    }
    //    Searching in the search bar after 'shirt' keyword Test.
    @Test(description = "Searching in the search bar after 'shirt' keyword ")
    public void searchAfterShirtTest() throws InterruptedException {
        homepagePage.enterSearch3();
        homepagePage.clickSearch();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'shirt' keyword initiated");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "We found Awesome 'Awesome Soft Shirt' product" );
        assertEquals("Awesome Soft Shirt", homepagePage.getShirtLink3().getText());
    }
//       Searching the Products to Dropdown and searching by name A to Z Test.
    @Test(description = "Search for products using the dropdown and sort by name from A to Z.")
    public void shortProductDropdown() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by name (A to Z)");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are correctly searched from A to Z.");
        assertEquals("Sort by name (A to Z)", homepagePage.getOptionAZ().getText());

    }
//     Searching the Products to Dropdown and searching by name Z to A Test.
    @Test(description = "Search for products using the dropdown and sort by name from Z to A.")
    public void shortProductDropdown1() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by name (Z to A)");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are correctly searched from Z to A.");
        assertEquals("Sort by name (Z to A)", homepagePage.getOptionZA().getText());

    }
//     Searching the Products to Dropdown and searching by price Low to High Test.
    @Test(description = "Searching for products using the dropdown and sort by price Low to High.")
    public void shortProductDropdown2() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by price (low to high)");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are correctly searched by price from low to high.");
        assertEquals("Sort by price (low to high)", homepagePage.getOptionLowToHigh().getText());

    }
//      Searching the Products to Dropdown and searching by price High to Low Test.
@Test(description = "Searching for products using the dropdown and sort by price High to Low.")
    public void shortProductDropdown3() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by price (high to low)");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are correctly searched by price from high to low .");
        assertEquals("Sort by price (high to low)", homepagePage.getOptionHighToLow().getText());

    }
//      Adding the products to the favorite list ,Test.
    @Test(description = "Add the product to the favorite list.")
    public void addProductToFavorite() throws InterruptedException {
        homepagePage.clickAddToFavoriteButton();
        homepagePage.getAddedToFavorite();
        homepagePage.clickFavoriteIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are  correctly added to the favorite list.");
        assertEquals("Wishlist", homepagePage.getPageTitleAdded().getText());

    }
    //      Adding the products to favorite list ,Test.
    @Test(description = "Add the product to the favorite list, and then remove it from the favorite list.")
    public void addProductToFavoriteAndCancel() throws InterruptedException {
        homepagePage.clickAddToFavoriteButton();
        homepagePage.getAddedToFavorite();
        homepagePage.clickFavoriteIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products have been correctly added from the favorite list.");
        homepagePage.clickCancelToFavoriteButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products have been correctly removed from the favorite list.");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Test passed successfully!");
        assertEquals("Wishlist", homepagePage.getPageTitleAdded().getText());

    }
    //  Add product to the favorite and check the reset functionality.
    @Test(description = "Add the product to the favorite list, and then remove it from the favorite list.")
    public void addProductToFavoriteAndReset() throws InterruptedException {
        homepagePage.clickAddToFavoriteButton();
        homepagePage.getAddedToFavorite();
        homepagePage.clickFavoriteIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products have been correctly added from the favorite list.");
        homepagePage.clickResetPageButton();
        assertEquals("Wishlist", homepagePage.getPageTitleAdded().getText());

    }

//      Checking the functionality off the homepage Test
    @Test(description = "Checking the functionality of the homepage. ")
    public void homepageFunctionality() throws InterruptedException {
        homepagePage.clickHomepageButton();
        homepagePage.getHomepageTitle();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The homepage title is displayed correctly.");
        assertEquals("Products", homepagePage.getHomepageTitle().getText());

    }
//      Checking the functionality off the reset button Test
    @Test(description = "Checking the functionality of the reset button.")
    public void resetHomePage() throws InterruptedException {
        homepagePage.clickResetPageButton();
        homepagePage.getHomepageTitle();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The homepage title is correctly displayed when clicking the reset button. ");
        assertEquals("Hello guest!", homepagePage.getHelloGuestTitle().getText());

    }

    // Bug Test of search bar.
    @Test(description = "Search for a product using the 'photo' keyword, but the product does not exist, and no text is displayed.")
    public void researchPhotoProducts() throws InterruptedException {
        homepagePage.enterSearch2();
        homepagePage.clickSearchButton2();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected result is " + homepagePage.getPageMessageResearch());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual result is " + homepagePage.getHomepageTitle().getText());
        assertEquals("No products are found.Try with another word.", homepagePage.getHomepageTitle().getText());

    }

    //    Add a product to cart and then cancel it Test.
    @Test(description = "Add a product to cart and then cancel it.")
    public void addPracticalWoodenBacon() throws InterruptedException {
        homepagePage.clickPracticalWoodenBacon();
        homepagePage.clickAddToCartButton();
        homepagePage.clickCartIcon();
        homepagePage.clickDeleteButton();
        homepagePage.getPageMessage();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The message indicating an empty cart is correctly displayed." );
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The test passed successfully!");
        assertEquals( "How about adding some products in your cart?",homepagePage.getPageMessage().getText());
    }
    // Add product to the cart end use the reset button functionality.
    @Test(description = "Selecting a product and adding it to the cart, and check the functionality of the reset button.")
    public void addGorgeousSoftPizzaAndResetButton() throws InterruptedException{
        homepagePage.clickGorgeousSoftPizza();
        homepagePage.clickAddToCartButton();
        homepagePage.clickCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The product was correctly added to the cart." );
        homepagePage.clickResetPageButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The product was correctly added to the cart." );
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected result is "+ HomepagePage.getPageMessage3().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual result is " + HomepagePage.getPageMessage3().getText());
        assertEquals(HomepagePage.getPageMessage3().getText(),"How about adding some products in your cart?");

    }
 //    This test demonstrates the product image is being displayed.
    @Test(description = "This test verifies the presence and visibility of the place holder image for 'Awesome Granite Chips' on the website.")
    public void testProductImageDisplayed() throws InterruptedException{
       homepagePage.clickSelectProduct();
       homepagePage.getProductImage();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The image of product is correctly displayed." );
        assertEquals(true,homepagePage.getProductImage().isDisplayed());
    }


}