package pages.orangehrm.pageobject;

import org.openqa.selenium.By;
import setup.PageSetup;

public class LoginPage extends PageSetup {
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By submitButton = By.xpath("//button");

    public LoginPage open(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        return this;
    }

    public LoginPage setUsernameField(String value){
        driver.findElement(usernameField).sendKeys(value);
        return this;
    }

    public LoginPage setPasswordField(String value){
        driver.findElement(passwordField).sendKeys(value);
        return this;
    }

    public LoginPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return this;
    }
}
