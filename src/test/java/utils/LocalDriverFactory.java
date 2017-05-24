package utils;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

class LocalDriverFactory {

    private static final String CHROME_DRIVER_WINDOWS_PATH = "src/test/resources/chromedriver.exe";
    private static final String FIREFOX_DRIVER_WINDOWS_PATH = "src/test/resources/geckodriver.exe";

    static WebDriver createInstance(String browser) {
        WebDriver driver = null;
        if (browser.toLowerCase().contains(FIREFOX)) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, FIREFOX_DRIVER_WINDOWS_PATH);
            driver = new FirefoxDriver();
            Thread.currentThread().setName(browser.toUpperCase());
            return driver;
        }
        if (browser.toLowerCase().contains(CHROME)) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_WINDOWS_PATH);
            driver = new ChromeDriver();
            Thread.currentThread().setName(browser.toUpperCase());
            return driver;
        }
        return driver;
    }
}
