package setup;

import browserfactory.BrowserFactory;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestSetup {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    public void setup(){
        driver.set(BrowserFactory.getDriver(Config.BROWSER_NAME));
    }

    @AfterMethod
    public void teardown(){
        driver.get().quit();
    }
}
