package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    private static final By MAIN_BLOCK = By.id("main");
    private static final By USER_DROPDOWN = By.cssSelector("[href='/account/login']");
    private static final By REGISTER_BUTTON = By.cssSelector("[href='/account/register']");
    private static final By LOG_OUT_BUTTON_INTO_DROPDOWN = By.cssSelector("[href='/account/logout']");
    private static final By GOODBYE_SECTION = By.id("goodbye");

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOfElementLocated(MAIN_BLOCK);
    }

    public void goToRegisterPage() {
        mouseOverToLoginButton();
        waitForAppear(REGISTER_BUTTON);
        getDriver().findElement(REGISTER_BUTTON).click();
    }

    public void goToLogInPage() {
        waitForAppear(USER_DROPDOWN);
        getDriver().findElement(USER_DROPDOWN).click();
    }

    public void logOut() {
        mouseOverToLoginButton();
        waitForAppear(LOG_OUT_BUTTON_INTO_DROPDOWN);
        getDriver().findElement(LOG_OUT_BUTTON_INTO_DROPDOWN).click();
        waitForAppear(GOODBYE_SECTION);
    }

    private void mouseOverToLoginButton() {
        waitForAppear(USER_DROPDOWN);
        WebElement loginButton = getDriver().findElement(USER_DROPDOWN);
        mouseOver(loginButton);
    }
}
