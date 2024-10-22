package tests.ui.steps.hooks;

import ui.cucumber.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setup(){
        DriverManager.getInstance().createWebDriver();
    }

    @After
    public void teardown(){
        DriverManager.getInstance().getDriver().close();
    }
}
