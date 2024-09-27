package pages.orangehrm.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.PageSetup;

public class DashboardPage extends PageSetup {
    private By title = By.xpath("//h6");

    public WebElement getTitle() {
        return driver.findElement(title);
    }
}
