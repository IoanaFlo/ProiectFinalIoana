import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[text()='Food']")
    private WebElement foodMenu;

    @FindBy(css = ".product-info button")
    private WebElement addToCart;

    //driver.findElement(By.id("city")).sendKeys("alabama");
    @FindBy(id = "city")
    private WebElement cityCart;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "region_id")
    public WebElement cartRegion;

    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom button")
    public WebElement proceedToCheckout;

    @FindBy(id = "onepage-guest-register-button")
    public WebElement selectGuest;

    @FindBy(id = "billing:firstname")
    public WebElement firstname;

    @FindBy(id = "billing:lastname")
    public WebElement lastname;
    @FindBy(id = "billing:email")
    private WebElement billingEmail;

    @FindBy(id = "billing:street1")
    private WebElement billingAddress;
    @FindBy(id = "billing:city")
    private WebElement billingCity;

    @FindBy(id = "billing:region_id")
    public WebElement billingRegion;

    @FindBy(id = "billing:postcode")
    private WebElement billingPostcode;

    @FindBy(id = "billing:telephone")
    private WebElement billingTelephone;

    @FindBy(css = "#shipping-method-buttons-container button")
    public WebElement shippingButton;

    @FindBy(css = "#billing-buttons-container button")
    public WebElement billingButton;

    @FindBy(css = "#payment-buttons-container button")
    public WebElement paymentButton;

    @FindBy(css = ".btn-checkout")
    public WebElement checkoutButton;

    @FindBy(css = ".sub-title")
    public WebElement subTitleElement;

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement requiredFirstName;

    @FindBy(id = "advice-required-entry-billing:lastname")
    public WebElement requiredLastName;

    public void getFoodMenu() {
        foodMenu.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void setCityCart() {
        cityCart.sendKeys("Alabama");
    }

    public void setPostcode() {
        postcode.sendKeys("33033");
    }

    public void setCartRegion() {
        cartRegion.sendKeys("Alabama");
    }

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    public void clickGuest() {
        selectGuest.click();
    }

    public void setFirstname() {
        firstname.sendKeys("Test");
    }

    public void setLastname() {
        lastname.sendKeys("User");
    }


    public void setBillingCompany() {
    }

    public void setBillingEmail() {
        billingEmail.sendKeys("a@a.com");
    }

    public void setBillingAddress() {
        billingAddress.sendKeys("adresa de test");
    }

    public void setBillingCity() {
        billingCity.sendKeys("alabama test");
    }

    public void setBillingPostCode() {
        billingPostcode.sendKeys("12345");
    }

    public void setBillingTelephone() {
        billingTelephone.sendKeys("0123456789");
    }

    public void clickShippingButton() {
        shippingButton.click();
    }

    public void clickBillingButton() {
        billingButton.click();
    }

    public void clickPaymentButton() {
        paymentButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void addItemToCart() {
        getFoodMenu();
        clickAddToCart();
    }

    public void cartInfo() {
        setCityCart();
        setPostcode();
        selectOption(cartRegion, "Alabama");
        clickProceedToCheckout();
    }

    public void checkoutMandatoryFields() {
        setFirstname();
        setLastname();
        setBillingCompany();
        setBillingEmail();
        setBillingAddress();
        setBillingCity();
        selectOption(billingRegion, "Alabama");
        setBillingPostCode();
        setBillingTelephone();
    }

    public void checkoutContinueButtons() {
        clickBillingButton();
        clickWhenReady(shippingButton);
        clickWhenReady(paymentButton);
        clickWhenReady(checkoutButton);
    }

    public void selectQty() {
        cartRegion.clear();
        cartRegion.sendKeys("2");
    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        } catch (Exception e) {
            System.out.println("Element or text not visible or incorrect");
        }
        assertEquals(expectedText, locator.getText());
    }

    public void fillMandatoryFieldsExcept(WebElement fieldToSkip) {
        addItemToCart();
        cartInfo();
        clickGuest();
        checkoutMandatoryFields();
        fieldToSkip.clear();
        billingButton.click();
    }


}
