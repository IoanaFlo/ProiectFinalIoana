import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @Before
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkoutAsAGuestTest() throws InterruptedException {
        checkoutPage.addItemToCart();
        checkoutPage.cartInfo();
        checkoutPage.clickGuest();
        checkoutPage.checkoutMandatoryFields();
        checkoutPage.checkoutContinueButtons();
        checkoutPage.assertTextWhenReady(checkoutPage.subTitleElement, "THANK YOU FOR YOUR PURCHASE!");
    }

    @Test
    public void checkFirstNameMandatoryFieldTest() {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.firstname);
        checkoutPage.assertTextWhenReady(checkoutPage.requiredFirstName, "This is a required field.");
    }

    @Test
    public void checkLastNameMandatoryFieldTest() {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.lastname);
        checkoutPage.assertTextWhenReady(checkoutPage.requiredLastName, "This is a required field.");
    }

    @Test
    public void checkAddressMandatoryFieldTest(){
     //   checkoutPage.fillMandatoryFieldsExcept(checkoutPage.address);
    }






}
