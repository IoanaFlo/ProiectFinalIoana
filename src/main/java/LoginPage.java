import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement loginIcon;

    public void clickLoginIcon() {
        loginIcon.click();
    }


    @FindBy(id = "user-name")
    private WebElement userName;

    public void setUserName(String name) {
        userName.sendKeys(name);
    }

    @FindBy(id = "user-name")
    private WebElement wrongUserName;

    public void setWrongUserName(String name) {
        wrongUserName.sendKeys(name);
    }

    @FindBy(id = "password")
    private WebElement password;

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    @FindBy(id = "password")
    private WebElement incorrectPassword;

    public void setIncorrectPassword(String pass) {
        incorrectPassword.sendKeys(pass);
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(linkText = "dino")
    private WebElement loginDinoName;

    public WebElement getLoginDinoName() {
        return loginDinoName;
    }

    @FindBy(css = ".error")
    private WebElement loginError;

    public WebElement getLoginError() {
        return loginError;
    }

    @FindBy(css = ".error")
    private WebElement incorrectPasswordError;

    public WebElement getIncorrectPasswordError() {
        return incorrectPasswordError;
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
    @FindBy(css="option[value='dino']")
    private WebElement userNameIcon;
    public WebElement getUserNameIcon() {
         return userNameIcon;
    }
    @FindBy(linkText = "dino")
    private WebElement loginDinoName2;

    public void clickLoginDinoName() {
        loginDinoName.click();
    }

    @FindBy(css = ".small.text-muted")
    private WebElement accountPageTitle;

    public WebElement getAccountPageTitle() {
        return accountPageTitle;
    }


}