package ui.pages.orangehrm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.setup.PageSetup;

public class LoginPage extends PageSetup {
    @FindBy(name = "username")
    private WebElement usernameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//button")
    private WebElement submitButton;

    public LoginPage open(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        return this;
    }

    public LoginPage setUsernameField(String value){
        usernameField.sendKeys(value);
        return this;
    }

    public LoginPage setPasswordField(String value){
        passwordField.sendKeys(value);
        return this;
    }

    public LoginPage clickSubmitButton(){
        submitButton.click();
        return this;
    }
}
