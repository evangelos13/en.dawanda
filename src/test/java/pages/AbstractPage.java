package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataHolder;
import utils.LocalDriverManager;

public abstract class AbstractPage {
    private static final long TIME_SECONDS_LIMIT = 21;
    private static final long SLEEP_IN_MILLIS = 3000;
    private static final String BASE_PAGE_URL = "base_page.url";

    protected WebDriver getDriver() {
        return LocalDriverManager.getDriver();
    }

    /**
     * A condition that might reasonably be expected to eventually evaluate to something that is
     * neither null nor false. Examples would include determining if a web page has loaded or that an
     * element is visible.
     * @return the WebElement once it is located and visible
     */
    protected abstract ExpectedCondition getPageLoadCondition();

    /**
     * Opens base page <a href="https://www.ryanair.com/" />
     */
    public void openMainPage() {
        String pageUrl = DataHolder.getProperty(BASE_PAGE_URL);
        getDriver().get(pageUrl);
    }

    /**
     * Method that waits for page element explicitly appear.
     *
     * @param element {@Code By}- The locating mechanism.
     */
    public void waitForAppear(By element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIME_SECONDS_LIMIT, SLEEP_IN_MILLIS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void mouseOver(WebElement elementLocator) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(elementLocator).build().perform();
    }
}
