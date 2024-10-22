package tests.ui.steps.hooks;

import ui.browserfactory.BrowserFactory;
import ui.config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setup(){
        BrowserFactory.getInstance().createWebDriver(Config.BROWSER_NAME);
    }

    @After
    public void teardown(){
        BrowserFactory.getInstance().closeWebDriver();
    }
}
