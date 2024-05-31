import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }
 //   Login with username and password functionality Test
    @Test(description = "This test verifies the login functionality with username and password.")
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.getLoginDinoName();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is successful with the correct username and password.");
        assertEquals("dino", loginPage.getLoginDinoName().getText());
    }
  //  Login without username, NegativeTest
    @Test(description = "This test verifies the login functionality without a username")
    public void negativeLoginTest1() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successful without a username.");
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the username!");

    }
//    Login with incorrect username, NegativeTest
    @Test(description = "This test verifies the login functionality with an incorrect username.")
    public void negativeLoginTest2() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setWrongUserName("ino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successful with the wrong username.");
        assertEquals(loginPage.getLoginError().getText(), "Incorrect username or password!");
    }
 //   Login with incorrect password ,Negative Test
    @Test(description = "This test verifies the login functionality with an incorrect password.")
    public void negativeLoginTest3() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setIncorrectPassword("ochoo");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successful with the wrong password.");
        assertEquals(loginPage.getIncorrectPasswordError().getText(), "Incorrect username or password!");
    }
 //   Login without password, Negative Test
    @Test(description = "This test verifies the login functionality without a password.")
    public void negativeLoginTest4() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successful without a password.");
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the password!");
    }
 //   Checking the functionality off login in the homepage
    @Test(description = "Checking the functionality of login on the homepage. ")
    public void homepageFunctionality() throws InterruptedException {
        loginPage.clickHomepageButton();
        loginPage.getHomepageTitle();
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.clickLoginDinoName();
        loginPage.getUserNameIcon();
        loginPage.getAccountPageTitle();
        ExtentTestNGITestListener.getTest().log(Status.INFO,  "The login is successful, and clicking the login icon works correctly.");
        assertEquals("Account", loginPage.getHomepageTitle().getText());

    }
 //   Checking the functionality off login in the homepage and reset button Test
    @Test(description =" Checking the functionality of logging in on the homepage and the reset button functionality.")
    public void homepageFunctionalityAndReset() throws InterruptedException {
        loginPage.clickHomepageButton();
        loginPage.getHomepageTitle();
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.clickLoginDinoName();
        loginPage.getUserNameIcon();
        loginPage.getAccountPageTitle();
        ExtentTestNGITestListener.getTest().log(Status.INFO,  "The login is successful, and clicking the reset button correctly displays the login homepage .");
        assertEquals("Account", loginPage.getHomepageTitle().getText());

    }


}
