package LIUPageObjects;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LIU_LoginPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "input.sbttn")
    @CacheLookup
    private WebElement logIn;

    private final String pageLoadedText = "Please use your User Name and Password to Log into the application";

    private final String pageUrl = "/";

    @FindBy(name = "answer(Object::UserDetail::userName)")
    @CacheLookup
    private WebElement pleaseUseYourUserNameAnd1;

    @FindBy(name = "answer(Object::UserDetail::passWord)")
    @CacheLookup
    private WebElement pleaseUseYourUserNameAnd2;

    public LIU_LoginPage() {
    }

    public LIU_LoginPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public LIU_LoginPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LIU_LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Log In Button.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage clickLogInButton() {
        logIn.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage fill() {
        setPleaseUseYourUserNameAnd1PasswordField();
        setPleaseUseYourUserNameAnd2PasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Please Use Your User Name And Password To Log Into The Application Password field.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage setPleaseUseYourUserNameAnd1PasswordField() {
        return setPleaseUseYourUserNameAnd1PasswordField(data.get("PLEASE_USE_YOUR_USER_NAME_AND_1"));
    }

    /**
     * Set value to Please Use Your User Name And Password To Log Into The Application Password field.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage setPleaseUseYourUserNameAnd1PasswordField(String pleaseUseYourUserNameAnd1Value) {
        pleaseUseYourUserNameAnd1.sendKeys(pleaseUseYourUserNameAnd1Value);
        return this;
    }

    /**
     * Set default value to Please Use Your User Name And Password To Log Into The Application Password field.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage setPleaseUseYourUserNameAnd2PasswordField() {
        return setPleaseUseYourUserNameAnd2PasswordField(data.get("PLEASE_USE_YOUR_USER_NAME_AND_2"));
    }

    /**
     * Set value to Please Use Your User Name And Password To Log Into The Application Password field.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage setPleaseUseYourUserNameAnd2PasswordField(String pleaseUseYourUserNameAnd2Value) {
        pleaseUseYourUserNameAnd2.sendKeys(pleaseUseYourUserNameAnd2Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage submit() {
        clickLogInButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the LIU_LoginPage class instance.
     */
    public LIU_LoginPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
