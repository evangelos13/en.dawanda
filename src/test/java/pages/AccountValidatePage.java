package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountValidatePage extends AbstractPage {

    private static final By REGISTERED_EMAIL = By.className("registered-email");

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOfElementLocated(REGISTERED_EMAIL);
    }

    public String getEmailHint() {
        waitForAppear(REGISTERED_EMAIL);
        return getDriver().findElement(REGISTERED_EMAIL).getText();
    }
}
