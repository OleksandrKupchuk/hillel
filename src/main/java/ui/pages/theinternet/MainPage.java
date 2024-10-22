package ui.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.browserfactory.BrowserFactory;

public class MainPage {
    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private By title = By.xpath("//h2");

    public MainPage assertTitle(){
        WebElement expectedTitle = driver.findElement(title);
        expectedTitle.getText().contains("Secure Area");
        return this;
    }
}
