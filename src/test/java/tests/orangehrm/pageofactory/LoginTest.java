package tests.orangehrm.pageofactory;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.orangehrm.pagefactory.DashboardPage;
import pages.orangehrm.pagefactory.LoginPage;
import setup.TestSetup;

public class LoginTest extends TestSetup {

    @Test
    public void checkSuccessLogin(){
        new LoginPage().open()
                .setUsernameField("Admin")
                .setPasswordField("admin123")
                .clickSubmitButton();

        WebElement titleElement = new DashboardPage().getTitle();
        Assert.assertEquals(titleElement.getText(), "Dashboard");
    }
}
