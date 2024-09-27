package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageSetup {
    protected WebDriver driver;

    public PageSetup(){
        this.driver = TestSetup.getDriver();
        PageFactory.initElements(driver, this);
    }
}
