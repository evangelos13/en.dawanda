package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LocalDriverManager;

public class AbstractTest {

    private  static final Logger LOG = LoggerFactory.getLogger(AbstractTest.class);

    protected WebDriver getDriver() {
        return LocalDriverManager.getDriver();
    }

    @Before
    public void setUp() {
        LocalDriverManager.setUpDriver();
        LOG.info(Thread.currentThread().getName() + "driver instance was created! Thread id- " + Thread.currentThread().getId());
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        if(getDriver()!=null){
            getDriver().quit();
            LOG.info(Thread.currentThread().getName() + "driver instance was closed! Thread id- " + Thread.currentThread().getId());
        }
    }
}
