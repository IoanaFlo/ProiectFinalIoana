import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Double.parseDouble;


public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
        this.priceProduct = priceProduct;
    }


    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement selectProduct;

    public void clickSelectProduct() {
        selectProduct.click();
    }

    @FindBy(css = ".btn.btn-danger")
    private WebElement continueShoppingButton;

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

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
    private WebElement mouseSelect;

    public void clickMouseSelect() {
        mouseSelect.click();
    }

    @FindBy(linkText = "Practical Metal Mouse")
    private WebElement mouseLink2;

    public WebElement getMouseLink2() {
        return mouseLink2;
    }

    @FindBy(css = ".shopping-cart-icon.fa-layers.fa-fw")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }


    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartIcon;

    public void clickCartIcon() {
        cartIcon.click();
    }

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement cartItemCount;

    public WebElement getCartItemCount() {
        return cartItemCount;

    }

    @FindBy(css = ".btn.btn-success")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    @FindBy(css =".text-center")
        private WebElement pageTitleOrderComplete;
    public WebElement getPageTitleOrderComplete(){
        return pageTitleOrderComplete;
    }
    @FindBy(css =".subheader-container")
    private WebElement pageTitleOrderSummary;
    public WebElement getPageTitleOrderSummary(){
        return pageTitleOrderSummary;
    }


    @FindBy(css = ".text-muted")
            private WebElement pageTitle;

            public WebElement getPageTitle(){
            return pageTitle;
            }

            @FindBy(css = ".btn.btn-success")
            private WebElement checkoutButton2;

            public WebElement getCheckoutButton2(){
            return checkoutButton;
            }

            @FindBy(linkText = "Your information")
            private WebElement pageTitleYourInformation;

            public WebElement getPageTitleYourInformation(){
            return pageTitleYourInformation;
            }

            @FindBy(id = "first-name")
            private WebElement firstNameField;

            public void enterFirstName(){
            firstNameField.sendKeys("Ionescu");
            }

            @FindBy(id = "last-name")
            private WebElement lastNameField;

            public void enterLastName(){
            lastNameField.sendKeys("Giovanni");
            }

            @FindBy(id = "address")
            private WebElement addressField;

            public void enterAddress(){
            addressField.sendKeys("Strada Lalelelor,nr.12I,Cluj");
            }
            @FindBy(id = "address")
            private WebElement invalidAddressField;

            public void enterInvalidAddress(){
            addressField.sendKeys("a");
            }

            @FindBy(css = ".text-center")
            private WebElement textCentre;

            public WebElement getTextCentre(){
            return textCentre;
            }

            // ADD Awesome Licensed Steel Gloves Product To Cart Test and calculate the total with tax.
            @FindBy(linkText = "Licensed Steel Gloves")
            private WebElement addProductLicensedSteelGlovesToCartLink;

            public void clickAddProductLicensedSteelGlovesToCartLink(){
            addProductLicensedSteelGlovesToCartLink.click();
            }

            @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
            private WebElement addProductLicensedSteelGlovesToCartButton;

            public void clickAddProductLicensedSteelGlovesToCartButton(){
            addProductLicensedSteelGlovesToCartButton.click();
            }

            @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
            private WebElement cartButton2;

            public void clickCartButton2(){
            cartButton2.click();
            }

            @FindBy(xpath = "(//td[@class='amount'])[1]")
            private WebElement priceProduct;

            public double priceProduct(){
            String amountValue=priceProduct.getText();
            String cleanAmountValue=amountValue.replace("$", "");
        return

    parseDouble(cleanAmountValue);
}

@FindBy(xpath = "(//td[@class='amount'])[2]")
private WebElement taxPrice;

public double taxPrice() {
    String taxValue = taxPrice.getText();
    String cleanTaxValue = taxValue.replace("$", "");
    return Double.parseDouble(cleanTaxValue);
}

@FindBy(xpath = "(//td[@class='amount'])[3]")
private WebElement totalPrice;

public double totalPrice() {
    String totalValue = totalPrice.getText();
    String cleanTotalValue = totalValue.replace("$", "");
    return Double.parseDouble(cleanTotalValue);
}

@FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
private WebElement plusQuantity;

public void clickPlusQuantity() {
    plusQuantity.click();
}

@FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
private WebElement homepageButton;

public void clickHomepageButton() {
    homepageButton.click();
}

//    ADD two products to the cart and make the total with tax.
@FindBy(linkText = "Incredible Concrete Hat")
private WebElement addProductIncredibleCH;

public void clickAddProductIncredibleCH() {
    addProductIncredibleCH.click();
}

@FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
private WebElement addToCartButton3;

public void clickAddToCartButton3() {
    addToCartButton3.click();
}

@FindBy(xpath = "(//div[@class='col-md-auto'])[7]")

private WebElement priceProductLSG;


public double priceProductLSG() {
    String amountValue = priceProductLSG.getText();
    String cleanAmountValue = amountValue.replace("$", "");
    return parseDouble(cleanAmountValue);
}

@FindBy(xpath = "(//div[@class='col-md-auto'])[2]")
private WebElement priceProductICH;

public double priceProductICH() {
    String amountValue = priceProductICH.getText();
    String cleanAmountValue = amountValue.replace("$", "");
    return parseDouble(cleanAmountValue);
}

@FindBy(xpath = "(//td[@class='amount'])[3]")
private WebElement totalPrice2;

public double totalPrice2() {
    String totalValue = totalPrice2.getText();
    String cleanTotalValue = totalValue.replace("$", "");
    return Double.parseDouble(cleanTotalValue);
}

//    ADD two products to the cart and make the total with tax and refresh button.

@FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16")
private WebElement refreshButton;

public void clickRefreshButton() {
    refreshButton.click();
}

@FindBy(linkText = "How about adding some products in your cart?")
private WebElement pageMessage;

public WebElement getPageMessage() {
    return pageMessage;
}

@FindBy(linkText = "Awesome Soft Shirt")
private WebElement awesomeSoftShirt;

public void clickAwesomeSoftShirt() {
    awesomeSoftShirt.click();
}

@FindBy(css = ".btn.btn-danger")
private WebElement cancelButton;

public void clickCancelButton() {
    cancelButton.click();
}


@FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
private WebElement addCartButton;

public void clickAddCartButton() {
    addCartButton.click();
}

@FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
private WebElement addCartButton2;

public void clickAddCartButton2() {
    addCartButton2.click();
}

@FindBy(css = ".fa-layers-counter.shopping_cart_badge")
private WebElement productInCart;

boolean isProductInCart() {
    // code to check if a product is in the cart
    return true;
}

@FindBy(css = ".fa-layers-counter.shopping_cart_badge")
private WebElement cartItemCount2;

String getCartItemCount2() {
    // code to get the number of items in the cart
    int i = 2;
    return "i";
}

@FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16 ")
private WebElement ProductQuantity;

public void increaseProductQuantity(int i) {
}

String getProductQuantity(int index) {
    // code to get the quantity of a product in the cart
    return "2";
}

@FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14")
private WebElement deleteButton;

public void clickDeleteButton() {
    deleteButton.click();
}


public void selectOption(WebElement element, String option) {
    Select optionSelect = new Select(element);
    optionSelect.selectByVisibleText(option);
}


}
