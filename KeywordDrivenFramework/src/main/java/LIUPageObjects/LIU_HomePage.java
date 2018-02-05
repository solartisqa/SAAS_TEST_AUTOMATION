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

public class LIU_HomePage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "clAssignedChk")
    @CacheLookup
    private WebElement firstLastShowPer1;

    @FindBy(id = "clUnassignedChk")
    @CacheLookup
    private WebElement firstLastShowPer2;

    @FindBy(id = "clOtherChk")
    @CacheLookup
    private WebElement firstLastShowPer3;

    @FindBy(id = "Period")
    @CacheLookup
    private WebElement firstLastShowPer4;

    @FindBy(id = "yui-pg0-0-rpp")
    @CacheLookup
    private WebElement firstLastShowPer5;

    @FindBy(id = "yui-pg0-1-rpp")
    @CacheLookup
    private WebElement firstLastShowPer6;

    @FindBy(css = "a[href='../Servlet?dms_id=699218d0c566a3e1c9f00358313caf19']")
    @CacheLookup
    private WebElement logout;

    @FindBy(css = "a[href='../Servlet?dms_id=371943ce683f324f2d989496bf1f8e15']")
    @CacheLookup
    private WebElement myAccount;

    private final String pageLoadedText = "&nbsp;&nbsp;&nbsp;To Do List";

    private final String pageUrl = "/logon.go";

    public LIU_HomePage() {
    }

    public LIU_HomePage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public LIU_HomePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LIU_HomePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Logout Link.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on My Account Link.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage clickMyAccountLink() {
        myAccount.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage fill() {
        setFirstLastShowPer1CheckboxField();
        setFirstLastShowPer2CheckboxField();
        setFirstLastShowPer3CheckboxField();
        setFirstLastShowPer4DropDownListField();
        setFirstLastShowPer5DropDownListField();
        setFirstLastShowPer6DropDownListField();
        return this;
    }

    /**
     * Set First Last Show Per Pageno Records Found Checkbox field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer1CheckboxField() {
        if (!firstLastShowPer1.isSelected()) {
            firstLastShowPer1.click();
        }
        return this;
    }

    /**
     * Set First Last Show Per Pageno Records Found Checkbox field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer2CheckboxField() {
        if (!firstLastShowPer2.isSelected()) {
            firstLastShowPer2.click();
        }
        return this;
    }

    /**
     * Set First Last Show Per Pageno Records Found Checkbox field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer3CheckboxField() {
        if (!firstLastShowPer3.isSelected()) {
            firstLastShowPer3.click();
        }
        return this;
    }

    /**
     * Set default value to First Last Show Per Pageno Records Found Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer4DropDownListField() {
        return setFirstLastShowPer4DropDownListField(data.get("FIRST_LAST_SHOW_PER_4"));
    }

    /**
     * Set value to First Last Show Per Pageno Records Found Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer4DropDownListField(String firstLastShowPer4Value) {
        new Select(firstLastShowPer4).selectByVisibleText(firstLastShowPer4Value);
        return this;
    }

    /**
     * Set default value to First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer5DropDownListField() {
        return setFirstLastShowPer5DropDownListField(data.get("FIRST_LAST_SHOW_PER_5"));
    }

    /**
     * Set value to First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer5DropDownListField(String firstLastShowPer5Value) {
        new Select(firstLastShowPer5).selectByVisibleText(firstLastShowPer5Value);
        return this;
    }

    /**
     * Set default value to First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer6DropDownListField() {
        return setFirstLastShowPer6DropDownListField(data.get("FIRST_LAST_SHOW_PER_6"));
    }

    /**
     * Set value to First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage setFirstLastShowPer6DropDownListField(String firstLastShowPer6Value) {
        new Select(firstLastShowPer6).selectByVisibleText(firstLastShowPer6Value);
        return this;
    }

    /**
     * Unset First Last Show Per Pageno Records Found Checkbox field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer1CheckboxField() {
        if (firstLastShowPer1.isSelected()) {
            firstLastShowPer1.click();
        }
        return this;
    }

    /**
     * Unset First Last Show Per Pageno Records Found Checkbox field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer2CheckboxField() {
        if (firstLastShowPer2.isSelected()) {
            firstLastShowPer2.click();
        }
        return this;
    }

    /**
     * Unset First Last Show Per Pageno Records Found Checkbox field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer3CheckboxField() {
        if (firstLastShowPer3.isSelected()) {
            firstLastShowPer3.click();
        }
        return this;
    }

    /**
     * Unset default value from First Last Show Per Pageno Records Found Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer4DropDownListField() {
        return unsetFirstLastShowPer4DropDownListField(data.get("FIRST_LAST_SHOW_PER_4"));
    }

    /**
     * Unset value from First Last Show Per Pageno Records Found Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer4DropDownListField(String firstLastShowPer4Value) {
        new Select(firstLastShowPer4).deselectByVisibleText(firstLastShowPer4Value);
        return this;
    }

    /**
     * Unset default value from First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer5DropDownListField() {
        return unsetFirstLastShowPer5DropDownListField(data.get("FIRST_LAST_SHOW_PER_5"));
    }

    /**
     * Unset value from First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer5DropDownListField(String firstLastShowPer5Value) {
        new Select(firstLastShowPer5).deselectByVisibleText(firstLastShowPer5Value);
        return this;
    }

    /**
     * Unset default value from First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer6DropDownListField() {
        return unsetFirstLastShowPer6DropDownListField(data.get("FIRST_LAST_SHOW_PER_6"));
    }

    /**
     * Unset value from First Last Show Per Page Drop Down List field.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage unsetFirstLastShowPer6DropDownListField(String firstLastShowPer6Value) {
        new Select(firstLastShowPer6).deselectByVisibleText(firstLastShowPer6Value);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage verifyPageLoaded() {
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
     * @return the LIU_HomePage class instance.
     */
    public LIU_HomePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
