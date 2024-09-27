package pages.orangehrm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageSetup;

public class DashboardPage extends PageSetup {
    @FindBy(xpath = "//h6")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }
}
