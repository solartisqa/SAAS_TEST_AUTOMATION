package AssistPageObjects;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a.font_content.command_link.margin-left20")
    @CacheLookup
    private WebElement forgotPassword;

    @FindBy(name = "loginForm:j_idt94")
    @CacheLookup
    private WebElement logIn;

    private final String pageLoadedText = "Please use your User Name and Password to login to the application";

    private final String pageUrl = "/";

    @FindBy(id = "loginForm:login_password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "loginForm:login_username")
    @CacheLookup
    private WebElement userName;

    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public LoginPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

  
    public LoginPage clickForgotPasswordLink() {
        forgotPassword.click();
        return this;
    }

   
    public LoginPage clickLogInButton() {
        logIn.click();
        return this;
    }

 
    public LoginPage fill() {
        setUserNameTextField();
        setPasswordPasswordField();
        return this;
    }

   
    public LoginPage fillAndSubmit() {
        fill();
        return submit();
    }

  
    public LoginPage setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

   
    public LoginPage setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    public LoginPage setUserNameTextField() {
        return setUserNameTextField(data.get("USER_NAME"));
    }

  
    public LoginPage setUserNameTextField(String userNameValue) {
        userName.sendKeys(userNameValue);
        return this;
    }

  
    public LoginPage submit() {
        clickLogInButton();
        return this;
    }

   
    public LoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

  
    public LoginPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
