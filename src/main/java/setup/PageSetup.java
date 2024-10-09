package setup;

import browserfactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageSetup {
    protected WebDriver driver = BrowserFactory.getInstance().getDriver();

    public PageSetup(){
        PageFactory.initElements(driver, this);
    }
}
