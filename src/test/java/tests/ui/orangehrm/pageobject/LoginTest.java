package tests.ui.orangehrm.pageobject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.orangehrm.pageobject.DashboardPage;
import ui.pages.orangehrm.pageobject.LoginPage;
import ui.setup.TestSetup;

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