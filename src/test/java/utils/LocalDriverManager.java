package utils;


import org.openqa.selenium.WebDriver;

public class LocalDriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setUpDriver() {
        WebDriver driver = LocalDriverFactory.createInstance(DataHolder.getProperty("browser.name"));
        webDriver.set(driver);
    }
}
