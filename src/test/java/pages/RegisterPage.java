package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CredentialGenerator;

public class RegisterPage extends AbstractPage {

    private static final By FIRST_NAME_FIELD = By.id("firstname");
    private static final By LAST_NAME_FIELD = By.id("lastname");
    private static final By USER_NAME_FIELD = By.id("username");
    private static final By EMAIL_FIELD = By.id("email");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By PRIVACY_POLICY_CHECKBOX = By.cssSelector("[data-bind-class-invalid='account;terms']");
    private static final By REGISTER_NOW_BUTTON = By.id("register_submit");

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_FIELD);
    }

    public void fillRegisterForm(String email) {
        waitForAppear(FIRST_NAME_FIELD);
        getDriver().findElement(FIRST_NAME_FIELD).sendKeys(CredentialGenerator.getFirstName());
        getDriver().findElement(LAST_NAME_FIELD).sendKeys(CredentialGenerator.getLastName());
        getDriver().findElement(USER_NAME_FIELD).sendKeys(CredentialGenerator.getUserName());
        getDriver().findElement(EMAIL_FIELD).sendKeys(email);
        getDriver().findElement(PASSWORD_FIELD).sendKeys(CredentialGenerator.generatePassword());
        getDriver().findElement(PRIVACY_POLICY_CHECKBOX).click();
        getDriver().findElement(REGISTER_NOW_BUTTON).submit();
    }
}
