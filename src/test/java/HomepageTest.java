import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void searchAfterMouseTest() {
        homepagePage.enterSearch();
        homepagePage.clickSearch();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'mouse' keyword initiated");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "We found two products : " + "Refined Frozen Mouse" + "and" + "Practical Metal Mouse" );
        assertEquals("Refined Frozen Mouse", homepagePage.getMouseLink().getText());
        assertEquals("Practical Metal Mouse", homepagePage.getMouseLink2().getText());
    }

    @Test(description = "Search Products to Dropdown and searching by name A to Z.")
    public void shortProductDropDown() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropDown(), "Sort by name (A to Z)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "");
        assertEquals("The products  are sorted correctly by name (A la Z).", homepagePage.getSortProductDropDown());

    }
    @Test(description = "Search Products to Dropdown and searching by price Low to High.")
    public void shortProductDropDown2() throws InterruptedException {
        homepagePage.selectOption(homepagePage.getSortProductDropDown(), "Sort by price (low to high)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "");

    }

    @Test
    public void addProductToFavorite() throws InterruptedException {
        //       extentTest = extentReports.createTest("Add product to favorite.", "We add product to favorite list");
        homepagePage.clickAddToFavoriteButton();
        homepagePage.getAddedToFavorite();
        homepagePage.clickFavoriteIcon();
        assertEquals("Wishlist", homepagePage.getPageTitleAdded().getText());

    }

    @Test
    public void homepageFunctionality() throws InterruptedException {
//        extentTest = extentReports.createTest("Homepage functionality.", "Homepage title");
        homepagePage.clickHomepageButton();
        homepagePage.getHomepageTitle();
        assertEquals("Products", homepagePage.getHomepageTitle().getText());
//        extentTest.log(Status.INFO, "The homepage title is correct");

    }

    @Test
    public void resetHomePage() throws InterruptedException {
        homepagePage.clickResetPageButton();
        Thread.sleep(2000);
        homepagePage.getHomepageTitle();
        assertEquals("Products", homepagePage.getHomepageTitle().getText());
    }

}