package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DataHolder;

public class LogInPage extends AbstractPage {

    //Credentials for test account
    private static final String DAWANDA_USER_NAME = DataHolder.getProperty("dawanda.username");
    private static final String DAWANDA_PASSWORD = DataHolder.getProperty("dawanda.password");

    private static final By LOG_IN_FORM = By.id("login_form");
    private static final By USER_NAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("login_credentials_password");
    private static final By REMEMBER_ME_CHECKBOX = By.id("remember_me_checkbox");
    private static final By LOG_IN_SUBMIT_BUTTON = By.id("login_submit");

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOfElementLocated(LOG_IN_FORM);
    }

    public void fillLogInForm() {
        waitForAppear(LOG_IN_FORM);
        getDriver().findElement(USER_NAME_FIELD).sendKeys(DAWANDA_USER_NAME);
        getDriver().findElement(PASSWORD_FIELD).sendKeys(DAWANDA_PASSWORD);
        uncheckRememberMeCheckbox();
        getDriver().findElement(LOG_IN_SUBMIT_BUTTON).submit();
    }

    private void uncheckRememberMeCheckbox() {
        getDriver().findElement(REMEMBER_ME_CHECKBOX).click();
    }
}
