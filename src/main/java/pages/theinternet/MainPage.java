package pages.theinternet;

import cucumber.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver = DriverManager.getInstance().getDriver();
    private By title = By.xpath("//h2");

    public MainPage assertTitle(){
        WebElement expectedTitle = driver.findElement(title);
        expectedTitle.getText().contains("Secure Area");
        return this;
    }
}
