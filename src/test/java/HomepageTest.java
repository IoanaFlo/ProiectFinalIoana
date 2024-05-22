import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)


public class HomepageTest extends Hooks {
    public HomepagePage homepagePage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        homepagePage = new HomepagePage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Searching in the search bar after 'mouse' keyword ")
    public void searchAfterMouseTest() throws InterruptedException {
        homepagePage.enterSearch();
        homepagePage.clickSearch();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'mouse' keyword initiated");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "We found two products : " + "Refined Frozen Mouse" + "and" + "Practical Metal Mouse");
        assertEquals("Refined Frozen Mouse", homepagePage.getMouseLink().getText());
        assertEquals("Practical Metal Mouse", homepagePage.getMouseLink2().getText());
    }

    @Test(description = "Search Products to Dropdown and searching by name A to Z.")
    public void shortProductDropdown() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by name (A to Z)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are searched correctly from A to Z.");
        assertEquals("Sort by name (A to Z)", homepagePage.getOptionAZ().getText());

    }

    @Test(description = "Search Products to Dropdown and searching by name Z to A.")
    public void shortProductDropdown1() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by name (Z to A)");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are searched correctly from Z to A.");
        assertEquals("Sort by name (Z to A)", homepagePage.getOptionZA().getText());

    }

    @Test(description = "Search Products to Dropdown and searching by price Low to High.")
    public void shortProductDropdown2() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by price (low to high)");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are searched correctly by price from low to high.");
        assertEquals("Sort by price (low to high)", homepagePage.getOptionLowToHigh().getText());

    }

    @Test(description = "Search Products to Dropdown and searching by price High to Low.")
    public void shortProductDropdown3() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropdown(), "Sort by price (high to low)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are searched correctly by price from high to low .");
        assertEquals("Sort by price (high to low)", homepagePage.getOptionHighToLow().getText());

    }

    @Test(description = "Add product to favorite list.")
    public void addProductToFavorite() throws InterruptedException {
        homepagePage.clickAddToFavoriteButton();
        homepagePage.getAddedToFavorite();
        homepagePage.clickFavoriteIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are  correctly added to the favorite list.");
        assertEquals("Wishlist", homepagePage.getPageTitleAdded().getText());

    }

    @Test(description = "Checking the functionality off the homepage. ")
    public void homepageFunctionality() throws InterruptedException {
        homepagePage.clickHomepageButton();
        homepagePage.getHomepageTitle();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The homepage title is correctly displayed. ");
        assertEquals("Products", homepagePage.getHomepageTitle().getText());

    }

    @Test(description = "Checking the functionality off the reset button.")
    public void resetHomePage() throws InterruptedException {
        homepagePage.clickResetPageButton();
        homepagePage.getHomepageTitle();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The homepage title is correctly displayed when click the reset button. ");
        assertEquals("Products", homepagePage.getHomepageTitle().getText());

    }

    // Negative Test of search bar.
    @Test(description = "Search a product after 'photo' keyword ,but the product don't exist and no text are displayed. ")
    public void researchPhotoProducts() throws InterruptedException {
        homepagePage.enterSearch2();
        homepagePage.clickSearchButton2();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected result is " + homepagePage.getPageMessageResearch());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual result is " + homepagePage.getHomepageTitle().getText());
        assertEquals("No products are not found.Try with another word.", homepagePage.getHomepageTitle());

    }

    //    Add a product to cart and then cancel it Test
    @Test(description = "Add a product to cart and then cancel the product.")
    public void addPracticalWoodenBacon() throws InterruptedException {
        homepagePage.clickPracticalWoodenBacon();
        homepagePage.clickAddToCartButton();
        homepagePage.clickCartIcon();
        homepagePage.clickDeleteButton();
        homepagePage.getPageMessage();
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Your cart" + homepagePage.getCartPageTitle());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The test passed successfully!");
        assertEquals("Your cart", homepagePage.getPageMessage());

    }

}