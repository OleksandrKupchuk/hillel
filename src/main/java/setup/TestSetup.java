package setup;

import browserfactory.BrowserFactory;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestSetup {

    public WebDriver getDriver(){
        return BrowserFactory.getInstance().getDriver();
    }

    @BeforeMethod
    public void setup(){
        BrowserFactory.getInstance().createWebDriver(Config.BROWSER_NAME);
    }

    @AfterMethod
    public void teardown(){
        BrowserFactory.getInstance().closeWebDriver();
        BrowserFactory.getInstance().addVideoLink();
    }
}
