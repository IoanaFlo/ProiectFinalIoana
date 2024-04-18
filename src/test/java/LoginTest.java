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

    @Test(description = "This test verify  the login with user name and password functionality. ")
    public void loginTest() throws InterruptedException {
 //       extentTest = extentReports.createTest("Login functionality test","Testing login functionality.");
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.getLoginDinoName();
        assertEquals("dino",loginPage.getLoginDinoName().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The system ");
    }
    @Test
    public void negativeLoginTest1() throws InterruptedException {
//        extentTest = extentReports.createTest("Login functionality test without username","Testing login functionality.");
        loginPage.clickLoginIcon();
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(),"Please fill in the username!");

    }
    @Test
    public void negativeLoginTest2() throws InterruptedException {
 //       extentTest = extentReports.createTest("Login functionality test with wrong username","Testing login functionality.");
        loginPage.clickLoginIcon();
        loginPage.setWrongUserName("ino");
        loginPage.setPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(),"Incorrect username or password!");
    }
    @Test
    public void negativeLoginTest3() throws InterruptedException {
 //       extentTest = extentReports.createTest("Login functionality test with wrong password","Testing login functionality.");
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.setIncorrectPassword("ochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getIncorrectPasswordError().getText(),"Incorrect username or password!");
    }
    @Test
    public void negativeLoginTest4() throws InterruptedException {
 //       extentTest = extentReports.createTest("Login functionality test without password","Testing login functionality.");
        loginPage.clickLoginIcon();
        loginPage.setUserName("dino");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(),"Please fill in the password!");
    }
}
