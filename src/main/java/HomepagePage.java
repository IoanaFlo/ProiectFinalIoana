import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomepagePage extends BasePage {

    public WebDriverWait wait;

    public HomepagePage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    //    Searching in the search bar after 'mouse' keyword.
    @FindBy(id = "input-search")
    private WebElement searchField;

    public void enterSearch() {
        searchField.sendKeys("mouse");
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearch() {
        searchButton.click();
    }

    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement mouseLink;

    public WebElement getMouseLink() {
        return mouseLink;
    }

    @FindBy(linkText = "Practical Metal Mouse")
    private WebElement mouseLink2;

    public WebElement getMouseLink2() {
        return mouseLink2;
    }

    // Select after dropdown from A to Z.
    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductDropdown;

    public WebElement getSortProductDropdown() {
        return sortProductDropdown;
    }

    @FindBy(css = "option[value='az']")
    private WebElement optionAZ;

    public WebElement getOptionAZ() {
        return optionAZ;
    }

    @FindBy(css = "option[value='za']")
    private WebElement optionZA;

    public WebElement getOptionZA() {
        return optionZA;
    }

    @FindBy(css = "option[value='lohi']")
    private WebElement optionLowToHigh;

    public WebElement getOptionLowToHigh() {
        return optionLowToHigh;
    }

    @FindBy(css = "option[value='hilo']")
    private WebElement optionHighToLow;

    public WebElement getOptionHighToLow() {
        return optionHighToLow;
    }


    // Add products to the favorite.
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-2x")
    private WebElement addToFavoriteButton;

    public void clickAddToFavoriteButton() {
        addToFavoriteButton.click();
    }

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement addedToFavorite;

    public WebElement getAddedToFavorite() {
        return addedToFavorite;
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16")
    private WebElement favoriteIcon;

    public void clickFavoriteIcon() {
        favoriteIcon.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement pageTitleAdded;

    public WebElement getPageTitleAdded() {
        return pageTitleAdded;
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement homepageButton;

    public void clickHomepageButton() {
        homepageButton.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement homepageTitle;

    public WebElement getHomepageTitle() {
        return homepageTitle;
    }

    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16")
    private WebElement resetPageButton;

    public void clickResetPageButton() {
        resetPageButton.click();
    }

    //    Research an item who don't exist and no message are displayed.
    @FindBy(id = "input-search")
    private WebElement searchField2;

    public void enterSearch2() {
        searchField2.sendKeys("photo");
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton2;

    public void clickSearchButton2() {
        searchButton2.click();
    }

    @FindBy(linkText = "No product are found.Try with another word.")
    private WebElement pageMessageResearch;

    public WebElement getPageMessageResearch(){
        return pageMessageResearch;
    }
    @FindBy(linkText = "Practical Wooden Bacon")
    private WebElement practicalWoodenBacon;

    public void clickPracticalWoodenBacon() {
        practicalWoodenBacon.click();
    }
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartIcon;

    public void clickCartIcon() {
        cartIcon.click();
    }
    @FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14")
    private WebElement deleteButton;

    public void clickDeleteButton() {
        deleteButton.click();
    }
    @FindBy(linkText = "How about adding some products in your cart? ")
    private WebElement pageMessage;

    public WebElement getPageMessage() {
        return pageMessage;
    }
    @FindBy(linkText = "Your cart")
    private WebElement cartPageTitle;

    public WebElement getCartPageTitle() {
        return cartPageTitle;
    }
    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

}
