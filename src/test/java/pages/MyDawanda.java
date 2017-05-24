package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyDawanda extends AbstractPage {

    private static final By MAIN_CONTENT = By.id("content");
    private static final By USER_NAVIGATION = By.id("shared_header_user_nav");
    private static final By USER_DROPDOWN = By.id("shared_header_user_dropdown");
    private static final By LOG_OUT_BUTTON_INTO_DROPDOWN = By.cssSelector("[href='/account/logout']");

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOfElementLocated(MAIN_CONTENT);
    }


    public void logOut() {
        waitForAppear(MAIN_CONTENT);
        mouseOverToLoginButton();
        waitForAppear(USER_DROPDOWN);
        getDriver().findElement(LOG_OUT_BUTTON_INTO_DROPDOWN).click();
    }

    private void mouseOverToLoginButton() {
        waitForAppear(USER_NAVIGATION);
        WebElement loginButton = getDriver().findElement(USER_NAVIGATION);
        mouseOver(loginButton);
    }
}
