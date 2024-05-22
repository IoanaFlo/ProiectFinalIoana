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
    @Test(description = "This test verify  the login with username and password functionality. ")
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.getLoginDinoName();
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is successfully with thw correct username and password. ");
        assertEquals("dino", loginPage.getLoginDinoName().getText());
    }
  //  Login without username Test
    @Test(description = "This test verify  the login without username")
    public void negativeLoginTest1() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successfully without username.");
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the username!");

    }
//    Login with incorrect username Test
    @Test(description = "This test verify  the login with incorrect username.")
    public void negativeLoginTest2() throws InterruptedException {
        //       extentTest = extentReports.createTest("Login functionality test with wrong username","Testing login functionality.");
        loginPage.clickLoginIcon();
        loginPage.setWrongUserName("ino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successfully with wrong username.");
        assertEquals(loginPage.getLoginError().getText(), "Incorrect username or password!");
    }
 //   Login with incorrect password test
    @Test(description = "This test verify  the login with incorrect password.")
    public void negativeLoginTest3() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setIncorrectPassword("ochoo");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successfully with wrong password.");
        assertEquals(loginPage.getIncorrectPasswordError().getText(), "Incorrect username or password!");
    }
 //   Login without password test
    @Test(description = "This test verify  the login without password.")
    public void negativeLoginTest4() throws InterruptedException {
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is not successfully without password.");
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the password!");
    }
 //   Checking the functionality off login in the homepage
    @Test(description = "Checking the functionality off login in the homepage. ")
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
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The login is  successfully and clicking the login icon works ok.");
        assertEquals("Account", loginPage.getHomepageTitle().getText());

    }
 //   Checking the functionality off login in the homepage and the refresh button
    @Test(description = "Checking the functionality off login in the homepage and the refresh button ")
    public void homepageFunctionality2() throws InterruptedException {
        loginPage.clickHomepageButton();
        loginPage.getHomepageTitle();
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.clickLoginDinoName();
        loginPage.getUserNameIcon();
        loginPage.getAccountPageTitle();
        assertEquals("Account", loginPage.getHomepageTitle().getText());

    }

}
