package tests.orangehrm.pageobject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.orangehrm.pageobject.DashboardPage;
import pages.orangehrm.pageobject.LoginPage;
import setup.TestSetup;

public class LoginTest {

    @Test
    public void checkSuccessLogin(){

//        new LoginPage().open()
//                .setUsernameField("Admin")
//                .setPasswordField("admin123")
//                .clickSubmitButton();
//
//        WebElement titleElement = new DashboardPage().getTitle();
//        Assert.assertEquals(titleElement.getText(), "Dashboard");
        System.out.println("It test run by jenkins");
    }
}
