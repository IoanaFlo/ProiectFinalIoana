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

// Research after dropdown from A to Z.
    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductDropDown;
    public WebElement getSortProductDropDown() {
        return sortProductDropDown;
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
    public void clickResetPageButton(){
        resetPageButton.click();
    }



    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

}
